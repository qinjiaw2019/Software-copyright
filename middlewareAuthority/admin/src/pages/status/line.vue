<template>
	<div id="linebox">
		<div class="lineone">
			<span>网络流量</span>
		</div>
		<hr />
		<div class="linetwo">
			<span>上行速度</span>
			<span style="padding-left: 250px;">下行速度</span>
		</div>
		<hr />
		<div class="linethree">
			<span>总发送</span>
			<span style="padding-left: 270px;">总接收</span>
		</div>
		 <div ref="demo1" style="width:600px;height:330px;padding-left: 20px;"></div>
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
    title: {
        text: '接口实时流量'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {
        data:['上行速度','下行速度'],
        right:100
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['12:28:11','12:18:14','12:18:17','12:18:20','12:18:23','12:18:26']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'单位KB/s'
        }
    ],
    series : [
        {
            name:'上行速度',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[5, 1, 3, 3, 2, 4, 5]
        },
        {
            name:'下行速度',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[3, 0, 0, 2, 1, 0, 2]
        },
    ]
};
			myChart.setOption(option)		
		},
	}
}
</script>

<style lang="scss" scoped>
#linebox{
	padding-bottom: 10px;
	background: white;
	.lineone{
		text-align: left;
		font-size: 1.1em;
		padding: 10px 0px 5px 20px;
	}
	.linetwo{
		text-align: left;
		font-size: 1.1em;
		padding: 10px 0px 5px 20px;
	}
	.linethree{
		text-align: left;
		font-size: 1.1em;
		padding: 10px 0px 5px 20px;
		padding-bottom: 30px;
	}
	hr{
    background-color: rgba(204,204,204,1);
    height: 1px;
    border: none;
   }
}
</style>
