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
				tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'left',
			        left:20,
			        top:50,
			        data:this.list.dataname
			    },
			    series: [
			        {
			            name:this.list.title,
			            type:'pie',
			            center:['60%','40%'],
			            radius: ['30%', '50%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                }
			            },
			            labelLine: {
			                normal: {
			                    smooth: 0.2,
			                    length: 10,
			                    length2: 20
			                }
			            },
			            data:this.list.data,
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
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
					title:'访问来源',
					data:[
			                {value:335, name:'不满意'},
			                {value:310, name:'还行'},
			                {value:234, name:'一般'},
			                {value:135, name:'满意'},
			                {value:1548, name:'非常满意'}
			            ],
			        dataname:['不满意','还行','一般','满意','非常满意'],
				}
			}
		}
	}
}
</script>

<style scoped>
</style>
