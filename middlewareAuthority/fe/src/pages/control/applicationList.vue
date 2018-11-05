<template>
	<div class="applicationList">
		<div class="breadcrumb">
			<el-breadcrumb separator="/">
			    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
			    <el-breadcrumb-item :to="{ path: '/control' }">应用管理</el-breadcrumb-item>
			    <el-breadcrumb-item>应用列表</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<hr />
		<div class="warn">
			<a class="remind">【重要提醒】{{}}</a>
		</div>
		<div class="keyword">
			<div class="inputkey">    		       
    		    <el-input 
    		    	v-model="inputKey"
    		    	size="small"
    		    	placeholder="请输入内容">
    		    	<template slot="prepend">关键字:</template>
    		    </el-input>    		    
			</div>
			<div class="select">
				应用类型:
				<el-select 
					v-model="options.value" 
					size="small"
					placeholder="请选择">
				    <el-option
				      v-for="item in options"
				      :key="item.value"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</el-select>
			</div>
		</div>
	</div>
</template>

<script>
export default{
	data() {
		return{
			inputKey: '',
			 options: [{
	          value: '选项1',
	          label: '黄金糕'
	        }, {
	          value: '选项2',
	          label: '双皮奶'
	        }, {
	          value: '选项3',
	          label: '蚵仔煎'
	        }, {
	          value: '选项4',
	          label: '龙须面'
	        }, {
	          value: '选项5',
	          label: '北京烤鸭'
	        }],
		}
	}
}
</script>

<style scoped>
.applicationList{
 	position: absolute;
 	left: 0;
 	top: 0;
 	right: 0;
 	background-color: white;
 	right: 20px;	
}	
.applicationList hr{
	border: 1px solid rgb(234, 237, 241);
}
/*，面包屑部分*/
.breadcrumb{
	height: 35px;
	margin-left: 10px;
	margin-top: 20px;
}
/*重要提醒部分*/
.warn{
	line-height: 40px;
	border: 1px solid rgb(240, 250, 250);
	background-color: rgb(249, 250, 252);
	text-align: left;
}
.remind{
	margin-left: 20px;
	cursor: pointer;
}
.inputkey{
	text-align: left;
	width: 200px;
	margin-top: 5px;
	float: left;
}
.select{
	float: left;
	margin-top: 5px;
	margin-left: 10px;
	color: rgb(135, 141, 153);
	font-size: 12px;
}
</style>