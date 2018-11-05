<template>
    <div>
    	 <v-header @HandlerLeft="HandlerLeft" ref="header" title=""/>
    	 <div style="position:absolute;top:45px;bottom:52px;overflow-y:auto;left:0;right:0;">
    	 	<!-- 内容 -->
    	 	<v-slider/>
    	 </div>
    	 <v-bottom/>
    </div>
</template>

<script>
import Bottom from '@/components/Bottom'
import Slider from '@/components/Slider'
export default{
	components:{
		'v-bottom':Bottom,
		'v-slider':Slider,
	},
	methods:{
		HandlerLeft(){
			console.log('HandlerLeft')
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>