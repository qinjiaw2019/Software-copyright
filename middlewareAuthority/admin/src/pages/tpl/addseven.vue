<template>
	<div style="text-align: left;">
		<div class="popoer-updata">
			<el-dialog 
				width="40%"
				:visible.sync="updataVisible"
				title="角色添加" 
				>
		        <div class="add-form">
		            <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="70px" class="demo-ruleForm">
		              <el-form-item label="名称:" prop="name">
		                <el-input v-model="ruleForm2.name" style="width: 85%;"></el-input>
		              </el-form-item>
		              <el-form-item label="路由:" prop="router">
		                <el-input v-model="ruleForm2.router" style="width: 85%;"></el-input>
		              </el-form-item>
		              <el-form-item label="描述:">
		                <textarea class="textarea" v-model="ruleForm2.desc"></textarea>
		             </el-form-item>
		            </el-form>
		        </div>
		        <div class="add-but">
		            <el-button size="small">取消</el-button>
		            <el-button type="primary" size="small" @click="onSubmit('ruleForm2')">立即创建</el-button>  
		        </div>
		    </el-dialog>		
	    </div>
    </div>
</template>
<script>
import {tplAdd} from 'service'
import {module} from 'service'
export default {
props:{
	updataVisible:{
			type:Boolean,
			default:false,
	},
},
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
      onSubmit(formName) {
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
    }
}
</script>
<style lang="scss" scoped>
    .add-header{
        padding-left: 20px;
        line-height: 40px;
        height: 40px;
        background: #e6e9ee;
        color: black;
    }
    .add-form{
        padding-left: 20px;
        text-align: left;
    }
    .textarea{
        height: 80px;
        width: 84%;
        border: 1px solid rgba(200,200,200,1);
        border-radius: 5px;
    }

.add-but{
    text-align: right;
    padding-right: 70px;
    line-height: 50px;
    height: 50px;
    color: black;
}
</style>