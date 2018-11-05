import * as userService from './user'
import * as stationService from './station'
import * as carInfoService from './carinfo'
import * as fareRuleService from './fare'
import * as carNumberBlackListService from './carblacklist'


import * as friendService from './friend'

let api={
	user:userService,                            //用户模块
	station:stationService,                      //停车场模块
	carinfo:carInfoService,                      //车牌信息
	fareRule:fareRuleService,			        //收费规则模块
	carNumberBlack:carNumberBlackListService,   //车牌黑名单

	friend:friendService,
}

export default api