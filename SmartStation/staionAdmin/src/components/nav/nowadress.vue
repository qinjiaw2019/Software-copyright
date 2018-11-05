<template>
	<div class="navbox">
		<el-breadcrumb separator="/">
		  <el-breadcrumb-item><span>{{address.one}}</span></el-breadcrumb-item>
		  <el-breadcrumb-item><span>{{address.two}}</span></el-breadcrumb-item>
		  <el-breadcrumb-item><span>{{address.three}}</span></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
</template>

<script>
export default {
	props:{
		address:{
			type:Object,
			default:function(){
				return {
					one:'one',
					two:'two',
					three:'three',
				}
			}
		},
	}
}
</script>

<style lang="scss" scoped>
.navbox{
	background: rgba(84, 142, 217, 1.0);
	height: 50px;
	span{
		line-height: 50px;
		margin-left: 20px;
		color: white;
	}
}
</style>
