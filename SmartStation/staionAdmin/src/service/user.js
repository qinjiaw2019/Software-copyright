/**
 * 用户模块
 */

import {fetch} from '@/utils/fetch'
/**
 * 用户登陆
 * @param  {[type]} username 账号
 * @param  {[type]} password 密码
 * @param  {[type]} method 1:网站管理员 0:停车场管理员
 * @return {[type]} 回调返回用户的ID，需要存储在本地缓存中，存储key最好为uid
 */
export function login(username='',password='',method=1){
	if(method==1)
		return fetch('v1/admin/login',{account:username,pwd:password},'POST')
	else
		return fetch('v1/depot/admin/login',{account:username,pwd:password},'POST')
}

/**
 * 停车场管理员注册
 * @param  {Object} param 对象
 *                        {
 *                        	account:账号,
 *                        	pwd:密码，
 *                        }
 * @return {[type]}       
 */
export function register(param={}){
	return fetch('v1/depot/admin/reg',param,'POST')
}

/**
 * 根据用户ID查询用户的账号信息
 * @param  {String} uid 用户ID,如果uid为空则从本地存储中读取uid的key值
 * @param  {[type]} method 1:网站管理员 0:停车场管理员
 * @return {[type]}  用户信息
 */
export function info(uid='',method=1){
	if(uid=='')
		uid=localStorage.getItem('uid')
	if(method==1)
		return fetch('v1/admin/info',{uid:uid},'GET')
	else
		return fetch('v1/depot/admin/info',{uid:uid},'GET')
}


/**
 * 判断是否登陆
 * @return {Boolean} true:登陆 false:未登陆
 */
export function isLogin(){
	let uid = localStorage.getItem('uid')
	if(uid==null || uid==undefined || uid=='')
		return false
	return true
}
/**
 * 退出登陆
 * @return {[type]}
 */
export function logout(){
	let uid = localStorage.getItem('uid')
	if(uid!=null){
		localStorage.removeItem('uid')
		localStorage.removeItem('usertype')
	}
}

/**
 * 查询用户列表
 * @param  {Number} page  页码
 * @param  {Number} limit 每页条数
 * @return {[type]}
 * 返回数据说明
 *          {
 *         	  code:,//错误代码
 *         	  data:{
 *         	  	total:,//数据总条数
 *         	  	pageIndex:,//当前的页码
 *         	  	pageSize:'',//当前页的总数据条数
 *         	  	data:[],//数据
 *         	  }
 *         }
 */
export function get(page=1,limit=20){
	let type = localStorage.getItem('usertype')
	if(type==1)//如果是网站管理员
		return fetch('v1/user/list',{page:page,limit:limit,type:type},'GET')
}

/**
 * 根据id查询用户信息
 * @param  {[type]} uid [description]
 * @return {[type]}     普通用户信息
 */
export function getUserInfo(uid=''){
	if(uid=='')
		uid=localStorage.getItem('uid')
	return fetch('v1/user/info',{uid:uid},'GET')
}

/**
 * 更具账号查询
 * @param  {[type]} account 账号
 * @return {[type]}         用户信息
 */
export function getByAccount(account){
	return fetch('v1/user/get/account',{account:account},'GET')
}