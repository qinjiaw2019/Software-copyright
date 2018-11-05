import Header from './index.vue'  

Header.install = function(Vue,opt={}){
	Vue.component(Header.name,Header)
}
export default Header  