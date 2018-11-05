<template>
    <ul class="list">
    	<li  :class="selectIndex==index?'select':''" 
    		 @click="selectEvent(index)"
    		 v-for="(item,index) in data" 
    		 :key="index">
    		<div>{{item}}</div>
    	</li>
    </ul>
</template>

<script>
export default{
	props:{
		data:[Array],
	},
	data(){
		return{
			selectIndex:0,
		}
	},
	methods:{
		selectEvent(index){
			this.selectIndex=index
			this.$emit('selectItem',index)
		}
	}
}   
</script>

<style lang="scss" scoped>
.list{
	// width:100%;  
	background:#F9F9F9; 
    height:54px;
    li{
    	float: left;
    	width: 102px;
	    height: 54px;
	    cursor: pointer;
	    position: relative;

	    
	    text-align:center;
	    div{
	    	height: 20px;
		    margin-top: 16px;
		    border-right: #E2E2E2;
		    width: 100%;
		    border-right: 1px solid #E2E2E2;
	    }
    }
    .select{
    	background-color: #2171C2;
    	color:#fff;
    }
}    
</style>