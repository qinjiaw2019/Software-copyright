<template>
	<div class="box">
		<c-nav></c-nav>
		<div class="main">
			<!--选择用户-->
			<div class="chooseuser">
				<el-tabs v-model="activeName2" type="card" @tab-click="handleClick">
					<!--用户一-->
				    <el-tab-pane label="注册用户" name="first">
					    	
				    </el-tab-pane>
				    <el-tab-pane label="认证用户" name="second">
				    	
				    </el-tab-pane>
				    <el-tab-pane label="认证用户" name="third">
				    	
				    </el-tab-pane>
				  </el-tabs>
			</div>
			
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
export default {
	components: {
		'c-nav': Nowadress,
	},
	data(){
		return{
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
