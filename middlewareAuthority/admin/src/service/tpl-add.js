import {DataTest} from 'common/utils'
import {tplAdd} from './data/cascade'

/**
 * [获取级联选项内数据]
 * @return 
 */

export  function getcascade(){
	return DataTest(tplAdd)
}

/**
 * [添加表单一]
 * @param  {String} form [提交的添加表单数据]
 * @return 
 */
export  function getaddone(params){
	let data = {
		code:0,
		data:[],	
		msg:'',
	}
	return DataTest(data)
}

/**
 * [添加表单二]
 * @param  {String} form [提交的添加表单数据]
 * @return 
 */
export  function getaddtwo(params){
	let data = {
		code:0,
		data:[],	
		msg:'',
	}
	return DataTest(data)
}

/**
 * [添加表单三]
 * @param  {String} form [提交的添加表单数据]
 * @return 
 */
export  function addthree(params){
	console.log(params)
	let data = {
		code:0,
		data:[],	
		msg:'',
	}
	return DataTest(data)
}

/**
 * [添加表单四]
 * @param  {String} form [提交的添加表单数据]
 * @return 
 */
export  function getaddfour(params){
	let data = {
		code:0,
		data:[],	
		msg:'',
	}
	return DataTest(data)
}