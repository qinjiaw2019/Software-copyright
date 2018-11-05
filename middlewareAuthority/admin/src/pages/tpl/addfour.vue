<template>
	<div id="add">
		<div class="add-header">
			添加标题
		</div>
		<div class="add-form">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="warning" style="background: rgba(230,230,230,0.1);border-radius: 3px;">
					<span class="add-warning">这里是警告信息</span>
				</el-form-item>
			  <el-form-item label="输入框一">
			    <el-input v-model="form.name1" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框二">
			    <el-input v-model="form.name2" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框三">
			    <el-input v-model="form.name3" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框四">
			    <el-input v-model="form.name4" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框五">
			    <el-input v-model="form.name5" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框六">
			    <el-input v-model="form.name6" size="small" class="addf-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			  <el-form-item label="输入框七">
			    <el-input v-model="form.name7" size="small" :disabled="true" class="addo-input"></el-input>
			    <span class="add-remark">备注信息一</span>
			  </el-form-item>
			 </el-form>
		</div>
		 <div class="add-but">
		    <el-button size="small">取消</el-button>
		    <el-button type="primary" size="small" @click="onSubmit">立即创建</el-button>  
		 </div>
	</div>
</template>

<script>
import {tplAdd} from 'service'
export default {
	data() {
      return {
        form: {
          name1: '',
          name2: '',
          name3: '',
          name4: '',
          name5: '',
          name6: '',
          name7: '这是一个已经存在数据',
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
        console.log(this.form)
      		tplAdd.getaddfour(this.form).
			then(response=>{//请求成功 response返回的是数据
				console.log(response)
			},err=>{//请求失败
				console.log(err)
			})
      }
    }
}
</script>

<style lang="scss" scoped>
#add{
	margin: 20px;
	border-radius: 3px;
	border: 1px solid rgba(200,200,200,1);
	width: 1100px;
	text-align: left;
	.add-header{
		padding-left: 20px;
		line-height: 40px;
		height: 40px;
		background: #e6e9ee;
		color: black;
	}
	.add-form{
		padding-top: 8px;
		padding-left: 10px;
		padding-right: 10px;
		margin: 15px;
		.addf-input{
			width: 40%;
		}
		.addo-input{
			width: 40%;
			/*background: rgba(200,200,200,1);*/
		}
	}
}
.add-remark{
	color: rgba(100,100,100,1);
	font-size: 0.9em;
	padding-left: 20px;
}
.add-warning{
	color: rgba(100,100,100,1);
	font-size: 0.9em;
}
.add-but{
	padding-right: 10px;
	text-align: right;
	padding-left: 20px;
	line-height: 50px;
	height: 50px;
	background: #e6e9ee;
	color: black;
}
</style>
