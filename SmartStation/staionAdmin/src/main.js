// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.css'
import echarts from 'echarts'
import china from 'echarts/map/js/china.js'
import VueQuillEditor from 'vue-quill-editor'
import Distpicker from 'v-distpicker'
import VueAMap from 'vue-amap';

import ApiService from '@/service'

// require styles 引入样式
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

Vue.prototype.$api = ApiService

Vue.use(VueAMap);
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$echarts = echarts 
Vue.component('v-distpicker', Distpicker)

Vue.use(VueQuillEditor, /* { default global options } */)
/* eslint-disable no-new */
VueAMap.initAMapApiLoader({
  key: 'YOUR_KEY',
  plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch','AMap.Geolocation', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor','AMap.Geocoder'],
  // 默认高德 sdk 版本为 1.4.4
  v: '1.4.4'
});

new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>'
})
