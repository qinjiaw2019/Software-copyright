<template>
	<div class="loginbox" >
		<div class="l-box">
			<div class="header">
				<span>登录{{login}}</span>
				<i class="el-icon-close" @click="closelogin"></i>
			</div>
			<div class="middle">
				<div class="l-form">
					<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
					  <!--输入邮箱号-->
					  <el-form-item label="邮箱" prop="email">
					    <el-input v-model.number="ruleForm2.email"></el-input>
					  </el-form-item>
					  <!--输入密码-->
					  <el-form-item label="密码" prop="pass">
					    <el-input type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
					  </el-form-item>
					  <!--记住账号忘记密码-->
					   <el-form-item>
						   	<div style="float: left;">
						    		<el-checkbox v-model="checked">记住账号</el-checkbox>
						    </div>
						    <div style="float: right;margin-right: 1em;">
						    		<a href="#">忘记密码</a>
						    </div>
					  </el-form-item>
					  <!--提交注册按钮-->
					  <el-form-item>
					  	<div style="float: left;margin-left: 0em;">
					    		<el-button size="medium" type="primary" @click="submitForm('ruleForm2')">登录</el-button>
					    </div>
					    <div style="float: left; margin-left: 2em;">
					    		<el-button size="medium" @click="resetForm('ruleForm2')">注册</el-button>
					    </div>
					  </el-form-item>
					</el-form>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {user} from 'service'
  export default {
  	props:{
  		show:{
  			type:Boolean,
  			default:false
  		}
  	},
    data() {
   
    	var checkEmail = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('邮箱名不能为空'));
        }
//      setTimeout(() => {
//        if (!Number.isInteger(value)) {
//          callback(new Error('请输入数字值'));
//        } else {
//          if (value < 1) {
//            callback(new Error('必须年满18岁'));
//          } else {
//            callback();
//          }
//        }
//      }, 1000);
		setTimeout(()=>{
			if(value<10){
				callback(new Error('请输入正确的邮箱号'));
			}
			else{
			callback();
		}
		},1000)
    };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm2.checkPass !== '') {
            this.$refs.ruleForm2.validateField('checkPass');
          }
          callback();
        }
      };
      return {
      	loginstr:"登录",
      	login:this.show,
      	checked: true,
        ruleForm2: {
        pass: '',
         checkPass: '',
         email: ''
        },
        rules2: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          email: [
            { validator: checkEmail, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
//  	关闭登录页面
    	  closelogin(login){
    	  	this.$emit('closelogin',event.target)
    	  	this.login = false
    	  },
//  	  验证表单是否填写成功
      submitForm(formName) {
      	let flag=false
        this.$refs[formName].validate((valid) => {
          if (valid) {
				const that = this
				user.login(this.ruleForm2.email,this.ruleForm2.pass).
				then(response=>{//请求成功 response返回的是数据
					console.log("success")
					that.loginstr="进入控制台"
					user.saveUsername(that.ruleForm2.email)
					console.log(response)
					flag = true
					that.login=false
//					this.$router.push('/control')
				},err=>{//请求失败
					console.log("error11")
					console.log("error11")
				})
//          this.$router.push('/control')
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
//    跳转注册页面
      resetForm(formName) {
        this.$router.push('/reg')
      }
    }
  }
</script>

<style lang="scss" scoped>
.loginbox{
	border: 1px solid rgba(204,204,204,1);
	border-radius: 5px;
	width: 500px;
	background: white;
	.l-box{
		.header{
			height: 2em;
			padding: 1em;
			background: rgba(204,204,204,0.3);
			span{
				font-size: 1.3em;
				float: left;
			}
			i{
				float: right;
			}
		}
		.middle{
			margin-top: 3em;
			.l-form{
				margin-right: 15%;
				padding-bottom: 1em;
			}
		}
	}
}
</style>