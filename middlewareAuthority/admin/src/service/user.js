import {fetch} from 'common/utils/fetch'
import {userPort} from 'common/port_url'
/**
 * [用户登录]
 * @param  {String} username [用户名]
 * @param  {String} password [密码]
 * @return 
 */
export  function login(username='',password=''){
	return fetch(userPort.login_url,{username:username,password:password},'POST')
}

/**
 * 退出登陆
 * @return {[type]} [description]
 */
export  function logout(){
	return fetch(userPort.logout_url,{},'POST')
}
/**
 * 查询用户信息
 * 1.params:{id:ID} 根据id查询
 * 2.params:{page:PAGE,limit:LIMIT} 分页查询[该功能还未实现]
 * @param  {[type]} params [description]
 * @return {[type]}        [description]
 */
export function getUserInfo(params){
	return fetch(userPort.get_url,{},'GET')
}

/**
 * 获得用户名
 * @return {[type]} [description]
 */
export function getUserName(){
	// return fetch(userPort.get_url,{},'GET')
	let username = localStorage.getItem('username')
}

/**
 * 保存登陆用户信息
 * @param  {[type]} params 参数
 * @return {[type]}        
 */
export function saveUserInfo(params){
	// return fetch(userPort.get_url,{},'GET')
	localStorage.setItem('username',params.username)
}

