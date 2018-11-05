<template>
	<div class="box">
		<el-row>
		<!--左侧-->
		 <el-col :span="4">
		  	<div id="h-left">
		  		<!--放置左侧内容导航-->
		  		<left></left>
		  	</div>
		  </el-col>
		  <!--右侧-->
		  <el-col :span="20">
		  	<div id="h-right">
		  		<!--头部导航栏-->
				<div id="hr-header">
					
				</div>
				<!--内容区-->
				<div id="hr-content">
					<router-view/>
				</div>
			</div>
		  </el-col>
		</el-row>
	</div>
</template>

<script>
import Left from 'pages/home/left'
export default {
	components:{
		'left':Left,
	}
}
</script>

<style lang="scss" scoped>
/*最外层盒子*/
.box{
	overflow: hidden;
	background: #e6e9ee;
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	top: 0;
}
/*左侧*/
#h-left{
	background: #3c444d;
	height: 100vh;
	overflow-y: auto;
	overflow-x: hidden;
}
/*右侧*/
#h-right{
	margin: 0px 10px 0 10px;
	height:100vh;
	overflow: hidden;
	/*右侧导航*/
	#hr-header{
		overflow: hidden;
		margin-top: 8px;
		height: 43px;
		background: white;
		margin-bottom: 5px;
	}
	/*右侧内容*/
	#hr-content{
		background: white;
		position: absolute;
		left: 17.6%;
		top: 60px;
		right: 10px;
		bottom: 0;
		overflow: auto;
	}
}
</style>

