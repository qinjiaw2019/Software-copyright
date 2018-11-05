<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\CommonModel;
use App\Http\Utils\ArrayConvertObject;

class Reader extends CommonModel
{
    protected $table = 'reader_info';
    protected $primaryKey = "r_id";


    public function get($id){
        $m = $this->getById($id);
        return $m;
    }
    public function getFaceImg($id){
        $f = $this->get($id);
        return $f['face'];
    }

    public function getAll(){
        return $this->getPages(2,2,"createtime","r_id");
    }

    public function add(array $param){

        $this->acount = $param['acount'];
        $this->wexin_num = $param['wexin_num'];
        $this->real_name = $param['real_name'];
        return $this->saveOrUpdate($this,"wexin_num");

    }
    public function delete_reader($arg){
        return $this->deleteBy("wexin_num",$arg);
    }

    public function test()
    {
        $m = $this->whereBy("acount","abc");
        return $m;
    }
    public function login($username,$password){
        $m = $this->getBy('acount',$username);
        if(!$m)
            return false;
        if($m->password==$password)
            return true;
        else
            return false;
    }
}