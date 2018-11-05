<template>
	<div>
		<!--{{charging}}-->
		<div v-for = "(i,index) in num">
	  		<el-row >
		  		<el-col :span="5">
		  			<el-input
					  v-model="bianli(index).t0"
					  :disabled="true">
					  <template slot="append">h</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="5">
		  			<el-input
					  placeholder="0"
					  v-model="bianli(index).tn">
					  <template slot="append">h</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="6" :offset="1">
		  			<el-input
					  placeholder="0"
					  v-model="bianli(index).price">
					  <template slot="prepend">$</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="3" :offset="1">
		  			<i class="el-icon-edit"></i>
		  		</el-col>
		  	</el-row>
	  	</div>
	  	<el-row >
		  		<el-col :span="5">
		  			<el-input
					  v-model="temp.t0"
					  :disabled="true">
					  <template slot="append">h</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="5">
		  			<el-input
					  placeholder="0"
					  v-model="temp.tn">
					  <template slot="append">h</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="6" :offset="1">
		  			<el-input
					  placeholder="0"
					  v-model="temp.price">
					  <template slot="prepend">$</template>
					</el-input>
		  		</el-col>
		  		<el-col :span="3" :offset="1">
		  			<i class="el-icon-plus" @click="add_foot1"></i>
		  		</el-col>
		  	</el-row>
	</div>
</template>

<script>
export default {
	props:{
		//已完成步段数组
		charging:{
				type:Array,
				default:function(){
					return []
				}
		},
	},
	data(){
		return{
			num:0,//当前步段计费id标示
			//步段临时存储对象
			temp:{
				discount:null,
				dismoney:null,
				distime:null,
				t0:0,
				tn:2,
				price:0,
				unit:1.0
			},
		}
	},
	methods:{
		bianli(index){
			for(let i in this.charging){
				let item = this.charging[i]
				if(item.id == index){
					return item
				}
			}
		},
		add_foot1(){
			this.temp.id = this.num
			this.num = this.num + 1
			let arr = JSON.parse(JSON.stringify(this.temp));
			this.charging.push(arr)
			this.temp.t0 = this.temp.tn
			this.bianli()
		},
	}
}
</script>

<style scoped>

</style>
