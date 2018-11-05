<template>
	<div class="home">
		<!--用户页面的头部header
		<div class="home-header">
			<div class="helper">登陆 | 注册</div>
		</div>-->
	</div>
</template>

<script>
export default {
	methods:{
		login(){
			this.$emit('login')
//			console.log(event.target)
		}
	}
}
</script>

<style>
/*header部分的css*/
.home-header{
	position: fixed;
	height: 58px;
	top: 0;
	width: 100%;
	background-color: black;
}
.login{
	float: right;
	margin-right: 10px;
	line-height: 50px;
	cursor: pointer;
	color: white;
}
.helper{
	float: right;
	cursor: pointer;
	line-height: 50px;
	margin-right: 10px;
	color: white;
}
.helper:hover{
	color: blue;
}
.login:hover{
	color: blue;
}
</style>
