<template>
   <div>
   	 <div ref="demo1" style="width:800px;height:800px;"></div>
	 <div ref="demo2" style="width:800px;height:800px;"></div>
	 <div ref="demo3" style="width:800px;height:800px;"></div> 
	 <div ref="demo4" style="width:800px;height:800px;"></div> 
   </div>
</template>

<script>

let echarts = require('echarts')
/*
导入模块，由于echarts很大 所以使用的时候必须按需引入，这里为了
简单，导入全部的，按需引入查看admin/docs，图表使用说明.md
1.首先指定dom 这里用div
2.给指定的div设置高度宽度，没有效果
3.使用的时候在method中定义相应的方法，切记不要在created中调用该方法
应在mounted()中调用

参考文档：
http://echarts.baidu.com/tutorial.html#%E4%B8%AA%E6%80%A7%E5%8C%96%E5%9B%BE%E8%A1%A8%E7%9A%84%E6%A0%B7%E5%BC%8F

官网
http://echarts.baidu.com/examples.html

 */
export default{
	mounted(){
		this.demo1()
		this.demo2()
		this.demo3()
		this.demo4()
	},
	methods:{
		demo1(){
			// 基于准备好的dom，初始化echarts实例
			let myChart = echarts.init(this.$refs.demo1)
			// 绘制图表
			myChart.setOption({
			    title: {
			        text: 'ECharts 入门示例'
			    },
			    tooltip: {},
			    xAxis: {
			        data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
			    },
			    yAxis: {},
			    series: [{
			        name: '销量',
			        type: 'bar',
			        data: [5, 20, 36, 10, 10, 20]
			    }]
			})
		},
		demo2(){
			let myChart = echarts.init(this.$refs.demo2)
			myChart.setOption({
			    series : [
			        {
			            name: '访问来源',
			            type: 'pie',
			            radius: '55%',
			            data:[
			                {value:235, name:'视频广告'},
			                {value:274, name:'联盟广告'},
			                {value:310, name:'邮件营销'},
			                {value:335, name:'直接访问'},
			                {value:400, name:'搜索引擎'}
			            ]
			        }
			    ]
			})
		},
		demo3(){
			let myChart = echarts.init(this.$refs.demo3)
			
			let data = [["2000-06-05",116],["2000-06-06",129],["2000-06-07",135],["2000-06-08",86],["2000-06-09",73],["2000-06-10",85],["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",137],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],["2000-07-24",60]]
			var dateList = data.map(function (item) {
			    return item[0];
			})
			var valueList = data.map(function (item) {
			    return item[1];
			});

			let option = {
			    // Make gradient line here
			    visualMap: [{
			        show: false,
			        type: 'continuous',
			        seriesIndex: 0,
			        min: 0,
			        max: 400
			    }, {
			        show: false,
			        type: 'continuous',
			        seriesIndex: 1,
			        dimension: 0,
			        min: 0,
			        max: dateList.length - 1
			    }],


			    title: [{
			        left: 'center',
			        text: 'Gradient along the y axis'
			    }, {
			        top: '55%',
			        left: 'center',
			        text: 'Gradient along the x axis'
			    }],
			    tooltip: {
			        trigger: 'axis'
			    },
			    xAxis: [{
			        data: dateList
			    }, {
			        data: dateList,
			        gridIndex: 1
			    }],
			    yAxis: [{
			        splitLine: {show: false}
			    }, {
			        splitLine: {show: false},
			        gridIndex: 1
			    }],
			    grid: [{
			        bottom: '60%'
			    }, {
			        top: '60%'
			    }],
			    series: [{
			        type: 'line',
			        showSymbol: false,
			  					      data: valueList
			    }, {
			        type: 'line',
			        showSymbol: false,
			        data: valueList,
			        xAxisIndex: 1,
			        yAxisIndex: 1
			    }]
			}
			myChart.setOption(option)		
		},
		demo4(){
			let myChart = echarts.init(this.$refs.demo4)
			
			let title = '环形图';

			let option = {
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'left',
			        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
			    },
			    series: [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius: ['50%', '70%'],
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
			                {value:335, name:'直接访问'},
			                {value:310, name:'邮件营销'},
			                {value:234, name:'联盟广告'},
			                {value:135, name:'视频广告'},
			                {value:1548, name:'搜索引擎'}
			            ]
			        }
			    ]
			}
			myChart.setOption(option)
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>