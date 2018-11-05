<?php
namespace App\Http\Controllers\Borrow;

use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Borrow\Borrow;
use App\Http\Model\Borrow\BorrowBefor;

class BorrowController extends BaseController{
    private $model;
    private $model_;
    function __construct()
    {
        $this->model = new BorrowBefor();
        $this->model_ = new Borrow();
    }
    /**
     * 新增预约记录
     */
    public function add(){
        $param = request_ins()->all();
        //必要属性检测
        if(!isset($param['reader_id']))
            return response_ins()->show(0,"reader_id is required");
        else if(!isset($param['book_id']))
            return response_ins()->show(0,"book_id is required");
        else if(!isset($param['zf_mon']) || $param['zf_mon']<0)
            return response_ins()->show(0,"zf_mon is required");
        else{
            $m = $this->model->add($param);
            return $m ?
                response_ins()->show(0,"success",$m) :
                response_ins()->show(1,"false");
        }
    }

    /**
     * 预约记录分页
     * @return mixed|string
     */
    public function get_page(){
        $page = request_ins()->rq('page');
        $limit = request_ins()->rq('limit');
        $limit = $limit ? $limit : 20;
        if(!$page)
            return response_ins()->show(1,"page is requied");
        $m = $this->model->get_page($page,$limit);
        return $m ?
            response_ins()->show(0,"success",$m) :
            response_ins()->show(1,"false");

    }

    /**
     * 借阅图书分页
     * @return string
     */
    public function get_page_b(){
        $page = request_ins()->rq('page');
        $limit = request_ins()->rq('limit');
        $limit = $limit ? $limit : 20;
        if(!$page)
            return response_ins()->show(1,"page is requied");
        $m = $this->model_->getPages($page,$limit);
        return $m ?
            response_ins()->show(0,"success",$m) :
            response_ins()->show(1,"false");
    }

    /**
     * 图书借阅
     * @return string
     */
    public function borrow_book(){
        $id = request_ins()->rq('id');
        if(!$id)
            return response_ins()->show(0,"id is required");
        $m = $this->model_->add($id);
        return $m ?
            response_ins()->show(0,"success",$m) :
            response_ins()->show(1,"failed");
    }

    /**
     * 查询所有指定读者的所有预约信息
     * @return string
     */
    public function get_reader_all_bow(){
        $reader_id = request_ins()->rq('reader_id');
        if(!$reader_id)
            return response_ins()->show(0,"reader_id is required");
        $m = $this->model->get_reader_all($reader_id);
        return $m ?
            response_ins()->show(0,"success",$m) :
            response_ins()->show(1,"failed");
    }
    /**
     * 查询所有指定读者的所有图书借阅信息
     * @return string
     */
    public function get_reader_all_bow_b(){
        $reader_id = request_ins()->rq('reader_id');
        if(!$reader_id)
            return response_ins()->show(0,"reader_id is required");
        $m = $this->model_->get_reader_all($reader_id);
        return $m ?
            response_ins()->show(0,"success",$m) :
            response_ins()->show(1,"failed");
    }
}