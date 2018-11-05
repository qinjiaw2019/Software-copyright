<template>
<div>
	<!--登录框-->
	<div class="loginbox" v-if="showlogin">
		<div class="l-box">
			<div class="header">
				<span>登录</span>
				<i class="el-icon-close" @click="closelogin"></i>
			</div>
			<div class="middle">
				<div class="l-form">
					<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
					  <!--输入邮箱号-->
					  <el-form-item
					    prop="email"
					    label="邮箱"
					  >
					    <el-input v-model="ruleForm2.email"></el-input>
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
	<!--主体区-->
	<div class="home">
		<!--用户页面的头部header-->
		<div class="home-header">
			<div class="login" v-if="!islogin" @click="tologin()">登录</div>
			<div class="login"  v-if="islogin" @click="tocontrol()">控制台</div>
			<div class="helper">帮助支持</div>
		</div>
	</div>
</div>
</template>

<script>
import Header from 'components/Header'
import {user} from 'service'
export default {
    data() {
//	    	 var checkEmail = (rule, value, callback) => {
//	        if (!value) {
//	          return callback(new Error('邮箱不能为空'));
//	        }
//	//      setTimeout(() => {
//	//        if (validate.email(value)) {
//	//          callback(new Error('请输入正确的邮箱地址'));
//	//        } else {
//	//            callback();
//	//        }
//	//      }, 300);
//	    	 var checkEmail = (rule, value, callback) => {
//	        if (!value) {
//	          return callback(new Error('邮箱不能为空'));
//	        }
//	//      setTimeout(() => {
//	//        if (validate.email(value)) {
//	//          callback(new Error('请输入正确的邮箱地址'));
//	//        } else {
//	//            callback();
//	//        }
//	//      }, 300);
//	      };
	      var validatePass = (rule, value, callback) => {
	        if (value === '') {
	          callback(new Error('请输入密码'));
	        }
	        else {
	          if (this.ruleForm2.checkPass !== '') {
	            this.$refs.ruleForm2.validateField('checkPass');
	          }
	          callback();
	        }
	      };
      return {
      	showlogin:false,
      	islogin:false,
      	checked: true,
        ruleForm2: {
        pass: '',
        checkPass: '',
        email: '',
        email1:'',
        },
        rules2: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
   //        email: [
			// { required: true,message: '请输入邮箱地址', trigger: 'blur' },
			// { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur,change' }
   //        ],
        }
      };
    },
    created(){
    if (user.getUsername() != null)
	  	this.islogin = true
    },
    methods: {
//  	关闭登录页面
    	  closelogin(login){
    	  	this.showlogin = false
    	  },
//  	  验证表单是否填写成功
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
				const that = this
				user.login(this.ruleForm2.email,this.ruleForm2.pass).
				then(response=>{//请求成功 response返回的是数据
			        that.$message({
			          message: '成功登录',
			          type: 'success'
			        });
			        localStorage.setItem('username',that.ruleForm2.emai)
					console.log("success")
					that.showlogin=false
					that.islogin=true
					console.log(that.islogin)
					user.saveUsername(that.ruleForm2.email)
					console.log(response)
				},err=>{//请求失败
					that.$message({
			          message: '登录失败',
			          type: 'warning'
			        });
				})
          } else {
            this.$message({
			          message: '登录失败',
			          type: 'warning'
			        });
            return false;
          }
        });
      },
//    跳转注册页面
      resetForm(formName) {
        this.$router.push('/reg')
      },
//    点击登录
	  tologin(){
	  	if (user.getUsername() == null)
	  	this.showlogin = true
	  },
//	  点击到控制台
	 tocontrol(){
	 	this.$router.push('/control')
	 }
    }
}

</script>

<style lang="scss" scoped>
.index-login{
	margin-top: 8em;
	margin-left: 32%;
}
.loginbox{
	margin: 10% 35% 0 30%;
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
.home-header{
	position: fixed;
	height: 50px;
	top: 0;
	width: 100%;
	background-color: black;
}
.login{
	float: right;
	margin-right: 10px;
	line-height: 50px;
	cursor: pointer;
	color: white;
}
.helper{
	float: right;
	cursor: pointer;
	line-height: 50px;
	margin-right: 10px;
	color: white;
}
.helper:hover{
	color: blue;
}
.login:hover{
	color: blue;
}
</style>

