<?php
namespace App\Http\Controllers\Wchart;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Wchart\WchartFriend;

/**
 * 微信Controller
 * Class WchartController
 * @package App\Http\Controllers\Book
 */
class WchartFriendController extends BaseController{

    protected $model;

    function __construct()
    {
        $this->model = new WchartFriend();
    }

    public function add(){
        $param = request_ins()->all();
        if(!isset($param['acount'])){
            return response_ins()->show(40003, 'account is required');
        }
        $res = $this->model->add($param);
        return $res ? response_ins()->show(0, 'success',$res):
            response_ins()->show(0, 'save failed');
    }
    /**
     * 分页列表
     * @return string
     */
    public function get_page(){
        $page = request_ins()->rq('page');
        if(!$page)
            return response_ins()->show(1, 'page is required');
        $limit = request_ins()->rq('limit');
        $limit = $limit ? $limit : 20;
        $m = $this->model->getPages($page,$limit);

        return $m ?
            response_ins()->show(0, 'success',$m) :
            response_ins()->show(1, 'failed');
    }

}