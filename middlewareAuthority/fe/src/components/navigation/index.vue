<template>
	<div>
		<div class="navbox">
			<span><a>{{pathone}}</a></span>
			<span class="path">／</span>
			<span><a>{{pathtwo}}</a></span>
			<span class="path">／</span>
			<span ><a>{{paththree}}</a></span>
			<span class="path">／</span>
			<span class="path">本页导航</span>
			<i class="el-icon-arrow-down"></i>
		</div>
	</div>
</template>

<script>
export default {
	props:{
  		pathone:{
			type:String,
			default:'文档中心'
		},
		pathtwo:{
			type:String,
			default:'当面付'
		},
		paththree:{
			type:String,
			default:'产品介绍'
		},
  	},
}
</script>

<style lang="scss" scoped>
.navbox{
	font-size: 1.1em;
	text-align: left;
	margin-left: 30px;
	line-height: 50px;
	height: 50px;
	.path{
	font-size: 0.8em;
	color: gray;
	}
}
</style>
