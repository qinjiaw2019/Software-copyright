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
			let option = {
				title : {
			        text: this.list.text,
			        x:'center',
			        top:4,
			        left:10
			    },
			    tooltip: {
			        trigger: 'axis'
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
			        data:this.list.show,
			        top:24,
			        left:100,
			    },
			        dataZoom: [
			        {
			            show: true,
			            realtime: true,
			            start: 50,
			            end: 100
			        },
			        {
			            type: 'inside',
			            realtime: true,
			            start: 50,
			            end: 100
			        }
			    ],
			    xAxis: {
			        type: 'category',
			        boundaryGap : false,
            			axisLine: {onZero: true},
			        data: this.list.time_data,
				    },
			    yAxis: {
			    		name: '件数',
			        type: 'value'
			    },
				series:this.list.series
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
