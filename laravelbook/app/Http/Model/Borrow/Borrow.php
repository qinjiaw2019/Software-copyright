<?php

namespace App\Http\Model\Borrow;

use App\Http\Model\BaseModel\CommonModel;
use App\Http\Model\ReaderType;
use App\Http\Utils\Common;

/**
 * 借阅信息
 * Class BorrowBefor
 * @package App\Http\Model\Borrow
 */
class Borrow extends CommonModel
{
    protected $table = 'book_bow_j';
    protected $primaryKey = "bj_id";


    public function add($id){
        $b = (new BorrowBefor())->getById($id);//获取预约记录图书信息

        if(!$b)
            return false;
        $this->reader_id = $b->reader_id;
        $this->book_id = $b->book_id;
        $this->get_book_addr = $b->get_book_addr;
        $this->get_book_time = (new Common())->simpleData();
        $this->bow_book_time = $b->get_book_time;

        //检测该用户是否已经借了该图书
        $check_book = $this->where(['reader_id'=>$b->reader_id,'book_id'=>$b->book_id])->first();//根据读者id查询预约记录
        if(count($check_book)>=1)
            return $check_book;//如果该用户已经借了该图书则返回预约信息
        else{
            $b->deleteById($b->by_id);//并删除预约里的信息
            return $this->saveOrUpdate($this);
        }

    }

    /**
     * 查询所有指定读者的所有借阅信息信息
     * @param $reader_id
     * @return mixed
     */
    public function get_reader_all($reader_id){
        return $this->where('reader_id',$reader_id)->get();
    }

}