<template>
	<div>
		<div>
			<c-boche :list="boche_list"></c-boche>
		</div>
	</div>
</template>

<script>
import {boche_list} from './data.js'
import Pie from '@/components/charts/pie'
import Boche from '@/components/charts/boche'
import Evaluate from '@/components/charts/evaluate'
export default {
	components: {
		'c-pie': Pie,
		'c-boche': Boche,
		'c-evaluate': Evaluate,
	},
	created(){
		this.boche_list = boche_list
	},
	data(){
		return{
			boche_list:{},
			list:{
				width:'500px',
				height:'400px',
				title:'访问来源',
				data:[
	                {value:335, name:'临时用户'},
	                {value:310, name:'期卡用户'},
	                {value:234, name:'充值卡用户'},
	            ],
		        dataname:['临时用户','期卡用户','充值卡用户'],
			}
		}
	}
}
</script>

<style scoped>
.map{
	border: 1px solid gainsboro;
	height: 274px;
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
