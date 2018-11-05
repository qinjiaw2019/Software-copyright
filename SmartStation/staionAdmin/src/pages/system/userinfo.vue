<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="停车场管理员" name="停车场管理员">
			  	<c-manage></c-manage>
			  </el-tab-pane>
			  <el-tab-pane label="注册用户" name="注册用户">
			  	<c-normal></c-normal>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Manage from './userinfo/manage'
import Normal from './userinfo/normal'
export default {
	components: {
		'c-nav': Nowadress,
		'c-manage': Manage,
		'c-normal': Normal,
	},
	data(){
		return{
			nav_address:{
				one:'系统管理',
				two:'用户数据',
				three:'停车场管理员',
			}
		}
	},
	methods: {
   },
   computed:{
		styleSheet:function(){
			let style = {
				background:this.background
			}
			return style
		}
	},
}
</script>

<style scoped>
.box{
	border: 1px solid gainsboro;
}
.main{
	margin: 10px;
}
</style>
