<template>
    <div class="main">
    	<div class="left">
    		<div class="statics">
    			
    		</div>

			<div class="myresource">
				<div class="box" v-for="n in 10" @click="routerGo('/control/api/info',n)">
					<div class="title">项目{{n}}</div>
					<div style="width:100%;height:100%;">
						<div style="float:left;height:100%;width:50%;">
							<p>
								&nbsp;&nbsp;&nbsp;
								项目类型
							</p>
							<p>
								&nbsp;&nbsp;&nbsp;
								API:访问次数
							</p>
						</div>

						<div style="float:left;height:100%;width:50%;">
								<p>使用API数量：</p>
								<p>免费API：</p>
								<p>收费API：</p>
						</div>
					</div>
				</div>
			</div>

    	</div>
    	<div class="right">
    		right
    	</div>
    </div>
</template>

<script>
export default{
	methods:{
		routerGo(router,id){
			this.$router.push({path:router,query:{project_id:id}})
		}
	}
}   
</script>

<style lang="scss" scoped>
.main{
	position:absolute;
	left:0;
	right:0;
	top:0;
	bottom:0;
	background:#fff;
	overflow:auto;
	.left{
		position:absolute;
		left:0;
		right:287px;
		top: 0;
		bottom:0;
		text-align:left;
		padding-left:10px;
		.statics{
			height:155px;
		}
		.myresource{
			margin-top: 20px;
			.box{
				width:385px;
				height:234px;
				border: 1px solid #dddddd;
				float: left;
				margin-right: 20px;
				margin-top:20px;
				cursor:pointer;
				.title{
					background:#F9F9F9;
					line-height:32px;
					padding-left:10px;
				}
			}
		}
	}
	.right{
		position:absolute;
		top: 0;
		bottom:0;
		right:0;
		width:280px;
	}
}    
</style>