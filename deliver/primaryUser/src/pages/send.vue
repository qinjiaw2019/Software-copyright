<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="发快递"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-cell-group>
		        <yd-cell-item>
		            <span slot="left">地址 &nbsp;&nbsp;</span>
		            <yd-input slot="right" required v-model="address" placeholder="请输入寄件人详细地址" @click.native="routerGo('/user/address')"></yd-input>
		        </yd-cell-item>
		        <yd-cell-item>
		            <span slot="left">机构：</span>
		            <yd-input slot="right" type="text" v-model="expName" placeholder="请选择快递公司" @click.native="show2 = true"></yd-input>
		        </yd-cell-item>
		        <yd-cell-item>
		            <yd-textarea slot="right" placeholder="备注信息" maxlength="500"></yd-textarea>
		        </yd-cell-item>
		    </yd-cell-group>
		    <yd-button size="large" type="primary" shape="circle" @click.native="send">一键发件</yd-button>
    	 </div>

    	 <!-- 机构选择 -->
    	 <yd-popup v-model="show2" position="bottom" height="60%">
            	<div  v-for="(item,index) in express" class="item-list">
            		<div style="display:flex">
	            		<div style="flex:1">
	            			<div class="img-wapper">
	            				<img :src="item.logo">
	            			</div>
	            		</div>
	            		<div style="flex:4;line-height:40px" @click="selectExpress(index)">
	            			{{item.name}}
	            		</div>
	            	</div>
            	</div>
        </yd-popup>
    	 <v-bottom/>
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
			show2: false,
			express:[],
			expName:'',
			form:{
				expressId:'',
				addressId:'',
				name:'',
				userId:''
			},
			address:''
		}
	},
	created(){

		//获取快递机构
		const that = this
		fetch('express/lists',{
			page:1,
			limit:2000
		},'GET').then(response=>{
			if(response!=-1){
				that.express = response
			}
		})
		
		let address = JSON.parse(this.$route.query.address)
		this.form.addressId = address.id
		this.address = address.reciever+' '+address.address+' '+address.info
		console.log('address',address.address)
		let uid = localStorage.getItem('uid')
		if(uid==undefined)
			this.$router.push('/login')
		this.form.userId = uid
		
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		},
		selectExpress(index){
			this.expName = this.express[index].name
			this.show2 = false
			this.form.expressId = this.express[index].id
		},
		routerGo(router){
			this.$router.push(router)
		},
		send(){
			this.$dialog.confirm({
                    title: '',
                    mes: '下单后会有快递员联系你，确定要下单吗',
                    opts: () => {
                        this.$dialog.toast({mes: '下单成功！', timeout: 1000})
                        //获取快递机构
						const that = this

						fetch('deliver/send',this.form,'POST').then(response=>{
							if(response!=-1){
								that.express = response
							}
						})
                        this.$router.push('/user/add/address/notice')
                    }
                });
		}
	}
}   
</script>

<style lang="" scoped>
.item-list{
	margin-top: 5px;
	margin-left: 10px;
	margin-right: 10px;
	overflow: hidden;
	height: 65px;
	margin-bottom: 10px;
	border-bottom: 1px solid #E9E9E9;
} 
.img-wapper {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	overflow:hidden;
}   
.img-wapper img{
	width: 100%;
	height: 100%;
}
</style>