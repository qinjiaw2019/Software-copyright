<template>
	<div class="addbox">
		<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="130px" class="demo-ruleForm">
			<div class="boss">
				<div class="box">
					  <el-form-item label="公告名称" prop="name">
					    <el-input v-model="ruleForm.name" style="width: 90%;"></el-input>
					  </el-form-item>
					  <el-form-item label="附件上传" prop="license">
						    <el-upload
							  class="upload-demo"
							  drag
							  action="https://jsonplaceholder.typicode.com/posts/"
							  :on-preview="handlePreview"
							  :on-remove="handleRemove"
							  :file-list="ruleForm.license"
							  list-type="picture"
							  style="width: 90%;"
							  multiple>
							  <i class="el-icon-upload"></i>
							  <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
							</el-upload>
					</el-form-item>
				</div>
				<div class="box">
					     <el-form-item label="发布人" prop="person">
						    <el-input v-model="ruleForm.person"></el-input>
						  </el-form-item>
						  <el-form-item label="所见区域" prop="region">
					    <el-select v-model="ruleForm.region" placeholder="请选择活动区域" style="width: 90%;">
					      <el-option label="区域一" value="shanghai"></el-option>
					      <el-option label="区域二" value="beijing"></el-option>
					    </el-select>
					  </el-form-item>
					  <el-form-item label="公告类型" prop="region">
					    <el-select v-model="ruleForm.region" placeholder="请选择活动区域" style="width: 90%;">
					      <el-option label="区域一" value="shanghai"></el-option>
					      <el-option label="区域二" value="beijing"></el-option>
					    </el-select>
					  </el-form-item>
						  <el-form-item label="公告内容" prop="desc">
						  	<el-button type="primary" @click="dialogTableVisible = true" plain>添加内容</el-button>
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
		<!--编辑公告-->
		<el-dialog title="编辑公告内容" style="margin-left: 12%;" width="80%" :visible.sync="dialogTableVisible">
		  <quill-editor 
		      v-model="content" 
		      ref="myQuillEditor" 
		      :options="editorOption" 
		      @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
		      @change="onEditorChange($event)">
		    </quill-editor>
		</el-dialog>
	</div>
</template>

<script>
import { quillEditor } from 'vue-quill-editor'
export default {
data() {
      return {
      	content:null,
      	dialogTableVisible: false,
        dialogFormVisible: false,
        editorOption:{},
        ruleForm: {
          name: '',
          region: '',
          type:'',
          desc: '',
          seat:'',
          IDcard:'',
          person:'',
          license:[
        		{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'},
//	        {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}
			]
        },
        rules: {
          name: [
            { required: true, message: '请输入停车场名称', trigger: 'blur' },
          ],
          region: [
            { required: true, message: '请选择停车场地址', trigger: 'change' }
          ],
          type: [
            { required: true, message: '请选择停车场类型', trigger: 'change' }
          ],
          seat: [
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
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      onEditorBlur(){//失去焦点事件
	    },
	    onEditorFocus(){//获得焦点事件
	    },
	    onEditorChange(){//内容改变事件
	    }
    }
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
</style>
