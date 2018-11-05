<template>
    <div>
    	<div style="margin:auto;width:50%;">
    		<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
			  <el-menu-item index="1">首页</el-menu-item>
			  <el-submenu index="2">
			    <template slot="title">服务</template>
			    <el-menu-item index="2-1">帮助</el-menu-item>
			    <el-menu-item index="2-2">查快递</el-menu-item>
			    <el-menu-item index="2-3">收快递</el-menu-item>
			  </el-submenu>
			  <el-menu-item index="3">查询</el-menu-item>
			</el-menu>
    	</div>

		<el-carousel :interval="1500" arrow="always" height="500px">
		    <el-carousel-item v-for="item in pics">
		      <div style="background:red;height:100%;width:100%;overflow:hidden" >
		      	<img :src="item.src" alt="" style="with:100%;height:100%;">
		      </div>
		    </el-carousel-item>
		  </el-carousel>
    </div>
</template>

<script>
export default{
	data(){
		return{
			pics:[
				{
					src:'http://www.sf-express.com/.gallery/other/2017banner-CN-1349-487-.jpg',
				},
				{
					src:'http://www.sf-express.com/cn/sc/download/banner-PC-1349487px-CN.jpg',
				},
				{
					src:'http://www.sf-express.com/.gallery/other/12142.jpg',
				},
				{
					src:'http://www.sf-express.com/.gallery/promotion/12045.jpg',
				},
				{
					src:'http://www.sf-express.com/.gallery/promotion/1204.gif',
				}
			]
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>
<style>
img{
	width: 100%;
	height: 100%;
}
</style>