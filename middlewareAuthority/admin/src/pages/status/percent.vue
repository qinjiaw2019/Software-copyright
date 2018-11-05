<template>
	<div class="percent">
		<div class="per">
		<span class="per-title">项目</span>
		<span class="per-little">API管理</span>
		<span class="per-little">API流量统计</span>
		</div>
		<hr />
		<div class="tipbox">
			<div ref="demo1" class="tip"></div>
			<div ref="demo2" class="tip"></div>
			<div ref="demo3" class="tip"></div>
			<div ref="demo4" class="tip"></div>
		</div>
	</div>
</template>

<script>
let echarts = require('echarts')
//let echarts = require("./lib/chart/pie")
export default {
	mounted(){
		this.check()
		this.demo1(this.check(this.list1.useper,this.list1.usedper))
		this.demo2(this.check(this.list2.useper,this.list2.usedper))
		this.demo3(this.check(this.list3.useper,this.list3.usedper))
		this.demo4(this.check(this.list4.useper,this.list4.usedper))
	},
	methods:{
		check(a,b){
			let c=b/(a+b)
			console.log(c)
//			const that = this
			if (c<0.4){
				let color=this.color.green
				console.log('color:'+color)
				return color
			}
			if (c>0.7){
				let color=this.color.red
				return color
				console.log('color:'+color)
			}
			else{
				let color=this.color.yellow
				return color
			}
		},
		demo1(color){
			let myChart = echarts.init(this.$refs.demo1)
			let title = '环形图';
			let option = {
				title : {
//					    text: '某站点用户访问来源',
				        subtext: '项目API使用率',
				        x:'center',
					   },
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    color:[color, 'rgba(231, 233, 239, 1.0)'],
			     graphic:{
				    	type:'text',
				    	left:'center',
				    bottom:'0',
				    style:{
				    	text:'项目统计',
				    	textAlign:'center',
				    	fill:'rgba(84, 166, 60, 1.0)',
				    }
			    },
			    series: [
			        {
			            name:'使用率',
			            type:'pie',
			            radius: ['53%', '60%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '20',
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
			                {value:this.list1.usedper, name:this.list1.used},
			                {value:this.list1.useper, name:this.list1.use},
			            ]
			        }
			    ]
			}
			myChart.setOption(option)
		},
		demo2(color){
			let myChart = echarts.init(this.$refs.demo2)
			let title = '环形图';
			let option = {
				title : {
//					    text: '某站点用户访问来源',
				        subtext: '服务器访问API统计',
				        x:'center',
					    },
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    color:[color, 'rgba(231, 233, 239, 1.0)'],
			     graphic:{
				    	type:'text',
				    	left:'center',
				    bottom:'0',
				    style:{
				    	text:'IP量',
				    	textAlign:'center',
				    	fill:'rgba(84, 166, 60, 1.0)',
				    }
			    },
			    series: [
			        {
			            name:'使用率',
			            type:'pie',
			            radius: ['53%', '60%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '20',
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
			            //已使用
			                  {value:this.list2.usedper, name:this.list2.used},
			            //未使用
			                  {value:this.list2.useper, name:this.list2.use},
			            ]
			        }
			    ]
			}
			myChart.setOption(option)
		},
		demo3(color){
			let myChart = echarts.init(this.$refs.demo3)

			let title = '环形图';

			let option = {
				title : {
//					    text: '某站点用户访问来源',
				        subtext: '单日客户端访问/服务端访问',
				        x:'center',
					    },
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    color:[color, 'rgba(231, 233, 239, 1.0)'],
			     graphic:{
				    	type:'text',
				    	left:'center',
				    bottom:'0',
				    style:{
				    	text:'百分比',
				    	textAlign:'center',
				    	fill:'rgba(84, 166, 60, 1.0)',
				    }
			    },
			    series: [
			        {
			            name:'使用率',
			            type:'pie',
			            radius: ['53%', '60%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '20',
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
			               //已使用
			                  {value:this.list3.usedper, name:this.list3.used},
			            //未使用
			                  {value:this.list3.useper, name:this.list3.use},
			            ]
			        }
			    ]
			}
			myChart.setOption(option)
		},
		demo4(color){
			let myChart = echarts.init(this.$refs.demo4)

			let title = '环形图';

			let option = {
				title : {
//					    text: '某站点用户访问来源',
				        subtext: '/data',
				        x:'center',
					    },
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    color:[color, 'rgba(231, 233, 239, 1.0)'],
			     graphic:{
				    	type:'text',
				    	left:'center',
				    bottom:'0',
				    style:{
				    	text:'2核心',
				    	textAlign:'center',
				    	fill:'rgba(84, 166, 60, 1.0)',
				    }
			    },
			    series: [
			        {
			            name:'使用率',
			            type:'pie',
			            radius: ['53%', '60%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '20',
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
			               //已使用
			                  {value:this.list4.usedper, name:this.list4.used},
			            //未使用
			                  {value:this.list4.useper, name:this.list4.use},
			            ]
			        }
			    ]
			}
			myChart.setOption(option)
		}
	},

	data(){
		return{
			color:{
				//绿色
				green:'rgba(100, 222, 90, 1.0)',
//				黄色
				yellow:'rgba(227, 172, 56, 1.0)',
//				红色
				red:'rgba(228, 89, 69, 1.0)',
			},
			list1:{
				use:'未使用',
				useper:30,
				used:'已使用',
				usedper:100,
			},
			list2:{
				use:'未使用',
				useper:313,
				used:'已使用',
				usedper:30,
			},
			list3:{
				use:'未使用',
				useper:300,
				used:'已使用',
				usedper:300,
			},
			list4:{
				use:'未使用',
				useper:90,
				used:'已使用',
				usedper:300,
			}
		}
	}
}
</script>

<style lang="scss" scoped>
.percent{
	height: 272px;
	background: white;
	.per{
		padding: 10px 0px 5px 30px;
		text-align: left;
		.per-title{
			font-size: 1.2em;
		}
		.per-little{
			color: rgba(84, 166, 60, 1.0);
			padding-left: 20px;
			font-size: 0.9em;
		}
	}
	hr{
		background-color: rgba(204,204,204,1);
	    height: 1px;
	    border: none;
	}
	.tipbox{
		padding: 20px 0 0 50px;
		.tip{
			margin-right: 20px;
			width:160px;
			height:160px;
			float: left;
		}
	}
}
</style>
