<?php
namespace App\Http\Controllers\Comment;

use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Comment;
use App\Http\Model\Reader;
use App\Http\Utils\Common;

class CommentController extends BaseController{
    private $model;
    function __construct()
    {
        $this->model = new Comment();
    }

    /**
     * 获得评论
     * @return string
     */
    public function get(){
        $reader_info = new Reader();
        $book_id = request_ins()->rq('book_id');
        if(!$book_id)
            return  response_ins()->show(1, 'book_id is required');
        $c = $this->model->where("book_id",$book_id)->get();
        foreach($c as $k=>$v){
            $rid = $c[$k]['reader_id'];
            $fi = $reader_info->get($rid);
            $c[$k]['face'] = $fi['face'];
            $c[$k]['nikename'] = $fi['nikename'];
        }
        return $c ?
            response_ins()->show(0, 'success',$c) :
            response_ins()->show(1, 'empty');
    }

    /**
     * 添加图书评论
     * @return mixed|string
     */
    public function add(){
        $param = request_ins()->all();
        if(!isset($param['book_id']))
            return response_ins()->show(1, 'book_id is required');
        if(!isset($param['reader_id']))
            return response_ins()->show(1, 'reader_id is required');
        if(!isset($param['content']))
            return response_ins()->show(1, 'content is required');

        if(isset($param['maxStar']) && isset($param['minStar'])){
            $param['avgStar'] = ($param['maxStar'] + $param['minStar'])/2;
        }
        $param['create_time'] = (new Common())->simpleData();
        $c = $this->model->add($param);
        return $c ?
            response_ins()->show(0, 'success',$c) :
            response_ins()->show(1, 'empty');
    }
    public function del(){
        $id = request_ins()->rq('id');
        if(isset($id)){
            $c=  $this->model->deleteById($id);
            return response_ins()->show(0, 'success');
        }
        $book_id = request_ins()->rq('book_id');
        if(!$id && $book_id){
            $c = $this->model->where("book_id",$book_id)->delete();
            return response_ins()->show(0, 'success');
        }
        $reader_id = request_ins()->rq('reader_id');
        if(!$id && !$book_id && $reader_id){
            $c = $this->model->where("reader_id",$reader_id)->delete();
            return response_ins()->show(0, 'success');
        }
        else{
            return response_ins()->show(1, 'err');
        }

    }
}