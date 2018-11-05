<template>
    <div>
    	<div class="header"><br><br><br><br>
    		<div class="user-face">
    			<!-- <img src="" alt=""> -->
    		</div>
    		<div class="user-name">
    			<div class="nick">
    				{{userInfo.name}}
    			</div>
    			<div class="acount">
    				{{userInfo.tell}}
    			</div>
    		</div>

    		<span style="position:absolute;top:10px;right:5px;">
    			<router-link to="/user/address"><yd-icon name="setting" color="#FBCFB8"></yd-icon></router-link>
    		</span>

    	</div>
    	 <div style="position:absolute;top:180px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-cell-group>
				<yd-cell-item>
					<span slot="left">快递订单</span>
				</yd-cell-item>
    	 	</yd-cell-group>
    	 <!-- 	<yd-grids-group :rows="4">
				<yd-grids-item>
				<img slot="icon" src="http://static.ydcss.com/ydui/img/logo.png">
				<span slot="text">image</span>
				</yd-grids-item>
				<yd-grids-item>
					 <yd-icon slot="icon" name="home" color="#FF685D"></yd-icon>
					  <span slot="text">iconfont</span>
				 </yd-grids-item>
			 </yd-grids-group> -->
			 <yd-cell-group >
	            <yd-cell-item  arrow href="/user/history" type="link">
	            	<yd-icon slot="icon" name="order" size=".42rem"></yd-icon>
	                <span slot="left">积分商城</span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/info" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">钱包</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/user/address" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">地址簿</span>
	                <span slot="right"></span>
	            </yd-cell-item>

	        </yd-cell-group>


    	 </div>
    	 <v-bottom :active="3"/>
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
			userInfo:{}
		}
	},
	created(){
		let uid = localStorage.getItem('uid')
		if(uid==undefined)
			this.$router.push('/login')

		//获取用户信息
		const that = this
		fetch('user/info',{
			uid:uid,
			type:0,
		},'GET').then(response=>{
			if(response!=-1){
				that.userInfo = response
			}
		})
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	}
}   
</script>

<style lang="" scoped>
.header{
	background: #F05000;
	height:180px;
	width: 100%;
}    
.user-face{
	background: #fff;
	width: 70px;
	height: 70px;
	border-radius: 50%;
	margin:auto;


}
.user-name .nick{
	text-align: center;
	line-height: 30px;
	color: #fff;
	font-size: 15px;
}
.user-name .acount{
	text-align: center;
	color: #fff;
}
</style>