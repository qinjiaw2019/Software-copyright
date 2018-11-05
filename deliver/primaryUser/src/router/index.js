import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages'
import Test from '@/pages/text'
import Search from '@/pages/search'
import Deliver from '@/pages/deliver'
import Send from '@/pages/send'

import Login from '@/pages/login'

import UserIndex from '@/pages/user'
import UserAddress from '@/pages/user/address'
import UserAddAddress from '@/pages/user/editAddress'
import UserAddAddressNotice from '@/pages/user/noticed'
import DeliverInfo from '@/pages/deliverinfo'
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
      path:'/search',
      component:Search
    },
    {
      path:'/deliver',
      component:Deliver
    },
    {
      path:'/user',
      component:UserIndex
    },
    {
      path:'/user/address',
      component:UserAddress
    },
    {
      path:'/send',
      component:Send
    },
    {
      path:'/user/add/address',
      component:UserAddAddress
    },
    {
      path:'/user/add/address/notice',
      component:UserAddAddressNotice
    },
    {
      path:'/deliver/info',
      component:DeliverInfo
    },
    {
      path:'/login',
      component:Login
    }
  ]
})

