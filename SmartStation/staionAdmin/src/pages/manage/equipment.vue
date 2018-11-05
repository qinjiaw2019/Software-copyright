<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<!--选择用户-->
			<div class="chooseuser">
				  <el-tabs type="border-card" v-model="nav_address.three">
					 <el-tab-pane label="车位状态管理" name="车位状态管理">
					 	<c-equip></c-equip>
					 </el-tab-pane>
					 <el-tab-pane label="泊车流水" name="泊车流水">
					 	<c-info></c-info>
					 </el-tab-pane>
				 </el-tabs>
			</div>
			
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Equip from '@/pages/manage/equip'
import Info from '@/pages/manage/equip/info'
export default {
	components: {
		'c-nav': Nowadress,
		'c-equip':Equip,
		'c-info':Info,
	},
	data(){
		return{
				nav_address:{
					one:'停车场管理',
					two:'设备管理',
					three:'车位状态管理',
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
