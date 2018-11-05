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
			let title = '正负条形图';
			let option = {
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data:['利润', '支出', '收入']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'value'
        }
    ],
    yAxis : [
        {
            type : 'category',
            axisTick : {show: false},
            data : ['周一','周二','周三','周四','周五','周六','周日']
        }
    ],
    series : [
        {
            name:'利润',
            type:'bar',
            label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            },
            data:[200, 170, 240, 244, 200, 220, 210]
        },
        {
            name:'收入',
            type:'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true
                }
            },
            data:[320, 302, 341, 374, 390, 450, 420]
        },
        {
            name:'支出',
            type:'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'left'
                }
            },
            data:[-120, -132, -101, -134, -190, -230, -210]
        }
    ]
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