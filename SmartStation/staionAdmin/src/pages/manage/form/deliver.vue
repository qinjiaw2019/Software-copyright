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
		</div>
		
		<el-table
		    :data="tableData"
		    border
		    style="width: 100%">
		    <el-table-column
		      prop="num"
		      label="流水号"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      prop="car_num"
		      label="车牌号"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      prop="statu"
		      label="进出状态"
		      width="80">
		    </el-table-column>
		    <el-table-column
		      prop="into_time"
		      label="驶入时间"
		      width="180">
		    </el-table-column>
		    <el-table-column
		      prop="out_time"
		      label="驶出时间"
		      width="180">
		    </el-table-column>
		    <el-table-column
		      prop="region"
		      label="泊位片区"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      prop="reg_num"
		      label="泊位号"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      prop="access"
		      label="进入通道"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      fixed="right"
		      label="操作"
		      width="150">
		      <template slot-scope="scope">
		        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
		        <el-button type="text" size="small" @click="dialogFormVisible = true">编辑</el-button>
		        <el-button type="text" size="small">移除</el-button>
		      </template>
		    </el-table-column>
	  </el-table>
	  
	  <!--编辑框-->
	  <el-dialog title="车位状态" :visible.sync="dialogFormVisible">
		  <el-form :model="form">
		    <el-form-item label="设备状态" :label-width="formLabelWidth">
		      <el-input v-model="form.name" auto-complete="off"></el-input>
		    </el-form-item>
		    <el-form-item label="泊位状态" :label-width="formLabelWidth">
		      <el-select v-model="form.region" placeholder="请选择泊位状态">
		        <el-option label="有车" value="shanghai"></el-option>
		        <el-option label="预定" value="shanghai"></el-option>
		        <el-option label="无车" value="beijing"></el-option>
		      </el-select>
		    </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="dialogFormVisible = false">取 消</el-button>
		    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
		  </div>
		</el-dialog>
		
	</div>
</template>

<script>
import {Deliver} from './deliver.js'
export default {
	methods: {
	      handleClick(row) {
	        console.log(row);
	      }
	   },
    data() {
      return {
      	input:'',
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
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
    created(){
		this.tableData = Deliver
	}
}
</script>

<style scoped>
.search{
	padding: 10px;
	background: white;
	border-bottom: 1px gainsboro solid;
	margin-bottom: 10px;
}
</style>
