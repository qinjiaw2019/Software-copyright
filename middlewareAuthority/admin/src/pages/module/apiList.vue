<template>
	<div class="list">
		<mw-loading  :load="load"/>
		<div class="breadcrumb">
			<el-breadcrumb separator="/">
			    <el-breadcrumb-item :to="{ path: '/index' }">
			    	<i class="fa fa-home"></i>首页
			    </el-breadcrumb-item>
			    <el-breadcrumb-item>API列表</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<hr />
		<div class="navmenu">
			<el-menu 
				default-active="activeIndex" 
				class="el-menu-demo" 
				mode="horizontal" 
				@select="handleSelect">
			    <el-menu-item index="1">全部</el-menu-item>
			    <el-menu-item index="2">运行环境</el-menu-item>
			    <el-menu-item index="3">插件</el-menu-item>
			</el-menu>			
			<div class="searchtop">
				<div class="inputkey">    		       
				    <el-input 
				    	v-model="sreachKey.inputKey"
				    	size="small"
				    	placeholder="名称搜索">
				    	<!--<template slot="prepend">关键字:</template>-->
				    </el-input>    		    
				</div>
				<!--<div class="select">
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
				</div>		            -->
				<div class="sreach">
					<el-button 
						size="small"
						@click.stop.prevent="sreach">搜索</el-button>
				</div>			
				<div class="add">
			        <el-button
			          size="small"
			          @click.stop.prevent="add">添加</el-button>
				</div>			
			</div>
		</div>	
		<!--详情-->
		<div class="powerlist">
			<el-tooltip content="双击查看详情" placement="top-end" effect="light">
				<el-table
					size="mini"
					ref="multipleTable"
			        :data="apilist"
			        style="width: 100%"
			        @row-dblclick="rowDblClick">
			        <el-table-column
				        prop="id"
				        label="ID">
			        </el-table-column>
			        <el-table-column
				        prop="name"
				        label="名称">
			        </el-table-column>
			        <el-table-column
				        prop="type"
				        label="接口地址">
			        </el-table-column>
			        <el-table-column
				        prop="method"
				        label="请求方式">
			        </el-table-column>
			        <el-table-column
				        prop="user"
				        label="描述">
			        </el-table-column>
			        <el-table-column
				        prop="user"
				        label="项目名称">
			        </el-table-column>
			        <el-table-column 
			        	width="180"
			        	label="操作">
					    <template slot-scope="scope" >
					    	<el-button
					          size="mini"
					          @click.stop.prevent="updata">编辑</el-button>
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
				title="API详情页" 
				width="70%"
				:visible.sync="dialogTableVisible">
			    <ul>
			    	<li>所属项目名称：<span>{{info.id}}</span></li>
                    <li>接口地址：<span>{{info.name}}</span></li>
                    <li>请求方式：<span>{{info.desc}}</span></li>
                    <li class="remind">描述：<span>{{info.secret}}大大</span></li>
                    <li>成功返回示例：<textarea class="fun"></textarea></li>
                    <li>失败返回示例：<textarea class="fun"></textarea></li>
                    <li>请求参数：
                    	<el-table
							size="mini"
					        :data="apilist"
					        border
					        style="width: 100%">
					        <el-table-column
						        prop="id"
						        label="参数名">
					        </el-table-column>
					        <el-table-column
						        prop="name"
						        label="类型">
					        </el-table-column>
					        <el-table-column
						        prop="type"
						        label="必填">
					        </el-table-column>
					        <el-table-column
						        prop="method"
						        label="参数位置">
					        </el-table-column>
					        <el-table-column
						        prop="user"
						        label="描述">
					        </el-table-column>
					        <el-table-column
						        prop="user"
						        label="默认">
					        </el-table-column>
				        </el-table>
                    </li>
                    <li class="request-fun">请求示例：
                    	<ul class="request">
                    		<li @click.stop.prevent="handlechange(index)">shfushfudhf</li>
                    		<li>shfushfudhf</li>
                    		<li>shfushfudhf</li>
                    		<li>shfushfudhf</li>
                    		<li>shfushfudhf</li>
                    	</ul>
                    	<textarea class="fun"></textarea>
                    </li>
                    <li class="remind">备注：<span>{{info.secret}}大大</span></li>
                    <!--<li>创建时间：<span>{{info.createTime}}</span></li>-->
			    </ul>
			</el-dialog>
		</div>
		<!--编辑-->
		<div class="popoer-updata">
			<el-dialog 
				title="编辑" 
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
		<!--添加-->
		<div class="popoer-add">
			<el-dialog 
				title="添加" 
				width="60%"
				:visible.sync="addVisible">
                <el-form >
                	<div class="adddata">
                		<h3>添加属性</h3>
                		<div class="add-type">
             			<el-form-item label="名称">
						    <div class="add-input"><el-input 
						    	size="small"
						    	placeholder="请输入"
						    	v-model="addform.name"></el-input></div>
						</el-form-item>
						<el-form-item label="接口地址">
						    <div class="add-input"><el-input 
						    	size="small"
						    	placeholder="请输入"
						    	v-model="addform.name"></el-input></div>
						</el-form-item> 
						<el-form-item label="请求方式">
							<div class="add-input">
								<el-radio v-model="addform.radio" label="1">GET</el-radio>
		  						<el-radio v-model="addform.radio" label="2">POST</el-radio></div>
  						</el-form-item> 
  						<el-form-item label="成功返回示例">
  							<div class="add-input-text">
  								<textarea v-model="addform.successText" class="add-text"></textarea>
  							</div>
  						</el-form-item> 
  						<el-form-item label="失败返回示例">
  							<div class="add-input-text">
  								<textarea v-model="addform.errText" class="add-text"></textarea>
  							</div>
  						</el-form-item>
  						<el-form-item label="描述">
  							<div class="add-input-desc">
  								<textarea v-model="addform.remind" class="add-text"></textarea>
  							</div>
  						</el-form-item> 
  						<el-form-item label="所属类型">
  							<div class="add-input-desc">
  								<el-select 
									v-model="addform.options.value" 
									size="small"
									placeholder="请选择">
								    <el-option
								      v-for="item in addform.options"
								      :key="item.value"
								      :label="item.label"
								      :value="item.value">
								    </el-option>
								</el-select>
  							</div>
  						</el-form-item> 
  						<el-form-item label="描述">
  							<div class="add-input-desc">
  								<textarea v-model="addform.desc" class="add-text"></textarea>
  							</div>
  						</el-form-item> 
                		</div>
                		<h3>请求参数</h3>
                		<div class="options">
                		<el-form-item label="参数名">
						    <div class="add-input-option"><el-input 
						    	size="small"
						    	placeholder="请输入"
						    	v-model="addform.form.name"></el-input></div>
						</el-form-item>
						<el-form-item label="参数类型">
  							<div class="add-input-desc">
  								<el-select 
									v-model="addform.form.options.value" 
									size="small"
									placeholder="请选择">
								    <el-option
								      v-for="item in addform.form.options"
								      :key="item.value"
								      :label="item.label"
								      :value="item.value">
								    </el-option>
								</el-select>
  							</div>
  						</el-form-item> 
  						<el-form-item label="位置">
						    <div class="add-input-option"><el-input 
						    	size="small"
						    	placeholder="请输入"
						    	v-model="addform.form.addr"></el-input></div>
						</el-form-item>
						<el-form-item label="描述">
  							<div class="add-input-desc">
  								<textarea v-model="addform.form.desc" class="add-text"></textarea>
  							</div>
  						</el-form-item> 
  						<el-form-item label="默认值">
						    <div class="add-input-option"><el-input 
						    	size="small"
						    	placeholder="请输入"
						    	v-model="addform.form.val"></el-input></div>
						</el-form-item>
						<el-form-item label="必选">
							<div class="add-input">
								<el-radio v-model="addform.form.radio" label="3">是</el-radio>
		  						<el-radio v-model="addform.form.radio" label="4">否</el-radio></div>
  						</el-form-item> 						
                		</div>
                		<div class="updata-btn">
		                	<el-button 
		                		type="primary" 
		                		size="mini"
		                		@click.stop.prevent="addCreate(this.addform)">提交</el-button>
	             	    </div>
					</div>
            	</el-form>	
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
			apilist:[],
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
	        addVisible:false,
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
	        addform:{
	        	name: '',
	        	address: '',
	        	radio: '',
	        	successText: '',
	        	errText: '',
	        	remind: '',
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
	        	desc: '',
	        	form:{
	        		name: '',
	        		options: [{
			          value: '选项1',
			          label: 'String'
			        }, {
			          value: '选项2',
			          label: 'Object'
			        }, {
			          value: '选项3',
			          label: 'Array'
			        }, {
			          value: '选项2',
			          label: 'Number'
			        }, ],
			        addr: '',
			        desc: '',
			        val: '',
			        radio: '',
	        	},
	        }
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
				that.apilist = response;
			},err=>{
        		that.$message({
		          showClose: true,
		          message: '请求错误',
		          type: 'error'
		        }); 				
			})
		},
		//add
		add(){
			this.addVisible = true
		},
		addCreate(val){
			console.log(vla)
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
        handleSelect(key, keyPath) {
	        console.log(key, keyPath);
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
/*导航*/
.navmenu{
	height: 50px;
	overflow: hidden;	
}
.el-menu-demo{
	margin-top: -10px;
}
.searchtop{
	position: absolute;
	top: 73px;
	right: 50px;
}
.inputkey{
	text-align: left;
	width: 200px;
	margin-top: 5px;
	float: left;
}
/*.select{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;
}*/
.sreach{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	color: rgb(135, 141, 153);
	font-size: 12px;		
}
/*.del{
	float: left;
	margin-top: 5px;
	margin-left: 5px;
	font-size: 12px;	
}*/
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
/*导航数据*/
.request-fun{
	position: relative;
}
/*.request {
	position: absolute;
}*/
.request li{
	float: left;
	line-height: 50px;
	padding: 10px;
	text-align: center;
	background-color: rgb(230, 233, 238);
	color: rgb(135, 141, 153);
	font-weight: bold;
	font-size: 16px;
	cursor: pointer;
}
.request li:hover{
	color: white;
	background-color: darkgray;
}
.fun{
    width: 800px;
    border: 2px solid rgb(230, 235, 245);
    min-height: 400px;
    max-height: 500px;
    overflow: auto;
}
.remind span{
	display: block;
	border: 5px solid orange;
	border-top-width: 0;
	border-right-width: 0;
	border-bottom-width: 0;
	border-radius: 2px;
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



/*添加*/
/*.popoer-add{
	position: relative;
	padding: 50px;
}*/
.adddata{
	position: relative;
	text-align: left;
	padding: 60px;
}
.adddata h3{
	font-weight: bold;
	color: rgb(205, 205, 205);
}
.add-type{
	position: relative;
}
.add-input{
	position: absolute;
	left: 100px;
	width: 300px;
}
.add-input-text{
	position: relative;
	margin-left:80px;
}
.add-text{
	width: 400px;
	max-width: 500px;
	border: 1px solid rgb(216, 220, 229);
	border-radius: 3px;
	min-height: 100px;
	max-height: 400px;
	overflow: auto;
}
.add-input-desc{
	position: relative;
	margin-left:95px;	
	width: 300px;
}
.add-input-option{
	position: absolute;
	left: 95px;	
	width: 300px;
}
</style>