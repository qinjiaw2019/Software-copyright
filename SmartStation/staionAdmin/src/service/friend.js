/**
 * 好友模块
 */

import {fetch} from '@/utils/fetch'

/**
 * 添加好友
 * @param {Object} param 对象
 *                       {
 *                       	myId:,//我的ID号
 *                       	frendId:,//好友ID号
 *                       	relative:,//关系
 *                       }
 * @return {[type]}     影响记录条数
 */
export function add(param={}){
	return fetch('v1/friend/add',param,'POST')
}

/**
 * 删除好友
 * @param  {[type]} myid 我的ID
 * @param  {[type]} fid 好友ID
 * @return {[type]}     影响记录条数
 */
export function del(myid='',fid=''){
	return fetch('v1/friend/del',{myId:myid,frendId:fid},'POST')
}

/**
 * 更新好友信息
 * @param  {[type]} param 对象
 *                       {
 *                       	myId:,//我的ID号
 *                       	frendId:,//好友ID号
 *                       	relative:,//关系
 *                       }                     
 * @return {[type]}   影响记录条数
 */
export function update(param={}){
	return fetch('v1/friend/update',param,'POST')
}

/**
 * 获取好友列表
 * @param  {[type]} myId       我的ID
 * @param  {[type]} relative   关系包含
 * @param  {[type]} unrelative 关系不包含
 * @param  {[type]} page       当前页码
 * @param  {[type]} limit      每页条数
 * @return {[type]}            对象数组
 */
export function getFriendList(myId,relative='',unrelative='',page=1,limit=20){
	return fetch('v1/friend/list',{
		myId:myId,
		relative:relative,
		unrelative:unrelative,
		page:page,
		limit:limit},'GET')
}