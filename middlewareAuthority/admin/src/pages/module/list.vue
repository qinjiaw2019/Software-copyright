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
		<div class="searchtop">
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
		          @click.stop.prevent="delAll(powerlist)">删除所选</el-button>
			</div>
			<div class="add">
		        <el-button
		          size="small"
		          ><router-link to="add">添加</router-link></el-button>
			</div>
		</div>
		<div class="powerlist">
			<el-tooltip content="双击查看用户全部信息" placement="top-end" effect="light">
				<el-table
					size="mini"
					ref="multipleTable"
			        :data="powerlist"
			        style="width: 100%"
			        @row-dblclick="rowDblClick"
			        @selection-change="selectionChange">
			        <el-table-column
				        type="selection">
				    </el-table-column>
			        <el-table-column
				        prop="id"
				        label="ID">
			        </el-table-column>
			        <el-table-column
				        prop="name"
				        label="角色名称">
			        </el-table-column>
			        <el-table-column
				        prop="type"
				        label="角色类型">
			        </el-table-column>
			        <el-table-column
				        prop="user"
				        label="角色下的模块">
			        </el-table-column>
			        <el-table-column
			        	width="180"
			        	label="操作">
					    <template slot-scope="scope" >
					    	<el-button
					          size="mini"
					          @click.stop.prevent="updata">修改</el-button>
					        <el-button
					          size="mini"
					          type="danger"
					          @click.stop.prevent="handleDelete(scope.$index, powerlist)">删除</el-button>
					    </template>
					</el-table-column>
			    </el-table>
			</el-tooltip>
		</div>
		<div class="pagination">
			<el-pagination
			    layout="prev, pager, next"
			    @current-change="getData"
			    :total="tatol">
			</el-pagination>
		</div>
		<div class="popoer-user">
			<el-dialog
				title="用户详细信息"
				width="50%"
				:visible.sync="dialogTableVisible">
			    <ul>
			    	<li>应用ID：<span>{{info.id}}</span></li>
                    <li>应用名称：<span>{{info.name}}</span></li>
                    <li>应用描述：<span>{{info.desc}}</span></li>
                    <li>应用地址：<span>{{info.url}}</span></li>
                    <li>回调地址：<span>{{info.redirectUri}}</span></li>
                    <li>应用类型：<span>{{info.type}}</span></li>
                    <li>所属用户：<span>{{info.user}}</span></li>
                    <li>应用key值：<span>{{info.key}}</span></li>
                    <li>secret：<span>{{info.secret}}</span></li>
                    <li>创建时间：<span>{{info.createTime}}</span></li>
			    </ul>
			</el-dialog>
		</div>
		<div class="popoer-updata">
			<el-dialog
				title="修改"
				width="50%"
				:visible.sync="updataVisible">
                <el-form >
                	<div class="updata">
						<el-form-item label="应用名称">
						    <div class="input"><el-input
						    	size="small"
						    	placeholder="请输入新的应用名称"
						    	v-model="form.name"></el-input></div>
						</el-form-item>
						<el-form-item label="应用描述">
						    <div class="input"><el-input
						    	size="small"
						    	type="textarea"
						    	placeholder="请输入新的应用描述"
						    	v-model="form.desc"></el-input></div>
						</el-form-item>
						<el-form-item label="应用地址">
						    <div class="input"><el-input
						    	size="small"
						    	placeholder="请输入新的应用地址"
						    	v-model="form.url"></el-input></div>
						</el-form-item>
						<el-form-item label="回调地址">
						    <div class="input"><el-input
						    	size="small"
						    	placeholder="请输入新的回调地址"
						    	v-model="form.redirectUri"></el-input></div>
						</el-form-item>
						<el-form-item label="应用类型">
							<div class="selectoption">
								&nbsp;&nbsp;
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
						</el-form-item>
					</div>
            	</el-form>
                <div class="updata-btn">
                	<el-button
                		type="primary"
                		size="mini"
                		@click.stop.prevent="updataCreate">提交</el-button>
                </div>
			</el-dialog>
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
	        dialogTableVisible:false,
	        updataVisible:false,
	        info:{},
	        ids:{
	        	type:String,
	        	default: ''
	        },
	        form:{
	        	id: '',
	        	name: '',
	        	desc: '',
	        	url: '',
	        	redirectUri: '',
	        	type: '',
	        	user: '',
	        	key: '',
	        	secret: '',
	        	createTime: '',
	        },
		}
	},
	created(){
		this.load = true;
		const that = this;
		setTimeout(()=>{
			this.load = false;
		},2000)
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
        		that.$message({
		          showClose: true,
		          message: '请求错误',
		          type: 'error'
		        });
			})
		},
		//修改数据
		updata(){
			this.updataVisible = true
		},
		updataCreate(){
			const that = this
			module.edit(this.form).then(response=>{
            	that.$message({
		          showClose: true,
		          message: '恭喜更新成功',
		          type: 'success'
		        });
			},err=>{
        		that.$message({
		          showClose: true,
		          message: '请求错误',
		          type: 'error'
		        });
			})
		},
		//删除行
        handleDelete(index, row) {
			const that = this;
			let id = String(row[index].id)
			module.del(id).then(response=>{
				console.log(response)
			},err=>{
				console.log(1)
			});
        	 row.splice(index, 1);
        },
        rowDblClick(row, event){
        	const that = this
        	this.dialogTableVisible = true
        	let id = row.id
        	module.get({id:id}).then(response=>{
        		that.info = response
        	},err=>{
        		that.$message({
		          showClose: true,
		          message: '请求错误',
		          type: 'error'
		        });
        	})
//      	console.log(row,$event)
        },
        //搜索
        sreach(){
        	const that = this
        	this.load = true
        	module.getBy({name:this.sreachKey.inputKey,type:this.sreachKey.value}).
        	then(response=>{
        		this.powerlist = response
        		this.load = false
        	},err=>{
        		that.$message({
		          showClose: true,
		          message: '请输入内容',
		          type: 'error'
		        });
        	})
        	this.load = false;
        },
        selectionChange(rows){
        	this.ids = ''
        	rows.forEach(row => {
        	 	this.ids = this.ids + String(row.id) + ','
        	 	this.show_ = true
        	})
        	console.log(this.ids)
        },
        //删除所有
        delAll(){
            const that = this
            module.delIds(ids).
            then(response=>{
            	console.log(response)
            	that.$message({
		          showClose: true,
		          message: '删除成功',
		          type: 'success'
		        });
            },err=>{
            	that.$message({
		          showClose: true,
		          message: '请求错误',
		          type: 'error'
		        });
            })
        },
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
	margin-top: 10px;
	margin-bottom: 10px;
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
.popoer-user{
	text-align: left;
}
.popoer-user ul{
	overflow: auto;
}
.popoer-user ul li{
	line-height: 30px;

}
.popoer-user ul li span{
	margin-left: 15px;
}
.popoer-updata{
	position: relative;
}
.input{
	position: absolute;
	left: 80px;
	right: 40px;
}
.updata{
    margin-left: 50px;
}
.selectoption{
	position: absolute;
	left: 70px;
}
</style>
