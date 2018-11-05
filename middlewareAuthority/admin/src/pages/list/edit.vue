<template>
		<div class="popoer-updata">
			<el-dialog 
				title="修改" 
				width="50%"
				:visible.sync="updataVisible">
                <el-form >
                    <el-form-item label="应用ID">
                        <div class="input"><el-input 
                        	size="small"
                        	prefix-icon="fa fa-pencil"
                        	placeholder="请输入新的ID"
                        	v-model="form.id"></el-input></div>
					</el-form-item>
					<el-form-item label="应用名称">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的应用名称"
					    	v-model="form.name"></el-input></div>
					</el-form-item>
					<el-form-item label="应用描述">
					    <div class="input"><el-input 
					    	size="small"
					    	type="textarea"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的应用描述"
					    	v-model="form.desc"></el-input></div>
					</el-form-item>
					<el-form-item label="应用地址">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的应用地址"
					    	v-model="form.url"></el-input></div>
					</el-form-item>
					<el-form-item label="回调地址">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的回调地址"
					    	v-model="form.redirectUri"></el-input></div>
					</el-form-item>
					<el-form-item label="应用类型">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的应用类型"
					    	v-model="form.type"></el-input></div>
					</el-form-item>
					<el-form-item label="所属用户">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入所属用户"
					    	v-model="form.user"></el-input></div>
					</el-form-item>
					<el-form-item label="应用key值">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的应用key值"
					    	v-model="form.key"></el-input></div>
					</el-form-item>
					<el-form-item label="secret">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的secret"
					    	v-model="form.secret"></el-input></div>
					</el-form-item>
					<el-form-item label="创建时间">
					    <div class="input"><el-input 
					    	size="small"
					    	prefix-icon="fa fa-pencil"
					    	placeholder="请输入新的创建时间"
					    	v-model="form.createTime"></el-input></div>
					</el-form-item>
                </el-form>	
                <div class="updata-btn">
                	<el-button type="success" @click.stop.prevent="updataCreate" round>提交</el-button>
                </div>
			</el-dialog>			
		</div>
</template>

<script>
</script>

<style>
</style>