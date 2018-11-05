<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="安全" name="安全">
			  	<c-safe></c-safe>
			  </el-tab-pane>
			  <el-tab-pane label="关于设备" name="关于设备">
			  	<c-about></c-about>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Safe from '@/pages/system/set/index'
import About from '@/pages/system/set/about'
export default {
	components: {
		'c-nav': Nowadress,
		'c-safe': Safe,
		'c-about': About,
	},
	data(){
		return{
			nav_address:{
				one:'系统管理',
				two:'统计设置',
				three:'安全',
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
