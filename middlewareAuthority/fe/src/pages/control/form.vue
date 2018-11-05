<template>
	<div class="form-use">
		<div class="form-title">
			<span>应用创建</span>
		</div>
		<el-form 
			ref="form" 
			:model="form" 
			label-width="80px">
			<el-form-item label="应用名称">
			    <el-input 
			    	size="small" 
			    	v-model="form.name"></el-input>
			</el-form-item>	
			<el-form-item label="应用介绍" prop="introduce">
			    <!--<el-input 
			    	type="textarea"
			    	size="medium"
			    	v-model="form.use_introduce"></el-input>-->
			    	<textarea 
			    		class="textarea" 
			    		v-model="form.introduce"/>
			</el-form-item>
			<el-form-item label="应用地址">
			    <el-input 
			    	size="small" 
			    	v-model="form.address"></el-input>
			</el-form-item>	
			<el-form-item label="回调地址">
			    <el-input 
			    	size="small" 
			    	v-model="form.address"></el-input>
			</el-form-item>	
		    <el-form-item label="应用类型" prop="type">
			    <el-radio-group v-model="form.type">
			        <div class="website"><el-radio label="网站类型"></el-radio></div>
			        <div class="desktop"><el-radio label="桌面客户端"></el-radio></div>
			        <div class="shift"><el-radio label="移动客户端"></el-radio></div>
			    </el-radio-group>
           </el-form-item>
           <div class="checked">
           		<el-checkbox v-model="form.checked">我已经阅读和接收&nbsp;&nbsp;
           			<a class="agree" href="#">《mrst开发平台》</a>
           		</el-checkbox>	  	
           </div>
           <div class="create-button">
           		<el-button type="primary" @click="createSubmit">创建应用</el-button>
           		<el-button @click="cancelSubmit">取消</el-button>
           </div>
		</el-form>		
	</div>
</template>

<script>
import {application} from 'service'
export default {
    data() {
        return {
            form: {
                name: '',
		        introduce: '',
		        callbackaddress: '',
		        type: [
		            { 
		            	required: true,
		                message: '请选择活动资源',
		                trigger: 'change' 
		            }
		        ],
		        checked: false,
            }
        }
    },
    methods: {
        createSubmit() {
            application.add(this.form).
			then(response=>{//请求成功 response返回的是数据
				console.log(response)
				//this.$router.push('')
			},err=>{//请求失败
				console.log(err)
			})
        },
        cancelSubmit() {
        	console.log('cancel！')
        }
    }
}
</script>

<style scoped>
.form-use{
	position: relative;
	margin-top: 20px;
	margin-left: 20px;
    width: 550px;
    padding: 20px;
    border: 1px solid rgb(220,220,220);
	background-color: rgb(255,255,255);
}
.form-title{
	line-height: 50px;
	background-color: rgb(250,250,250);
}
.el-input--medium{
	height: 100px;
}
textarea{
	width: 464px;
	border-radius: 3px;
	text-indent: 10px;
	border-color: rgb(210,220,229);
	height: 150px;
}
.website{
	position: relative;
	margin-left: -394px;
	line-height: 30px;
}
.desktop{
	position: relative;
	margin-left: -380px;
	line-height: 30px;
}
.shift{
	position: relative;
	margin-left: -380px;
	line-height: 30px;
}
.checked{
	position: relative;
	margin-top: 100px;
	margin-left: -135px;
}
.create-button{
	position: relative;
	margin-top: 20px;
	margin-left: -212px;
	cursor: pointer;	
}
</style>

