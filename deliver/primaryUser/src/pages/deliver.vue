<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="我的快递"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-tab :callback="sortByWhere">
		        <yd-tab-panel label="近期快递">近期快递</yd-tab-panel>
		        <yd-tab-panel label="我的查询">我的查询</yd-tab-panel>
		        <yd-tab-panel label="我寄出的">我寄出的</yd-tab-panel>
		        <yd-tab-panel label="我收到的">我收到的</yd-tab-panel>
		        <!-- <yd-tab-panel tabkey="4" label="排序" >排序</yd-tab-panel> -->
		       
		    </yd-tab>

		    <yd-popup v-model="sortBy" position="bottom" height="60%">
	            <yd-button type="warning" style="margin: 30px;" @click.native="sortBy = false">Close Bottom Popup</yd-button>
	        </yd-popup>
    	 </div>
    	 <v-bottom :active="2"/>
    </div>
</template>

<script>
import Bottom from '@/components/Bottom'
export default{
	data(){
		return{
			sortBy:false
		}
	},
	components:{
		'v-bottom':Bottom,
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		},
		sortByWhere(label,tabkey){
			if(tabkey==4)
			this.sortBy = !this.sortBy
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>