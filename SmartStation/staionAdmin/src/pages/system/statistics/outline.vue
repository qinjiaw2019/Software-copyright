<template>
	<div>
		<div>
			<el-row>
			  <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
			    <el-card :body-style="{ padding: '0px' }">
			      	<div class="image">
						<c-chart :list="list"></c-chart>
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
			<el-row style="margin-top: 20px;">
			  <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
			    <el-card :body-style="{ padding: '0px' }">
			      	<div class="image">
						<c-chart :list="list"></c-chart>
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
import Chart from '@/components/charts/ring'
export default {
	data(){
		return{
			list:{
				nofinish:'200',
				finished:'100',
				text:'月订单来源',
				width:'300px',
				height:'300px',
			},
			currentDate: new Date()
		}
	},
	components: {
		'c-chart': Chart,
	},
}
</script>

<style scoped>
.time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>