import Vue from 'vue'
import Router from 'vue-router'
//import Index from 'pages'
//import Index from 'pages'
//import Control from 'pages/control'

Vue.use(Router)
//export default new Router({
//routes: [
//  {
//    path: '/',
//    component: Index,
////    children:[
////    	{path:'/',}
////    ]
//  },
//]
//routes: [
//  {
//    path: '/',
//    component: Index,
////    children:[
////    	{path:'/',}
////    ]
//  },
//]
//})
import R1 from './r1'
import R2 from './r2'

const router =  new Router({
  routes: [
    ...R1,
    ...R2,
  ]
})
export default router

//全局路由配置
//路由开始之前的操作
// router.beforeEach((to, from, next) => {
//   let username = localStorage.getItem('username')
//   let userKey = false
//   if(username!=undefined) userKey = true
 	
 	
// 	if (!userKey && to.path !== '/') {
// 	 	next({path: '/'})
// 	} else if (userKey && to.path === '/') {
// 	    next({ path: '/control' })
// 	} else {
// 	    next()
// 	}
// })

// //路由完成之后的操作
// router.afterEach(route => {
//   // NProgress.done()
// })