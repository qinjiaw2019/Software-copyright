// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import YDUI from 'vue-ydui'
import 'vue-ydui/dist/ydui.rem.css';
import 'vue-ydui/dist/ydui.flexible.js'

import HeaderComponent from '@/components/Header/index.js'

Vue.use(YDUI)
Vue.use(HeaderComponent)
Vue.config.productionTip = false

// 解决点击事件延迟
document.addEventListener('DOMContentLoaded', function() {
    typeof FastClick === 'function' && FastClick.attach(document.body);
}, false)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
// //路由开始之前的操作
// router.beforeEach((to, from, next) => {

//   //检查用户是否登陆
//   let userKey = true

//   if (!userKey && to.path !== '/login') {
//     next({path: '/login'})
//   } else if (userKey && to.path === '/login') {
//       next({ path: '/index' })
//   } else {
//       next()
//   }
// })
   // XBack.listen(function(){　　　　　　　　　　　　//这个是vux的确认弹出框
   //   alert('back')
   //        // history.pushState('x-back', null, location.href);

   //  });