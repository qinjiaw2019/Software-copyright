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
	props:{
		type:{
			type:Object,
			default:function(){
				return {
					width:'1150px',
					height:'500px',
				}
			}
		},
		list:{
			type:Object,
			default:function(){
				return {
					title:'标题',
					subtitle:'副标题',
					numtype:['type1', 'type2'],
					dataAxis:['data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data8', 'data9', 'data10'],
					data:[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133],
			        nodata:[220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133],
				}
			}
		}
	},
	data(){
		return{
			yMax:500,
			dataShadow:[],
			itemStyle:{
			    normal: {
			    	color: 'rgba(112, 158, 166, 1.0)'
			    },
			    emphasis: {
			        barBorderWidth: 1,
			        shadowBlur: 10,
			        shadowOffsetX: 0,
			        shadowOffsetY: 0,
			        shadowColor: 'rgba(0,0,0,0.5)'
			    }
			},
			itemStyle1:{
			    normal: {
			    	color: 'rgba(154, 154, 154, 0.5)'
			    },
			    emphasis: {
			        barBorderWidth: 1,
			        shadowBlur: 10,
			        shadowOffsetX: 0,
			        shadowOffsetY: 0,
			        shadowColor: 'rgba(0,0,0,0.5)'
			    }
			}
		}
	},
	mounted(){
		this.demo1()
	},
	created(){
		for (var i = 0; i < this.list.data.length; i++) {
		    this.dataShadow.push(yMax);
		}	
	},
	methods:{
		demo1(){
			let myChart = echarts.init(this.$refs.demo1)
			let option = {
				 title: {
			        text: this.list.title,
			        subtext: this.list.subtitle
			    },
			    legend: {
			        data: this.list.numtype,
			        align: 'left',
			        left: 200
			    },
			    toolbox: {
			        feature: {
			            magicType: {
			                type: ['stack', 'tiled']
			            },
			            dataView: {}
			        },
			        right:200,
			    },
			    tooltip: {},
			    xAxis: {
			        data: this.list.dataAxis,
			        axisLabel: {
			            inside: true,
			            textStyle: {
			                color: '#fff'
			            }
			        },
			        axisTick: {
			            show: false
			        },
			        axisLine: {
			            show: false
			        },
			        z: 10
			    },
			    yAxis: {
			        axisLine: {
			            show: false
			        },
			        axisTick: {
			            show: false
			        },
			        axisLabel: {
			            textStyle: {
			                color: '#999'
			            }
			        }
			    },
			    dataZoom: [
			        {
			            type: 'inside'
			        }
			    ],
			    series: [
			        { // For shadow
			            type: 'bar',
			            itemStyle: {
			                normal: {color: 'rgba(112, 158, 166, 1.0)'}
			            },
			            barGap:'-100%',
			            barCategoryGap:'40%',
			            data: this.dataShadow,
			            animation: false
			        },
			        {
			            name: '已注册',
			            type: 'bar',
			            stack: 'two',
			            itemStyle: this.itemStyle,
			            data: this.list.data
			        },
			        {
			            name: '未注册',
			            type: 'bar',
			            stack: 'two',
			            itemStyle: this.itemStyle1,
			            data: this.list.nodata
			        },
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
}
</script>

<style scoped>
</style>
