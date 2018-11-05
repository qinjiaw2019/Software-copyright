/**
 * 停车场模块
 */

import {fetch} from '@/utils/fetch'


/**
 * 管理员分页查询停车场信息
 * @param  {Number} page  当前页码，默认为1
 * @param  {Number} limit 每页数据条数，默认20
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
		return fetch('v1/station/list/address',{page:page,limit:limit},'GET')
}

/**
 * 根据经纬度查询
 * @param  {[type]} param 对象
 *                        {
 *                        	lat:经度,
 *                        	lng:纬度，
 *                        	len：范围
 *                        	step：步进数,
 *                        	page:当前页数，
 *                        	limit：每页条数
 *                        }
 * @return {[type]}     数组
 */
export function getByLngAndLat(param){
	return fetch('v1/station/get/position',param,'GET')
}

/**
 * 添加一条停车场信息
 * @param {[type]} depotInfo 停车场信息
 *                           {
 *                           	name://停车场名称
 *                           	userId:用户ID
 *                           	desc：描述
 *                           	stationNum：车位数量
 *                           	address：简单地址描述
 *                           	latitude：纬度
 *                           	longitude：经度
 *                           	photo：照片
 *
 *								地址信息
 * 								provice：省，
 * 								city：市
 * 								country：县
 *                           }
 */
export function add(depotInfo){
	let type = localStorage.getItem('usertype')
	if(type==0)//如果是停车场管理员
	return fetch('v1/station/add',depotInfo,'POST')
}

/**
 * 获取停车场管理员下管理的所有停车场信息
 * @param  {String} uid id号
 * @return {[type]}     [description]
 */
export function getList(uid=''){
	if(uid==''){
		uid=localStorage.getItem('uid')
	}
	let type = localStorage.getItem('usertype')
	if(type==0)//如果是停车场管理员
		return fetch('v1/station/list',{uid:uid,type:type},'GET')
}

/**
 * 修改停车场信息
 * @param  {[type]} param 对象
 * @return {[type]}       
 */
export function edit(param={}){
	let type = localStorage.getItem('usertype')
	if(type==0)//如果是停车场管理员
	return fetch('v1/station/edit',param,'POST')
}

/**
 * 根据id删除停车场
 * @param  {[type]} id 停车场id
 * @return {[type]}
 */
export function del(id=''){
	return fetch('v1/station/del',{id:id},'POST')
}


/**
 * 根据停车场ID获取使用停车场的用户信息
 * @param  {[type]} param 条件信息
 *                        {
 *                        	 page:1,页码信息
 *                        	 limit:20,每页数据量
 *                        }
 */
export function getUsedUser(param){

}

/**
 * 根据ID查询
 * @param  {String} stationId 停车场ID
 * @return {[type]} 对象信息
 */
export function getById(stationId=''){
	return fetch('v1/station/get',{id:stationId},'GET')
}