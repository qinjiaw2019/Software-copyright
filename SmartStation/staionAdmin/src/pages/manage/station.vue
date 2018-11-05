<template>
	<div class="box" @click="Handget">
		<c-nav :address="nav_address"></c-nav>
		<div class="main" @click="nav">
			<el-tabs type="border-card" v-model="activeName2">
				<!--停车场信息-->
				 <el-tab-pane label="收费标准" name="first">
				 	<c-charging></c-charging>
				 </el-tab-pane>
				<!--停车场信息-->
				 <el-tab-pane label="停车场信息" name="second" @click="Handget">
				 	<c-info @HandAdd="HandAdd" @Handdel="Handget" :park="park" :info="info"></c-info>
				 </el-tab-pane>
				 <!--编辑停车场-->
				 <el-tab-pane label="新增停车场" name="third">
				 	<c-add></c-add>
				 </el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import Nowadress from '@/components/nav/nowadress'
import Charging from './park/charging'
import Info from './park/info'
import Add from './park/add'
export default {
	data(){
		return{
			activeName2:'first',
			info:'',
			park:[],
			nav_address:{
				one:'停车场管理',
				two:'停车场',
				three:'收费标准',
			}
		}
	},
	methods:{
		//没有停车场信息时添加
		HandAdd(){
			this.activeName2 = 'third'
		},
		//管理员获取名下停车场信息
		Handget(){
			this.$api.station.getList().then(response=>{
          		this.park = response.data
          		let a = this.park.length
				if (a==0){
					this.info = true
				}
				else{
					this.info = false
				}
          })
		},
//		导航显示
		nav(){
			if(this.activeName2 == 'first')
			this.nav_address.three = '收费标准'
			if(this.activeName2 == 'second')
			this.nav_address.three = '停车场信息'
			if(this.activeName2 == 'third')
			this.nav_address.three = '新增停车场'
		}
	},
	created(){
		this.Handget()
	},
	components: {
		'c-nav': Nowadress,
		'c-info': Info,
		'c-add': Add,
		'c-charging':Charging
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
