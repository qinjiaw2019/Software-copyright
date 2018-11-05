<template>
	<div class="box">
		<div class="title1">{{list.title}}</div>
		<div class="box1">
			<p class="best">{{list.subtext}}<span class="strong">{{list.num}}</span></p>
			<p class="space">{{list.lable}}<span class="provice">{{list.time}}</span></p>
		</div>
	</div>
</template>

<script>
export default {
	props:{
		list:{
			type:Object,
			default:function(){
				return {
					title:'泊车次数最多',
					subtext: '泊车次最多',
					num:'981',
					lable:'时间',
					time:'星期二',
				}
			}
		}
	}
}
</script>

<style scoped>
.box{
	border: 1px solid gainsboro;
	height: 198px;
	background: whitesmoke;
}
.title1{
	height: 35px;
	background-color: rgba(83, 142, 217, 1.0);
	color: white;
	line-height: 35px;
	padding-left: 10px;
}
.box1{
	background: whitesmoke;
	text-align: center;
}
.strong{
	font-size: 1.6em;
	margin-left: 10px;
}
.best{
	font-size: 1.3em;
	padding-top: 10px;
}
.space{
	font-size: 0.9em;
	padding-bottom: 10px;
	margin-top: -10px;
	color: gray;
}
.provice{
	font-size: 1.1em;
	margin-left: 10px;
}
</style>
