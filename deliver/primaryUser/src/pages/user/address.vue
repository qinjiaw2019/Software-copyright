<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="地址簿">
    	 <span slot="right">
    	 	<yd-icon name="search" color="#FBCFB8"></yd-icon>
    	 </span>
    	 </v-header>
    	 <div style="position:absolute;top:45px;bottom:50px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-list theme="4"> 
		        <yd-list-item v-for="(item,index) in list" @click.native="select(item)">
		           <!--  <div slot="img" >
		            	旺
		            </div> -->
		            <span slot="title">{{item.reciever}}  {{item.tell}} <yd-badge type="danger" v-if="index==1">默认</yd-badge></span>
		           	<yd-list-other slot="other">
		                <div>
		                	{{item.address}}<br>
		                	{{item.info}}
		                </div>
		                <div>
		                	<yd-icon name="feedback"></yd-icon>
		                </div>
		            </yd-list-other>
		        </yd-list-item>
		    </yd-list>
    	 </div>
    	 <router-link to="/user/add/address">
	    	 <div class="bottom">
	    	 	添加地址
	    	 </div>
    	 </router-link>
    </div>
</template>

<script>
import {fetch} from '@/utils/fetch'
export default{
	data(){
		return{
			list:[]
		}
	},
	created(){
		let uid = localStorage.getItem('uid')
		const that = this
		fetch('address/lists',{
			uid:uid,
			page:1,
			limit:1000,
		},'GET').then(response=>{
			if(response!=-1){
				that.list = response
			}
		})
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		},
		select(item){
			this.$router.push({path:'/send',query:{address:JSON.stringify(item)}})
		}
	}
}   
</script>

<style lang="" scoped>
.bottom{
	background: #5ADAD0;
	height: 50px;
	width: 100%;
	position: fixed;
	bottom: 0;
	text-align: center;
	line-height: 50px;
	color: #fff;
}  
 
</style>
<style>
.yd-list-img {
	position: absolute;

} 
.yd-list-item{
	height: 80px;
}	
</style>