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
				title : {
			        text: this.list.text,
			        subtext: this.list.subtext,
			        x:'center',
			        top:10,
			        left:10
			   },
			    legend: {
			    		type: 'scroll',
        				orient: 'vertical',
			        data:['未完成','已完成'],
			        right: 0,
			        top: 70,
			        bottom: 20,
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    grid:{
			    		left: '50%',
			    },
			    series: [
			        {
			            name:'单日任务',
			            type:'pie',
			            center:['50%','30%'],
			            radius: ['20%', '38%'],
			            color:['rgba(178, 70, 61, 1.0)', 'rgba(157, 195, 173, 1.0)'], 
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    textStyle: {
			                        color: 'rgba(189, 189, 189, 1.0)'
			                    }
			                }
			            },
			            labelLine: {
			                normal: {
			                    lineStyle: {
			                        color: 'rgba(189, 189, 189, 1.0)'
			                    },
			                    smooth: 0.2,
			                    length: 10,
			                    length2: 20
			                }
			            },
			            roseType: 'radius',
			            data:[
			                {value:this.list.nofinish, name:'未完成'},
			                {value:this.list.finished, name:'已完成'}
			            ],
			            animationType: 'scale',
			            animationEasing: 'elasticOut',
			            animationDelay: function (idx) {
			                return Math.random() * 200;
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
