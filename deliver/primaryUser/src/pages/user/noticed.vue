<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title="下单状态">
    	 	<span slot="right" style="color:#fff">取消订单</span>
    	 </v-header>
    	 <div style="position:absolute;top:45px;bottom:45px;overflow:hidden;overflow-y:auto;left:0;right:0;">
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

    	 	<yd-step current="2" current-color="#F05000">
		        <yd-step-item>
		            <span slot="bottom">订单提交</span>
		        </yd-step-item>
		        <yd-step-item>
		            <span slot="bottom">通知快递员</span>
		        </yd-step-item>
		        <yd-step-item>
		            <span slot="bottom">下单完成</span>
		        </yd-step-item>
		        <yd-step-item>
		            <span slot="bottom">运输中</span>
		        </yd-step-item>
		    </yd-step>
			
			<yd-timeline>
		        <yd-timeline-item>
		            <p>【南宁市】您的订单正在配送途中，请您准备签收，感谢您的耐心等待。京东扫码付，单单享立减。</p>
		            <p style="margin-top: 10px;">2017-08-18 08:24:18</p>
		        </yd-timeline-item>
		        <yd-timeline-item>
		            <p>【南宁市】您的订单已到达【南宁安吉站】</p>
		            <p style="margin-top: 10px;">2017-08-18 07:25:08</p>
		        </yd-timeline-item>
		        <yd-timeline-item v-for="n in 10">
		            <p>【南宁市】您的订单在京东【南宁分拨中心】发货完成，准备送往京东【南宁安吉站】</p>
		            <p style="margin-top: 10px;">2017-08-17 21:44:08</p>
		        </yd-timeline-item>
		    </yd-timeline>
			
			<router-link to="/deliver/info">
		    	 <div class="bottom">
		    	 	查看物流
		    	 </div>
	    	 </router-link>
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