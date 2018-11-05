/**
 * 车牌黑名单模块
 */

import {fetch} from '@/utils/fetch'

/**
 * 添加黑名单
 * 		{
	 * 		carNum:,车牌
	        userId:1,//用户
	        oweAmount:30,//欠费金额
        }
 * @param {Object} param 对象信息
 */
export function add(param={}){
	return fetch('v1/carblacklist/add',param,'POST')
}

/**
 * 更新黑名单
 *     {
 *     	id:,//ID号
        userId:,//用户ID
        oweAmount:30,//欠费金额
        oweMoneyTime:400,//欠费次数
        }
 * @param  {Object} param [description]
 * @return {[type]}       [description]
 */
export function update(param={}){
	return fetch('v1/carblacklist/update',param,'POST')
}

/**
 * 根据ID删除
 * @param  {String} id id
 * @return {[type]}    影响记录条数
 */
export function delById(id=1){
	return fetch('v1/carblacklist/del/id',{id:id},'POST')
}

/**
 * 根据ID查询
 * @param  {String} id ID
 * @return {[type]}    对象信息
 */
export function getById(id=''){
	return fetch('v1/carblacklist/get/id',{id:id},'GET')
}

/**
 * 根据车牌查询
 * @param  {String} number 车牌号码
 * @return {[type]}        数组信息
 */
export function getByNumber(number='',page=1,limit=20){
	return fetch('v1/carblacklist/get/number',{carNum:number,page:page,limit:limit},'GET')
}
