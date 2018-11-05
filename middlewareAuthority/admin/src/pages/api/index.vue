<template>
	<div id="apibox">
		<div class="api-box">
			<div class="a-boxone">
				<div>
					<span>api调试工具：</span>
					<el-button type="primary" plain size="mini">主要按钮</el-button>
				</div>
				<div>
					<span>接口地址：</span>
					<span> http://apis.baidu.com/kingtto_media/106sms/106sms</span>
				</div>
				<div>
					<span>请求方法：</span>
					<span>GET</span>
				</div>
			</div>
			<div class="a-boxtwo">
				<span>请求参数（header）：</span>
			</div>
			<div class="a-boxthree"></div>
			<div class="a-boxfour"></div>
		</div>
	</div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
#apibox{
	.api-box{
		.a-boxone{
			text-align: left;
		}
		.a-boxtwo{
			
		}
		.a-boxthree{
			
		}
		.a-boxfour{
			
		}
	}
}
</style>
