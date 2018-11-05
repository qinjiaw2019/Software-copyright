<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="快递员小助手"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-tab :callback="sortByWhere">
		        <yd-tab-panel label="全部">全部</yd-tab-panel>
		        <yd-tab-panel label="我揽的">我揽的</yd-tab-panel>
		        <yd-tab-panel label="新件">我寄出的</yd-tab-panel>		       
		    </yd-tab>
    	 </div>
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
	mounted(){
		console.log(this.$refs.header.height)
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	},
	created(){
		const that = this
		fetch('user/login',{
			username:'23',
			password:'234',
			type:2
		},'POST').then(response=>{
			console.log(response)
			localStorage.setItem('uid',response)
			that.list = response
		})
	}
}   
</script>

<style lang="" scoped>
    
</style>