<template>
	<div id="add">
		<div class="add-header">
			添加模块
		</div>
		<div class="add-form">
			<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
			  <el-form-item label="名称:" prop="name">
			    <el-input v-model="ruleForm2.name" style="width: 400px;"></el-input>
			  </el-form-item>
			  <el-form-item label="路由:" prop="router">
			    <el-input v-model="ruleForm2.router" style="width: 400px;"></el-input>
			  </el-form-item>
			  <el-form-item label="描述:">
				<textarea class="textarea" v-model="ruleForm2.desc"></textarea>
			 </el-form-item>
			</el-form>
		</div>
		<div class="add-table">
			<table border="1px" cellspacing="0" cellpadding="10" width="100%" height="30">
				<caption>添加方法</caption>
				<tr>
					<th class="center">模块名称</th>
					<th class="center">模块描述</th>
					<th class="center">模块路由</th>
					<th class="center">操作</th>
				</tr>
				<tr>
					<th><el-input v-model="input" size="mini" placeholder="请输入内容"></el-input></th>
					<th><el-input v-model="input" size="mini" placeholder="请输入内容"></el-input></th>
					<th><el-input v-model="input" size="mini" placeholder="请输入内容"></el-input></th>
					<th><el-input v-model="input" size="mini" placeholder="请输入内容"></el-input></th>
				</tr>
			</table>
		</div>
		<div class="add-but">
		    <el-button size="small" @click="resetForm()">取消</el-button>
		    <el-button type="primary" size="small" @click="submitForm('ruleForm2')">立即创建</el-button>  
		</div>
	</div>
</template>

<script>
import {module} from 'service'
export default {
data() {
      var checkifnull = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('该字段不能为空'));
        }
        else  callback();
      };
      return {
      	ruleForm2: {
          name:'',
          router:'',
          desc:'',//描述
       },
       tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        rules2: {
          name:[
            { validator: checkifnull, trigger: 'blur'}
          ],
          router:[
            { validator: checkifnull, trigger: 'blur'}
          ],
        }
      }
    },
    methods: {
    	submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
          	const that = this
          	module.add(this.ruleForm2).
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
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
}
</script>

<style lang="scss" scoped>
#add{
	margin: 20px;
	border-radius: 3px;
	border: 1px solid rgba(200,200,200,1);
	width: 97%;
	text-align: left;
	.add-header{
		padding-left: 20px;
		line-height: 40px;
		height: 40px;
		background: #e6e9ee;
		color: black;
	}
	.add-form{
		padding-top: 25px;
		padding-left: 20px;
	}
	.add-table{
		margin: 15px;
		table{
			border: 1px solid rgba(216,220,229,1);
			.center{
				text-align: center;
			}
		}
	}
	.textarea{
		height: 80px;
		width: 400px;
		border: 1px solid rgba(216,220,229,1);
		border-radius: 5px;
	}
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