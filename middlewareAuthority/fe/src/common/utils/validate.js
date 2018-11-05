let validate = {};


/**
 * 验证邮箱格式
 */
validate.email = (email) => {
//  let ema = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
//  if (!ema.test(email)){  
//          return false
//     }
//  let ema = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
//  if (!ema.test(email)){  
//          return false
//     }
//     }
//  return true;
　　var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
　　var obj = document.getElementById("mazey"); //要验证的对象
　　if(obj.value === ""){ //输入不能为空
　　　　alert("输入不能为空!");
　　　　return false;
　　}else if(!reg.test(obj.value)){ //正则验证不通过，格式不对
　　　　alert("验证不通过!");
　　　　return false;
　　}else{
　　　　alert("通过！");
　　　　return true;
　　}
}

export default validate;