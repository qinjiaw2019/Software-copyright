<template>
    <div class="info">
    	基本信息
    	<table>
    		<tr>
    			<td class="td-1">账号:</td>
    			<td class="td-2">
    				<input type="text"
    					   class="input disabled"
    					   disabled="disabled"
    					   style="width:200px"
    					   value="1354174190qjw@sina.com">
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">昵称:</td>
    			<td class="td-2">
    				<input type="text"
    					   class="input"
    					   style="width:200px"
    					   value="1354174190qjw@sina.com">
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">邮箱:</td>
    			<td class="td-2">
    				<input type="text"
    					   class="input"
    					   style="width:200px"
    					   value="123213">
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">注册时间:</td>
    			<td class="td-2">
    				2017-11-09
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">账号状态:</td>
    			<td class="td-2">
    				正常
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">修改密码:</td>
    			<td class="td-2">
    				<input type="password"
    					   class="input"
    					   style="width:200px"
    					   value="123213">
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1">重复修改密码:</td>
    			<td class="td-2">
    				<input type="password"
    					   class="input"
    					   style="width:200px"
    					   value="123213">
    			</td>
    		</tr>

    		<tr>
    			<td class="td-1"></td>
    			<td class="td-2">
    				<el-button size="medium ">确定修改</el-button>
    				<el-button size="medium" type="danger" plain>取消</el-button>
    			</td>
    		</tr>

    	</table>
    </div>
</template>

<script>
export default{

}
</script>

<style lang="scss" scoped>
.info{
	padding-left: 20px;
	padding-top: 20px;
	margin-bottom: 20px;
	table{
		tr{
			height:40px;
		}
	}
}
.td-1{
	width:150px;
	text-align:right;
	padding-right:15px;
}
.td-2{
	width:300px;
}
.input{
    border-radius: 0px;
    padding: 6px;
    -webkit-transition: none;
    transition: none;
    font-size: 12px;
	border-radius: 3px;
    line-height: 1.428571429;
    color: #555555;
    vertical-align: middle;
    background-color: #ffffff;
    background-image: none;
    border: 1px solid #cccccc;
}
.disabled{
	cursor: not-allowed;
    background-color: #eeeeee;
}
</style>
