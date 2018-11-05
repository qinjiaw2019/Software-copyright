<template>
	<div style="border: solid 1px gainsboro;padding: 10px;width: 280px;">
		<el-row>
			<el-col :span="13">
				<div class="wordbox">
					<span class="title">{{list.title}}</span>
					<div style="margin-top: 10px;">
						<span class="strong">{{list.num}}</span>
					</div>
				</div>
			</el-col>
			<el-col :span="4" :offset="3">
				<div class="iconbox" :style="styleSheet">
					<i :class=list.icon></i>
				</div>
			</el-col>
		</el-row>
	</div>
</template>

<script>
export default {
	props:{
		list:{
			type:Object,
			default:function(){
				return {
					title:'期卡持有人数',
					num:200,
					backgroundcolor:'chocolate',
					icon:'iconfont icon-biaozhunchaxun icon',
				}
			}
		}
	},
	computed:{
		styleSheet:function(){
			let style = {
				backgroundColor:this.list.backgroundcolor
			}
			return style
		}
	},
}
</script>

<style scoped>
@import '../../../static/font/iconfont.css';
.title{
	font-size: 1.1em;
	color: rgba(117, 202, 253, 1.0);
}
.strong{
	font-size: 1.9em;
	color: rgba(97, 97, 97, 1.0);
}
.wordbox{
	margin-left: 20px;
}
.iconbox{
	width: 60px;
	height: 60px;
	padding: 10px;
	text-align: center;
	border-radius: 5px;
}
.icon{
	font-size: 40px;
	line-height: 60px;
	color: white;
  }
</style>
