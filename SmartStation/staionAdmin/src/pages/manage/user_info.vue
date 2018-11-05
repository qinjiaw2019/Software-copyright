<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		
		<div class="main">
			<!--选择用户-->
			<div class="chooseuser">
				<el-tabs type="border-card" v-model="nav_address.three">
					<!--注册用户-->
					 <el-tab-pane label="注册用户" name="注册用户">
					 		<c-tab></c-tab>
					 </el-tab-pane>
					 <!--认证用户-->
					 <el-tab-pane label="认证用户" name="认证用户">
					 </el-tab-pane>
				 </el-tabs>
			</div>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Table from '@/pages/manage/userinfo'
export default {
	components: {
		'c-nav': Nowadress,
		'c-tab': Table
	},
	data(){
		return{
			nav_address:{
				one:'停车场管理',
				two:'用户数据',
				three:'注册用户',
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
	overflow-x: hidden;
	overflow-y: auto;
}
.main{
	margin: 10px;
}
.button{
	background: rgba(220, 225, 228, 1.0);
	border: white 0px solid;
	border-radius: 0px;
	border-right: 1px solid grey;
}
</style>
