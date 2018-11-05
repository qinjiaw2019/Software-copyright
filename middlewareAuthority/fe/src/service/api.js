import {fetch} from 'common/utils/fetch'
import {apiPort} from 'common/port_url'

/**
 * 根据项目ID查询api简单列表
 * params:{project_id:PROJECT_id,page:PAGE,limit:LIMIT}
 * project_id 项目id
 * page:当前页
 * limit:每页显示数据条数
 * @param  {[Object]} params 参数
 * @return {[type]}        [description]
 */
export function getApiByProjectId(params){
	return fetch(apiPort.get_api_simple_list,params,'GET')
}

/**
 * 根据id查询详细信息
 * @param  {[String]} id ID
 * @return
 */
export function getApiById(id){
	return fetch(apiPort.get_api_by_id,{id:id},'GET')
}