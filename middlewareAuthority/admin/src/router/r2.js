
//应用application路由配置
const Login  = r =>require.ensure([], () => r(require('pages/login/index')),'index')

export default [
//  {
//    path: '/',
//    name: 'HelloWorld',
//    component: HelloWorld
//  },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },   
]