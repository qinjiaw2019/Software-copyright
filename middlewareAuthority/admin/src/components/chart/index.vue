<template>
	<div class="chart">
		<div class="cpu-header">
			<div class="btn">
				<button 					
					v-for="(item,index) in timeList"
					class="selection"
					:class="{'se': j==index}"
				    @click.stop.prevent="handleButton(index,item.id,timeList)">{{item.name}}</button>
			</div>
		</div>
		<div class="cpu-text" ref="address"></div>	
	</div>
</template>

<script>
let echarts = require('echarts')
import Bus from 'common/utils/eventBus.js'
export default{
	props:{
		list:{
			type:Array,
		},
	},
	data(){
		return{
			timeList:[
			{
				id:1,
				name:'昨天',
			},
			{
				id:2,
				name:'今天'
			},
			{
				id:3,
				name:'最近七天'
			},
			{
				id:4,
				name:'最近30天'
			},
			{
				id:5,
				name:'最近1年'
			},
			],	
			j:0,
		
		}
	},
	mounted(){
		this.showCpu()
	},
	computed:{
//		selectionIndex(){            
//          for(let i; i<this.timeList.length;i++){
//          	this.j = i
//          }
//		}
	},
	methods:{
		handleButton(val,obj,list){	
			Bus.$emit('handleButton',event)
            this.j = val		
		},
		showCpu(){
			let myChart = echarts.init(this.$refs.address)
			//图表
//			let data = [["2000-06-05",116],["2000-06-06",129],["2000-06-07",135],["2000-06-08",86],["2000-06-09",73],["2000-06-10",85],["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",137],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],["2000-07-24",60]]
			let data = this.list
			myChart.setOption({
		        tooltip: {
		            trigger: 'axis'
		        },
		        backgroundColor: ["white"],
		        xAxis: {
		            data: data.map(function (item) {
		                return item[0];
		            })
		        },
		        yAxis: {
		            splitLine: {
		                show: false
		            }
		        },
		        dataZoom: [{
		            startValue: '1'
		        }, {
		            type: 'inside'
		        }],
		        visualMap: {
		            top: 10,
		            right: 10,
		            pieces: [{
		                gt: 0,
		                lte: 50,
		                color: '#096'
		            }, {
		                gt: 50,
		                lte: 100,
		                color: '#ffde33'
		            }, {
		                gt: 100,
		                lte: 150,
		                color: '#ff9933'
		            }, {
		                gt: 150,
		                lte: 200,
		                color: '#cc0033'
		            }, {
		                gt: 200,
		                lte: 300,
		                color: '#660099'
		            }, {
		                gt: 300,
		                color: '#7e0023'
		            }],
		            outOfRange: {
		                color: '#999'
		            }
		        },
		        series: {
		            name: '访问次数',
		            type: 'line',
		            data: data.map(function (item) {
		                return item[1];
		            }),
//					markLine: {
//			            silent: false,
//			            data: [{
//			                yAxis: 50
//			            }, {
//			                yAxis: 100
//			            }, {
//			                yAxis: 150
//			            }, {
//			                yAxis: 200
//			            }, {
//			                yAxis: 300
//			            }]
//			        },				
		        }
		    });
		},		
	}
}
</script>

<style scoped>
.chart{
	height: 100%;
	width:100%
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
.selection {
	float: left;
	outline-style: none;
	cursor: pointer;
	margin-top: 5px;
	margin-left: -2px;
	border: 1px solid rgb(230, 233, 238);
	color: rgb(135, 141, 153);
	background-color: white;
	padding: 2px 4px;
	border-radius: 2px;	
}
.selection:hover{
	color: white;
	background-color: rgb(32, 165, 58);
	border: 2px solid rgb(32, 165, 58);
	border-radius: 2px;	
}
.se {
	color: white;
	background-color: rgb(32, 165, 58);
	border: 2px solid rgb(32, 165, 58);
	border-radius: 2px;		
}	
</style>