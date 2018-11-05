import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/pages/home'

//用户权限
import Login from '@/pages/power/login'
import Reg from '@/pages/power/register'
import Forget from '@/pages/power/forget'

//管理员管理
import Addnews from '@/pages/manage/addnews'
//import Parking from '@/pages/manage/parking'
import Parking from '@/pages/manage/station'
import Equipment from '@/pages/manage/equipment'
import Form from '@/pages/manage/form'
import Order from '@/pages/manage/order'
import Mchart from '@/pages/manage/chart'

//系统管理员
import Public from '@/pages/system/public'
import ParkManage from '@/pages/system/park_manage'
import Set from '@/pages/system/set'
import Statistics from '@/pages/system/statistics'
import UserInfo from '@/pages/system/userinfo'

//图表试验区
import Chart from '@/pages/charts'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/home',
      name: 'Home',
      meta:{
      	requireAuth: true
      },
      component: Home,
      children:[
//    停车场管理员
		    {
		    	path:'addnews',
		    	component:Addnews,
		    },
		    {
		    	path:'parking',
		    	component:Parking,
		    },
		    {
		    	path:'equipment',
		    	component:Equipment,
		    },
		    {
		    	path:'form',
		    	component:Form,
		    },
		    {
		    	path:'mchart',
		    	component:Mchart,
		    },
		    {
		    	path:'order',
		    	component:Order,
		    },
//		系统管理员
		    {
		    	path:'parkmanage',
		    	component:ParkManage,
		    },
		    {
		    	path:'set',
		    	component:Set,
		    },
		    {
		    	path:'statistics',
		    	component:Statistics,
		    },
		    {
		    	path:'userinfo',
		    	component:UserInfo,
		    },
		    {
		    	path:'public',
		    	component:Public,
		    },
    	    ]
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/reg',
      name: 'Reg',
      component: Reg
    },
    {
      path: '/forget',
      name: 'Forget',
      component: Forget
    },
    {
      path: '/chart',
      name: 'Chart',
      component: Chart
    }
  ]
})

//  判断是否需要登录权限 以及是否登录
router.beforeEach((to, from, next) => {
   if (to.matched.some(res => res.meta.requireAuth)) {// 判断是否需要登录权限
     if (localStorage.getItem('uid')) {// 判断是否登录
       next()
     } else {// 没登录则跳转到登录界面
       next({
         path: '/',
         query: {redirect: to.fullPath}
       })
     }
   } else {
     next()
   }
})
 
export default router