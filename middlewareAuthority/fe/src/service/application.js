import {DataTest} from 'common/utils'
import {fetch} from 'common/utils/fetch'
import {appPort} from 'common/port_url'

/**
 * 添加一条记录
 * @param {[Object]} params 参数
 */
export  function add(params){
	return fetch(appPort.add_url,params,'POST')
}

/**
 * [删除一条记录]
 * @param  {String} id [ID]
 * @return 
 */
export  function del(id){
	return fetch(appPort.del_url,{id:id},'POST')
}

/**
 * [修改一条记录]
 * @param  {Object} params [参数]
 * @return 
 */
export  function edit(params){
	return fetch(appPort.edit_url,params,'POST')
}

/**
 * [查询]
 * 1.根据id查询  params:{id:ID}
 * 2.分页查询 params:{page:PAGE,limit:LIMIT}  page:当前页，limit:每页显示条数
 * @param  {Object} params [参数]
 * @return 
 */
export  function get(params){
	return fetch(appPort.get_url,params,'GET')
}

/**
 * [多条件查询]
 * params:{属性名1:值1,属性名2:值2,...}
 * @param  {Object} params [参数]  
 * @return 
 */
export  function getBy(params){
	return fetch(appPort.get_where_url,params,'GET')
}

/**
 * 获取记录总数
 * @return 
 */
export  function getTatol(){
	return fetch(appPort.get_tatol_url,{},'GET')
}

/**
 * 获取应用分类
 * @return 
 */
export  function getTypes(){
	let data = {
		code:0,
		data:[
			{
				id:1,
				name:'网站应用',
				desc:'网页应用',
			},
			{
				id:2,
				name:'桌面客户端',
				desc:'桌面程序',
			},
			{
				id:3,
				name:'移动客户端',
				desc:'App',
			}
		],	
		msg:'',
	}
	return DataTest(data)
	// return fetch(appPort.get_app_tepe_url,{},'GET')
}

//////////
/**
 * [应用表单]
 * @param  {String} form [提交的表单数据]
 * @return 
 */

// export  function add(params){
	// let data = {
	// 	code:0,
	// 	data:[],	
	// 	msg:'',
	// }
// 	return DataTest(data)
// }
