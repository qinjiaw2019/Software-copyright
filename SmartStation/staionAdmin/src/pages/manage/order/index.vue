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
				:data="park"
				size="mini"
				:stripe="true"
				tooltip-effect="dark"
		    		style="width: 100%;font-size: 0.9em;">
		    		    <el-table-column type="expand">
				      <template slot-scope="props">
				        <el-form label-position="left" inline class="demo-table-expand">
				          <el-form-item label="照片">
				            <span>{{ props.row.photo }}</span>
				          </el-form-item>
				        </el-form>
				      </template>
				    </el-table-column>
		    		<el-table-column
		    		  v-if="selection"
			      type="selection"
			      width="55">
			    </el-table-column>
			    	<el-table-column
			      label="所属片区"
			      width="120"
			      prop="id">
			    </el-table-column>
			    <el-table-column
			      label="片区号"
			      width="100"
			      prop="carNumber">
			    </el-table-column>
			    <el-table-column
			      label="泊位号"
			      width="100"
			      prop="currentUsed">
			    </el-table-column>
			    <el-table-column
		          prop="userId"
		          label="泊位状态"
		          width="130">
		        </el-table-column>
			    <el-table-column
		          prop="carNumberType"
		          label="变化时间"
		          width="130">
		       </el-table-column>
		       <el-table-column
			      prop="photo"
			      label="照片"
			      width="120">
			    </el-table-column>
			    <el-table-column
			      prop="carType"
			      label="预定车牌号"
			      width="120">
			    </el-table-column>
			    <el-table-column
			      prop="carXH"
			      label="设备状态"
			      width="120">
			    </el-table-column>
			    <el-table-column
			      fixed="right"
			      label="操作"
			      width="150">
			      <template slot-scope="scope">
			        <el-button @click="handleBlank(scope.row)" type="text" size="small">拉黑</el-button>
			        <el-button type="text" size="small"  @click="handleEdit(scope.$index, park)">编辑</el-button>
			        <el-button type="text" size="small" @click="deleteRow(scope.$index, park)">移除</el-button>
			      </template>
			    </el-table-column>
			  </el-table>
			  <!--选择页码-->
			  <el-pagination
			      @size-change="handleSizeChange"
			      @current-change="handleCurrentChange"
			      :current-page="param.page"
			      :page-sizes="[5, 10, 15, 20]"
			      :page-size="param.limit"
			      layout="total, sizes, prev, pager, next, jumper"
			      :total="total"
			      style="text-align: center;padding: 10px;">
			    </el-pagination>
		</div>
		<!--弹出框／编辑框-->
		<el-dialog title="车位状态" 
			width="500px"
			:visible.sync="dialogFormVisible">
			<div class="edit">
				<el-form :model="form">
				    <el-form-item label="姓名" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="电话" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="设备状态" :label-width="formLabelWidth">
				      <el-input v-model="form.name" auto-complete="off"></el-input>
				    </el-form-item>
				    <el-form-item label="泊位状态" :label-width="formLabelWidth">
				      <el-select v-model="form.region" placeholder="请选择泊位状态" style="width:100%">
				        <el-option label="有车" value="shanghai"></el-option>
				        <el-option label="预定" value="shanghai"></el-option>
				        <el-option label="无车" value="beijing"></el-option>
				      </el-select>
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
			info:'',
			park:'',
//			数据总条数
			total:20,
			dialogTableVisible: false,
	        dialogFormVisible: false,
	        selection: false,
	        search:false,
//	        分页器
	        param:{
	        	  page:1,
	        	  limit:5,
	        },
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
//		获取车牌数据
		getinfo(){
			this.$api.carinfo.get(this.param).then(response=>{
          		this.park = response.data.data
          })
		},
//		编辑
      handleEdit(index, row) {
      	this.dialogFormVisible = true
        console.log(index, row);
      },
      //拉黑该用户
      handleBlank(){
      	
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
        this.param.limit = size; 
        this.getinfo()
      },
//		为currentPage发生改变时的相应函数
      handleCurrentChange(currentPage) {
         this.param.page = currentPage; 
         this.getinfo()
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
