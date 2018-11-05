<template>
	<div class="percent">
		<div class="tipbox">
			<div ref="demo1" :style="styleSheet"></div>
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
			let title = '多 X 轴示例';
			let colors = ['#5793f3', '#d14a61', '#675bba'];
			let option = {
				xAxis: {
			        type: 'category',
			        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			    },
			    yAxis: {
			        type: 'value',
			        name: '人次'
			    },
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'cross'
			        }
			    },
			    series: [{
			        data: [120, 200, 150, 80, 70, 110, 130],
			        type: 'line',
			        symbol: 'triangle',
			        symbolSize: 20,
			        lineStyle: {
			            normal: {
			                color: 'green',
			                width: 4,
			                type: 'dashed'
			            }
			        },
			        itemStyle: {
			            normal: {
			                borderWidth: 3,
			                borderColor: 'yellow',
			                color: 'blue'
			            }
			        }
			    }]
			};
			myChart.setOption(option)
		},
	},
	computed:{
		styleSheet:function(){
			let style = {
				width:this.list.width,
				height:this.list.height,
			}
			return style
		},
	},
	data(){
		return{
			
		}
	},
	props:{
		list:Object,
			}
}
</script>

<style scoped>
</style>