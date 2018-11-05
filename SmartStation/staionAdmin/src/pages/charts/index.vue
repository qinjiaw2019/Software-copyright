<template>
	<div class="chartbox">
		<div class="box">
			<c-chart :list="list"></c-chart>
		</div>
		<div class="box">
			<c-chart1 :list="list1"></c-chart1>
		</div>
		<div class="box">
			<c-chart2 :list="list2"></c-chart2>
		</div>
		<div class="box">
			<c-boken :list="list3"></c-boken>
		</div>
		<div class="box">
			<c-boken2 :list="list6"></c-boken2>
		</div>
		<div class="box">
			<c-bar :list="list4"></c-bar>
		</div>
		<div class="box">
			<c-bar2 :list="list5"></c-bar2>
		</div>
	</div>
</template>

<script>
import Chart from '@/components/chart/tip'
import Chart1 from '@/components/chart/tiptwo'
import Chart2 from '@/components/chart/tipthree'
import Boken from '@/components/chart/boken'
import Boken2 from '@/components/chart/boken2'
import Bar from '@/components/chart/bar'
import Bar2 from '@/components/chart/bar2'
import {month_num,finish_not} from '@/components/chart/data.js'
export default {
	components: {
		'c-chart': Chart,
		'c-chart1': Chart1,
		'c-chart2': Chart2,
		'c-boken': Boken,
		'c-boken2': Boken2,
		'c-bar': Bar,
		'c-bar2': Bar2
	},
	created(){
		this.list3.time_data = month_num.time_data
		this.list3.show = month_num.show_data
		this.list3.series = month_num.seri
	},
	data(){
		return{
			list:{
				nofinish:'200',
				finished:'100',
				text:'月订单来源',
				subtext:'订单君',
				width:'300px',
				height:'300px',
			},
			list1:{
				title:'月订单来源',
				subtext:'所有订单',
				width:'300px',
				height:'300px',
				lable:['未完成','已完成'],
	    			data:[
	                {value:1848,name: '已完成'},
	                {value:235, name: '未完成'},
	            ],
			},
			list2:{
				title:'月订单来源',
				subtext:'所有订单',
				width:'1000px',
				height:'500px',
				lable:['散件','工业货物','公司发货','公司文件','网购订单','网购退单','网购进单','网购其他'],
			    data:[
		                {value:40145, name:'散件'},
		                {value:19841, name:'工业货物'},
		                {value:40981, name:'公司发货'},
		                {value:1098, name:'公司文件'},
		                {value:120875, name:'网购订单'},
		                {value:19836, name:'网购退单'},
		                {value:10314, name:'网购进单'},
		                {value:8000, name:'网购其他'}
			       ],
			    type_data:[
				        {value:40145, name:'散件', selected:true},
		                {value:61920, name:'公司货流'},
		                {value:159024, name:'网购订单'}
		           ]
			},
			list3:{
				  text:'月业务订单',
				  width:'800px',
				  height:'530px',
				  time_data:[],
				  show:[],
				  series:[],
			},
			list4:{
				width:'800px',
				height:'530px',
			},
			list5:{
				width:'800px',
				height:'530px',
			},
			list6:{
				width:'800px',
				height:'530px',
			}
		}
	},
}
</script>

<style scoped>
	.chartbox{
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		align-items: flex-start;
	}
	.box{
		border-color: silver;
		border-width: 1px;
		border: solid;
		padding: 10px;
	}
</style>
