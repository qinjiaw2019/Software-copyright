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
			let title = '环形图';
			let option = {
				title: {
		        text: this.list.title,
		    },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        },
		        formatter: function (params) {
		            var tar = params[1];
		            return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type : 'category',
		        splitLine: {show:false},
		        data: this.list.data_name,
		    },
		    yAxis: {
		        type : 'value'
		    },
		    series: [
		        {
		            name: '辅助',
		            type: 'bar',
		            stack:  '总量',
		            itemStyle: {
		                normal: {
		                    barBorderColor: 'rgba(0,0,0,0)',
		                    color: 'rgba(0,0,0,0)'
		                },
		                emphasis: {
		                    barBorderColor: 'rgba(0,0,0,0)',
		                    color: 'rgba(0,0,0,0)'
		                }
		            },
		            data: this.list.cha
		        },
		        {
		        		name: this.list.num_name,
		            type: 'bar',
		            stack: '总量',
		            label: {
		                normal: {
		                    show: true,
		                    position: 'inside'
		                }
		            },
		            data: this.list.num
		        }
		    ]
		}
		myChart.setOption(option)
		},
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
	props:{
		type:{
			type:Object,
			default:function(){
				return {
					width:'550px',
					height:'300px',
				}
			}
		},
		list:{
			type:Object,
			default:function(){
				return {
					title:'月收入构成单元',
					num_name:'月收入',
					num:[2900, 1300, 1200,400],
					cha:[0, 1600, 400,0],
			        data_name:['总值','临时卡','期卡','充值卡'],
				}
			}
		}
	}
}
</script>

<style scoped>
</style>
