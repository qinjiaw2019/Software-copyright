<?php
namespace App\Http\Controllers\Wchart;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Wchart;

/**
 * 微信Controller
 * Class WchartController
 * @package App\Http\Controllers\Book
 */
class WchartController extends BaseController{

    protected $wchart;

    function __construct()
    {
        $this->wchart = new Wchart();
    }

    /**
     * 获得微信菜单标准格式
     * @return string
     */
    public function getMenu(){
        $menu =  $this->wchart->getMenu();
        return response_ins()->show(0, 'success', $menu);
    }

    /**
     * 获取菜单列表
     * @return string
     */
    public function getMenuList(){
        $menu =  $this->wchart->getMenuList();
        return response_ins()->show(0, 'success', $menu);
    }

    /**
     * 只获取微信的菜单json字符串
     * @return string
     */
    public function getMenuJson(){
        return $this->wchart->getMenu();
    }

    /**
     * 获得Token的Obj信息
     * @return mixed
     */
    public function getToken(){
        $wchart =  $this->wchart->getToken();
        return $wchart;
    }

    /**
     * 获得Token的Value信息
     * @return mixed
     */
    public function getTokenValue(){
        $token = $this->getToken();
        return $token[0]->value;
    }

    /**
     * 获得access_token的值
     * @return mixed
     */
    public function getAccessTokenValue(){
        return $this->wchart->getAccessTokenValue();
    }

    public function getSecretValue(){
        return $this->wchart->getSecretValue();
    }

    public function getEncodingAESKeyValue(){
        return $this->wchart->getEncodingAESKeyValue();
    }

    /**
     * 消息获取
     * @return string
     */
    public function getMsg(){
        /*limit条件*/
        $limit = request_ins()->rq('limit')?:20;
        $page = request_ins()->rq('page');
        /*skip条件,用于分页*/
        $skip = ($page ? $page-1 : 0) *$limit;

        /*构建query并返回collection数据*/
        $r = $this->wchart->getMsgList($skip,$limit);
        return $r ?
            response_ins()->show(0, 'success', $r) :
            response_ins()->show(40002, 'empty');
    }

    /**
     * 查询消息总数
     * @return string
     */
    public function getMsgCount(){
        $res = $this->wchart->getMsgCount();

        return $res ?
            response_ins()->show(0, 'success', $res) :
            response_ins()->show(40002, 'empty');
    }

    /**
     * 保存消息
     * @return string
     */
    public function saveMsg(){
        $param = request_ins()->all();
        $param['createtime']=date("Y-d-m H:m:i",time());
        if(count($param)<=0){
            //如果空
            return response_ins()->show(1, 'base info is required');
        }
        //信息验证
        if(!isset($param['type']))
            return response_ins()->show(1, 'type info is required');

        $type = $param['type'];
        switch($type){
            case "文本":
                //TODO 未检查关键字重复的情况
                $res = $this->wchart->saveMsgTypeOfText($param);
                break;
        }

        return $res ?
            response_ins()->show(0, 'success') :
            response_ins()->show(40006, 'save failed',0);

    }
    public function getSubscribe(){
        $res = $this->wchart->getSubscribe();
        return $res;
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
        $m = $this->wchart->get_page($page,$limit);

        return $m ?
            response_ins()->show(0, 'success',$m) :
            response_ins()->show(1, 'failed');
    }

    /**
     * 获得设置基本信息
     * @return string
     */
    public function getBaseInfo(){
        $token = $this->wchart->getToken();
        $info = array(
            'appId'=>$this->wchart->getAppIdValue(),
            'appSecret'=>$this->wchart->getSecretValue(),
            'token'=>$token[0]->value,
        );
        return response_ins()->show(0, 'success',$info);
    }
}