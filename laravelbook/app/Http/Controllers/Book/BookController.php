<?php
namespace App\Http\Controllers\Book;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Book;
use App\Http\Utils\Common;

class BookController extends BaseController{

    /**
     * 查询图书信息api
     * @return string
     */
    public function get(){
        $book = new Book();
        $id = request_ins()->rq('id');
        //echo $id;

        //如果参数id存在 则返回id对应的图书信息
        if($id){
             $res = $book->getById($id);
            return $res ?
                response_ins()->show(0, 'success', $res):
                response_ins()->show(40002, 'empty', $res);
        }
        //请求id不存在则返回分页信息
        //id不存在表示是分页查询
        /*limit条件*/
        $limit = request_ins()->rq('limit')?:20;
        $page = request_ins()->rq('page');
        /*skip条件,用于分页*/
        $skip = ($page ? $page-1 : 0) *$limit;
        $where = "";
        if(request_ins()->rq('bookname'))
            $where = "book_name like '%".request_ins()->rq('bookname')."%'";

        /*构建query并返回collection数据*/
        $r = $book->getByPage($skip,$limit,$where);
        return $r ?
            response_ins()->show(0, 'success', $r) :
            response_ins()->show(40002, 'empty');

    }

    public function getByName(){
        $book = new Book();
        $name = request_ins()->rq('book_name');
        //如果参数name存在 则返回id对应的图书信息
        if($name){
            $res = $book->getByName($name);
            return $res ?
                response_ins()->show(0, 'success', $res):
                response_ins()->show(40002, 'empty');
        }
        return response_ins()->show(40003 , 'book_name is required');
    }

    /**
     * 查询图书分类api
     * @return string
     */
    public function getMenu(){
        $book = new Book();
        //获取参数id
        $id = request_ins()->rq('id');
        if($id && !is_numeric($id))//id存在 但是id不是数字
            return response_ins()->show(40001, '参数类型错误!');

        if($id){
            //如果id存在表示要查询id对应的图书信息
            $res = $book->getTypeById($id);
            return $res ?
                response_ins()->show(0, 'success', $res):
                response_ins()->show(40002, 'empty', $res);
        }
        //id不存在表示是分页查询
        //TODO 前台做分页
        /*limit条件*/
        $limit = request_ins()->rq('limit')?:2000;
        $page = request_ins()->rq('page');
        $t_name = request_ins()->rq('t_name');
        $where = "";
        if($t_name)
          $where = trim($t_name);
        /*skip条件,用于分页*/
        $skip = ($page ? $page-1 : 0) *$limit;

        /*构建query并返回collection数据*/
        $r = $book->getType($skip,$limit,$where);
        return $r ?
            response_ins()->show(0, 'success', $r) :
            response_ins()->show(40002, 'empty');
    }

    public function getCount(){
        $book = new Book();
        $res = array(
            'count'=>$book->getCount(),
        );
        return response_ins()->show(0, 'success',$res);
    }

    /**
     * 获得指定分类下的所有图书分页信息
     * @return string
     */
    public function getByTypeId(){
        $book = new Book();
        //获取参数type_id
        $type_id = request_ins()->rq('type_id');
        if(!$type_id)//id存在 但是id不是数字
            return response_ins()->show(40003, 'type_id is required');

        /*limit条件*/
        $limit = request_ins()->rq('limit')?:20;
        $page = request_ins()->rq('page');
        /*skip条件,用于分页*/
        $skip = ($page ? $page-1 : 0) *$limit;
        $res = $book->getByTypeId($type_id,$skip,$limit);


        return $res ?
            response_ins()->show(0, 'success', $res) :
            response_ins()->show(40002, 'empty');

    }

    /**
     * 查询分类下的所有图书总数
     * @return string
     */
    public function countByTypeId(){
        $book = new Book();
        $type_id = request_ins()->rq('type_id');
        if(!$type_id)//id存在 但是id不是数字
            return response_ins()->show(40003, 'type_id is required');

        $res =$book->CountByTypeId($type_id);
        return $res ?
            response_ins()->show(0, 'success', $res) :
            response_ins()->show(0, 'success',0);
    }
    public function getTop(){
        $book = new Book();
        $limit = request_ins()->rq('limit');
        if(!$limit)
            $limit = 10;
        $res = $book->getTop($limit);
        return $res ?
            response_ins()->show(0, 'success', $res) :
            response_ins()->show(0, 'success',0);
    }
    public function getTypeTop(){

    }

    /**
     * 添加一条图书记录
     * @return string
     */
    public function saveInfo(){
        $book = new Book();
        $param = request_ins()->all();
        $param['createtime']=date("Y-d-m H:m:i",time());
        if(count($param)<=0){
            //如果图书信息为空
            return response_ins()->show(1, 'book info is required');
        }
        //信息验证

        $res = $book->saveinfo($param);

        return $res ?
            response_ins()->show(0, 'success') :
            response_ins()->show(40006, 'save failed',0);

    }

    /**
     * 更新一条记录
     * @return string
     */
    public function updateInfo(){
        $book = new Book();
        $param = request_ins()->all();
        if(!$param['book_id'])
            return response_ins()->show(40003  , 'book_id  is required');

        $res = $book->saveOne($param);
        return $res ?
            response_ins()->show(0, 'success',$res) :
            response_ins()->show(40006, 'save failed',0);
    }

    /**
     * 删除一条图书信息
     * @return string
     */
    public function deleteById(){
        $book = new Book();
        $id = request_ins()->rq('book_id');//获取id
        $ids = request_ins()->rq('book_ids');//批量删除
        if($id){
            $res = $book->deleteById($id);
        }
        if($ids){
            $res = $book->deleteByIds($ids);
        }
        if(!$ids || $id)
            return response_ins()->show(40003  , 'book_id  is required');
        return $res ?
            response_ins()->show(0, 'success',$res) :
            response_ins()->show(40002, 'delete failed',0);
    }

    /**
     * 添加一个分类
     * @return string
     */
    public function addTypeById(){
        $book = new Book();
        $param = request_ins()->all();
        if(count($param)<=0){
            //如果图书信息为空
            return response_ins()->show(1, 'base info is required');
        }

        $res = $book->addType($param);
        return $res ?
            response_ins()->show(0, 'success') :
            response_ins()->show(40006, 'save failed',0);
    }

    /**
     * 更新一条分类信息
     * @return string
     */
    public function updateTypeById(){
        $book = new Book();
        $param = request_ins()->all();
        if(count($param)<=0)
            return response_ins()->show(40003  , 't_id  is required');
        $res = $book->updateTypeById($param);
        return $res ?
            response_ins()->show(0, 'success',$res) :
            response_ins()->show(40002, 'update failed',0);
    }

    /**
     * 删除一条分类信息
     * @return string
     */
    public function deleteTypeById(){
        $book = new Book();
        $id = request_ins()->rq('t_id');//获取id
        if(!$id){
            return response_ins()->show(40003  , 't_id  is required');
        }

        $res = $book->deleteTypeById($id);
        return $res ?
            response_ins()->show(0, 'success',$res) :
            response_ins()->show(40002, 'delete failed',0);
    }
    public function search(){
        $s_type = request_ins()->rq('s_type');//所搜类名
        $b_type = request_ins()->rq('b_type');//图书类型
        $lib_addr = request_ins()->rq('lib_addr');//图书馆
        $keyword = request_ins()->rq("keyword");//关键字
        $book = new Book();
        $m = $book->search($s_type,$b_type,$lib_addr,$keyword);
        return $m ?
            response_ins()->show(0, 'success',$m) :
            response_ins()->show(1, 'empty');
    }
}