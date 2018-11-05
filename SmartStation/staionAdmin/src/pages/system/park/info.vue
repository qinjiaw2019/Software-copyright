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
				:data="info"
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
			      label="ID号"
			      prop="id"
			      width="100">
			    </el-table-column>
			    <el-table-column
			      label="流水号"
			      prop="addressId"
			      width="100">
			    </el-table-column>
			    <el-table-column
			      label="停车场名称"
			      prop="name"
			      width="150">
			    </el-table-column>
			    <el-table-column
			      label="所在区域"
			      prop="address"
			      width="250">
			    </el-table-column>
			    <el-table-column
		          prop="stationNum"
		          label="停车位"
		          width="100">
		        </el-table-column>
		        <el-table-column
		          label="创建时间"
		          prop="createTime"
		          width="120">
		          <template slot-scope="scope">{{ getLocalTime(scope.row.createTime) }}</template>
		        </el-table-column>
		        <el-table-column
			      label="法人资料"
			      width="180">
			      <template slot-scope="scope">
			        <el-popover trigger="hover" placement="top">
			          <p>姓名: {{ scope.row.pk_person }}</p>
			          <p>身份证号: {{ scope.row.pk_IDcard }}</p>
			          <div slot="reference" class="name-wrapper">
			            <el-tag size="medium">{{ scope.row.pk_person }}</el-tag>
			            <el-tag size="medium">{{ scope.row.pk_lable }}</el-tag>
			          </div>
			        </el-popover>
			      </template>
			    </el-table-column>
			    <el-table-column
			      fixed="right"
			      label="操作"
			      width="150">
			      <template slot-scope="scope">
			        <el-button type="text" size="small"  @click="handleEdit(scope.$index, tableData)">编辑</el-button>
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
		<el-dialog title="停车场数据" 
			width="500px"
			:visible.sync="dialogFormVisible">
			<div class="edit">
				<el-form :model="form">
				    <el-form-item label="ID" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="停车场名称" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="所在区域" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="停车位" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				     <el-form-item label="法人资料" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
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
			info:[],
			input: '',
			total:'',
			currentPage: 1,
			activeName2: 'first',
			background:'white',
			pagesize:20,
			tableData: [],
			dialogTableVisible: false,
	        dialogFormVisible: false,
	        selection: false,
	        search:false,
	        form: {
	          name: '',
	          region: '',
	          date1: '',
	          date2: '',
	          delivery: false,
	          type: [],
	          resource: '',
	          desc: ''
	        },
	        formLabelWidth: '120px'
		}
	},
	methods:{
//		编辑
      handleEdit(index, row) {
      	this.dialogFormVisible = true
        console.log(index, row);
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
//		获取所有停车场的信息
		getinfo(){
			this.$api.station.get(this.currentPage,this.pagesize).then(response=>{
				this.total = response.data.total
				this.info = response.data.data
	        })
		},
//		根据获取日期
		getLocalTime(nS) {  
			 var date=new Date(nS);
			 var year=date.getFullYear();
			 var month=this.gw_now_addzero(date.getMonth()+1);
			 var day=this.gw_now_addzero(date.getDate());
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
		this.bianli()
//		this.getLocalTime(1522718713230)
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
