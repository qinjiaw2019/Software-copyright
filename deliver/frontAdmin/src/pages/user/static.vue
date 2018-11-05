<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="快递员小助手"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<div class="rate" id="rate"></div>
    	 </div>
    	 <v-bottom/>
    </div>
</template>

<script>
let echarts = require('echarts')
import Bottom from '@/components/Bottom'
export default{
	components:{
		'v-bottom':Bottom,
	},
	mounted(){
		// 基于准备好的dom，初始化echarts实例
		let myChart = echarts.init(document.getElementById('rate'));

		let option = {
		    legend: {
		        orient: 'vertical',
		        x: 'left',
		        data:['生活用品','休闲零食','母婴玩具','小家电']
		    },

		    series: [
		        {
		            type:'pie',
		            selectedMode: 'single',
		            radius: [0, '80%'],

		            label: {
		                normal: {
		                    position: 'inner'
		                }
		            },
		           
		            data:[
		                {value:335, name:'生活用品', selected:true},
		                {value:679, name:'休闲零食',selected:false},
		                {value:1548, name:'母婴玩具'},
		                {value:1548, name:'小家电'}
		            ]
		        }
		    ]
		}
		// 绘制图表
		myChart.setOption(option)
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	}
}   
</script>

<style lang="" scoped>
  .rate{
 	height: 500px;
 }     
</style>