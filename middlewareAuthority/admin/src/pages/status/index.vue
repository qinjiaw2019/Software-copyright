<template>
	<div id="statusbox">
		<div class="sta-per">
			<percent></percent>
		</div>
		<div class="sta-line">
			<l-line></l-line>
		</div>
	</div>
</template>

<script>
import Percent from './percent'
import Line from './line'
export default {
	components:{
		'percent':Percent,
		'l-line':Line,
	}
}
</script>

<style lang="scss" scoped>
#statusbox{
	background: rgba(231, 233, 239, 1.0);
	.sta-per{
		/*background: #1F2D3D;*/
		/*height: 900px;*/
	}
	.sta-line{
		width: 55%;
		height: 900px;
		margin-top: 5px;
	}
}
</style>
