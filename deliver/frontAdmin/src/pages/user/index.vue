<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="快递员小助手"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	 <yd-cell-group >
	            <yd-cell-item  arrow href="/user/history" type="link">
	            	<yd-icon slot="icon" name="order" size=".42rem"></yd-icon>
	                <span slot="left">我的揽件记录</span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/info" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">地址管理</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/info" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">认证</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	        </yd-cell-group>

	        <yd-cell-group >
	            <yd-cell-item  arrow href="/user/history" type="link">
	            	<yd-icon slot="icon" name="order" size=".42rem"></yd-icon>
	                <span slot="left">我的消息</span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/user/static" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">统计任务</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	        </yd-cell-group>

	        <yd-cell-group >
	            <yd-cell-item  arrow href="/user/history" type="link">
	            	<yd-icon slot="icon" name="order" size=".42rem"></yd-icon>
	                <span slot="left">基本信息</span>
	            </yd-cell-item>
	            <yd-cell-item arrow href="/info" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">快递服务查询</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	             <yd-cell-item arrow href="/info" type="link">
	            	<yd-icon slot="icon" name="like-outline" size=".42rem"></yd-icon>
	                <span slot="left">派送</span>
	                <span slot="right"></span>
	            </yd-cell-item>
	        </yd-cell-group>


    	 </div>
    	 <v-bottom/>
    </div>
</template>

<script>
import Bottom from '@/components/Bottom'
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
	}
}   
</script>

<style lang="" scoped>
    
</style>