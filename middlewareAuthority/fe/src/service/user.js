import {fetch} from 'common/utils/fetch'
import {userPort} from 'common/port_url'
import {DataTest} from 'common/utils'
/**
 * [用户登录]
 * @param  {String} username [用户名]
 * @param  {String} password [密码]
 * @return 
 */
export  function login(username='',password=''){
	return fetch(userPort.login_url,{username:username,password:password},'POST')
}

export  function getUserInfo(){
	let data = {
		code:0,
		data:{
			uId:1,
		},	
		msg:'',
	}
	return DataTest(data)
	// return fetch(userPort.get_userInfo_url,{},'GET')
}
/**
 * [用户注册]
 * @param  {[type]} params [参数列表]
 * @return
 */
//export function register(params){
//	return fetch(userPort.register_url,params,'POST') 
//export function register(params){
//	return fetch(userPort.register_url,params,'POST') 
//}
/**
 * [保存用户名]
 * @param  {String} username [用户名]
 * @return
 */
export function saveUsername(username){
	localStorage.setItem('username',username)
	console.log(username)
}

/**
 * 获取用户的ID
 * @return {
 */
export  function getUserId(){
	return 1
}

/**
 * [获取用户名]
 * @return 用户名
 * 如果不存在返回null
 */
export function getUsername(){
	let username = localStorage.getItem('username')
	return username 
}

/**
 * [注册表单]
 * @param  {String} form [提交的注册表单数据]
 * @return 
 */
export  function register(params){
	let regdata = {
		code:0,
		data:[],	
		msg:'',
	}
	return DataTest(data)
}