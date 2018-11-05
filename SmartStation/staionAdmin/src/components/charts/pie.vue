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
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'right',
		        top:100,
		        right:10,
		        data:this.list.dataname
		    },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '45%',
		            center: ['35%', '40%'],
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
		                {value:335, name:'临时用户'},
		                {value:310, name:'期卡用户'},
		                {value:234, name:'充值卡用户'},
		            ],
			        dataname:['临时用户','期卡用户','充值卡用户'],
				}
			}
		}
	}
}
</script>

<style scoped>
</style>
