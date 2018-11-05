<template>
	<div class="addbox">
		<div class="popoer-updata">
			<el-dialog 
				width="35%"
				:visible.sync="updataVisible"
				title="设置默认站点" 
				>
		        <div class="add-form">
		            <el-form ref="form" status-icon :rules="rules2" :model="form" label-width="80px">
					  <el-form-item label="默认站点" prop="region">
					    <el-select v-model="form.region" size="small" placeholder="请选择活动区域" style="width: 96%;">
					      <el-option label="区域一" value="shanghai"></el-option>
					      <el-option label="区域二" value="beijing"></el-option>
					    </el-select>
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
          	region:'',
        },
        rules2: {
          region: [
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
    height: 35px;
    color: black;
}
</style>