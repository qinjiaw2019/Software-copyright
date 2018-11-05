<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="停车场数据" name="停车场数据">
			  	<div>
			  		<c-info></c-info>
			  	</div>
			  </el-tab-pane>
			  <el-tab-pane label="新增停车场" name="新增停车场">
			  	<div>
			  		<c-add></c-add>
			  	</div>
			  </el-tab-pane>
			</el-tabs>
		</div>
		
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Add from './park/add'
import Info from './park/info'
export default {
	components: {
		'c-nav': Nowadress,
		'c-add': Add,
		'c-info': Info,
	},
	data(){
		return{
			nav_address:{
				one:'系统管理',
				two:'停车场管理',
				three:'停车场数据',
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
