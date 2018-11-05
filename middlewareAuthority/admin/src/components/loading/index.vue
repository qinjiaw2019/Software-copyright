<template>
	<div class="loading"
		v-show="load"
	    v-loading="load"
	    :element-loading-text="loadingText"
	    :element-loading-background="loadingBackground">
	</div>
</template>

<script>
export default{
	props:{
		load:{//加载显示
			type: Boolean,
			default: true
		},
		loadingText:{//文字
			type: String,
			default: '拼命加载中'
		},
		loadingBackground:{//背景
			type: String,
			default: 'rgba(0, 0, 0, 0.5)'
		}
	},
	data(){
		return{
			loading:this.load,
		}
	}
}
</script>

<style scoped>
.loading{
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 50px;
}	
</style>