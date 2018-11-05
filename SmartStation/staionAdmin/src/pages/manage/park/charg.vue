<template>
	<div>
		<!--{{ruleForm}}
		{{chargs}}
		{{rule}}-->
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="130px" class="demo-ruleForm">
				 <el-form-item label="卡用户类型" prop="region">
				    <el-select v-model="ruleForm.card_type" placeholder="请选择卡类型">
				      <el-option label="临时卡" value="1"></el-option>
				      <el-option label="期卡" value="2"></el-option>
				      <el-option label="充值卡" value="3"></el-option>
				    </el-select>
				  </el-form-item>
				  <!--临时卡-->
				  <div v-if = "ruleForm.card_type == 1">
				  	<el-form-item label="收费类型" prop="region">
					    <el-select v-model="ruleForm.charging_type" placeholder="请选择收费类型">
					      <el-option label="按阶段收费" value="1"></el-option>
					      <el-option label="按时收费" value="2"></el-option>
					      <el-option label="按天收费" value="3"></el-option>
					    </el-select>
					  </el-form-item>
					  <el-form-item label="收费细则" prop="region" v-if="ruleForm.charging_type == 1">
					  	<c-foot :charging="rule.dayChargeList"></c-foot>
					  </el-form-item>
					  <el-form-item label="收费折扣" prop="region" v-if="ruleForm.charging_type == 1">
					      <el-input
							  placeholder="0"
							  v-model="rule.baseCharge.discount"
							  style="width: 20%;">
							</el-input>
					  </el-form-item>
					  <el-form-item label="收费细则" prop="region" v-if="ruleForm.charging_type == 2">
					  	<el-input
						  placeholder="0"
						  v-model="ruleForm.charging_two"
						  style="width: 20%;">
						  <template slot="append">／时</template>
						</el-input>
					  </el-form-item>
					  <el-form-item label="收费细则" prop="region" v-if="ruleForm.charging_type == 3">
					  	<el-input
						  placeholder="0"
						  v-model="ruleForm.charging_three"
						  style="width: 20%;">
						  <template slot="append">／天</template>
						</el-input>
					  </el-form-item>
				  </div>
				  
				  <!--期卡-->
				  <div v-if = "ruleForm.card_type == 2">
				  	<el-form-item label="收费类型">
					    <el-select v-model="ruleForm.charging2_type" placeholder="请选择收费类型">
					      <el-option label="按月收费" value="1"></el-option>
					      <el-option label="按季收费" value="2"></el-option>
					      <el-option label="按年收费" value="3"></el-option>
					    </el-select>
					  </el-form-item>
					  
					  <el-form-item label="收费细则" v-if="ruleForm.charging2_type == 1">
					    <el-input
						  placeholder="0"
						  v-model="ruleForm.charging2_one"
						  style="width: 20%;">
						  <template slot="append">／月</template>
						</el-input>
					  </el-form-item>
					  <el-form-item label="收费细则" v-if="ruleForm.charging2_type == 2">
					    <el-input
						  placeholder="0"
						  v-model="ruleForm.charging2_two"
						  style="width: 20%;">
						  <template slot="append">／季</template>
						</el-input>
					  </el-form-item>
					  <el-form-item label="收费细则" v-if="ruleForm.charging2_type == 3">
					    <el-input
						  placeholder="0"
						  v-model="ruleForm.charging2_three"
						  style="width: 20%;">
						  <template slot="append">／年</template>
						</el-input>
					  </el-form-item>
				  </div>
				  
				  <div v-if = "ruleForm.card_type == 3">
					  <el-form-item label="收费细则">
					    <el-input
						  placeholder="0"
						  v-model="ruleForm.charging3_one"
						  style="width: 20%;">
						  <template slot="append">折</template>
						</el-input>
					  </el-form-item>
				  </div>
				  <el-form-item>
				  	
				  	<div style="margin-top: 20px;">
				  		<el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
				    		<el-button @click="resetForm('ruleForm')">重置</el-button>
				  	</div>
				 </el-form-item>
			</el-form>
	</div>
</template>

<script>
import Foot from '@/components/foot'
export default {
	props:{
		chargs:{
			type:Object,
			default:function(){
				return {
					stationId:0,//停车场ID
					 rule:{},
			         mode:1,//收费模式
			         desc:'',//描述
			         used:1,//是否使用当前标准
			         userId:'',//用户ID这个属性值默认可以为空，是自动获取的
			         title:'',//规则名称
				}
			}
		},
	},
	data(){
		return{
			charging:[],//已完成步段数组
			rule:{
				baseCharge:{discount:0.7,dismoney:10.0,distime:8.0,unit:0.0},
				dayChargeList:[],
			},
			info:[],
			//传输给后台的参数
			ruleForm:{
				stationId:'',
				card_type:'',
				discount:'',
//				临时卡
				charging_type:'',
				charging_two:'',
				charging_three:'',
//				期卡
				charging2_type:'',
				charging2_one:'',
				charging2_two:'',
				charging2_three:'',
//				充值卡
				charging3_one:'',
				
				foot: 0,
				origin:0,
				max:24
			}
		}
	},
	created(){
		this.get()
	},
	computed: {  
	     data: function () {  
	         let obj={};  
	         obj=JSON.parse(JSON.stringify(this.temp)); //this.templateData是父组件传递的对象  
	         return obj  
	    }  
	},
	methods:{
//		立即创建
		submitForm(){
			let foot = JSON.stringify(this.rule)
			this.chargs.rule = foot
			console.log(this.chargs.rule)
			this.PostInfo()
		},
		PostInfo(){
			this.$api.fareRule.add(this.chargs).then(response=>{
				if (response.data == 0)
				{
					this.$notify({
			          title: '成功',
			          message: '您已添加成功',
			          type: 'success'
			        });
				}
				else{
					this.$notify({
			          title: '警告',
			          message: '输入信息错误或已添加！',
			          type: 'warning'
			        });
				}
//				console.log(response)
          })
		},
	},
	components: {
		'c-foot': Foot,
	},
}
</script>

<style scoped>
</style>
