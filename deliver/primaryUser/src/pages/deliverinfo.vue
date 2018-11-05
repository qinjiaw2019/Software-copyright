<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header"/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<div  class="top"> <br><br><br><br>
    	 		<div class="info">
    	 			覃家旺 13541741901<br><br>
    	 			湖北省 荆州市 荆州市

    	 		</div>
    	 		<div class="tip">
    	 			寄
    	 		</div>
    	 	</div>
    	 </div>
    </div>
</template>

<script>
export default{

	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	}
}   
</script>

<style lang="" scoped>
.top{
	background: #F05000;
	color: #fff;
	height: 150px;
	width: 100%;
	/*text-align: center;*/
}  
.top .info{
	width: 60%;
	margin-left: 150px;
}
.top .tip{
	position: absolute;
	top:70px;
	left: 80px;
	background: #5ADAD0;
	width: 40px;
	height: 40px;
	border-radius: 50%;
	font-size: 20px;
	text-align: center;
	line-height: 40px;
}    
</style>