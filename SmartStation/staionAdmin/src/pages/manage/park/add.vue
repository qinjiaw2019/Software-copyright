<template>
	<div class="addbox">
		<div class="box">
			<!--<iframe class="iframe" src="http://47.94.167.18/station/search.html"></iframe>-->
		</div>
		<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="130px" class="demo-ruleForm">
		<div class="boss">
			<div class="box">
				  <el-form-item label="停车场名称" prop="name">
				    <el-input v-model="ruleForm.name" style="width: 90%;"></el-input>
				  </el-form-item>
				  <el-form-item label="所在区域">
					<v-distpicker 
						:province="ruleForm.provice" 
						:city="ruleForm.city" 
						:area="ruleForm.country"
						@province="onChangeProvince" 
						@city="onChangeCity"
						@area="onChangeArea">
					</v-distpicker>
				  </el-form-item>
				  <el-form-item label="详细地址" prop="address">
				    <el-input v-model="ruleForm.address" type="textarea" style="width: 90%;" placeholder="请输入详细地址"></el-input>
				  </el-form-item>
				  <el-form-item label="停车场营业执照" prop="photo">
					    <el-upload
						  class="upload-demo"
						  drag
						  action="https://jsonplaceholder.typicode.com/posts/"
						  :on-preview="handlePreview"
						  :on-remove="handleRemove"
						  :file-list="ruleForm.photo"
						  list-type="picture"
						  style="width: 90%;"
						  multiple>
						  <i class="el-icon-upload"></i>
						  <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
				</el-form-item>
			</div>
			<div class="box">
					  <el-form-item label="停车位" prop="stationNum">
					    <el-input-number v-model="ruleForm.stationNum" :step="1"></el-input-number>
					  </el-form-item>
					  <el-form-item label="类型" prop="type">
					    <el-radio-group v-model="ruleForm.type">
					      <el-radio label="公共停车场"></el-radio>
					      <el-radio label="专用停车场"></el-radio>
					    </el-radio-group>
					  </el-form-item>
				     <el-form-item label="停车场负责人" prop="person">
					    <el-input v-model="ruleForm.person"></el-input>
					  </el-form-item>
					  <el-form-item label="经营人身份证号" prop="IDcard">
					    <el-input v-model="ruleForm.IDcard"></el-input>
					  </el-form-item>
					  <el-form-item label="停车场简述" prop="desc">
					    <el-input type="textarea" v-model="ruleForm.desc"></el-input>
				  	  </el-form-item>
					  <el-form-item>
					  	<div style="margin-top: 20px;">
					  		<el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
					    		<el-button @click="resetForm('ruleForm')">重置</el-button>
					  	</div>
					 </el-form-item>
			</div>
		</div>
		</el-form>
	</div>
</template>

<script>
import VDistpicker from 'v-distpicker' // 城市选择器
import Map from '@/components/map'
export default {
data() {
      return {
        parkId:'',
        ruleForm: {
          name:'',
        	  userId:'',
          address: '',
          type:'',
          desc: '',
          stationNum:'',
          IDcard:'',
          person:'',
          latitude:'1',
          longitude:'1',
          provice:'北京市',
          city:'北京城区',
          country:'东城区',
          photo:[
        		{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'},
//	        {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}
			]
        },
        rules: {
          name: [
            { required: true, message: '请输入停车场名称', trigger: 'blur' },
          ],
          address: [
            { required: true, message: '请选择停车场地址', trigger: 'change' }
          ],
          type: [
            { required: true, message: '请选择停车场类型', trigger: 'change' }
          ],
          stationNum: [
            { required: true, message: '请填写停车位数', trigger: 'blur' },
          ],
          IDcard: [
            { required: true, message: '请填写身份证号', trigger: 'blur' },
          ],
          person: [
            { required: true, message: '请填写停车场负责人', trigger: 'blur' },
          ],
          license:[
          	{ type: 'array', required: true, message: '请上传营业执照', trigger: 'change' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
		this.map()
      	console.log(this.ruleForm)
        this.$refs[formName].validate((valid) => {
          if (valid) {
//          验证完成后
          	this.$api.station.add(this.ruleForm).then(response=>{
          		console.log(response)
          		this.$notify({
		          title: '成功',
		          message: '您已成功添加停车场',
		          type: 'success'
		        });
          	})
          } else {
            console.log('error submit!!');
            return false;
          }
        });
        this.$emit('HandSub')
      },
//    选取地区
      onChangeProvince(data) {
      	  this.ruleForm.provice = data.value
    		},
	  onChangeCity(data) {
	      this.ruleForm.city = data.value
	  },
	  onChangeArea(data){
	  	this.ruleForm.country = data.value
	  },
	  //根据所选地区判断经纬度
      map(){
      	let detail_add = this.ruleForm.provice + this.ruleForm.city + this.ruleForm.country + this.ruleForm.address
      	this.getLatAndLng(detail_add)
      },
      getLatAndLng(address){
            const that = this
            AMap.service('AMap.Geocoder',function(){//回调函数
                //实例化Geocoder
                let geocoder = new AMap.Geocoder()
                 //地理编码
                geocoder.getLocation(address, function(status, result) {
                    if (status === 'complete' && result.info === 'OK') {
                        //TODO:获得了有效经纬度，可以做一些展示工作
                        //比如在获得的经纬度上打上一个Marker
                        console.log(result)
                        that.ruleForm.latitude = result.geocodes[0].location.lat
                        that.ruleFormlongitude = result.geocodes[0].location.lng
                        that.errinfo = 0
                    }else{
                        //获取经纬度失败
                        that.$utils.toast.toast(that,'查询失败')
                        that.errinfo = 1
                        this.$notify({
				          title: '警告',
				          message: '经纬度获取失败',
				          type: 'warning'
				        });
                    }
                });
            })
           
        },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      }
    },
    created(){
    		let uid = localStorage.getItem('uid')
    		this.ruleForm.userId = uid
    		this.parkId=this.$route.query.id
    },
    	components: {
		'c-map':Map,
		'v-distpicker': VDistpicker
	},
  }
</script>

<style scoped>
.boss{
	display: flex;
	flex-direction: row;
}
.box{
	flex: 1;
	padding: 20px;
}
.iframe{
	width: 500px;
	height: 500px;
}
</style>
