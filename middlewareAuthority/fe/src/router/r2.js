//控制台路由配置
import Control from 'pages/control/control'
//import Out from 'pages/out'
//import Form from 'pages/form'
//应用application路由配置
const Form  = r =>require.ensure([], () => r(require('pages/control/form')),'form')
const Index  = r =>require.ensure([], () => r(require('pages/control/application/index')),'index')

//应用列表
const AppList  = r =>require.ensure([], () => r(require('pages/control/application/list')),'applist')
//添加应用
const AppAdd  = r =>require.ensure([], () => r(require('pages/control/application/add')),'appadd')

const Error404  = r =>require.ensure([], () => r(require('pages/404')),'error404')
//首页home
const Home  = r =>require.ensure([], () => r(require('pages/home/index')),'home')

//用户中心
const UserIndex  = r =>require.ensure([], () => r(require('pages/control/user')),'userIndex')
//用户信息
const UserInfo  = r =>require.ensure([], () => r(require('pages/control/user/info')),'userInfo')
//应用授权管理
const UserOAuth  = r =>require.ensure([], () => r(require('pages/control/user/oauth')),'useroauth')

//API管理
const Api  = r =>require.ensure([], () => r(require('pages/control/api')),'api')

//API详情
const ApiInfo  = r =>require.ensure([], () => r(require('pages/control/api/info')),'apiinfo')
export default [
    {
    	name: 'Control',
        path: '/control',      
        component: Control,
        children: [
       	 {path: 'form',component: Form},
       	 {path: 'index',component: Index},
         {path: 'list',component: AppList},
         {path: 'add',component: AppAdd},

         {path: '/',component: Api},
         {path: 'oauth',component: UserOAuth},
        {path: 'api',component: Api},
        {path: 'api/info',component: ApiInfo},
         {
            path: 'user',
            component: UserIndex,
            children:[
                {path:'/',component:UserInfo}
            ]
         },

        ]
    },
    {
    	name: 'form',
        path: '/form',      
        component: Form,
    },
    {
        path: '*', 
        component: Error404
    },
    {
    	name: 'home',
        path: '/home',      
        component: Home,
        children: [
            // {path: 'api/list',component: Word},
        ]
    },
]