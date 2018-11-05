<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\BaseModel;
use Illuminate\Support\Facades\DB;

class Book extends BaseModel
{
    protected $table = 'book';
    protected $primaryKey = "book_id";

    /**
     * 图书全部信息列表查询
     * @param int $skip 当前页
     * @param int $limit 每页大小
     * @param string $where 条件
     * @return mixed
     */
    public function getByPage($skip=0,$limit=20,$where=""){
        //TODO sql语句要修改  不能使用select *
        $sql = "select * from book  where  status!=0 ";
        if($where!="")
            $sql.=" and ".$where;
        $sql.=" order by createtime desc limit ?,?";
        $res = DB::select($sql,[$skip,$limit]);
        return $res;
    }

    /**
     *查询图书分类
     * @param int $skip
     * @param int $limit
     * @return mixed
     */
    public function getType($skip=0,$limit=20,$where=""){
        if($where!="")
            $sql = "select t_id,t_name,t_code,levels from book_type where t_name like '%$where%' order by levels desc limit ?,?";
        else
            $sql = "select t_id,t_name,t_code,levels from book_type  order by levels desc limit  ?,? ";
        $res = DB::select($sql,[$skip,$limit]);
        return $res;
    }
    public function getTypeById($id){
        $res = DB::select("select * from book_type where t_id=?",[$id]);
        return $res;
    }
    public function getTop($num=10){

        $sql ="SELECT * from book_bow_j GROUP BY book_id limit 0,?";

        $res = DB::select($sql,[$num]);

        $book = array();
        foreach($res as $k=>$v){

            $res[$k]['count'] =  $this->getCountTop($v['book_id']);
        }
        return $res;
    }
    public function getTypeTop($num){

    }
    public function getCountTop($id){

        $res = DB::select('select * from book_bow_j where book_id=?',[$id]);
        return count($res);
    }

    /**
     * 根据Id查找 图书信息
     * @param $id
     * @return mixed
     */
    public function getById($id){
        $res = DB::select("select * from book where book_id=?",[$id]);
        return $res;
    }

    /**
     * 根据图书名称查找 图书信息
     * @param $name
     * @return mixed
     */
    public function getByName($name){
        $res = DB::select("select * from book where book_name=?",[$name]);
        return $res;
    }

    /**
     * 查询图书的总数
     * @return int 总数
     */
    public function getCount(){
        $count = 0;
        $count = $this->count();
        return $count;
    }

    /**
     * 查询指定分类id下的所有图书
     * @param $id 分类id
     * @param $skip
     * @param $limit
     * @return mixed
     */
    public function getByTypeId($type_id,$skip,$limit){
        $sql = "select * from book where type=? order by createtime desc limit  ?,?";
        $res = DB::select($sql,[$type_id,$skip,$limit]);
        return $res;
    }

    /**
     * 获取分页下的所有图书总数
     * @param $type_id
     * @return mixed
     */
    public function CountByTypeId($type_id){
        $res = $this->where("type",$type_id)->count();
        return $res;
    }

    /**
     * 保存一条记录到数据库
     * @param $input  数组参数
     * @return static
     */
    public function saveinfo($input){
        $sql = "insert into book(
                   book_name,codeno,checkno,isbn,law_author,author,
                   pub_addr,pub_loc,pub_datatime,copyno,price,addres,
                   status,count,note,pages,type,picUrl,author_intro,
                   description,createtime
                ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        $res = DB::insert($sql,[$input['book_name'],$input['codeno'],$input['checkno'],$input['isbn'], $input['law_author'],$input['author'],
                $input['pub_addr'],$input['pub_loc'],$input['pub_datatime'], $input['copyno'],$input['price'],$input['addres'],
                $input['status'],$input['count'],$input['note'],$input['pages'],$input['type'],$input['picUrl'],$input['author_intro'],
                $input['description'],$input['createtime']
        ]);
        return $res;
    }

    /**
     * 更新一条记录
     * @param $input
     * @return mixed
     */
    public function saveOne($input){
        $res = $this->find($input['book_id']);
        if(!$res)//记录为空直接返回
            return $res;
        $res->book_name = $input['book_name'];
        $res->codeno = $input['codeno'];
        $res->checkno = $input['checkno'];
        $res->isbn = $input['isbn'];
        $res->law_author = $input['law_author'];
        $res->author = $input['author'];
        $res->pub_addr = $input['pub_addr'];
        $res->pub_loc = $input['pub_loc'];
        $res->pub_datatime = $input['pub_datatime'];
        $res->copyno = $input['copyno'];
        $res->price = $input['price'];
        $res->addres = $input['addres'];
        $res->status = $input['status'];
        $res->count = $input['count'];
        $res->note = $input['note'];
        $res->pages = $input['pages'];
        $res->type = $input['type'];
        $res->picUrl = $input['picUrl'];
        $res->author_intro = $input['author_intro'];
        $res->description = $input['description'];
        return $res->save();
    }

    /**
     * 根据id删除一条记录
     * @param $id
     * @return mixed
     */
    public function deleteById($id){
        $res = $this->where('book_id',$id)->delete();
        return $res;
    }

    /**
     * 批量删除 格式id1,id2,id3
     * @param $ids
     * @return mixed
     */
    public function deleteByIds($ids){
        $sql= "delete from book where book_id IN(".$ids.")";
        $res = DB::delete($sql);
        return $res;
    }

    /**
     * 添加一个分类
     * @param $input
     * @return mixed
     */
    public function addType($input){
        $sql = "insert into book_type(
                   t_name,t_code,pid,levels
                ) VALUES(?,?,?,?)";
        $res = DB::insert($sql,[$input['t_name'],$input['t_code'],$input['pid'],$input['levels']]);
        return $res;
    }

    /**
     * 更新一条分类信息
     * @param $input
     * @return mixed
     */
    public function updateTypeById($input){
        $sql = "update  book_type set t_name=?,t_code=?,pid=?,levels=?  where t_id=?";
        $res = DB::update($sql,[$input['t_name'],$input['t_code'],$input['pid'],$input['levels'],$input['t_id']]);
        return $res;
    }

    /**
     * 删除一条分类信息
     * @param $id
     * @return mixed
     */
    public function deleteTypeById($id){
        $res = DB::delete("delete from book_type where t_id=?",[$id]);
        return $res;
    }
    public function search($s_type,$b_type,$lib_addr,$keyword){
//        $res = $this->getTypeByName($b_type);
//        $t_id = $res[0]['t_id'];
        $t_id=0;
        switch($s_type){
            case "name":
                $m = $this->where(["book_name"=>$keyword,"type"=>$t_id,"addres"=>$lib_addr])->get();
                return $m;
                break;
            case "author":
                $m = $this->where(["author"=>$keyword,"type"=>$t_id,"addres"=>$lib_addr])->get();
                return $m;
                break;
            default:
                $sql = "select * from book where book_name like '%".$keyword."%'";
                $m = DB::select($sql);
                return $m;
                break;
        }
    }
    public function getTypeByName($name){
        $res = DB::select("select * from book_type where t_name=?",[$name]);
        return $res;
    }
}