<template>
	<div class="control-header">
			<div class="mrst-icon">
				<i class="fa fa-cloud"></i>
			</div>
			<div class="header-contain">
				<el-menu
					class="el-menu-demo"
					mode="horizontal"
					@select="handleSelect"
					background-color="rgb(55,61,65)"
					text-color="#fff"
					active-text-color="#ffd04b">
					<el-menu-item index="1">控制台管理</el-menu-item>
					<el-submenu index="2">
					   <template slot="title">我的工作台</template>
					   <el-menu-item index="2-1">选项1</el-menu-item>
					   <el-menu-item index="2-2">选项2</el-menu-item>
					   <el-menu-item index="2-3">选项3</el-menu-item>
					</el-submenu>				
				</el-menu>			
			</div>
			<div class="header-right">
				<el-menu
					class="el-menu-demo"
					mode="horizontal"
					@select="handleSelect"
					background-color="rgb(55,61,65)"
					text-color="#fff"
					active-text-color="#ffd04b">
					<el-menu-item index="3">服务</el-menu-item>
					<el-menu-item index="4">管理</el-menu-item>						
					<el-menu-item index="5">{{getUsername}}</el-menu-item>					
					<el-submenu index="6">
					   <template slot="title">我的工作台</template>
					   <el-menu-item index="6-1">选项1</el-menu-item>
					   <el-menu-item index="6-2">选项2</el-menu-item>
					   <el-menu-item index="6-3">选项3</el-menu-item>
					</el-submenu>					
				</el-menu>					
			</div>
		</div>
</template>

<script>
import {user} from 'service'	
export default{
	data(){
		return {
			getUsername: user.getUsername(),
		}
	},
	methods: {
		handleSelect(key, keyPath) {
          console.log(key, keyPath);
          
        },
		handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
	}
}
</script>

<style>
/*control页面的头部导航页*/
.control-header{
	height: 60px;
	width: 100%;
	background-color: rgb(55,61,65);
	position: absolute;	
	color: white;
	font-size: 25px;
	line-height: 60px;
}
.header-contain{
	position: absolute;
	left: 100px;
}
.mrst-icon{
	position: absolute;
	left: 0;
	height: 61px;
	width: 100px;
	line-height: 60px;
}
.header-right{
	position: absolute;
	right: 0;
}
</style>