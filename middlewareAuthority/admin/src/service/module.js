import {fetch} from 'common/utils/fetch'
import {modulePort} from 'common/port_url'
import {DataTest} from 'common/utils'
/**
 * [添加一条记录]
 * @param  {Object} params [参数]
 * @return
 */
export  function add(params){
	return fetch(modulePort.add_url,params,'POST')
}

/**
 * [批量添加]
 * @param  {JSON} params [参数]  要转成JSON字符串
 * @return
 */
export  function addList(params){
	return fetch(modulePort.addList_url,params,'POST')
}

/**
 * [删除一条记录]
 * @param  {String} id [ID]
 * @return
 */
export  function del(id){
	return fetch(modulePort.del_url,{id:id},'POST')
}

/**
 * [删除多条记录]
 * @param  {String} ids [ID,多个id用“,”分割]
 * @return
 */
export  function delIds(ids){
	return fetch(modulePort.delIds_url,{id:ids},'POST')
}

/**
 * [修改一条记录]
 * @param  {Object} params [参数]
 * @return
 */
export  function edit(params){
	return fetch(modulePort.edit_url,params,'POST')
}

/**
 * [查询]
 * 1.根据id查询  params:{id:ID}
 * 2.分页查询 params:{page:PAGE,limit:LIMIT}  page:当前页，limit:每页显示条数
 * @param  {Object} params [参数]
 * @return
 */
export  function get(params){
  return fetch(modulePort.get_url,params,'GET')
}

/**
 * [多条件查询]
 * params:{属性名1:值1,属性名2:值2,...}
 * @param  {Object} params [参数]
 * @return
 */export  function getBy(params){
	return fetch(modulePort.get_where_url,params,'GET')
}

/**
 * [模糊查询-根据一个属性条件查询]
 * params:{属性名:值}
 * @param  {Object} params [参数]
 * @return
 */export  function getLike(params){
	return fetch(modulePort.get_like_url,params,'GET')
}

/**
 * [模糊查询-根据多个属性条件查询]
 * params:{属性名:值}
 * @param  {Object} params [参数]
 * @return
<<<<<<< HEAD
 */
export  function getLikeBy(params){
 	console.log(params)
	return fetch(modulePort.get_like_where_url,params,'GET')
}

/**
 * [获取总记录条数]
 * @return
 */export  function getTatol(){
	return fetch(modulePort.get_tatol_url,{},'GET')
}
