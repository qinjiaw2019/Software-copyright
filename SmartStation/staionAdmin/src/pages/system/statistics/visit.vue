<template>
	<div>
		<div>
			<el-card class="box-card">
			  <div class="text item" v-for="i in 4">
			    {{data.title}}&nbsp;&nbsp;&nbsp;&nbsp;{{data.data_times}}
			  </div>
			</el-card>
		</div>
		<div style="margin-top: 20px;">
			<el-row>
			  <el-col :span="11" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 1 : 0">
			    <el-card :body-style="{ padding: '0px' }">
			      	<div class="image">
						<c-boken2 :list="list6"></c-boken2>
					</div>
			      <div style="padding: 14px;">
			        <span>好吃的汉堡</span>
			        <div class="bottom clearfix">
			          <time class="time">{{ currentDate }}</time>
			          <el-button type="text" class="button">操作按钮</el-button>
			        </div>
			      </div>
			    </el-card>
			  </el-col>
			</el-row>
		</div>
	</div>
</template>

<script>
import Boken2 from '@/components/chart/boken2'
export default {
	components: {
		'c-boken2': Boken2,
	},
	data(){
		return{
			data:{
				title:'登录人次',
				data_times:'10020',
			},
			list6:{
				width:'520px',
				height:'430px',
			}
		}
	}
}
</script>

<style scoped>
.text {
    font-size: 14px;
  }
  .item {
  	padding: 10px 0;
    border-bottom: solid gainsboro 1px;
  }
  .box-card {
    width: 480px;
  }
</style>
