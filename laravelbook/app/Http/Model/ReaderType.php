<?php

namespace App\Http\Model;

use App\Http\Model\BaseModel\CommonModel;

class ReaderType extends CommonModel
{
    protected $table = 'reader_type';
    protected $primaryKey = "rt_id";

    /**
     * 根据id查询读者信息
     * @param $id
     * @return mixed
     */
    public function reader_info_all($id){
        return $this->getById($id);
    }
    public function test()
    {
        $m = $this->getById(1);
        return $m;
    }
}