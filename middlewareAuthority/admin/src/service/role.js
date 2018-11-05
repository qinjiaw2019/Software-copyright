import {fetch} from 'common/utils/fetch'
import {rolePort} from 'common/port_url'
import {DataTest} from 'common/utils'
import {roleMothods} from './data/role/rolemothods'
/**
 * 获取当前登陆用户的角色的详细信息
 * 获取当前登陆用户的角色的详细信息  TODO 获取数据失败，接口有问题
 * @return 
 */
export function getRoles(){
	return fetch(rolePort.get_roles,{},'GET')
}

/**
 * 获取某用户角色的详细信息
 * @param  {[type]} username 用户名
 * @return
 */
export function getUserRoles(username){
	return fetch(rolePort.get_roles,{username:username},'GET')
}


/**
 * [获取角色方法数据]
 * @return 
 */

export  function getrolemothods(){
	return DataTest(roleMothods)
}