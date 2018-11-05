<template>
	<div>
		<div class="box">
			<c-boche :list="incomelist"></c-boche>
		</div>
		<div class="box">
			<el-row>
				<el-col :span="12" :offset="1">
					<div>
						<c-make :list="inmake_list"></c-make>
					</div>
				</el-col>
				<el-col :span="8">
					<div>
						<c-evaluate :list="makelist"></c-evaluate>
					</div>
				</el-col>
			</el-row>
		</div>
		<el-row gutter="20">
			<el-col :span="7">
				<div class="cabbox">
					<c-cab :list="cablist1"></c-cab>
				</div>
				<div class="cabbox">
					<c-cab :list="cablist2"></c-cab>
				</div>
			</el-col>
			<el-col :span="7">
				<div class="cabbox">
					<c-cab :list="cablist3"></c-cab>
				</div>
			</el-col>
		</el-row>
	</div>
</template>

<script>
import {incomelist,inmake_list,makelist,cablist1,cablist2,cablist3} from './data2.js'
import Pie from '@/components/charts/pie'
import Boche from '@/components/charts/boche'
import Make from '@/components/charts/make'
import Evaluate from '@/components/charts/evaluate'
import Cab from '@/components/cab/index'
export default {
	components: {
		'c-pie': Pie,
		'c-boche': Boche,
		'c-evaluate': Evaluate,
		'c-make': Make,
		'c-cab': Cab
	},
	created(){
		this.incomelist = incomelist
		this.inmake_list = inmake_list
		this.makelist = makelist
		this.cablist1 = cablist1
		this.cablist2 = cablist2
		this.cablist3 = cablist3
	},
	data(){
		return{
			incomelist:{},//停车场收入
			inmake_list:{},//停车场收入构成
			makelist:{},//停车场输入构成百分比
			cablist1:{},//充值卡持有人数
			cablist2:{},//期卡持有人数
			cablist3:{}//临时卡停车次
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
	padding-bottom: 20px;
	margin-bottom: 20px;
	border-bottom: 1px solid gainsboro;
}
.cabbox{
	margin-top: 10px;
}
</style>
