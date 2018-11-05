<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			 <el-tab-pane label="系统推广" name="系统推广">
			  	<c-area></c-area>
			  </el-tab-pane>
			  <el-tab-pane label="资源数据分析" name="用户数据分析">
			  	<c-resource></c-resource>
			  </el-tab-pane>
			  <el-tab-pane label="访问数据分析" name="访问数据分析">
			  	<c-visit></c-visit>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Resource from './statistics/resource'
import Visit from './statistics/visited'
import Area from './statistics/area'
export default {
	components: {
		'c-nav': Nowadress,
		'c-resource': Resource,
		'c-visit': Visit,
		'c-area': Area,
	},
	data(){
		return{
			nav_address:{
				one:'系统管理',
				two:'统计分析',
				three:'系统推广',
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
