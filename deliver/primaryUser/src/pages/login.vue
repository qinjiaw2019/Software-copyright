<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title=""/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-cell-group>
		        <yd-cell-item>
		            <span slot="left">用户名：</span>
		            <yd-input slot="right" required v-model="form.username" max="20" placeholder="请输入用户名"></yd-input>
		        </yd-cell-item>
		        <yd-cell-item>
		            <span slot="left">密码：</span>
		            <yd-input slot="right" type="password" v-model="form.password" placeholder="请输入密码"></yd-input>
		        </yd-cell-item>
		    </yd-cell-group>
		    <yd-button size="large" type="primary" @click.native="login">登陆</yd-button>
    	 </div>
    	 <!-- <v-bottom/> -->
    </div>
</template>

<script>
import Bottom from '@/components/Bottom'
import {fetch} from '@/utils/fetch'
export default{
	components:{
		'v-bottom':Bottom,
	},
	data(){
		return{
			form:{
				username:'',
				password:'',
				type:0
			}
		}
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		},
		login(){
			const that = this
			fetch('user/login',this.form,'POST').then(response=>{
				console.log(response)
				if(response==-1){
						that.$dialog.toast({
	                    mes: '登陆失败',
	                    timeout: 1500,
	                    icon: 'error'
	                })
				}else{
					that.$dialog.loading.open('登陆中...');

                setTimeout(() => {
                	localStorage.setItem('uid',response)
                    that.$dialog.loading.close()
                    that.$router.go(-1)
                }, 2000);
					
				}
			})
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>