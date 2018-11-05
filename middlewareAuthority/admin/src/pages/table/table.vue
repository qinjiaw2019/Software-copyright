<template>
	<div class="table">
		<div class="breadcrumb">
			<el-breadcrumb separator="/">
			    <el-breadcrumb-item :to="{ path: '/index' }">
			    	<i class="fa fa-home"></i>首页
			    </el-breadcrumb-item>
			    <el-breadcrumb-item>后台图表</el-breadcrumb-item>
			</el-breadcrumb>			
		</div>
		<hr class="hr" />
		<div class="operation">
			<div class="switch">
				<el-switch
				  v-model="value2"
				  active-color="#13ce66"
				  inactive-color="#ff4949"
				  active-text="开启监控">
				</el-switch>
			</div>
		</div>
		<hr class="hr" />
		<!--表部内容-->
		<div class="table-text">
			<div class="table-cpu">
				<mw-chart :list="list"/>
			</div>			
			<div class="table-storage">
				<mw-chart :list="list"/>				
			</div>
			<div class="table-disk">
 				<mw-chart :list="list"/>			
			</div>
			<div class="table-network">
   				<mw-chart :list="list"/>			
			</div>
		</div>
	</div>
</template>

<script>
import Chart from 'components/chart'
import Bus from 'common/utils/eventBus.js'
let echarts = require('echarts')
export default{
	data(){
		return{
			list:[["1",116],["2",129],["3",135],
				["4",86],["5",73],["6",85],["7",73],["8",44]
				,["9",44],["10",344],["11",144],["12",44],["13",44]
				,["14",44],["15",44],["16",44],["17",44],["18",44]
				,["19",434],["20",44],["21",44],["22",44],["23",44]
				,["24",44]],
			value1: true,
       		value2: true,
       		Line:true
		}
	},
	created(){
		this.$nextTick(() => {
			Bus.$on('handleButton', event=>{
				console.log(event)
			})
		})
	},
	methods:{
		handleButton(val,obj){
//			this.$refs.btn.addClass(selection)
			console.log(val,obj)
		},
	},
	components:{
		'mw-chart':Chart
	}
	
}
</script>

<style scoped>
*{
	padding: 0;
	margin: 0;
}
.breadcrumb{
	margin-top: 10px;
	margin-bottom: 10px;
	line-height: 40px;	
}
.hr{
	height: 10px;
	border: 1px solid rgb(230, 233, 238);
	background-color: rgb(230, 233, 238);
}
/*操作*/
.operation{
	height: 40px;
	overflow: hidden;
	width: 100%;
}
.switch{
	float: left;
	margin-left: 10px;
	text-align: center;
	line-height: 35px;
}
/*表内容*/
.table-text{
	position: absolute;
	top: 88px;
	left: 0;
	right: 0;
	bottom: -90px;
	background-color: rgb(230, 233, 238);	
}
.table-cpu{
	position: absolute;
	background-color: white;
	margin-top: 0;
	left: 0px;
	right: 50.2%;
	height: 300px;
}
.cpu-header{
	width: 100%;
	height: 32px;	
}
.cpu-text{
	width: 100%;
	height: 257px;
}
.btn{
	margin-left: 2px;
}
.btn button{
	float: left;
	cursor: pointer;
	margin-top: 5px;
	margin-left: -2px;
	border: 1px solid rgb(230, 233, 238);
	color: rgb(135, 141, 153);
	background-color: white;
	padding: 2px 4px;
	border-radius: 2px;	
}
.btn button:hover{
	color: white;
	background-color: rgb(32, 165, 58);
	border: 1px solid rgb(32, 165, 58);
	border-radius: 2px;	
}

.table-storage{
	position: absolute;
	height: 300px;
	right: 0px;
	left: 50.2%;
	background-color: white;
}
.storage-header{
	width: 100%;
	height: 32px;
}
.table-disk{
	position: absolute;
	background-color: white;
	left: 0px;
	right: 50.2%;
	top: 49.5%;
	height: 300px;	
}
.table-network{
	position: absolute;
	background-color: white;
	left: 50.2%;
	right: 0px;
	top: 49.5%;
	height: 300px;		
}
</style>