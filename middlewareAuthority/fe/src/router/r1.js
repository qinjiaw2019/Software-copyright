const Index  = r =>require.ensure([], () => r(require('pages')),'index')
//登录页面导入
const Registration  = r =>require.ensure([], () => r(require('pages/registration')),'registration')

//API文档
const ApiDoc  = r =>require.ensure([], () => r(require('pages/api/doc')),'apidoc')
//API列表
const ApiList  = r =>require.ensure([], () => r(require('pages/api/list')),'apilist')
//API接口
const ApiInterface  = r =>require.ensure([], () => r(require('pages/api/interface')),'apiinterface')
export default [
	{
	    name: 'index',
	    path: '/',
	    component: Index,
	    children:[
	    	// {path:'/',component:ExampleComponents},
	    	// {path:'word',component:Word},
//	    	{path:'br',component:ExampleBr},
//	    	{path:'loading',component:ExampleLoading},
//	    	{path:'icon',component:ExampleIcon},
//	    	{path:'bg',component:ExampleBG},
//	    	{path:'iframe',component:ExampleIFrame},
//	    	{path:'dialog',component:ExampleDialog},
	    ]
	},
	{
		name:'registration',
		path:'/reg',
		component: Registration,
	},
//	    children:[
//	    	{path:'/',component:ExampleComponents},
//	    	{path:'tag',component:ExampleTag},
//	    	{path:'br',component:ExampleBr},
//	    	{path:'loading',component:ExampleLoading},
//	    	{path:'icon',component:ExampleIcon},
//	    	{path:'bg',component:ExampleBG},
//	    	{path:'iframe',component:ExampleIFrame},
//	    	{path:'dialog',component:ExampleDialog},
//	    ]
//	},
	{
		name:'registration',
		path:'/reg',
		component: Registration,
	},
	{
		name:'api_doc',
		path:'/api/doc',
		component: ApiDoc,
	},
	{
		name:'api_list',
		path:'/api/list',
		component:ApiList,
		children:[
			{path:'/',component:ApiInterface},
		]
	}
//	{
//		path:'/loading',
//		component:Loading,
//	},
//	{
//		path:'/testVue',
//		component:TestComponent,
//	}
//	{
//		path:'/loading',
//		component:Loading,
//	},
//	{
//		path:'/testVue',
//		component:TestComponent,
//	}

]