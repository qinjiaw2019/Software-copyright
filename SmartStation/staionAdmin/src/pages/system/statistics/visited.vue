<template>
	<div>
		<el-row>
			<el-col :span="12">
				<div class="map">
					<div class="title">访问人次（一周）</div>
					<c-boken2 :list="list6"></c-boken2>
					<div class="choose">
						<span style="margin-right: 20px;">选择显示时间:</span>
						 <el-button type="primary" plain>一周</el-button>
						 <el-button type="primary" plain>一月</el-button>
						 <el-button type="primary" plain>一年</el-button>
					</div>
				</div>
			</el-col>
			<el-col :span="12">
				<div class="map">
					<div class="title">新注册用户（一周）</div>
					<c-boken2 :list="list6"></c-boken2>
					<div class="choose">
						<span style="margin-right: 20px;">选择显示时间:</span>
						 <el-button type="primary" plain>一周</el-button>
						 <el-button type="primary" plain>一月</el-button>
						 <el-button type="primary" plain>一年</el-button>
					</div>
				</div>
			</el-col>
		</el-row>
		<br />
		<el-row>
			<el-col :span="12">
				<div class="mapp">
					<div class="title1">用户评价（一周）</div>
					<c-evaluate :list="user_list"></c-evaluate>
				</div>
				<div class="mapp">
					<div class="title1">管理员评价（一周）</div>
					<c-evaluate :list="manage_list"></c-evaluate>
				</div>
			</el-col>
			<el-col :span="12">
				<div class="map1">
					<div class="title1">停车场类型</div>
						<c-pie :list="stationlist"></c-pie>	
				</div>
				<el-row>
					<el-col :span="8">
						<div class="box">
							<div class="title1">访问人次（一周）</div>
							<div class="box1">
								<p class="best">注册最多<span class="strong">981</span></p>
								<p class="space">坐标<span class="provice">上海</span></p>
							</div>
						</div>
					</el-col>
					<el-col :span="8">
						<div class="box">
							<div class="title1">访问人次（一周）</div>
							<div class="box1">
								<p class="best">注册最多<span class="strong">981</span></p>
								<p class="space">坐标<span class="provice">上海</span></p>
							</div>
						</div>
					</el-col>
					<el-col :span="8">
						<div class="box">
							<div class="title1">访问人次（一周）</div>
							<div class="box1">
								<p class="best">注册最多<span class="strong">981</span></p>
								<p class="space">坐标<span class="provice">上海</span></p>
							</div>
						</div>
					</el-col>
				</el-row>
			</el-col>
		</el-row>
		
	</div>
</template>

<script>
import {user_list,manage_list,stationlist} from './data.js'
import Pie from '@/components/charts/pie'
import Boche from '@/components/charts/boche'
import Evaluate from '@/components/charts/evaluate'
import Boken2 from '@/components/charts/boken'
export default {
	components: {
		'c-pie': Pie,
		'c-boche': Boche,
		'c-evaluate': Evaluate,
		'c-boken2': Boken2,
	},
	created(){
		this.user_list = user_list
		this.manage_list = manage_list
		this.stationlist = stationlist
	},
	data(){
		return{
			stationlist:{},//停车场类型数据
			user_list:{},//用户评价
			manage_list:{},//管理员评价
			
			data:{
				title:'登录人次',
				data_times:'10020',
			},
			list6:{
				width:'600px',
				height:'430px',
			}
		}
	}
}
</script>

<style scoped>
.map{
	border: 1px solid gainsboro;
	height: 550px;
}
.mapp{
	border: 1px solid gainsboro;
	height: 274px;
}
.title{
	height: 45px;
	background-color: rgba(83, 142, 217, 1.0);
	color: white;
	font-size: 1.2em;
	line-height: 45px;
	padding-left: 10px;
}
.choose{
	margin-left: 50px;
	margin-top: 10px;
}
.map1{
	border: 1px solid gainsboro;
	height: 350px;
}
.box{
	border: 1px solid gainsboro;
	height: 198px;
	background: whitesmoke;
}
.title1{
	height: 35px;
	background-color: rgba(83, 142, 217, 1.0);
	color: white;
	line-height: 35px;
	padding-left: 10px;
}
.box1{
	background: whitesmoke;
	text-align: center;
}
.strong{
	font-size: 1.6em;
	margin-left: 10px;
}
.best{
	font-size: 1.3em;
	padding-top: 10px;
}
.space{
	font-size: 0.9em;
	padding-bottom: 10px;
	margin-top: -10px;
	color: gray;
}
.provice{
	font-size: 1.1em;
	margin-left: 10px;
}
</style>
