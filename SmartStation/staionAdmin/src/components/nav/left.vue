<template>
	<div class="box">
		<el-menu
	      default-active="2"
	      class="el-menu-vertical-demo"
	      background-color="#545c64"
	      text-color="#fff"
	      active-text-color="rgba(81, 188, 250, 1.0)"
	      >
	      <el-menu-item v-for="(item,index) in data" :index="index" style="height: 90px;">
	      	<div style="text-align: center;padding-top: 10px;" @click="routerGo(item.router)">
	      		<i :class=item.icon></i>
		        <p style="margin-top: -20px;">{{item.title}}</p>
	      	</div>
	      </el-menu-item>
	      
	    </el-menu>
	</div>
</template>

<script>
import {Nav1,Nav2} from './nav.js'
export default {
	data(){
		return{
			type:2,//用户类型1、停车场管理员 2、系统管理员
			data:[],
		}
	},
	methods: {
//		根据用户类型给定导航页面
		choose(){
			let usertype = localStorage.getItem('usertype')
//				0:停车场管理员
			if (usertype==0){
				this.data = Nav1
				console.log('ddd')
			}
//				1:网站管理员
			if (usertype==1){
				this.data = Nav2
			}
		},
		/*路由跳转*/
	    routerGo(router){
	    		this.$router.push(router)
	    }
	  },
	  created(){
	   	this.choose()
	  }
}
</script>

<style lang="scss" scoped>
@import '../../../static/font/iconfont.css';
.icon{
	font-size: 40px;
  }
</style>
