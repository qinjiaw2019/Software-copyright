//	let data = {
//		code:0,
//		data:[],	
//		msg:'',
//	}
export function DataTest(params){
	return new Promise((resolve,reject) => {
		if(params.code==0)
			resolve(params.data)
		else
			reject(params.code)		
	})
}
