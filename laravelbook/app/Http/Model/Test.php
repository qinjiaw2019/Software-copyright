<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\CommonModel;

class Readers extends CommonModel
{
    protected $table = 'reader_info';
    protected $primaryKey = "r_id";


    public function get($id){
        $m = $this->getById(3);
        return $m;
    }

    public function getAll(){
        return $this->getPages(2,2,"createtime","r_id");
    }

    public function test()
    {
        $m = $this->whereBy("acount","abc");
        return $m;
    }
}