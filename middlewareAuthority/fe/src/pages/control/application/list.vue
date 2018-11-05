<template>
	<div class="applicationList">
		<div class="breadcrumb">
			<el-breadcrumb separator="/">
			    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
			    <el-breadcrumb-item :to="{ path: '/control/index' }">应用管理</el-breadcrumb-item>
			    <el-breadcrumb-item>应用列表</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<hr />
		<div class="warn">
			<a class="remind">
				<!-- 搜索区 -->
			</a>
		</div>
		<div class="keyword">
			<div class="inputkey">    		       
    		    <el-input 
    		    	v-model="inputKey"
    		    	size="small"
    		    	placeholder="请输入应用名">
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
			
			<div class="sreach">
				<el-button size="small">搜索</el-button>
				<el-button size="small" @click="routerGo('/control/add')">添加</el-button>
			</div>
		</div>
		<div class="list">
			<el-table
			    :data="list"
			    size="mini"
			    style="border: 1px solid rgb(230, 235, 245);top: 5px;"
			    max-height="450">
			    <el-table-column
			      prop="id"
			      label="ID"
			      width="50">
			    </el-table-column>
			    <el-table-column
			      prop="name"
			      label="应用名称"
			      width="300">
			    </el-table-column>
			    <el-table-column
			      prop="url"
			      label="应用地址"
			      width="150">
			    </el-table-column>
			    <el-table-column
			      prop="redirectUri"
			      label="回调地址"
			      width="300">
			    </el-table-column>
			    <el-table-column
			      prop="typeId"
			      label="应用类型"
			      width="150">
			    </el-table-column>
			     <el-table-column
			      prop="appKey"
			      label="appKey">
			    </el-table-column>
			     <el-table-column
			      prop="appSecret"
			      label="appSecret">
			    </el-table-column>
			    <el-table-column
			      fixed="right"
			      label="相应操作"
			      width="120">
				    <template slot-scope="scope">
				        <el-button
				          @click="handleEdit(scope.$index, scope.row)"
				          type="text"
				          size="small">
				                               编辑
				        </el-button>
				        <el-button
				          size="mini"
				          type="danger"
				          @click.native.prevent="deleteRow(scope.$index)">删除</el-button>
				    </template>
			    </el-table-column>
			</el-table>
		</div>
		<div class="pagination">
			<el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :page-size="paramPage.limit"
		      layout="prev, pager, next, jumper"
		      :total="tatol">
		    </el-pagination>
		</div>
	
	</div>
</template>

<script>
import {application} from 'service'	
export default{
	data() {
		return{
			paramPage:{page:1,limit:20},//分页参数
			tatol:0,//记录总数
			inputKey: '',
			options: [{
	          value: '选项1',
	          label: '网站应用'
	        }, {
	          value: '选项2',
	          label: '桌面客户端'
	        }, {
	          value: '选项3',
	          label: '移动客户端'
	        }],
			baginTiem: '',
			overTiem: '',
			pickerOptions: {
	         	disabledDate(time) {
	           		return time.getTime() > Date.now();
	         	}
	       },
	        list: []
		}
	},
	created(){
		//获取数据
		this.getData()

		//获取记录总数
		const that = this
		application.getTatol()
		.then(response=>{
			that.tatol = response
		},err=>{
			that.$message({
			    message: '获取数据错误',
			    type: 'err'
			});	
		})
	},
	methods: {
		deleteRow(index, rows) {
			// console.log(rows)
        	rows.splice(index, 1);

        },
        handleSizeChange(val) {
        	console.log(`每页 ${val} 条`);
        },
        //当前页回调
         handleCurrentChange(val) {
       		this.paramPage.page = val
       		this.getData()
        },
        getData(){
        	const that = this
        	application.get(this.paramPage)
        	.then(response=>{
        		that.list = response
        	},err=>{
        		that.$message({
			         	message: '获取数据错误',
			          	type: 'err'
			        });	
        	})
        },
        routerGo(router){
        	if(router!=undefined)
        		this.$router.push(router)
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
/*关键字部分*/
.keyword{
	/*position: relative;*/
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
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;
}
.time{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;		
}
.sreach{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;		
}
.list{
    padding: 0 10px;
	text-align: left;
}
.pagination{
	margin-top: 10px;
	background-color: rgb(249, 250, 252);
	border: 1px solid rgb(240, 250, 250);
}
/*caozuo部分*/
.operation{
	position: relative;
	margin-top: 10px;
	line-height: 40px;
}
.register{
	border: 1px solid rgb(225, 230, 235);
	line-height: 40px;
	border-right-width: 0;
	border-left-width: 0;
	width: 300px;
	height: 40px;
	color: rgb(135, 141, 153);
	font-size: 12px;
	font-weight: 700;	
	cursor: pointer;
}
.buy{
	position: absolute;
	top: 0;
	left: 300px;
	right: 30%;
	border: 1px solid rgb(225, 230, 235);
	bottom: 0;
	color: rgb(135, 141, 153);
	font-size: 12px;
	font-weight: 700;
	cursor: pointer;			
}
.sell{
	position: absolute;
	right: 0;
	top: 0;
	bottom: 0;
	border: 1px solid rgb(225, 230, 235);
	border-left-width: 0;
	border-right-width: 0;	
	bottom: 0;
	left: 70%;	
	color: rgb(135, 141, 153);
	font-size: 12px;
	font-weight: 700;	
	cursor: pointer;		
}
.operation div:hover{
	color: rgb(102, 174, 255);
}
.reminder{
	margin-top: 10px;
	text-align: left;
	line-height: 25px;
	padding: 0 10px;
	border: 5px solid rgb(237, 210, 138);
	border-radius: 2px;
	border-right-width: 0;
	background-color: rgb(252, 248, 226);
	border-bottom-width: 0;
	border-top-width: 0;
}
.reminder h3{
	margin-left: 10px;
	color: rgb(157, 116, 55);
	font-size: 12px;
	font-weight: 700;	
}
.reminder span{
	margin-left: 10px;
	color: rgb(157, 116, 55);
	font-size: 12px;
	font-weight: 700;		
}
</style>