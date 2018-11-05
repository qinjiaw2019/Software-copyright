<template>
	<div>
		<div class="bar">
			<c-rate :list="area_list"></c-rate>
		</div>
		<el-row>
			<el-col :span="12">
				<div class="map">
					<div class="title">注册分布图</div>
					<c-map></c-map>
				</div>
			</el-col>
			<el-col :span="12">
				<div class="ring">
					<div class="title">总体注册率</div>
					<c-ring :list="list"></c-ring>
				</div>
				<div class="ring2">
					<div class="title">注册分析</div>
					<div class="word">
						<div class="box">
							<p class="best">{{analysis.title}}<span class="strong">{{analysis.num}}</span></p>
							<p class="space">坐标<span class="provice">{{analysis.address}}</span></p>
						</div>
						<div class="box">
							<p class="best">{{analysis1.title}}<span class="strong">{{analysis1.num}}</span></p>
							<p class="space">坐标<span class="provice">{{analysis1.address}}</span></p>
						</div>
					</div>
				</div>
			</el-col>
		</el-row>
	</div>
</template>

<script>
import {area_list,analysis,analysis1} from './data.js'
import Map from '@/components/charts/map'
import Rate from '@/components/charts/rate'
import Ring from '@/components/charts/ring'
export default {
	components: {
		'c-map': Map,
		'c-rate':Rate,
		'c-ring':Ring,
	},
	created(){
		this.area_list = area_list
		this.analysis = analysis
		this.analysis1 = analysis1
	},
	data(){
		return{
			area_list:{},
			analysis:{},
			analysis1:{},
			list:{
				width:'500px',
				height:'500px',
				nofinish:100,
				finished:200
			}
		}
	}
}
</script>

<style scoped>
.map{
	border: 1px solid gainsboro;
	height: 650px;
}
.ring{
	border: 1px solid gainsboro;
	height: 325px;
}
.ring2{
	border: 1px solid gainsboro;
	height: 323px;
}
.bar{
	border: 1px solid gainsboro;
	padding: 20px;
}
.title{
	height: 45px;
	background-color: rgba(83, 142, 217, 1.0);
	color: white;
	font-size: 1.2em;
	line-height: 45px;
	padding-left: 10px;
}
.box{
	background: whitesmoke;
}
.word{
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
