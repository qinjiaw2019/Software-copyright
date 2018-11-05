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
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    	toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {
			                show: true,
			                type: ['pie', 'funnel']
			            },
			            restore : {show: true},
			            saveAsImage : {show: true}
			        },
			        right:30
			    },
			    legend: {
			        x: 'right',
			        data:['未完成','已完成'],
			        type: 'scroll',
        				orient: 'vertical',
        				right: 10,
			        top: 50,
			        bottom: 10,
//			        top:100,
//			        left:10
			    },
			    grid:{
			    		left: '50%',
			    },
			    series: [
			        {
			            name:'单日任务',
			            type:'pie',
			            center:['40%','60%'],
			            radius: ['40%', '53%'],
			            color:['rgba(178, 70, 61, 1.0)', 'rgba(157, 195, 173, 1.0)'], 
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '30',
			                        fontWeight: 'bold'
			                    }
			                }
			            },
			            labelLine: {
			                normal: {
			                    show: false
			                }
			            },
			            data:[
			                {value:this.list.nofinish, name:'未完成'},
			                {value:this.list.finished, name:'已完成'}
			            ]
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
