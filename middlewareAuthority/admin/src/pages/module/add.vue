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
              <el-form-item label="方法:">
                <el-checkbox-group v-model="ruleForm2.methods">
                  <el-checkbox label="方法1" name="methods"></el-checkbox>
                  <el-checkbox label="方法2" name="methods"></el-checkbox>
                  <el-checkbox label="方法3" name="methods"></el-checkbox>
                  <el-checkbox label="方法4" name="methods"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-form>
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
      }
    },
}
</script>
<style lang="scss" scoped>
#add{
    margin: 20px;
    border-radius: 3px;
    border: 1px solid rgba(200,200,200,1);
    width: 630px;
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