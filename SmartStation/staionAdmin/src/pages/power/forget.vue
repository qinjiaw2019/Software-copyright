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
				<span class="left" style="font-size: 1.3em;">密码重置</span>
				<span class="right blueword" style="padding-top: 10px;" @click="routerGo('/')">立即登录</span>
			</div>
			<div style="padding-top: 50px;">
				<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" class="demo-ruleForm">
				  <el-form-item prop="num" 
				  	:rules="[
				      { required: true, message: '请输入手机号', trigger: 'blur' },
				      { type: 'email', message: '请输入正确的手机号', trigger: 'blur,change' }
				    ]"
				    >
				    <el-input prefix-icon="fa fa-user fa-2x" v-model="ruleForm2.num" auto-complete="off" placeholder="请输入手机号"></el-input>
				  </el-form-item>
				  <el-form-item prop="pass">
				    <el-input prefix-icon="fa fa-lock fa-2x" type="password" v-model="ruleForm2.pass" auto-complete="off" placeholder="请输入新密码"></el-input>
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
				<el-checkbox v-model="checked" class="left">自动登录</el-checkbox>
				<span class="right blueword" @click="routerGo('/reg')">立即注册</span>
			</div>
			<div style="padding-top: 50px;">
				<el-button type="primary" class="login_button" @click="submitForm('ruleForm2')">确认</el-button>
			</div>
		</div>
	</div>
</template>

<script>
let flag = false
  export default {
    data() {
    	var validateNum = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入手机号或邮箱'));
        } else {
          if (this.ruleForm2.checkPass !== '') {
            this.$refs.ruleForm2.validateField('checkPass');
          }
          callback();
        }
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
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      var Region = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请选择用户类型'));
        } else {
          callback();
        }
      };
      var validateCode = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入验证码'));
        } else if (value !== this.oldCode) {
          callback(new Error('验证码输入错误!'));
        } else {
          callback();
        }
      };
      return {
      	oldCode:'1111',
      	code:"发送",
		uncode:"已发送",
		COUNT:60,
      	checked:'',//判断是否登录
        ruleForm2: {
        	  num: '',
          pass: '',
          region: '',
          checkPass: '',
          checkCode:'',
        },
        rules2: {
        	num: [
            { validator: validateNum, trigger: 'blur' }
          ],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          region: [
            { validator: Region, trigger: 'blur' }
          ],
          checkCode: [
            { validator: validateCode, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
    	//登录按钮
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
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
	margin-top: 100px;
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
