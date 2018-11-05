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
				title: {
			        text: this.list.title,
			        subtext: this.list.subtext,
			        left: 'left'
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
			        top:30,
			        right:50
			    },
			    legend: {
			    		type: 'scroll',
        				orient: 'vertical',
        				right: 30,
			        top: 80,
			        bottom: 10,
			        data: this.list.lable
			    },
			    series: [
			        {
			            name:'订单来源',
			            type:'pie',
			            selectedMode: 'single',
			            radius: [0, '30%'],
			            label: {
			                normal: {
			                    position: 'inner'
			                }
			            },
			            labelLine: {
			                normal: {
			                    show: false
			                }
			            },
			            data:this.list.type_data
			        },
			        {
			            name:'订单来源',
			            type:'pie',
			            radius: ['40%', '55%'],
			            label: {
			                normal: {
			                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
			                    backgroundColor: '#eee',
			                    borderColor: '#aaa',
			                    borderWidth: 1,
			                    borderRadius: 4,
			                    rich: {
			                        a: {
			                            color: '#999',
			                            lineHeight: 22,
			                            align: 'center'
			                        },
			                        hr: {
			                            borderColor: '#aaa',
			                            width: '100%',
			                            borderWidth: 0.5,
			                            height: 0
			                        },
			                        b: {
			                            fontSize: 16,
			                            lineHeight: 33
			                        },
			                        per: {
			                            color: '#eee',
			                            backgroundColor: '#334455',
			                            padding: [2, 4],
			                            borderRadius: 2
			                        }
			                    }
			                }
			            },
						data:this.list.data
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
