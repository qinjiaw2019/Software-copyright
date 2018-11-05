<template>
	<div>
		<div>
			<c-boche :list="timelist" @HandWeek="HandWeek" @HandMonth="HandMonth" @HandYear="HandYear"></c-boche>
		</div>
		<el-row>
			<el-col :span="12">
				<div class="map">
					<div class="title1">泊车评价（一周）</div>
					<c-evaluate :list="evaluate_list"></c-evaluate>
				</div>
				<div class="map">
					<div class="cabbox">
						<c-cab :list="cablist1"></c-cab>
					</div>
					<div class="cabbox">
						<c-cab :list="cablist2"></c-cab>
					</div>
				</div>
			</el-col>
			<el-col :span="12">
				<div class="map1">
					<div class="title1">访客类型</div>
					<c-pie :list="visitedlist"></c-pie>
				</div>
				<el-row>
					<el-col :span="8">
						<c-cabtwo :list="cabtwo1"></c-cabtwo>
					</el-col>
					<el-col :span="8">
						<c-cabtwo :list="cabtwo2"></c-cabtwo>
					</el-col>
					<el-col :span="8">
						<c-cabtwo :list="cabtwo3"></c-cabtwo>
					</el-col>
				</el-row>
			</el-col>
		</el-row>
	</div>
</template>

<script>
import {week_cartime,month_cartime,year_cartime,evaluate_list,visitedlist,cablist1,cablist2,cabtwo1,cabtwo2,cabtwo3} from './data.js'
import Pie from '@/components/charts/pie'
import Boche from '@/components/charts/boche'
import Evaluate from '@/components/charts/evaluate'
import Cab from '@/components/cab/index'
import Cabtwo from '@/components/cab/two'

export default {
	components: {
		'c-pie': Pie,
		'c-boche': Boche,
		'c-evaluate': Evaluate,
		'c-cab': Cab,
		'c-cabtwo':Cabtwo
	},
	methods:{
		HandWeek(){

		},
		HandMonth(){
			this.timelist = month_cartime
		},
		HandYear(){
			this.timelist = year_cartime
		}
	},
	created(){
		this.timelist = week_cartime
		this.evaluate_list = evaluate_list
		this.visitedlist = visitedlist
		this.cablist1 = cablist1
		this.cablist2 = cablist2
		this.cabtwo1 = cabtwo1
		this.cabtwo2 = cabtwo2
		this.cabtwo3 = cabtwo3
	},
	data(){
		return{
			timelist:{},
			visitedlist:{},
			evaluate_list:{},
			cablist1:{},
			cablist2:{},
			cabtwo1:{},
			cabtwo2:{},
			cabtwo3:{}
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
.title1{
	height: 35px;
	background-color: rgba(83, 142, 217, 1.0);
	color: white;
	line-height: 35px;
	padding-left: 10px;
}
.cabbox{
	margin-top: 20px;
	margin-left: 20px;
}
</style>
