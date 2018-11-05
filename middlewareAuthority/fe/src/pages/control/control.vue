<template>
	<div class="control">
		<!--control头部-->
		<mw-control-header/>
		<!--coutrolmenu左边菜单-->
		<mw-control-menu ref="menu"/>
		<!--control内容部分-->
		<div class="control-text" ref="controlright">
			
				<router-view/>
					
		</div>
	</div>
</template>

<script>
import Controlheader from 'components/Control-header'
import Controlmenu from 'components/Control-menu'
import Bus from 'common/utils/eventBus.js'
export default{
   components:{
	   	'mw-control-header': Controlheader,
	   	'mw-control-menu':Controlmenu
   },
   created() {
	   	Bus.$on('controlMenu', ev => {
			if(this.$refs.menu.sou === false){
				this.$refs.controlright.style.left = 65 +'px';				
			}else{
				this.$refs.controlright.style.left = 200 +'px';
			}	   		
	   	})
   }
}
</script>

<style scoped>
.control{
	position: absolute;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
}
/*cntrol右边样式*/
.control-text{
	position: absolute;
	left: 200px;
	right: 0;
	top: 61px;
	bottom: 0;
	background-color: rgb(234,237,241);
	overflow-y: auto;
}
.text{
 	position: absolute;
 	left: 0px;
 	top: 0px;
 	background-color: white;
 	right: 0px;	
}
</style>