/**
 * 收费规则模块
 */

import {fetch} from '@/utils/fetch'

/**
 * 添加收费规则
 * @param {Object} param 对象信息
 *                      {
      			         stationId:19,//停车场ID
      			         rule:,//JSON字符串
      			         mode:1,//收费模式
      			         desc:'',//描述
      			         used:1,//是否使用当前标准
      			         userId:'',//用户ID这个属性值默认可以为空，是自动获取的
      			         title:'',//规则名称
   						}
 */
export function add(param={}){
	if(param.userId!=undefined)
		param.userId = localStorage.getItem('uid')
	return fetch('v1/fare/add',param,'POST')
}

/**
 * 根据ID删除
 * @param  {String} id ID
 * @return {[type]}    返回删除记录数
 */
export function del(id=''){
	return fetch('v1/fare/del',{id:id},'POST')
}

/**
 * 根据主键查询
 * @param  {String} id ID
 * @return {[type]}    信息
 */
export function getById(id=''){
	return fetch('v1/fare/get',{id:id},'GET')
}

/**
 * 修改规则
 * @param  {[type]} param 对象信息
 * @return {[type]}       
 */
export function update(param){
	return fetch('v1/fare/update',param,'POST')
}

/**
 * 根据停用户ID
 * @param  {String} uid 如果为空自动从本地存储读取
 * @return {[type]}     [description]
 */
export function getList(uid=''){
	if(uid=='')
		uid = localStorage.getItem('uid')
	return fetch('v1/fare/list',{uid:uid},'GET')
}

/**
 * 从新设置停车场的规则
 * @param {[type]} id   停车场ID
 * @param {String} used 0:不使用当前规则， 1:使用当前规则
 */
export function setUsed(id,used=''){
	return fetch('v1/fare/update/used',{id:id,used:used},'POST')
}