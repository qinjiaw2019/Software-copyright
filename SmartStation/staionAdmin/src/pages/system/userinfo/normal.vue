<template>
	<div>
		<!--搜索框-->
		<div class="search">
			<el-input
			    placeholder="请输入内容"
			    style="width: 300px;"
			    prefix-icon="el-icon-search"
			    v-model="input">
			</el-input>
			 	<el-button type="primary" icon="el-icon-edit" @click="delete1" circle style="margin-left: 15px;"></el-button>
			  	<el-button type="danger" icon="el-icon-delete" circle></el-button>
		</div>
		<!--表格区-->
		<div>
			<el-table
				:data="userinfo"
				size="mini"
				:stripe="true"
				tooltip-effect="dark"
				border
		    		style="width: 100%;font-size: 0.9em;">
		    		<el-table-column
		    		  v-if="selection"
			      type="selection"
			      width="55">
			    </el-table-column>
			    	<el-table-column
			      type="index"
			      width="50">
			    </el-table-column>
			    <el-table-column
			      label="账户"
			      width="120"
			      prop="account">
			    </el-table-column>
			    <el-table-column
			      label="电话"
			      width="120"
			      prop="tel">
			    </el-table-column>
			    <el-table-column
		          prop="createTime"
		          label="创建时间"
		          width="130">
		          <template slot-scope="scope">{{ getLocalTime(scope.row.createTime) }}</template>
		        </el-table-column>
			    <el-table-column
		          prop="money"
		          label="费用"
		          width="100">
		       </el-table-column>
		        <el-table-column
		          label="积分"
		          prop="rankPoints"
		          width="100">
		        </el-table-column>
		        <el-table-column
		          label="身份证号"
		          prop="idCard"
		          width="170">
		        </el-table-column>
		        <el-table-column
		          label="信誉度"
		          prop="reputationPoints"
		          width="100">
		        </el-table-column>
			    <el-table-column
			      fixed="right"
			      label="操作"
			      width="150">
			      <template slot-scope="scope">
			        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
			        <el-button type="text" size="small"  @click="handleEdit(scope.row.id , tableData)">编辑</el-button>
			        <el-button type="text" size="small" @click="deleteRow(scope.$index, tableData)">移除</el-button>
			      </template>
			    </el-table-column>
			  </el-table>
			  <!--选择页码-->
			  <el-pagination
			      @size-change="handleSizeChange"
			      @current-change="handleCurrentChange"
			      :current-page="currentPage"
			      :page-sizes="[10, 20, 30, 40]"
			      :page-size="pagesize"
			      layout="total, sizes, prev, pager, next, jumper"
			      :total="total"
			      style="text-align: center;padding: 10px;">
			    </el-pagination>
		</div>
		<!--弹出框／编辑框-->
		<el-dialog title="用户信息修改" 
			width="630px"
			:visible.sync="dialogFormVisible">
			<div class="edit">
				<el-form :model="form">
				    <el-form-item label="账户" :label-width="formLabelWidth">
				      <el-input v-model="form.account" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="电话" :label-width="formLabelWidth">
				      <el-input v-model="form.account" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="余额" :label-width="formLabelWidth">
				      <el-input v-model="form.money" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="积分" :label-width="formLabelWidth">
				      <el-input v-model="form.rankPoints" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="身份证号" :label-width="formLabelWidth">
				      <el-input v-model="form.idCard" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="信誉度" :label-width="formLabelWidth">
				      <el-input v-model="form.reputationPoints" auto-complete="off"></el-input>
				    </el-form-item>
				  </el-form>
			</div>
		  <div slot="footer" class="edit">
		    <el-button @click="dialogFormVisible = false">取 消</el-button>
		    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
		  </div>
		</el-dialog>
		
	</div>
</template>

<script>
export default {
	data(){
		return{
			input: '',
			userinfo:'',
			idinfo:'',
			total:'',
			currentPage: 1,
			activeName2: 'first',
			background:'white',
			pagesize:10,
			dialogTableVisible: false,
	        dialogFormVisible: false,
	        selection: false,
	        search:false,
	        form: {
	        		account:'11'
	        	},
	        formLabelWidth: '120px'
		}
	},
	methods:{
		getinfo(){
			this.$api.user.get(this.currentPage,this.pagesize).then(response=>{
				this.total = response.data.total
          		this.userinfo = response.data.data
          })
		},
//		编辑
      handleEdit(id, row) {
      	this.dialogFormVisible = true
      	this.$api.user.getUserInfo(id).then(response=>{
      		this.form = response.data
          })
      },
//     删除用户
      deleteRow(index, rows) {
        rows.splice(index, 1);
      },
      delete1(){
      	this.selection = ~this.selection
      },
//	   为pagesize发生改变时的相应函数
      handleSizeChange(size) {
        this.pagesize = size; 
        this.getinfo()
      },
//		为currentPage发生改变时的相应函数
      handleCurrentChange(currentPage) {
         this.currentPage = currentPage; 
         this.getinfo()
      },
//		获取日期
		getLocalTime(nS) {  
			 var date=new Date(nS);
			 var year=date.getFullYear();
			 var month=this.gw_now_addzero(date.getMonth()+1);
			 var day=this.gw_now_addzero(date.getDate());
			 if(nS == 0){
			 	return null
			 }
			 else
			 return year+'/'+month+'/'+day+'  '
		},
		 gw_now_addzero(temp){  
			 if(temp<10) return "0" + temp;
			 else 
			 return temp;
		},
	},
	created(){
		this.getinfo()
	}
}
</script>

<style scoped>
.search{
	padding: 10px;
	background: white;
	border-bottom: 1px gainsboro solid;
}
.edit{
	margin-right: 15%;
}
</style>
