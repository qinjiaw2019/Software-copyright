import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages'
import Test from '@/pages/text'
import User from '@/pages/user/index'
import Static from '@/pages/user/static'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'/index'
    },    
    {
      path: '/index',
      name: 'home',
      component: Index,
      children:[
      ]
    },
    {
      path:'/test',
      name:'home',
      component:Test
    },
    {
      path:'/user',
      component:User
    },
    {
      path:'/user/static',
      component:Static
    }
  ]
})

