<template>
    <div class="loginbg">
        <mw-loading :load="load"/>
        <div class="login" 
            v-show="show">
            <div class="title">
                <h2>登录</h2>
            </div>
            <div class="user">
                <el-input 
                    v-model="loginForm.username" 
                    size="medium"
                    placeholder="管理员"></el-input>
            </div>
            <div class="word">
                <el-input 
                    v-model="loginForm.password" 
                    size="medium"
                    type="password"
                    placeholder="密码"></el-input>			
            </div>
            <div class="createlogin">
                <span @click="login"><el-button 
                    size="medium"
                    type="success">登录</el-button></span>
            </div>
            <div class="forget">
                <a href="#">忘记密码&nbsp;<i class="fa fa-angle-double-right"></i></a>
            </div>
        </div>	
    </div>
</template>
<script>
//import {login} from 'service'
import {user} from 'service'
import Loading from 'components/loading'
export default{
    data(){
        return{
            show:true,
            success: false,
            err: false,
            loginForm:{
                username:'',
                password:'',
            },
            load:false
        }
    },
    created(){
        this.load = true;
    },
    mounted(){
        this.load = false
    },
    methods:{
        login(){
//			const that = this;
//			that.load = true;
//			login.Login(this.loginForm.username,this.loginForm.password).
//			then(response=>{//请求成功				
//					that.load = false;
//				    this.$router.push('/index')	//路由						
//					that.$message({
//			         	message: '恭喜你，登录成功',
//			          	type: 'success'
//			        });				
//			},err=>{//请求失败
//				console.log('err')
//				that.load = false;
//				that.$message.error('登录失败！请从新输入');			
//			})
//			this.load = false;
            const that = this;
            that.load = true;
            user.login(this.loginForm.username,this.loginForm.password).
            then(response=>{//请求成功				
                    that.load = false;
                    this.$router.push('/index')	//路由	
                    user.saveUserInfo({username:that.loginForm.username})						
                    that.$message({
                     	message: '恭喜你，登录成功',
                      	type: 'success'
                    });	
            },err=>{//请求失败
                console.log('err')
                that.load = false;
                that.$message.error('登录失败！请从新输入');			
            })
            this.load = false;
        }
    },
    components:{
        'mw-loading': Loading,
    }
}
</script>
<style scoped>
.loginbg{
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(68, 68, 68, 0.9);
}	
.login{
    margin: 150px auto;
    height: 300px;
    width: 380px;
    background-color: rgb(255, 255, 255);
    -webkit-box-shadow: #5A5E66 0px 1px 2px 1px;
    -moz-box-shadow: #5A5E66 0px 1px 2px 1px;	
    box-shadow: #5A5E66 0px 1px 2px 1px;
    border-radius: 4px;
    z-index: 10;
}
.title{
    line-height: 80px;
}
.user{
    padding: 0 50px;
}
.word{
    margin-top: 20px;
    padding: 0 50px;
}
.createlogin{
    margin-top: 20px;
    padding: 0 50px;	
}
.createlogin button{
    width: 100%;
}
.forget{
    margin-right: -220px;
    margin-top: 30px;
    font-size: 12px;
}
.success{
    position: absolute;
    top: 10px;
    left: 35%;
    right: 35%;
}
.error{
    position: absolute;
    top: 10px;
    left: 35%;
    right: 35%;
}
</style>