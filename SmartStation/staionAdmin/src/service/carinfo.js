/**
 * 车/牌信息接口
 */

import {fetch} from '@/utils/fetch'

/**
 * 查询车牌信息
 * @param  {[type]} param 对象
 *                        {
 *                        	  carNumber:车牌,
 *                        	  carNumberType:车牌类别,
 *                        	  carType:车辆品牌,
 *                        	  carXH:车辆型号,
 *                        	  carYear:车辆年份,
 *                        	  carColor:车身颜色,
 *                        	  code:识别号码,
 *                        	  page:1,页码
 *                        	  limit:20,每页数据量
 *                        }
 * @return {[type]}       [description]
 */
export function get(param){
	return fetch('v1/carinfo/get',param,'GET')
}

/**
 * 绑定车牌
 * @param  {[type]} param 对象
 * @return {[type]} 添加成功返回1
 */
export function bind(param){
	return fetch('v1/carinfo/bind',param,'POST')
}

/**
 * 添加车牌[非车主 需要车主授权]
 * @param {[type]} param [description]
 */
export function addCarNumber(param){
	return fetch('v1/carinfo/addcn',param,'POST')
}

//解除绑定车牌
export function unbind(cid,uid=''){
	return fetch('v1/carinfo/unbind',param,'POST')
}


/**
 * 查看我的车牌使用记录
 * @param  {[type]} carNum 车牌
 * @return {[type]}        [description]
 */
export function history(carNum){
	return fetch('v1/carinfo/history',param,'GET')
}
