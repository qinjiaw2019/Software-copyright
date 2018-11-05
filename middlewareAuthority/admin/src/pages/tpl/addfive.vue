<template>
	<div id="add">
		<div class="add-header">
			<span style="color: gray;">添加角色方法</span>
		</div>
		<hr />
		<div class="warning">
			<i class="el-icon-warning" style="padding-left: 2em;"></i><span class="add-warning">这里是警告信息</span>
		</div>
		<div class="add-form">
			<el-form ref="form" :model="form" label-width="80px" status-icon :rules="rules2">
              <el-form-item label="输入框" prop="notnull">
                <el-input v-model="form.name" style="width: 50%;"></el-input>
              </el-form-item>
              <el-form-item label="相应选择" prop="notregion">
                <el-select v-model="form.region" placeholder="请选择" style="width: 50%;">
                  <el-option label="选择一" value="shanghai"></el-option>
                  <el-option label="选择二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
               <el-form-item label="复选框" style="padding-right: 20px;">
                <el-checkbox-group v-model="form.typeone">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                  <el-checkbox label="复选框5" name="type"></el-checkbox>
                  <el-checkbox label="复选框6" name="type"></el-checkbox>
                  <el-checkbox label="复选框7" name="type"></el-checkbox>
                  <el-checkbox label="复选框8" name="type"></el-checkbox>
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                  <el-checkbox label="复选框5" name="type"></el-checkbox>
                  <el-checkbox label="复选框6" name="type"></el-checkbox>
                  <el-checkbox label="复选框7" name="type"></el-checkbox>
                  <el-checkbox label="复选框8" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item> <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typetwo">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item> <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typethree">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
              <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typefore">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-form>
			 <el-form style="margin-top: 10px;margin-left: 25px;">
			 	<el-button type="primary" size="small" @click="onSubmit('form')">立即创建</el-button>  
			 	<el-button size="small" @click="resetForm()">取消</el-button>
			 </el-form>
		</div>
	</div>
</template>

<script>
import {tplAdd} from 'service'
import {module} from 'service'
export default {
	data() {
		var check = (rule, value, callback) => {
		    if (!value) {
		      return callback(new Error('请输入内容'));
		    } else {
		          callback();
		        }
		  };
		var checkregion = (rule, value, callback) => {
		    if (this.form.region === '') {
		      return callback(new Error('请输入内容'));
		    } else {
		          callback();
		        }
		  };
      return {
        form: {
          name: '',
          region:'',
        },
        rules2: {
          notnull: [
            { validator: check, trigger: 'blur' }
          ],
          notregion:[
             { validator: checkregion, trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
    	//添加按钮
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
          	const that = this
          	tplAdd.addthree(this.form).
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
//    取消按钮（跳转至列表页）
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
