<template>
    <div class="main">
    	<div class="left">
    		<div class="title">
    			账号管理
    		</div>
    		<div class="nav "
    			 :class="selectIndex==index?'selected':''" 
    			 v-for="(item,index) in list"
    			 @click="selectItem(index,item.router)">{{item.name}}</div>
    	</div>
    	<div class="right">
    		<router-view/>
    	</div>
    </div>
</template>

<script>
export default{
	methods:{
		selectItem(index,item){
			this.selectIndex = index
		}
	},
	data(){
		return {
			selectIndex:0,
			list:[
				{
					id:1,
					name:'基本资料',
					router:'/control/user',
				},
				{
					id:2,
					name:'应用信息',
					router:'',
				},
				{
					id:2,
					name:'账号绑定',
					router:'',
				},
			]
		}
	}
}   
</script>

<style lang="scss" scoped>
.left{
	position:absolute;
	left:0;
	top:0;
	bottom:0;
	width:180px;
	.title{
		font-weight: bold;
    	text-indent: 20px;
    	width: 180px;
	    height: 70px;
	    line-height: 70px;
	    background: #D9DEE4;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	    text-align:left;
	}
	.nav{
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	    line-height:40px;
	    cursor:pointer;
	}
	.selected{
		background:#fff;
	}
}    
.right{
	text-align:left;
	position: absolute;
	left:180px;
	top: 0;
	right:0;
	bottom:0;
	background: #fff;
	overflow:auto;
}
</style>