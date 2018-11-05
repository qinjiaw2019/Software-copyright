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
			<el-form-item label="应用描述" >
			    <!--<el-input 
			    	type="textarea"
			    	size="medium"
			    	v-model="form.use_introduce"></el-input>-->
			    	<textarea 
			    		class="textarea" 
			    		v-model="form.desc"/>
			</el-form-item>
			<el-form-item label="应用地址">
			    <el-input 
			    	size="small" 
			    	v-model="form.url"></el-input>
			</el-form-item>	
			<el-form-item label="回调地址">
			    <el-input 
			    	size="small" 
			    	v-model="form.redirectUri"></el-input>
			</el-form-item>	
		    <el-form-item label="应用类型" prop="type">
			    <el-radio-group v-model="form.typeId">
			    
			        <div class="desktop" v-for="(item,index) in typeList" :key="index">
			        	<el-radio :label="item.id">{{item.name}}</el-radio>
			        </div>

			    </el-radio-group>
           </el-form-item>
           
           <div class="create-button">

           		<el-button type="primary" @click="createSubmit">创建应用</el-button>
           		<el-button @click="routerGo('/control/list')">取消</el-button>
           </div>
		</el-form>
	</div>
</template>

<script>
import {application,user} from 'service'
export default {
    data() {
        return {
            form: {
                name: '',//应用名称
		        desc: '',//应用描述
		        url: '',//应用地址
		        redirectUri:'',//回调地址
		        typeId:1,//应用类型
		        userId:'',
            },
            typeList:[],//应用类型
        }
    },
    created(){
    	//获取应用类型
    	const that = this
    	application.getTypes().
			then(response=>{//请求成功 response返回的是数据
				that.typeList = response
			},err=>{//请求失败
				// console.log(err)
		})
		if(this.typeList.length>0)
			this.form.typeId = this.typeList[0].id

		//获取用户的ID
		this.form.userId = user.getUserId()
    },
    methods: {
        createSubmit() {
        	if(this.form.name==''|| this.form.url=='' ||this.form.redirectUri==''){
        		this.$message({
				    message: '添加失败，表单数据不完整',
				    type: 'err'
				})
				return
        	}
        	const that = this
            application.add(this.form).
			then(response=>{//请求成功 response返回的是数据
				that.$message({
				    message: '添加成功',
				    type: 'err'
				})
				that.form = []
				that.form.typeId= this.typeList[0].id
			},err=>{//请求失败
				that.$message({
				    message: '添加失败',
				    type: 'err'
				})
			})
        },

        routerGo(router){
        	if(router!=undefined)
        		this.$router.push(router)
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
	margin-left: -384px;
	line-height: 30px;
}
.desktop{
	position: relative;
	margin-left: -394px;
	line-height: 30px;
}
.shift{
	position: relative;
	margin-left: -394px;
	line-height: 30px;
}

.create-button{
	position: relative;
	margin-top: 20px;
	margin-left: -212px;
	cursor: pointer;	
}
</style>

