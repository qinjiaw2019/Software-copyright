<template>
	<div id="add">
		<div class="add-header">
			<span style="color: gray;">设置</span>
		</div>
		<hr />
		<div class="warning">
			<i class="el-icon-warning" style="padding-left: 2em;"></i><span class="add-warning">这里是警告信息</span>
		</div>
		<div class="add-form">
			<el-form ref="form" status-icon :rules="rules2" :model="form" label-width="80px" >
			  <el-form-item label="输入框一" prop="pass">
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
			 <el-form style="margin-top: 10px;">
			 	<el-button type="primary" size="small" @click="onSubmit('form')">立即创建</el-button>  
			 	<el-button size="small" @click="resetForm()">取消</el-button>
			 </el-form>
		</div>
	</div>
</template>

<script>
import {module} from 'service'
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
        },
        rules2: {
          
        }
      }
    },
    methods: {
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
          	const that = this
          	module.add(this.form).
            then(response=>{//请求成功 response返回的是数据
                that.$message({
                      message: '添加成功',
                      type: 'success'
                    })
            },err=>{//请求失败
                that.$message({
                      message: '添加失败',
                      type: 'warning'
                    })
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
     resetForm(){
      	this.$router.push('/index/module/list')
      }
    }
}
</script>

<style lang="scss" scoped>
$ul-tick: "*";
#add{
	text-align: left;
	hr{
		background-color: rgba(216,220,229,1);
	    height: 2px;
	    border: none;
	}
	.warning{
		margin: 20px 2em 0px 2em;
		border: 1px solid rgba(230,230,230,0.3);
		background: rgba(230,230,230,0.1);
		border-radius: 3px;
		height: 3em;
		line-height: 3em;
	}
	.add-header{
		color: rgba(100,100,100,1);
		font-size: 1.1em;
		padding-left: 20px;
		line-height: 50px;
		height: 40px;
		/*background: #e6e9ee;*/
		color: black;
	}
	.add-form{
		margin-top: 20px;
		padding-top: 8px;
		padding-left: 10px;
		padding-right: 10px;
		margin: 15px;
		.addf-input{
			width: 40%;
			margin-left: 20px;
		}
		.addo-input{
			width: 40%;
			margin-left: 20px;
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
	padding-left: 1em;
	color: rgba(100,100,100,1);
	font-size: 0.9em;
}
</style>
