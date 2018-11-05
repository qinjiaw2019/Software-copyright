<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="添加地址"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-cell-group>
		        <yd-cell-item>
		            <span slot="left">姓名：</span>
		            <yd-input slot="right" v-model="form.reciever" required :show-clear-icon="false" placeholder="请输入您的姓名"></yd-input>
		        </yd-cell-item>
		        <yd-cell-item>
		            <span slot="left">手机号：</span>
		            <yd-input slot="right" v-model="form.tell" required :show-success-icon="false" :show-error-icon="false" regex="mobile" placeholder="请输入手机号码"></yd-input>
		        </yd-cell-item>
		        <yd-cell-item arrow>
		            <span slot="left">所在地区：</span>
		            <input slot="right" type="text" @click.stop="show2 = true" v-model="form.address" readonly placeholder="请选择收货地址">
		        </yd-cell-item>
		        <yd-cell-item >
		            <span slot="left">设置为默认地址：</span>
		           	<div slot="right">
		           		<yd-switch v-model="switch1"></yd-switch>
		           	</div>
		        </yd-cell-item>
		    </yd-cell-group>
		    <yd-button size="large" type="primary" @click.native="toastNone">确认</yd-button>
		    <yd-cityselect
	                v-model="show2"
	                ref="cityselectDemo"
	                :callback="result2"
	                :items="district"
	                provance="湖北"
	                city="襄阳市"
	                area="襄城区"
	        ></yd-cityselect>

    	 </div>
    </div>
</template>

<script>
import {fetch} from '@/utils/fetch'
import District from 'ydui-district/dist/jd_province_city_area_id';
export default{
	data(){
		return{
			show2:false,
            district: District,
            switch1:'',
            form:{
            	info:'',
            	reciever:'',
            	tell:'',
            	address:'湖北 襄阳市 襄城区',
            	userId:'',
            }
		}
	},

	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		},
		result2(ret) {
                this.form.address = ret.itemName1 + ' ' + ret.itemName2 + ' ' + ret.itemName3;
            },
        toastNone() {
                // this.$dialog.confirm({
                //     title: '',
                //     mes: '下单后会有快递员联系你，确定要下单吗',
                //     opts: () => {
                //         this.$dialog.toast({mes: '下单成功！', timeout: 1000});
                //         this.$router.push('/user/add/address/notice')
                //     }
                // });
                let uid = localStorage.getItem('uid')
                this.form.userId = uid
				const that = this
				fetch('address/add',this.form,'POST').then(response=>{
					if(response!=-1){
						that.list = response
						that.$router.go(-1)
					}
				})
            },
	}
}   
</script>

<style lang="" scoped>
    
</style>