import {api_baseUrl} from 'common/config/env'


/*
简化ajax请求
 */
export function fetch(url,param={},type='GET',async=false,header){
	return new Promise((resolve,reject) => {
		ajax({
			method:type,
			url:url,
			data:param,
			async:async,
			contentType:header,
			succss:function(res){//成功回调
				let responseJSON = JSON.parse(res)
			    if(responseJSON.code==0)
			    	//数据  错误码 信息  完整信息
			    	resolve(responseJSON.data,responseJSON.code,responseJSON)
			    else //信息 错误码  数据  
			    	reject(responseJSON.msg,responseJSON.code,responseJSON)
			 },
			failed:function(code){
				//自定义网络异常值  js ajax返回值
				reject(code.NETWORK_ERROR,code)//网络异常回调
			}
		})	
	})
}
/*
封装ajax请求
 */
export  function ajax(options){//options =  {url:'',method:'',data:'',callback:'',async:''}
    //默认参数
    options.url = options.url || ''
    options.method = options.method || 'get'
    options.data = options.data || ''
    options.async = options.async || true
    options.baseUrl = options.baseUrl || api_baseUrl
    options.contentType = options.contentType || 'application/x-www-form-urlencoded'

    //函数回调
    options.callback = options.callback || ''

    //参数拼接
    var paramStr = '';
    for (let p in options.data) {
        if (options.data.hasOwnProperty(p)) {
            if (typeof(options.data[p]) == " function ") {
                options.data[p]();
            }
            else {
                paramStr += p + '=' + encodeURIComponent(options.data[p]) + "&";
            }
        }
    }
    //构造完整的url = 前缀+url+参数
    options.url =  options.baseUrl + options.url + '?' + paramStr 
    // options.url =  options.baseUrl + options.url
    //get请求-拼接url
    // if(options.method.toLowerCase() == 'get'){
    //     if(typeof options.data == 'object'){
    //         options.data = [];
    //         for (var k in options.data){
    //             options.data.push(k+'='+options.data[k]);
    //             options.data.join('&');
    //         }
    //     }
    //     options.url += (options.url.indexOf('?' == -1) ? '?' : '') + options.data;
    // }
    //post请求-转换字符串
    // if(options.method.toLowerCase() == 'post'){
    //     if(typeof options.data == 'object'){
    //         var arrs = [];
    //         for (var k in options.data){
    //             arrs.push(k+'='+options.data[k]);
    //         }
    //         options.data = arrs.join('&');
    //     }
    // }
    //创建发送请求
    var xhr = window.XMLHttpRequest ?  new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //兼容ie
    xhr.open(options.method,options.url,options.async);
    if(options.method == 'post'){
        xhr.setRequestHeader('Content-Type',options.contentType);
        xhr.send(options.data);
        // xhr.send(options.data);
    }else{
        xhr.send(null);
    }
    //异步请求
    if(options.async == true){
        xhr.onreadystatechange = function(){
          if(xhr.readyState == 4){
              callcall();
          }
        }
    }
    // xhr.abort(); // 取消异步请求
    //同步请求
    if(options.async == false){
        callcall();
    }
    //返回状态判断
    function callcall(){
        if(xhr.status == 200){
            options.succss(xhr.responseText)
        }else if(xhr.status == 404){//请求失败
        	if(options.error)
        		options.error(xhr.status + xhr.statusText)
        }else if(xhr.status==0){
        	if(options.failed)//网络原因错误
        		options.failed(xhr.status)
        }else{
        	options.callback('error:' + xhr.status + xhr.statusText)
        }
    }
};
/*
http://blog.csdn.net/qq_17335153/article/details/50176099


setRequestHeader 设置请求头
http://blog.csdn.net/qlcql/article/details/51206972

发送json格式数据
xhr.setRequestHeader("Content-type","application/json; charset=utf-8");

发送表单数据
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");

发送纯文本
不指定Content-type时，此是默认值值
xhr.setRequestHeader("Content-type", "text/plain; charset=utf-8");

发送html文本
xhr.setRequestHeader("Content-type", "text/html; charset=utf-8");

编码可带可不带
// 不带字符编码写法
xhr.setRequestHeader("Content-type", "application/json");

值对大小写不敏感
xhr.setRequestHeader("Content-type","Application/JSON; charset=utf-8");
虽然如此，但还是都保持小写
 */