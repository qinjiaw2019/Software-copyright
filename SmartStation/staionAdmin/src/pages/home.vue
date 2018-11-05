<template>
	<div class="boss">
		<el-container style="min-height: 100%;">
			<!--侧栏-->
		  <el-aside style="width: 13%;">
		  	<div style="background: rgba(84, 142, 217, 1.0);height: 90px;text-align: center;">
					<i class="iconfont icon1">&#xe60e;</i>
					<p style="margin-top: -3px;font-size: 1em;font-weight:600;color: white;" @click="Loading">智能车载</p>
		  	</div>
		  	<c-nav></c-nav>
		  </el-aside>
		  <el-container style="min-height: 100%;">
		  	<!--头部-->
		    <el-header style="height: 90px;">
		    		<c-header></c-header>
		    </el-header>
		    <!--主干-->
		    <el-main>
			    	<div class="main">
					<router-view/>
			    	</div>
		    </el-main>
		    
		  </el-container>
		</el-container>
	</div>
</template>

<script>
import Header from '@/components/header'
import Nav from '@/components/nav/left'
export default {
	components: {
		'c-header': Header,
		'c-nav': Nav,
	},
	methods: {
		/*路由跳转*/
	    routerGo(router){
	    	this.$router.push(router)
	    },
//	    loading
	    	Loading() {
	        const loading = this.$loading({
	          lock: true,
	          text: 'Loading',
	          spinner: 'el-icon-loading',
	          background: 'rgba(0, 0, 0, 0.7)'
	        });
	        setTimeout(() => {
	          loading.close();
	        }, 2000);
      }
   }
}
</script>

<style lang="scss" scoped>
@font-face {
  font-family: 'iconfont';  /* project id 583598 */
  src: url('//at.alicdn.com/t/font_583598_odv9qf9ulqc15rk9.eot');
  src: url('//at.alicdn.com/t/font_583598_odv9qf9ulqc15rk9.eot?#iefix') format('embedded-opentype'),
  url('//at.alicdn.com/t/font_583598_odv9qf9ulqc15rk9.woff') format('woff'),
  url('//at.alicdn.com/t/font_583598_odv9qf9ulqc15rk9.ttf') format('truetype'),
  url('//at.alicdn.com/t/font_583598_odv9qf9ulqc15rk9.svg#iconfont') format('svg');
}
.iconfont{
    font-family:"iconfont" !important;
    font-size:16px;font-style:normal;
    -webkit-font-smoothing: antialiased;
    -webkit-text-stroke-width: 0.2px;
    -moz-osx-font-smoothing: grayscale;
    }
.boss{
	height: 100%;
	background: salmon;
    }
.el-header{
	background: rgba(220, 225, 228, 1.0);
    color: #333;
    }
.el-aside {
    color: #333;
    overflow: hidden;
    min-height: 100%;
    background: rgba(83, 91, 100, 1.0);
   }
.el-main {
    background-color: #E9EEF3;
    color: #333;
    }
.main{
  	margin: -25px -20px -30px -20px;
  	padding: 15px 10px 10px 10px;
  	overflow-x: hidden;
	overflow-y: auto;
  }
  .icon1{
  	font-size: 3.3em;
  	color: white;
  }
</style>
