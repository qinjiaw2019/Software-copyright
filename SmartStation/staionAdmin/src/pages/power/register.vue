<template>
	<div class="login_boss">
		<div class="login_box">
			<div class="login_face">
				<div style="float: left;">
					<i class="iconfont icon-cheliang- icon1"></i>
				</div>
				<div style="float: left;padding-left: 14px;text-align: left;">
					<span style="font-size: 2.5em; color: rgba(82, 194, 251, 1.0);">carweb</span>
					<br />
					<span style="color: rgba(82, 194, 251, 1.0);font-size: 0.9em;">智能车载停车场管理系统</span>
				</div>
			</div>
			<div style="border-top: 1px gainsboro solid;padding-top: 20px;">
				<span class="left" style="font-size: 1.3em;">注册停车场管理员账户</span>
				<span class="right blueword" style="padding-top: 10px;" @click="routerGo('/')">直接登录</span>
			</div>
			<div style="padding-top: 50px;">
				<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" class="demo-ruleForm">
				  <el-form-item prop="account">
				    <el-input prefix-icon="fa fa-user fa-2x" v-model="ruleForm2.account" auto-complete="off" placeholder="请输入用户名"></el-input>
				  </el-form-item>
				  <el-form-item prop="phone">
				    <el-input prefix-icon="fa fa-mobile fa-2x" v-model="ruleForm2.phone" auto-complete="off" placeholder="请输入手机号"></el-input>
				  </el-form-item>
				  <el-form-item prop="pwd">
				    <el-input prefix-icon="fa fa-lock fa-2x" type="password" v-model="ruleForm2.pwd" auto-complete="off" placeholder="请输入密码"></el-input>
				  </el-form-item>
				  <el-form-item prop="checkPass">
				    <el-input prefix-icon="fa fa-lock fa-2x" type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="请确认密码">
				    </el-input>
				  </el-form-item>
				  <el-form-item prop="checkCode">
				    <el-input placeholder="请输入验证码" v-model="ruleForm2.checkCode">
				    		<el-button slot="append" @click="returnCodeClick">{{COUNT<60&&COUNT>0?uncode+COUNT:code}}</el-button>
					  </el-input>
				  </el-form-item>
				</el-form>
			</div>
			<div>
				<el-checkbox v-model="checked" class="left">记住密码</el-checkbox>
				<span class="right blueword" @click="routerGo('/forget')">忘记密码</span>
			</div>
			<div style="padding-top: 50px;">
				<el-button type="primary" class="login_button" @click="submitForm('ruleForm2')">立即注册</el-button>
			</div>
		</div>
	</div>
</template>

<script>
let flag = false
  export default {
    data() {
    	//验证密码是否一致
	    	var validatePass = (rule, value, callback) => {
	        if (value === '') {
	          callback(new Error('请再次输入密码'));
	        } else if (value !== this.ruleForm2.pwd) {
	          callback(new Error('两次输入密码不一致!'));
	        } else {
	          callback();
	        }
	      };
      return {
      	code:"发送",
		uncode:"已发送",
		COUNT:60,
      	checked:'',//判断是否登录
        ruleForm2: {
        	  account: '',
        	  phone:'',
          pwd: '',
          checkPass: '',
          checkCode:'',
        },
        rules2: {
        	account: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          phone: [
            { required: true, message: '请输入手机号', trigger: 'blur' },
          ],
          pwd: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ],
          checkPass: [
            { validator: validatePass, trigger: 'blur' },
          ],
          checkCode: [
            { required: true, message: '请输入验证码', trigger: 'blur' },
          ],
        }
      };
    },
    methods: {
    	//注册按钮
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
          	this.$api.user.register(this.ruleForm2).then(response=>{
          		console.log(response)
          		if(response.code == 0){
          			this.$message({
			          message: '注册成功！',
			          type: 'success'
			        });
          		}
          	})
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      returnCodeClick(){
		this.COUNT = 60
		flag = false
        this.count()
	  },
	  count(){
        	const that = this
            this.code = this.uncode        	
	 		let time = setInterval(()=>{
					that.COUNT--;
					this.$api.get('v1/msg/code',{},function(res){
						console.log(this.res)
					})
					if(this.COUNT < 0){
						clearInterval(time)					
						that.code = "重新发送"
						flag = true
					}
				},1000)
		},
		/*路由跳转*/
	  routerGo(router){
	    	this.$router.push(router)
	  }
    }
  }
</script>


<style lang="scss" scoped>
.login_boss{
	background-size: cover;  
	background-image: url(../../common/image/car1.jpg);
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	text-align: center;
}
.login_box{
	margin-left:auto;
	margin-right:auto;
	margin-top: 50px;
	background: white;
	width: 360px;
	padding: 10px 60px 20px 60px;
	box-shadow:0px 0px  5px 3px #aaa;
}
.login_face{
	padding-left: 20%;
	padding-top: 30px;
	height: 100px;
}
.icon{
	font-size: 2em;
	color: black;
}
.icon1{
	font-size: 4.5em;
	color: rgba(82, 194, 251, 1.0);
}
.blueword{
	color: rgba(82, 194, 251, 1.0);
	font-size: 0.9em;
}
.login_button{
	width: 340px;
}
.demo-ruleForm{
	width: 100%;
}
.left{
	float: left;
}
.right{
	float: right;
}
</style>