<template>
	<div class="list">
		<mw-loading  :load="load"/>
		<div class="breadcrumb">
			<el-breadcrumb separator="/">
			    <el-breadcrumb-item :to="{ path: '/index' }">
			    	<i class="fa fa-home"></i>首页
			    </el-breadcrumb-item>
			    <el-breadcrumb-item :to="{path: '/index/module/list'}">权限管理</el-breadcrumb-item>
			    <el-breadcrumb-item>权限列表</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<hr />
		<div class="search">
			<div class="inputkey">    		       
    		    <el-input 
    		    	v-model="sreachKey.inputKey"
    		    	size="small"
    		    	placeholder="请输入内容">
    		    	<template slot="prepend">关键字:</template>
    		    </el-input>    		    
			</div>
			<div class="select">
				应用类型:
				<el-select 
					v-model="sreachKey.options.value" 
					size="small"
					placeholder="请选择">
				    <el-option
				      v-for="item in sreachKey.options"
				      :key="item.value"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</el-select>
			</div>		            
			<div class="sreach">
				<el-button 
					size="small"
					@click.stop.prevent="sreach">搜索</el-button>
			</div>
			<div class="del" v-show="show_">
		        <el-button
		          size="small"
		          type="danger"
		          @click.stop.prevent="delAll(powerlist)">删除所有</el-button>
			</div>	
			<div class="add">
		        <el-button
		          size="small"
		          ><a href="add.vue">添加</a></el-button>
			</div>			
		</div>
		<div class="powerlist">
			<el-table
				size="mini"
				ref="multipleTable"
		        :data="powerlist"
		        style="width: 100%"
		        @select-all="selectAll(powerlist)">
		        <el-table-column
			        type="selection">
			    </el-table-column>
		        <el-table-column
			        prop="id"
			        label="应用地址">
		        </el-table-column>
		        <el-table-column
			        prop="name"
			        label="应用名称">
		        </el-table-column>
		        <el-table-column
			        prop="desc"
			        label="应用描述">
		        </el-table-column>
		        <el-table-column
			        prop="url"
			        label="应用地址">
		        </el-table-column>
		        <el-table-column
			        prop="redirectUri"
			        label="回调地址">
		        </el-table-column>
		        <el-table-column
			        prop="type"
			        label="应用类型">
		        </el-table-column>
		        <el-table-column
			        prop="user"
			        label="所属用户">
		        </el-table-column>
		        <el-table-column
			        prop="key"
			        label="key">
		        </el-table-column>
		        <el-table-column
			        prop="createTime"
			        label="创建时间">
		        </el-table-column>
		        <el-table-column 
		        	width="180"
		        	label="操作">
				    <template slot-scope="scope" >
				    	<el-button
				          size="mini"
				          >修改</el-button>
				        <el-button
				          size="mini"
				          type="danger"
				          @click.stop.prevent="handleDelete(scope.$index, powerlist)">删除</el-button>
				    </template>
				</el-table-column>
		    </el-table>
		</div>
		<div class="pagination">
			<el-pagination
			    layout="prev, pager, next"
			    @current-change="getData"
			    :total="tatol">
			</el-pagination>
		</div>
		<hr />
		<div class="face-operation">
			<div class="title"><h3>面板操作日志</h3></div>
			<div class="clear">
				<el-button 
					size="small"
					@click.stop.prevent="clear(facelist)">清空</el-button>
			</div>
		</div>
		<div class="line"></div>
		<div class="operation-table">
			<el-table
		        :data="facelist"
		        size="mini"
		        style="width: 100%">
		        <el-table-column
			        prop="id"
			        label="编号"
			        width="180">
		        </el-table-column>
		        <el-table-column
			        prop="name"
			        label="操作类型"
			        width="180">
		        </el-table-column>
		        <el-table-column
			        prop="desc"
			        label="说明">
		        </el-table-column>
		    </el-table>
		</div>
	</div>
</template>

<script>
import{module}from 'service'
import Loading from 'components/loading'
export default{
	data(){
		return{
			powerlist:[],
			facelist:[],
			params:{page:1,limit:10},
			tatol: 0,
			sreachKey:{
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
			},
		    show_: false,
	        load: false,
	        visible: false,
		}
	},
	created(){
		this.load = true;
		const that = this;
		this.getList(this.params.page,this.params.limit)
		//gettatol
		module.getTatol().then(response=>{
			that.tatol = response;
			this.load = false;
		},err=>{
			
		})
	},
    methods: {
		getData(val){
			this.load = true
			this.params.page = val
			this.getList(this.params.page,this.params.limit)
			this.load = false
			this.show_ = false
		},
		//获取数据
		getList(page,limit){
			const that = this;
			module.get({page:page,limit:limit}).then(response=>{
				that.powerlist = response;
			},err=>{
				
			});
		},
		//删除行
        handleDelete(index, row) {
         row.splice(index, 1);
        },
        //搜索
        sreach(){
        	const that = this
        	this.load = true
        	module.getBy({name:this.sreachKey.inputKey}).
        	then(response=>{
        		console.log(response)
        		this.powerlist = response
        		this.load = false
        	},err=>{
        		that.$message({
		          showClose: true,
		          message: '请输入内容',
		          type: 'success'
		        });
        	})
        	this.load = false;
        },
        //全选
        selectAll(rows){
	        if (rows) {
	          rows.forEach(row => {
	            this.$refs.multipleTable.toggleRowSelection(row,!this.show_);
	          });
	        } else {
	          this.$refs.multipleTable.clearSelection();
	        }
	            console.log(this.$refs.multipleTable)
	        	this.show_ = !this.show_
        },
        //删除所有
        delAll(val){
        	this.val = []
        	this.powerlist = this.val
        	this.show_ = false
        },
        //清除操作面板数据
        clear(val){
        	this.val = []
        	this.facelist = this.val        	
        }
    },	
    components:{
    	'mw-loading': Loading,	
    }
}
</script>

<style scoped>

.list hr{
	height: 10px;
	border: 1px solid rgb(230, 233, 238);
	background-color: rgb(230, 233, 238);
}
.breadcrumb{
	margin-top: 20px;
	margin-bottom: 20px;
	line-height: 40px;
}
.breadcrumb i{
	color: rgb(205, 205, 205);
	font-size: 16px;
	margin-top: -2px;
}	
.start{
	border: 1px solid rgb(240, 250, 250);
}
.powerlist{
	text-align: left;
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
.sreach{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;		
}
.del{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	font-size: 12px;	
}
.add{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	font-size: 12px;		
}
/*面板操作日志*/
.face-operation{
	height: 40px;
}
.title{
	float: left;
	margin: 10px;
}
.clear{
	float: left;
	margin: 10px;
	margin-top: 6px;	
}
.line{
	border: 1px solid rgb(230, 233, 238);
}
.operation-table{
	text-align: left;
}
</style>