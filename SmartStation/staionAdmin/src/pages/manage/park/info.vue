<template>
	<div>
		<!--暂无信息-->
		<div v-if="info">
			<el-card shadow="hover">
				<i class='iconfont icon-meiyoudingdan-01 icon'></i>
				<span>还没有停车场信息，快去<span class="add" @click="add()">添加停车场</span></span>
			</el-card>
		</div>
		<!--{{park}}-->
		<!--有信息时-->
		<div v-if="!info">
			<el-card shadow="hover" class="card2" v-for="(item,index) in park">
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车场编号:</span></el-col>
						<el-col :span="10"><span class="word1">{{index+1}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车场名称:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.name}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">地址:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.address}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">计价方式:</span></el-col>
						<el-col :span="19"><span class="word1">暂时获取不到</span></el-col>
						<el-col :span="1"><i class="el-icon-edit" @click="editFoot(item.id)"></i></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车位:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.stationNum}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车场类型:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.type}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车场负责人:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.pk_person}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">身份证号:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.pk_IDcard}}</span></el-col>
					</el-row>
				</div>
				<div class="parkinfo">
					<el-row>
						<el-col :span="4"><span class="word">停车场简述:</span></el-col>
						<el-col :span="10"><span class="word1">{{item.desc}}</span></el-col>
					</el-row>
				</div>
				<div class="button">
						<el-button type="primary" @click="edit(item.id)" icon="el-icon-edit" circle></el-button>
						<el-button type="danger" @click="del(item.id)" icon="el-icon-delete" circle></el-button>
				</div>
			</el-card>
		</div>
		<!--编辑基本信息-->
		<el-dialog title="修改停车场信息" :visible.sync="dialogFormVisible">
			<div style="padding:20px;">
				<el-form :model="form">
			    <el-form-item label="停车场名称" :label-width="formLabelWidth">
			      <el-input v-model="form.name" auto-complete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="停车场地址" :label-width="formLabelWidth">
			      <v-distpicker 
							:province="form.provice" 
							:city="form.city" 
							:area="form.country"
							@province="onChangeProvince" 
							@city="onChangeCity"
							@area="onChangeArea">
						</v-distpicker>
			    </el-form-item>
			    <el-form-item label="详细地址" :label-width="formLabelWidth">
			      <el-input type="textarea" v-model="form.address" auto-complete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="停车位" :label-width="formLabelWidth">
			      <el-input-number v-model="form.stationNum" :step="1"></el-input-number>
			    </el-form-item>
			    <el-form-item label="停车场类型" :label-width="formLabelWidth">
			      <el-radio-group v-model="form.type">
				      <el-radio label="公共停车场"></el-radio>
				      <el-radio label="专用停车场"></el-radio>
				    </el-radio-group>
			    </el-form-item>
			    <el-form-item label="停车场负责人" :label-width="formLabelWidth">
			      <el-input v-model="form.person" auto-complete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="身份证号" :label-width="formLabelWidth">
			      <el-input v-model="form.IDcard" auto-complete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="停车场简述" :label-width="formLabelWidth">
			      <el-input type="textarea" v-model="form.desc" auto-complete="off"></el-input>
			    </el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer">
			    <el-button @click="dialogFormVisible = false">取 消</el-button>
			    <el-button type="primary" @click="editParkInfo">确 定</el-button>
			  </div>
			</div>
		</el-dialog>
		
		<!--编辑收价信息-->
		<el-dialog title="修改停车场信息" :visible.sync="dialogFormVisible2">
			<c-foot></c-foot>
		</el-dialog>
	</div>
</template>

<script>
import charg from './charg'
export default {
	components: {
		'c-foot': charg,
	},
	props:{
		park:{
			type:Array,
			default:function(){
				return []
			}
		},
		info:false,
	},
	data(){
		return{
			dialogTableVisible: false,
        		dialogFormVisible: false,
        		dialogTableVisible2: false,
        		dialogFormVisible2: false,
		    form: {},
			formLabelWidth: '120px',
		}
	},
	methods:{
		add(){
			this.$emit('HandAdd')
		},
//		根据停车场id获取其信息
		getinfo(){
			let carid = this.$route.query.id
			const that = this
			this.$api.station.getById(carid).then(response=>{
	          		that.form = response.data
	       })
		},
		getcharg(){
			let carid = this.$route.query.id
			this.$api.fareRule.getById(1).then(response=>{
				console.log(response)
          })
		},
//		编辑该条停车场信息
		edit(id){
			this.$router.push({path:'/home/parking',query:{id:id}})
			this.dialogFormVisible = true
			this.getinfo()
			this.getcharg()
		},
		editFoot(id){
		  	this.$router.push({path:'/home/parking',query:{id:id}})
			this.dialogFormVisible2 = true
	  	},
//		获取管理员名下停车场信息
		get(){
			this.$api.station.getList().then(response=>{
				this.park = response.data
          })
		},
//		删除该条停车场信息
		del(addressId){
			this.$alert('确定删除该停车场吗', '注意！', {
	          confirmButtonText: '确定',
	          callback: action => {
            			this.$api.station.del(addressId).then(response=>{
					console.log(response)
					this.get()
	          		this.$notify({
			          title: '成功',
			          message: '删除成功',
			          type: 'success'
			        });
	          	})
	          }
	       });
			this.$emit('Handdel')
		},
//	  确认修改停车场信息
	  editParkInfo(){
	  	this.dialogFormVisible = false
	  	const that = this
		this.$api.station.edit(that.form).then(response=>{
          })
		this.get()
	  },
	  onChangeProvince(){
	  	
	  },
	  onChangeCity(){
	  },
	  onChangeArea(){
	  	
	  }
	  
	},
	created(){
		this.get()
	}
}
</script>

<style scoped>
@import '../../../static/font/iconfont.css';
.add{
	color: rgba(87, 201, 246, 1.0);
}
.word{
	float: right;
}
.word1{
	margin-left: 25px;
}
.card2{
	width: 90%;
	float: left;
	padding: 20px;
	margin: 20px;
}
.icon{
	font-size: 2em;
	padding: 10px;
}
.parkinfo{
	border-bottom: 1px solid gainsboro;
	padding: 10px;
	color: rgba(100, 100, 100, 1.0);
}
.button{
	float: right;
	padding: 20px;
}
.dialog-footer{
	float: right;
}
</style>
