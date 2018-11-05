<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="泊车报表" name="泊车报表">
			  	<c-form></c-form>
			  </el-tab-pane>
			  <el-tab-pane label="收入流水" name="收入流水">
			  	<c-deliver></c-deliver>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Form from '@/pages/manage/form/index'
import Deliver from '@/pages/manage/form/deliver'
export default {
	components: {
		'c-nav': Nowadress,
		'c-form': Form,
		'c-deliver': Deliver
	},
	data(){
		return{
			nav_address:{
				one:'停车场管理',
				two:'报表管理',
				three:'泊车报表',
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
