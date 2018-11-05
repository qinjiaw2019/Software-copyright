<template>
	<div class="addbox">
		<div class="popoer-updata">
			<el-dialog 
				width="38%"
				:visible.sync="updataVisible"
				title="添加" 
				>
		        <div class="add-form">
		            <el-form ref="form" status-icon :rules="rules2" :model="form" label-width="80px">
		              <el-form-item label="输入框一"  prop="notnull">
					     <el-input placeholder="请输入内容" v-model="form.name1" size="small">
						    <template slot="prepend">Http://</template>
						  </el-input>
					  </el-form-item>
					  <el-form-item label="输入框一"  prop="notnull">
					    <el-input placeholder="请输入内容" v-model="form.name2" size="small"></el-input>
					  </el-form-item>
					  <el-form-item label="输入框二" prop="notnull">
					    <el-input placeholder="请输入内容" v-model="form.name3" size="small"></el-input>
					  </el-form-item>
					  <el-form-item label="输入框三" prop="notnull">
					    <el-input placeholder="请输入内容" v-model="form.name4" size="small"></el-input>
					  </el-form-item>
					  <el-form-item label="输入框四" prop="notnull">
					    <el-input placeholder="请输入内容" v-model="form.name5" size="small"></el-input>
					  </el-form-item>
					 </el-form>
		        </div>
		        <div class="add-remark">
				 	<ul>
				 		<li>&nbsp;&nbsp;&nbsp;此处备注句1此处备注句1</li>
				 		<li>&nbsp;&nbsp;&nbsp;此处备注句2此处备注句2</li>
				 		<li>&nbsp;&nbsp;&nbsp;此处备注句3此处备注句3</li>
				 	</ul>
				 </div>
		        <div class="add-but">
		            <el-button size="small">取消</el-button>
		            <el-button type="primary" size="small" @click="onSubmit('form')">立即添加</el-button>  
		        </div>
		    </el-dialog>		
	    </div>
    </div>
</template>
<script>
import {module} from 'service'
export default {
props:{
	updataVisible:{
			type:Boolean,
			default:false,
	},
},
data() {
	var check = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('请输入内容'));
        } else {
              callback();
            }
      };
      return {
        form: {
          name1: '',
          name2: '',
          name3: '',
          name4: '',
          name5: '',
        },
        rules2: {
          notnull: [
            { validator: check, trigger: 'blur' }
          ]
        },
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
    }
}
</script>
<style lang="scss" scoped>
$ul-tick: "*";
$ol-tick:">";
.addbox{
	text-align: left;
}
    .add-header{
        padding-left: 20px;
        line-height: 40px;
        height: 40px;
        background: #e6e9ee;
        color: black;
    }
    .add-form{
		padding-left: 10px;
		padding-right: 10px;
		margin: 15px;
		width: 80%;
    }
    .textarea{
        height: 80px;
        width: 79%;
        border: 1px solid rgba(200,200,200,1);
        border-radius: 5px;
    }
.add-remark{
	margin-bottom: 10px;
	color: rgba(100,100,100,1);
	font-size: 0.9em;
	padding-left: 40px;
	ul>li:before {
        content: $ul-tick;
    }
}
.add-but{
    text-align: right;
    padding-right: 40px;
    line-height: 50px;
    height: 50px;
    color: black;
}
</style>