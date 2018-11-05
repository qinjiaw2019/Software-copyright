<template>
	<div class="percent">
		<div class="tipbox">
			<div ref="demo1" :style="styleSheet">
			</div>
			<div style="position: absolute;top: 40px;right: 13%;">
				<el-button type="primary" plain @click="HandWeek">一周</el-button>
				 <el-button type="primary" plain @click="HandMonth">一月</el-button>
				 <el-button type="primary" plain @click="HandYear">一年</el-button>
			</div>
		</div>
	</div>
</template>

<script>
let echarts = require('echarts')
export default {
	mounted(){
		this.demo1()
	},
	methods:{
		demo1(){
			let myChart = echarts.init(this.$refs.demo1)
			let title = '环形图';
			let option = {
				title: {
			        text: this.list.title,
			        subtext: this.list.subtext,
			        left:'50px'
			    },
				xAxis: {
			        type: 'category',
			        data: this.list.dataname
			    },
			    yAxis: {
			        type: 'value',
			        name:this.list.title
			    },
			    grid: {
			        top: 100,
			        bottom: 50
			    },
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'cross'
			        }
			    },
			    series: [{
			        data: this.list.data,
			        type: 'line',
			        smooth: true,
			    },
			    ]
			}
			myChart.setOption(option)
		},
		HandWeek(){
			this.$emit('HandWeek')
		},
		HandMonth(){
			this.$emit('HandMonth')
		},
		HandYear(){
			this.$emit('HandYear')
		}
	},
	computed:{
		styleSheet:function(){
			let style = {
				width:this.type.width,
				height:this.type.height,
			}
			return style
		},
	},
	data(){
		return{
			demo:'demo2'	
		}
	},
	props:{
		type:{
			type:Object,
			default:function(){
				return {
					width:'1100px',
					height:'600px',
				}
			}
		},
		list:{
			type:Object,
			default:function(){
				return {
					title:'泊车次',
					subtext: '一周泊车',
					data:[820, 932, 901, 934, 1290, 1330, 1320],
			        dataname:['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
				}
			}
		},
	}
}
</script>

<style scoped>
</style>
