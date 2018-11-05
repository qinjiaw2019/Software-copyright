const Index  = r =>require.ensure([], () => r(require('pages')),'index')

//首页内容页
const Main  = r =>require.ensure([], () => r(require('pages/main')),'main')

const Shiyan  = r =>require.ensure([], () => r(require('pages/shiyan')),'shiyan')
//module
//list
const ModuleList  = r =>require.ensure([], () => r(require('pages/module/list')),'modulelist')

//apilist
const ApiList  = r =>require.ensure([], () => r(require('pages/module/apiList')),'apilist')

//增加功能
const Add  = r =>require.ensure([], () => r(require('pages/tpl/add')),'add')
//增加功能2
const Addtwo  = r =>require.ensure([], () => r(require('pages/tpl/addtwo')),'addtwo')
//增加功能3
const Addthree  = r =>require.ensure([], () => r(require('pages/tpl/addthree')),'addthree')
//增加功能4
const Addfour  = r =>require.ensure([], () => r(require('pages/tpl/addfour')),'addfour')
//增加功能5
const Addfive  = r =>require.ensure([], () => r(require('pages/tpl/addfive')),'addfive')

//module增加功能
const ModuleAdd  = r =>require.ensure([], () => r(require('pages/module/addfour')),'moduleadd')
//module增加功能1
const ModuleAddone  = r =>require.ensure([], () => r(require('pages/module/add')),'module')
//404错误页面
const NotFoundComponent   = r =>require.ensure([], () => r(require('pages/404')),'moduleadd')
//图表状态
const Status  = r =>require.ensure([], () => r(require('pages/status')),'status')
//后台table表数据
const Table   = r =>require.ensure([], () => r(require('pages/table/table')),'table')
//接口表格
const Api  = r =>require.ensure([], () => r(require('pages/api')),'api')
export default [
	{
	    name: 'index',
	    path: '/index',
	    component: Index,
	    children:[
	    {
	    	path:'/',
	    	component:Main,
	    },
	    {
	    	    name:'shiyan',
		    	path:'shiyan',
		    	component: Shiyan,
	    },
	    {
	    	    name:'add',
		    	path:'tpl/add',
		    	component: Add,
	    },	 
	    {
	    	    name:'addtwo',
		    	path:'tpl/addtwo',
		    	component: Addtwo,
	    },
	    {
	    	    name:'addthree',
		    	path:'tpl/addthree',
		    	component: Addthree,
	    },
	     {
	    	    name:'addfour',
		    	path:'tpl/addfour',
		    	component: Addfour,
	    },
	    {
	    	    name:'addfive',
		    	path:'tpl/addfive',
		    	component: Addfive,
	    },
	    {
	    	    name:'list',
		    	path:'tpl/list',
		    	component: Shiyan,
	    }, 
	    {
	        path: 'module/list',
	        name: 'ModuleList',
	        component: ModuleList
		},    
	    {
	        path: 'module/apilist',
	        name: 'ApiList',
	        component: ApiList
		}, 		
	    {
	    	    name:'moduleadd',
		    	path:'module/add',
		    	component: ModuleAdd,
	    },  
	     {
	    	    name:'module',
		    	path:'role/add',
		    	component: ModuleAddone,
	    },
	    {
	    	    name:'status',
		    	path:'status',
		    	component:Status,
	    },
	    {
	    	    name:'api',
		    	path:'module/api',
		    	component:Api,
	    }, 
	     {
	    	    name:'table',
		    	path:'module/table',
		    	component: Table,
	    },
	    {
		    	path:'*',
		    	component: NotFoundComponent,
	    },   
	    ]	    
    },  
]
