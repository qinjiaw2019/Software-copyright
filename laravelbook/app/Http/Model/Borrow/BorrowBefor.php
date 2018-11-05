<?php

namespace App\Http\Model\Borrow;

use App\Http\Model\BaseModel\CommonModel;
use App\Http\Model\Book;
use App\Http\Model\Reader;
use App\Http\Model\ReaderType;
use App\Http\Utils\Common;
use App\Http\Utils\Random\RandChar;

class BorrowBefor extends CommonModel
{
    protected $table = 'book_bow';
    protected $primaryKey = "by_id";

    public function add(array $param){
        $this->attributes = $param;
        $this->bow_time = (new Common())->simpleData();//添加预约时间
        $this->get_book_num = (new RandChar())->getRandChar(8);//生成取书号

        //获取图书信息
        $book_ = (new Book())->getById($param['book_id']);

        if(!$book_)
            return false;//图书不存在返回false
        else{//图书存在处理

            $book = $book_[0];//只取出第一条记录

            if(($book->count)<($book->left_count))
                return false;//保证安全性剩余量不能超过总数

            if(($book->left_count)<0)
                return false;//如果可借数不足则返false

        }


        $reader_info= (new Reader())->get($param['reader_id']);//获取读者信息

        if(!$reader_info)
            return false;//如果读者不存在
        else{//读者存在处理

            $reader_type_id = $reader_info->reader_type_id;//读者类型id
            $reader_type = (new ReaderType())->reader_info_all($reader_type_id);//获取读者类型信息

            if(!$reader_type)
                return false;//如果读者类型不存在

        }
        //补充预约图书表
        //计算取书时间
        $borrow_time = $reader_type['will_book_bow_time'];
        $this->get_book_time = $borrow_time;//取书时间
        $this->get_book_addr = $book->addres;//图书地址
        $this->zf_mon = $param['zf_mon'];//押金

        //检测该用户是否已经借了该图书
        $check_book = $this->where(['reader_id'=>$param['reader_id'],'book_id'=>$param['book_id']])->first();//根据读者id查询预约记录
        if(count($check_book)>=1)
            return $check_book;//如果该用户已经借了该图书则返回预约信息
        else
            return $this->saveOrUpdate($this);
    }

    /**
     * 预约记录分页
     * @param $page
     * @param $limit
     * @return mixed
     */
    public function get_page($page,$limit){
        return $this->getPages($page,$limit);
    }

    /**
     * 查询所有指定读者的所有预约信息
     * @param $reader_id
     * @return mixed
     */
    public function get_reader_all($reader_id){
        return $this->where('reader_id',$reader_id)->orderBy('bow_time',"desc")->get();
    }
}