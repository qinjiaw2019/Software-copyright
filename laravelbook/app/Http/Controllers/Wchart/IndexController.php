<?php
namespace App\Http\Controllers\Wchart;



use App\Http\Controllers\BaseController\BaseController;
use App\Http\Model\Wchart;
use Illuminate\Support\Facades\Input;
use Symfony\Component\HttpFoundation\Response;

/**
 * 微信请求首页
 * Class WchartController
 * @package App\Http\Controllers\Book
 */
class IndexController extends BaseController{

        private $wchart;
        function __construct()
        {
            $this->wchart = new Wchart();
        }

        function index(){
            $wc= $this->wchart->getToken();

            $token = $wc[0]->value;//从数据区取得Token

            if($this->checkSignature($token))
            {
                echo 1;
                //返回echostr
                $echostr = request_ins()->rq('echostr');
                $this->menu();//自定义菜单
                if($echostr)
                {
                    echo $echostr;
                    exit;
                }else{
              //      $this->responseMsg();
                }
            }

        }
    //验证签名
    public function checkSignature($token)
    {
        //先获取到这三个参数
        $signature = request_ins()->rq("signature");
        $timestamp = request_ins()->rq("timestamp");
        $nonce = request_ins()->rq("nonce");
        //把这三个参数存到一个数组里面
        $tmpArr = array($timestamp,$nonce,$token);
        //进行字典排序
        sort($tmpArr);

        //把数组中的元素合并成字符串，impode()函数是用来将一个数组合并成字符串的
        $tmpStr = implode($tmpArr);

        //sha1加密，调用sha1函数
        $tmpStr = sha1($tmpStr);
        //判断加密后的字符串是否和signature相等
        return $tmpStr == $signature;

        //如果相等，验证成功就返回echostr
    }
    public function menu(){
        $menu = $this->wchart->getMenu();

        $access_token = $this->getSaveAccessToken();
        $url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=".$access_token;
        $res = $this->http_request()->https_request($url,$menu);
    }
    //响应消息
    public function responseMsg()
    {
        $postStr = file_get_contents('php://input');
   //     $postStr = $GLOBALS["HTTP_RAW_POST_DATA"];

        if (!empty($postStr)){
            $this->logger("R ".$postStr);
            $postObj = simplexml_load_string($postStr, 'SimpleXMLElement', LIBXML_NOCDATA);

            $RX_TYPE = trim($postObj->MsgType);

            switch ($RX_TYPE)
            {
                case "event":
                    $result = $this->receiveEvent($postObj);
                    break;
                case "text":
                    $result = $this->receiveText($postObj);
                    break;
//                case "image":
//                    $result = $this->receiveImage($postObj);
//                    break;
//                case "location":
//                    $result = $this->receiveLocation($postObj);
//                    break;
//                case "voice":
//                    $result = $this->receiveVoice($postObj);
//                    break;
//                case "video":
//                    $result = $this->receiveVideo($postObj);
//                    break;
//                case "link":
//                    $result = $this->receiveLink($postObj);
//                    break;
                default:
                    $result = "unknown msg type: ".$RX_TYPE;
                    break;
            }
            $this->logger("T".$result);
            echo $result;
        }else {
            echo "";
            exit(0);
        }
    }
    //接收事件消息
    private function receiveEvent($object)
    {
        $content = "";
        switch ($object->Event)
        {
            case "subscribe":
                $content = "欢迎关注 图书借阅伴侣 微信公众号,感谢您的关注!\n回复 1 待开发；\n回复 2 待开发；\请回复help产看相关命令 ";
                $content .= (!empty($object->EventKey))?("\n来自二维码场景 ".str_replace("qrscene_","",$object->EventKey)):"";
                break;
            case "unsubscribe":
                $content = "取消关注";
                break;
            case "SCAN":
                switch ($object->EventKey) {
                    case 2000:
                        $content = "欢迎你 [临时二维码] 扫描场景 ".$object->EventKey;
                        break;
                    case 3000:
                        $content = "欢迎你 [永久二维码] 扫描场景 ".$object->EventKey;
                        break;
                    default:
                        ;
                        break;
                }
                break;
            case "CLICK"://自定义菜单中的click
                switch ($object->EventKey)
                {
                    case "active":
                        $content = "回复:\n
									1.培训\n
									2.讲座\n
									3.展览";
                        break;
                    default:
                        $content = "点击菜单：".$object->EventKey;
                        break;
                }
                break;
            case "LOCATION":
                $content = "上传位置：纬度 ".$object->Latitude.";经度 ".$object->Longitude;
                break;
            case "VIEW":
                $content = "跳转链接 ".$object->EventKey;
                break;
            default:
                $content = "receive a new event: ".$object->Event;
                break;
        }
        $result = $this->transmitText($object, $content);
        return $result;
    }
    //接收文本消息
    private function receiveText($object)
    {
        switch ($object->Content)
        {
            case "1":
                $content = array();
                $content[] = array("Title"=>"yabeBlog,技术改变世界，代码成就未来!","Description"=>"yabeBlog,Your write anything word!","PicUrl"=>"http://discuz.comli.com/weixin/weather/icon/cartoon.jpg","Url"=>"http://mp.weixin.qq.com/s?__biz=MzA3NjM3MjQxOA==&mid=200218642&idx=1&sn=1a901b68dd5941035c20027635be5e29#rd");
                break;
            case "2":
                $content = array();
                $content[] = array("Title"=>"Baidu,百度!","Description"=>"百度!","PicUrl"=>"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png","Url"=>"http://www.baidu.com");
                break;
            case "tel":
                $content = "13541741901";
                break;
            case "admin":
                $content = "<a href='http://120.25.211.167'>图书借阅伴侣后台登陆系统</a>";
                break;
            case "help":
                $content = "请回复:\n
							tel 电话
							admin 后台登陆";
                break;
            case "图文":
            case "单图文":
                $content = array();
                $content[] = array("Title"=>"单图文标题",  "Description"=>"单图文内容", "PicUrl"=>"http://discuz.comli.com/weixin/weather/icon/cartoon.jpg", "Url" =>"http://m.cnblogs.com/?u=xrhou12326");
                break;
            case "baidu":
                $content = array();
                $content[] = array("Title"=>"百度",  "Description"=>"单图文内容--百度", "PicUrl"=>"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png", "Url" =>"http://www.baidu.com");
                break;
            case "google":
                $content = array();
                $content[] = array("Title"=>"谷歌",  "Description"=>"单图文内容--谷歌", "PicUrl"=>"https://www.google.com.hk/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png", "Url" =>"http://www.google.com");
                break;
            case "2":
                $content = array();
                $content[] = array("Title"=>"yabeBlog,技术改变世界,代码成就未来!", "Description"=>"", "PicUrl"=>"http://discuz.comli.com/weixin/weather/icon/cartoon.jpg", "Url" =>"http://m.cnblogs.com/?u=xrhou12326");
                $content[] = array("Title"=>"舌尖上的中国2 时间的味道", "Description"=>"", "PicUrl"=>"http://d.hiphotos.bdimg.com/wisegame/pic/item/f3529822720e0cf3ac9f1ada0846f21fbe09aaa3.jpg", "Url" =>"http://m.cnblogs.com/?u=xrhou12326");
                $content[] = array("Title"=>"yabeBlog，下一个目标", "Description"=>"", "PicUrl"=>"http://g.hiphotos.bdimg.com/wisegame/pic/item/18cb0a46f21fbe090d338acc6a600c338644adfd.jpg", "Url" =>"http://m.cnblogs.com/?u=xrhou12326");
                break;
            case "音乐":
                $content = array("Title"=>"最炫民族风", "Description"=>"歌手：凤凰传奇", "MusicUrl"=>"http://music.baidu.com/album/63594", "HQMusicUrl"=>"http://121.199.4.61/music/zxmzf.mp3");
                break;
            case "二维码":
                $content = array();
                $content[] = array("Title"=>"二维码", "Description"=>"Url:https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQH38TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyMjNCSGhObklmM2kxMDAwMGcwM0YAAgTSzdxYAwQAAAAA", "PicUrl"=>"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQH38TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyMjNCSGhObklmM2kxMDAwMGcwM0YAAgTSzdxYAwQAAAAA", "Url" =>"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQH38TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyMjNCSGhObklmM2kxMDAwMGcwM0YAAgTSzdxYAwQAAAAA");
                break;
            case "gy-sub":
                $content = "馆员助手:\n1.账号信息  \n 2.读者证绑定/解绑 \n";
                break;
            default:
                $content = date("Y-m-d H:i:s",time());
                break;
        }
        if(is_array($content)){
            if (isset($content[0]['PicUrl'])){
                $result = $this->transmitNews($object, $content);
            }else if (isset($content['MusicUrl'])){
                $result = $this->transmitMusic($object, $content);
            }
        }else{
            $result = $this->transmitText($object, $content);
        }
        return $result;
    }
    //回复文本消息
    private function transmitText($object, $content)
    {
        $textTpl = "<xml>
						<ToUserName><![CDATA[%s]]></ToUserName>
						<FromUserName><![CDATA[%s]]></FromUserName>
						<CreateTime>%s</CreateTime>
						<MsgType><![CDATA[text]]></MsgType>
						<Content><![CDATA[%s]]></Content>
					</xml>";
        $result = sprintf($textTpl, $object->FromUserName, $object->ToUserName, time(), $content);
        return $result;
    }
    //回复图文消息
    private function transmitNews($object, $newsArray)
    {
        if(!is_array($newsArray)){
            return;
        }
        $itemTpl = "<item>
				        <Title><![CDATA[%s]]></Title>
				        <Description><![CDATA[%s]]></Description>
				        <PicUrl><![CDATA[%s]]></PicUrl>
				        <Url><![CDATA[%s]]></Url>
				    </item>";
        $item_str = "";
        foreach ($newsArray as $item){
            $item_str .= sprintf($itemTpl, $item['Title'], $item['Description'], $item['PicUrl'], $item['Url']);
        }
        $newsTpl = "<xml>
						<ToUserName><![CDATA[%s]]></ToUserName>
						<FromUserName><![CDATA[%s]]></FromUserName>
						<CreateTime>%s</CreateTime>
						<MsgType><![CDATA[news]]></MsgType>
						<Content><![CDATA[]]></Content>
						<ArticleCount>%s</ArticleCount>
						<Articles>
							$item_str
						</Articles>
				   </xml>";

        $result = sprintf($newsTpl, $object->FromUserName, $object->ToUserName, time(), count($newsArray));
        return $result;
    }

    //回复音乐消息
    private function transmitMusic($object, $musicArray)
    {
        $itemTpl = "<Music>
    <Title><![CDATA[%s]]></Title>
    <Description><![CDATA[%s]]></Description>
    <MusicUrl><![CDATA[%s]]></MusicUrl>
    <HQMusicUrl><![CDATA[%s]]></HQMusicUrl>
</Music>";

        $item_str = sprintf($itemTpl, $musicArray['Title'], $musicArray['Description'], $musicArray['MusicUrl'], $musicArray['HQMusicUrl']);

        $textTpl = "<xml>
		<ToUserName><![CDATA[%s]]></ToUserName>
		<FromUserName><![CDATA[%s]]></FromUserName>
		<CreateTime>%s</CreateTime>
		<MsgType><![CDATA[music]]></MsgType>
		$item_str
		</xml>";
        $result = sprintf($textTpl, $object->FromUserName, $object->ToUserName, time());
        return $result;
    }
    //从数据库获取accss_token
    function getSaveAccessToken(){
        //从数据库读取
        $access_token = $this->wchart->getAccessTokenValue();//access_token
        $expire_time = $this->wchart->getExpireTimeValue();//过期时间

        $appid = $this->wchart->getAppIdValue();
        $secret = $this->wchart->getSecretValue();

        if($this->wchart->getAccessToken()!=NULL && $expire_time!="" && $expire_time>time()){
            //如果access_token存在且没有过期
            return $access_token;
        }else{
            //如果access_token不存在或已经过期 则重新获取
            $res = $this->getAccessToken($appid,$secret);
            $acc_token = $res['access_token'];
            //将重新获取到的存在数据库中
            $newat = $acc_token;
            $newet = time()+7000;
            //更新access_token
            $this->wchart->saveAccessToken($newat);

            //更新expire_time
            $this->wchart->SaveExpireTime($newet);
            return $newat;
        }
    }
    //获取access_token
    function getAccessToken($appid,$secret){
        $url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=".$appid."&secret=".$secret;
        $json = $this->http_request()->https_request($url);
        $arr = json_decode($json,true);
        return $arr;
    }


}