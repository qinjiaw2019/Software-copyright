<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<yd-cell-group>
		        <yd-cell-item>
		            <span slot="left">快递单号：</span>
		            <yd-input slot="right" v-model="number" regex="^\d{5,12}$" placeholder="请输入快递单号"></yd-input>
		        </yd-cell-item>
		    </yd-cell-group>
		    
		    <!-- 查询结果 -->
		    <div>
		    	最近查询
		    </div>
		    
    	 </div>
    	 <v-bottom/>
    </div>
</template>

<script>
import Bottom from '@/components/Bottom'
export default{
	data(){
		return{
			number:'',
			
		}
	},
	components:{
		'v-bottom':Bottom,
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	}
}   
</script>

<style lang="" scoped>
.box{
	width: 98%;
	margin:auto;
	margin-top: 20%;
	display: flex;
	text-align: center;
}    
.box .input{
	border: 1px solid #E9E9E9;
	line-height: 40px;
	width: 100%;
	border-radius: 8px;
	text-indent: 10px;
}
</style>