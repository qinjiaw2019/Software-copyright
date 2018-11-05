<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="发布公告" name="发布公告">
			  	<c-broadcast></c-broadcast>
			  </el-tab-pane>
			  <el-tab-pane label="已发公告" name="已发公告">
			  	<div>
			  		<c-cancle></c-cancle>
			  	</div>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Broadcast from './public/boradcast.vue'
import Sent from './public/sent.vue'
export default {
	components: {
		'c-nav': Nowadress,
		'c-broadcast': Broadcast,
		'c-cancle': Sent
	},
	data(){
		return{
			nav_address:{
				one:'停车场管理',
				two:'公告发布',
				three:'发布公告',
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
