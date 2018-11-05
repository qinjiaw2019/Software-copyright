<template>
    <div id="main">
    	<div class="top">
    		
    	</div>

    	<div class="nav">
    		<item-ul :data="ulList" @selectItem="selectItem"/>

    		<div class="content"><Interface/>
				<!-- <router-view/> -->
    		</div>
    		
    	</div>
    </div>
</template>

<script>
import ItemList from './itemList'
import Interface from './interface'
export default{
	data(){
		return{
			ulList:['API','联系商家','套餐','错误码参照','交易记录','遇到问题','服务相关']
		}
	},
	methods:{
		selectItem(data){
			console.log(data)
		}
	},
	components:{
		'item-ul':ItemList,
		Interface,
	}
}   
</script>

<style lang="scss" scoped>
#main{
	width: 100%;
	height: 100%;
	.top{
		width:100%;
		height:86px;
		background:#232940;
	}	
	.nav{
		width:1300px;
		margin: auto;
		margin-top: 5px;
		text-align: left;
	}
	.content{
		margin-top:10px;
		background-color: #FBFBFB;
    	border: 1px solid #ECECEC;
    	min-height: 400px;
    	clear: both;
    	background:#fff;

	}
}    
</style>