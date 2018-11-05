<template>
	<div class="wordbox">
		<div class="allword">
			<span>全部文档</span>
			<i class="el-icon-d-caret"></i>
		</div>
		<hr />
		<div class="wordheadings">
			<p style="font-weight: bold;font-size: 1.3em;">{{pathtwo}}</p>
			<div class="buleborder" :style="styleborder"><p style="font-size: 1.1em;padding-top: 3px;"><a>{{paththree}}</a></p></div>
			<div class="headings">
				<p v-for="item in word"><a>{{item.headings}}</a></p>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	props:{
		word:{
			type:Array,
			default:''
		},
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
  		computed:{
			//前后宽高一致
		    styleborder:function(){
				let style = {
					borderRight:this.borderright,
				}
				return style
			},
    },
}
</script>

<style lang="scss" scoped>
.wordbox{
	height: 100vh;
	overflow-y:hidden;
	border-right: 1px solid rgba(230, 230, 230, 1.0);
	text-align: left;
	.allword{
		/*background: aqua;*/
		margin: 20px 0px 0px 20px;
		height: 50px;
		line-height:50px;
		span{
			margin-left: 15px;
			font-size: 1.3em;
			font-weight: bold;
			color: rgba(89, 89, 89, 1.0);
		}
		i{
			margin-left: 80px;
			font-size: 1.3em;
			color: rgba(6, 17, 36, 1.0);
		}
	}
	hr{
		background-color: rgba(244, 244, 244, 1.0);
	    height: 1.5px;
	    border: none;
	}
	.wordheadings{
		padding: 10px 0 0 30px;
		.buleborder{
			border-right: 2px solid rgba(58, 151, 230, 1.0);
		}
	}
	.headings{
		font-size: 1.1em;
		color: rgba(113, 113, 113, 1.0);
		p{
			padding-top: 2px;
		}
		a{
			color: rgba(51,51,51,1);
		}
		a:hover{
		color: rgba(58, 151, 230, 1.0);
		}
	}
}
</style>
