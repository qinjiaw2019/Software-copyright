<?php

namespace App\Http\Model;
use App\Http\Model\BaseModel\CommonModel;

class Comment extends CommonModel
{
    protected $table = 'comment';
    protected $primaryKey = "c_id";

    public function add($param){
        $this->attributes = $param;
         return $this->saveOrUpdate($this);
    }
}