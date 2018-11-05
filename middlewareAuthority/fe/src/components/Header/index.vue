<template>
	<div class="home">
		<!--用户页面的头部header-->
		<div class="home-header">
			<div class="home-menu">
				<div class="home-icon">
					<!-- <img src="https://zos.alipayobjects.com/rmsportal/ZBtrIlcNSvkudzvriZvZ.png" /> -->
				</div>
				<el-menu
				    class="el-menu-demo"
				    mode="horizontal"
				    @select="handleSelect"
				    background-color="black"
				    text-color="#fff"
				    active-text-color="#ffd04b">
				    <span v-for="(item,index) in list" >
				    	<el-menu-item :index="index+''" v-if="item.children==null">{{item.name}}</el-menu-item>
					    <el-submenu :index="index+''" v-if="item.children!=null">
						    <template slot="title">{{item.name}}</template>
						    <el-menu-item :index="index+'+'+j" v-for="(i,j) in item.children">
						    <span @click="routerGo()">{{i.name}}</span></el-menu-item>
						</el-submenu>
				    </span>
				</el-menu>
			</div>
			<div class="login" v-if="!islogin">登录</div>
			<div class="login"  v-if="islogin">控制台</div>
			<div class="helper">帮助支持</div>
		</div>
	</div>
</template>

<script>
//import Login from 'components/Login'
import {user} from 'service'
export default {
	data(){
		return{
		islogin:false,
		list:[
		    {
		   		id:1,
			   	name:'首页',
			   	router:'/',
			   	children:[
				   	{
				   		id:1,
				   		name:'首页',
				   		router: '/',
				   	}
			   	]
		    },
		    {
		   		id:2,
			   	name:'开发接入',
			   	router: '/home',
			   	children:[
          ],
		    },
		    {
		   		id:3,
			   	name:'文档中心',
			   	router: '/home',
			   	children:[
			   	{
			   		id:1,
			   		name:'接口文档',
			   		router: '/home',
			   	},
			   	{
			   		id:2,
			   		name:'行业解决方案',
			   		router: '#',
			   	},
			   	{
			   		id:3,
			   		name:'合作方式',
			   		router: '#'
			   	}
			   	]
		    },
			{
			   	id:3,
			   	name:'帮助与支持',
			   	router: '/control',
			   	children:[
				   	{
				   		id:3,
				   		name:'系统帮助',
				   		router: '/control'
				   	},
             	{
				   		id:3,
				   		name:'用户帮助',
				   		router: '/control'
				   	},
             	{
				   		id:3,
				   		name:'管理员帮助',
				   		router: '/control'
				   	},
             	{
				   		id:3,
				   		name:'项目接入帮助',
				   		router: '/control'
				   	}
				 ]
			}
		]
		}
	},
	methods:{
		handleSelect(key, keyPath){
			let index = key.substring(0,key.indexOf('+'))//1级数组索引
			let subIndex = key.substring(key.indexOf('+')+1)//2级数组索引

			let router = this.list[index].children[subIndex].router//得到2级路由
			this.routerGo(router)//路由跳转

		},
		routerGo(router){
        	if(router!=undefined)
        		this.$router.push(router)
        }
	},
	components: {
//		'mw-login': Login,
	},
}
</script>

<style>
/*header部分的css*/
.home-header{
	position: absolute;
	height: 60px;
	top: 0;
	width: 100%;
	background-color: black;
	/*z-index: 10;*/
}
.home-icon img{
	position: absolute;
	left: 10px;
	width: 132px;
	height: 47.47px;
}
/*meun*/
.el-menu-demo{
	position: absolute;
	left: 142px;
	right: 0;
	top: -8px;
}
.change{
	position: absolute;
	top: -8px;
	z-index: 1000;
	text-align: center;
}
.login{
	float: right;
	margin-right: 10px;
	line-height: 50px;
	cursor: pointer;
	color: white;
}
.helper{
	float: right;
	cursor: pointer;
	line-height: 50px;
	margin-right: 10px;
	color: white;
}
.helper:hover{
	color: blue;
}
.login:hover{
	color: blue;
}
</style>

