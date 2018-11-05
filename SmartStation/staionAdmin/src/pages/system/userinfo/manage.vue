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
				:data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
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
			      prop="mn_ID"
			      width="120">
			    </el-table-column>
			    <el-table-column
			      label="姓名"
			      prop="mn_name"
			      width="100">
			    </el-table-column>
			    <el-table-column
			      label="所属停车场"
			      width="180">
			      <template slot-scope="scope">
			        <el-popover trigger="hover" placement="top">
			          <p>停车场ID: {{ scope.row.pk_ID }}</p>
			          <p>地址: {{ scope.row.pk_name }}</p>
			          <div slot="reference" class="name-wrapper">
			            <el-tag size="medium">{{ scope.row.pk_name }}</el-tag>
			          </div>
			        </el-popover>
			      </template>
			    </el-table-column>
			    <el-table-column
		          prop="mn_pass"
		          label="密码"
		          width="130">
		        </el-table-column>
			    <el-table-column
		          prop="mn_phone"
		          label="联系电话"
		          width="130">
		        </el-table-column>
		        <el-table-column
		          label="身份证号"
		          prop="mn_IDcard"
		          width="200">
		        </el-table-column>
		        <el-table-column
		          label="性别"
		          prop="mn_sex"
		          width="100">
		        </el-table-column>
		        <el-table-column
		          label="年龄"
		          prop="mn_age"
		          width="100">
		        </el-table-column>
			    <el-table-column
			      fixed="right"
			      label="操作"
			      width="150">
			      <template slot-scope="scope">
			        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
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
			      :total="tableData.length"
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
import {userInfo} from './mn_info.js'
export default {
	data(){
		return{
			input: '',
			currentPage: 1,
			activeName2: 'first',
			background:'white',
			pagesize:10,
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
      },
//		为currentPage发生改变时的相应函数
      handleCurrentChange(currentPage) {
         this.currentPage = currentPage; 
      },
	},
	created(){
		this.tableData = userInfo
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
