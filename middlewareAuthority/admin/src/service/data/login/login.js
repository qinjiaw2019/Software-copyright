import {DataTest} from 'common/utils'
/*
 *@管理员登录
 * 
 *
 */
export function Login(username,password) {
	//提交数据类型
	let data = {
		code:0,
		data:[],	
		msg:'',
	}
	if(username=='' || password==''){
		let err = {
			code:1,
			data:[],	
			msg:'',
		}
		return DataTest(err)
	}
	//dat
	return DataTest(data)
}
