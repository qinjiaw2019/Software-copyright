<?php

namespace App\Http\Model\Wchart;



use App\Http\Model\BaseModel\CommonModel;

class WchartFriend extends CommonModel
{
    protected $table = 'wchart_friend';
    protected $primaryKey = "w_id";

    /**
     * 添加一条记录
     * @param array $param
     * @return mixed
     */
    public function add(array $param){
        $this->acount = $param['acount'];
        $res = $this->saveOrUpdate($this,'acount');
        return $res;
    }
}