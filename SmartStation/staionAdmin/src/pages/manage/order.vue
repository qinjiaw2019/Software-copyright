<template>
	<div class="box">
		<c-nav :address="nav_address"></c-nav>
		<div class="main">
			<el-tabs type="border-card" v-model="nav_address.three">
			  <el-tab-pane label="注册车辆" name="注册车辆">
			  	<c-order></c-order>
			  </el-tab-pane>
			  <el-tab-pane label="会员车辆" name="会员车辆">
			  	<c-car></c-car>
			  </el-tab-pane>
			  <el-tab-pane label="黑名单" name="黑名单">
			  	<c-black></c-black>
			  </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Order from './order/index'
import Car from './order/car'
import Black from './order/blacklist'
export default {
	components: {
		'c-nav': Nowadress,
		'c-order': Order,
		'c-car': Car,
		'c-black': Black,
	},
	data(){
		return{
			info:{ "id": 1, "carNumber": "冀A130100", "currentUsed": 0, "userId": 1, "carNumberType": "", "photo": "", "carType": "", "carXH": "", "carYear": 0, "carColor": "", "code": "" },
			nav_address:{
					one:'停车场管理',
					two:'车辆管理',
					three:'注册车辆',
				}
		}
	},
	methods: {
   },
   computed:{
		styleSheet:function(){
			let style = {
				background:this.background
			}
			return style
		}
	},
}
</script>

<style scoped>
.box{
	border: 1px solid gainsboro;
}
.main{
	margin: 10px;
}
</style>
