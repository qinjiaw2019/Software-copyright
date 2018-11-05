<?php
namespace App\Http\Controllers\Reader;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\ReaderType;

class ReaderController extends BaseController{
    private $model;
    function __construct()
    {
        $this->model = new ReaderType();
    }

    public function getType(){
        $m = $this->model->test();
        return response_ins()->show(0,"success",$m);
    }
}