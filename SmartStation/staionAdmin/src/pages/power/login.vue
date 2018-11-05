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
				<span class="left" style="font-size: 1.3em;">账号登录</span>
				<span class="right blueword" style="padding-top: 10px;" @click="routerGo('/reg')">立即注册</span>
			</div>
			<div style="padding-top: 50px;" v-on:keyup.enter="submitForm('ruleForm2')">
				<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" class="demo-ruleForm">
				  <el-form-item prop="name">
				    <el-input prefix-icon="fa fa-user fa-2x" type="text" v-model="ruleForm2.name" auto-complete="off" placeholder="请输入用户名"></el-input>
				  </el-form-item>
				  <el-form-item prop="pass">
				    <el-input prefix-icon="fa fa-lock fa-2x" type="password" v-model="ruleForm2.pass" auto-complete="off" placeholder="请输入密码"></el-input>
				  </el-form-item>
				 <el-form-item prop="region">
				    <el-select v-model="ruleForm2.region" placeholder="请选择用户类型" style="float: left;width: 100%;">
				      <el-option label="停车场管理员" :value="0"></el-option>
				      <el-option label="系统管理员" :value="1"></el-option>
				    </el-select>
				  </el-form-item>
				</el-form>
			</div>
			<div>
				<el-checkbox v-model="checked" class="left">自动登录</el-checkbox>
				<span class="right blueword" @click="routerGo('/forget')">忘记密码</span>
			</div>
			<div style="padding-top: 50px;">
				<el-button type="primary" class="login_button" @click="submitForm('ruleForm2')">登录</el-button>
			</div>
		</div>
	</div>
</template>

<script>
  export default {
    data() {
      return {
      	checked:'',//判断是否登录
        ruleForm2: {
        	  name:'',
          pass: '',
          region: 0,
        },
        rules2: {
	        	name:[
	        		{ required: true, message: '请输入用户名', trigger: 'blur' },
	        	],
	        pass: [
	            { required: true, message: '请输入密码', trigger: 'blur' },
	        ],
	        region: [
	            { required: true, message: '请选择用户类型', trigger: 'blur' },
	        ],
        }
      };
    },
    methods: {
    	//登录按钮
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
//        	验证完成后登录
          	this.$api.user.login(this.ruleForm2.name,this.ruleForm2.pass,this.ruleForm2.region).then(response=>{
        			console.log(response)
				if(response.code == -1){
					this.$message({
			          message: '帐号或密码错误，请确认后输入',
			          type: 'error'
			        });
				}
				else{
					localStorage.setItem('uid',response.data)
					localStorage.setItem('usertype',this.ruleForm2.region)
					let usertype = localStorage.getItem('usertype')
					const h = this.$createElement;
			        this.$notify({
			          title: '登录成功',
			          type: 'success',
			          message: h('i', { style: 'color: teal'}, '现在是工作区间')
			        });
	//				0:停车场管理员
					if (usertype==0){
						this.$router.push('/home/parking')
					}
	//				1:网站管理员
					if (usertype==1){
						this.$router.push('/home/parkmanage')
					}
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
