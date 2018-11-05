<template>
	<div class="img-wapper" 
    	     @click="faceClick">
    	     <i class="iconfont icon" v-if="icon">&#xe627;</i>
	    	 <img :src="src" alt="" v-if="!icon">
	</div>
</template>

<script>
export default {
	props:{
		src:{
			type:String,
			default:'http://img0.imgtn.bdimg.com/it/u=925623450,1242011400&fm=27&gp=0.jpg'
		},
	},
	data(){
		return{
			icon:true,//判断是否为默认无头像
		}
	},
	created (){
    		if(this.src != ''){
			this.icon = false
		}
	},
	methods:{
    		faceClick(){
			this.$emit('faceClick')
		},
    },
}
</script>

<style lang="scss" scoped>
@font-face {
  font-family: 'iconfont';  /* project id 583598 */
  src: url('//at.alicdn.com/t/font_583598_4zec1gv0gvz33di.eot');
  src: url('//at.alicdn.com/t/font_583598_4zec1gv0gvz33di.eot?#iefix') format('embedded-opentype'),
  url('//at.alicdn.com/t/font_583598_4zec1gv0gvz33di.woff') format('woff'),
  url('//at.alicdn.com/t/font_583598_4zec1gv0gvz33di.ttf') format('truetype'),
  url('//at.alicdn.com/t/font_583598_4zec1gv0gvz33di.svg#iconfont') format('svg');
}
.img-wapper{
	width: 60px;
	height: 60px;
	border-radius: 50%;
	overflow: hidden;
	background: gainsboro;
	text-align: center;
	img{
		width:100%;
		height:100%;
	}
}    
.iconfont{
    font-family:"iconfont" !important;
    font-size:16px;font-style:normal;
    -webkit-font-smoothing: antialiased;
    -webkit-text-stroke-width: 0.2px;
    -moz-osx-font-smoothing: grayscale;
    }
.icon{
	font-size: 3.2em;
	color: white;
}
</style>
