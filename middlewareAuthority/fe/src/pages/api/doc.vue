<template>
	<div class="box-wapper">
	<div class="search">
		
	</div>
		<div class="box">
			<el-row>
			<!--左侧-->
			 <el-col :span="4">
			  	<div id="h-left">
			  		<!--放置左侧内容导航-->
			  		<mw-navigationleft :word="wordone"></mw-navigationleft>
			  	</div>
			  </el-col>
			  <!--右侧-->
			  <el-col :span="19">
			  	<div id="h-right">
			  		<!--头部导航栏-->
					<div id="hr-header">
						<mw-navigation></mw-navigation>
					</div>
					<!--内容区-->
					<div id="hr-content">
						<router-view/>
					</div>
				</div>
			  </el-col>
			</el-row>

		</div>
	</div>
</template>

<script>
import {Navigation,Navigationleft} from 'components'
export default {
	components: {
		'mw-navigation': Navigation,
		'mw-navigationleft': Navigationleft,
	},
	data(){
		return{
			wordone:[{
				headings:'条码支付接入指引',
			},{
				headings:'扫码支付接入指引',
			},{
				headings:'快速接入',
			},{
				headings:'异步通知',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},{
				headings:'接入必读',
			},
			]
		}
	}
}
</script>

<style lang="scss" scoped>
/*最外层盒子*/
.box-wapper{
	.search{
		height:86px;
		background-color: #232940;
		margin-bottom:20px;
	}	
}
.box{
	width:100%;
	height:100%;
	background:#fff;
	width:1300px;
	margin:auto;
}
/*左侧*/
#h-left{
	/*background: #6F7180;*/
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


