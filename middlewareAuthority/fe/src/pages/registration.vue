<template>
	<div class="regbox">
		<mw-platform></mw-platform>
		<div class="reg-box">
			<!--步骤条-->
			<div class="header">
				<div style="padding-top: 2em;">
				<el-steps :active="active" simple finish-status="success">
				  <el-step title="填写基本信息" icon="el-icon-edit"></el-step>
				  <el-step title="邮箱验证" icon="el-icon-message"></el-step>
				  <el-step title="完善资料" icon="el-icon-edit-outline"></el-step>
				</el-steps>
				</div>
			</div>
			<!--第一步-->
			<div class="box" v-if="active==0">
				<div class="middle" style="width: 70%;margin-top: 4%;">
				<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
				    <el-form-item
					    prop="email"
					    label="邮箱"
					  >
					    <el-input v-model="ruleForm2.email"></el-input>
					  </el-form-item>
				 <el-form-item label="密码" prop="pass">
				    <el-input type="password" v-model="ruleForm2.pass" auto-complete="off" placeholder="请输入您的密码"></el-input>
				  </el-form-item>
				  <el-form-item label="确认密码" prop="checkPass">
				    <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="请确认您的密码"></el-input>
				  </el-form-item>
				  <!--验证码填写区域-->
				  <div class="validation">
					   <el-form-item label="验证码" prop="validation">
					    <el-input type="text" v-model="ruleForm2.validation" auto-complete="off"></el-input>
					  </el-form-item>
				  </div>
				  <!--验证码区域-->
				  <el-form-item>
				  	<div class="img">
					  		<img :src="src" alt="">
					    </div>
					    <div class="change">
					    		<span @click="changeval">换一张</span>
					    </div>
					</el-form-item>
				  <!--是否同意条款-->
				  <el-form-item>
				   	<div style="float: left;">
				    <el-checkbox v-model="checked">我同意并遵守上述的</el-checkbox> <a href="#">《开放平台开发者服务协议》</a>
				    </div>
				  </el-form-item>
				</el-form>
				</div>
				<hr/>
				<div style="float: left;margin-left: 7em;margin-top: 1em;">
					<el-button type="success" plain v-show="nexttwo" @click="next('ruleForm2')">下一步</el-button>
				</div>
			</div>
			<!--第二步-->
			<div class="reg-two" v-if="active==1">
				<div class="regtwo-box">
					<div class="regtwo-email">
						<div class="regtwo-img">
							<i class="el-icon-message"></i>
						</div>
						<div class="regtwo-p">
							<span>感谢您的注册，确认邮件已发送至您的注册邮箱：{{ruleForm2.email}}</span>
							<p>请进入邮箱查看邮件，并激活开放平台帐号。</p>
							<div class="regtwo-but">
								<el-button type="success">登陆邮箱</el-button>
							</div>
							<div class="regtwo-ol">
								<p>没有收到邮件?</p>
								<p>1. 请检查邮箱地址是否正确，你可以返回<a>重新填写</a></p>
								<p>2. 检查你的邮件垃圾箱</p>
								<p>3. 若仍未收到确认，请尝试 <a>重新发送</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import validate from 'common/utils'
import Platform from 'components/Header/platform'
import {user} from 'service'
  export default {
  	components: {
		'mw-platform': Platform,
	},
  	props:{
  		src:{
			type:String,
			default:'/static/img/validation.png'
		},
  	},
    data() {
//    var checkEmail = (rule, value, callback) => {
//      let ema =/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/
//      if (!value) {
//        return callback(new Error('邮箱不能为空'));
//      }
////      setTimeout(() => {
////        if (validate.email(value)) {
////          callback(new Error('请输入正确的邮箱地址'));
////        } else {
////            callback();
////        }
////      }, 300);
//    var checkEmail = (rule, value, callback) => {
//      let ema =/^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/
//      if (!value) {
//        return callback(new Error('邮箱不能为空'));
//      }
////      setTimeout(() => {
////        if (validate.email(value)) {
////          callback(new Error('请输入正确的邮箱地址'));
////        } else {
////            callback();
////        }
////      }, 300);
////      }, 300);
//    };

      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        }
        else if (value.length<6){
	      callback(new Error('密码太短，请大于6位'));
	     }
        else if (value.length>12){
        	   callback(new Error('密码太长，请小于12位'));
        }
        else {
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
      var checkvalidation = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('请输入验证码'));
        } else {

        }
      };
      return {
      	nextone:false,
      	nexttwo:true,
      	emailnumber:'2459757525@qq.com',
      	show:false,
//    	show:true,
      	showtwo:true,
//    	showtwo:false,
      	active: 0,
      	checked: false,
        ruleForm2: {
          pass: '',
          checkPass: '',
          email: '',
          validation:'',
        },
        rules2: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          email: [
            { required: true,message: '请输入邮箱地址', trigger: 'blur' },
			{ type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur,change' }
          ],
          validation:[
          {validator: checkvalidation, trigger: 'blur'}
          ],
        }
   }
    },
    methods:{
//  	isEmail(str){
//		var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
//		if(myReg.test(str)) return true;
//		return false;
//  	isEmail(str){
//		var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
//		if(myReg.test(str)) return true;
//		return false;
//		return false;
//	},
    	next(formName) {
    		this.$refs[formName].validate((valid) => {
          if (valid) {
          	user.register(this.ruleForm2).
			then(response=>{//请求成功 response返回的是数据
				console.log(response)
			},err=>{//请求失败
				console.log(err)
			})
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
        if (this.active > 2) this.active = 0;
        if(this.check()) this.active ++
     },
     check(){
     	if(this.ruleForm2.pass!='' &&
     	   this.ruleForm2.checkPass!=''&&
     	   this.ruleForm2.email!=''&&
     	   this.ruleForm2.validation!=''&&
     	   this.checked!=false
     	   ) return true
     	else return false
     },
     changeval(){

     }
    }
  }
</script>

<style lang="scss" scoped>
.regbox{
	background: rgba(204,204,204,0.5);
	.reg-box{
		background: white;
		margin: 0em 16% 0em 16%;
		min-width: 500px;
		border: 1px solid rgba(204,204,204,0.5);
		.header{
			height: 100px;
			background: rgba(204,204,204,0.1);
		}
		/*第一部分*/
		.box{
			padding-left: 3em;
			padding-right: 3em;
			margin-bottom: 10.6em;
			hr{
				background-color: rgba(204,204,204,1);
				height: 1px;
				border: none;
			}
			.middle{
				.validation{
					width: 50%;
				}
				.img{
						/*margin-top: 1em;*/
						width: 8em;
						height: 3.5em;
						float: left;
						img{
							/*float: left;*/
							width:100%;
					  		height:100%;
						}
					}
				.change{
					padding-top: 0.5em;
					float: left;
					color: #3399CC;
					margin-left: 2em;
				}
			}
		}
		/*第二部分*/
		.reg-two{
			.regtwo-box{
				margin: 7em 10em 37.5% 13em;
				.regtwo-email{
					height: 5em;
					/*background: wheat;*/
					padding-bottom:3em;
					.regtwo-img{
						float: left;
						background: rgba(51,204,204,1);
						width: 4.7em;
						height: 4.7em;
						border-radius: 50%;
						overflow: hidden;
						i{
							color: white;
							line-height: 1.8em;
							font-size: 2.5em;
						}
					}
					.regtwo-p{
						padding-left: 1em;
						padding-top: 1em;
						text-align: left;
						float: left;
						.regtwo-but{
							margin-top: 1em;
						}
						.regtwo-ol{
							margin-top: 1em;
						}
					}
				}
			}
		}
	}
}
</style>
