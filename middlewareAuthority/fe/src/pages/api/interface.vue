<template>
    <div class="main">
    	<div class="left">
    		<ul>
    			<li v-for="item in list" @click="getApiInfo(item.id)">
    				{{item.name}}
    			</li>
    		</ul>
    	</div>
    	<div class="right">
    		<p>接口地址:{{apiInfo.address}}</p>
    		<p>请求方法:{{methodfilter(apiInfo.method)}}</p>
    		<p>请求参数:</p>
    		<p>
    			<table>
					<thead>
						<tr>
						<th class="td-1">参数名</th>
						<th class="td-2">类型</th>
						<th class="td-3">必填</th>
						<th class="td-4">参数位置</th>
						<th class="td-5">描述</th>
						<th class="td-1">默认值</th>
						</tr>
					</thead>
					<tbody data-api-param="3653">
						<tr v-for="item in apiInfo.params " :key="item.id">
							<td class="td-1" data-param-name=""><div class="text-overflow-fix" style="width:145px;" title="apikey">{{item.name}}</div></td>
							<td class="td-2">{{item.type}}</td>
							<td class="td-3">{{item.required==0?'否':'是'}}</td>
							<td class="td-4">{{item.pos}}</td>
							<td class="td-5 pr">
								<div style="width:200px;" v-html="item.desc"></div>
							</td>
							<td class="td-1 api-param-ellipsis">
								<div style="width:100px;" 
									 :title="item.defaultValue" v-html="subStr(item.defaultValue,30)">
									 </div>
							</td>
						</tr>
						<tr>
							<td class="td-1" style="border-right-color:#fff"></td>
							<td class="td-2" style="border-right-color:#fff"></td>
							<td class="td-3" style="border-right-color:#fff"></td>
							<td class="td-4" style="border-right-color:#fff;font-size:14px">无请求参数</td>
							<td class="td-5" style="border-right-color:#fff"></td>
							<td class="td-1" ></td>
						</tr>
					</tbody>
				</table>
    		</p>
    		<p>请求示例：</p>
    		<p>
    			请求示例：
    		</p>

			<br>

    		<p>成功返回：</p>
    		<p v-html="apiInfo.responseSuccess"></p>

    		<br>
    		<p>错误返回：</p>
    		<p v-html="apiInfo.responseError"></p>

    		<br>
    		<p>备注:</p>
    		<p>{{apiInfo.note}}</p>
    		<div style="clear:both"></div>
    	</div>
    	<p style="clear:both"></p>
    </div>
</template>

<script>
import {api} from 'service'
export default{
	data(){
		return{
			params:{page:1,limit:1000,project_id:-1},
			list:[],
			apiInfo:{},
		}
	},
	created(){
		this.params.project_id = this.$route.query.project_id//获得项目ID
		//获取列表数据
		this.getApiList()		
	},
	methods:{
		//获得api接口列表
		getApiList(){
			const that = this
			api.getApiByProjectId(this.params).
			then(response=>{
				that.list = response
				that.getApiInfo(response[0].id)
			},err=>{
				that.$message.error('获取数据失败')
			})
		},
		getApiInfo(id){
			const that = this
			api.getApiById(id).
			then(response=>{
				that.apiInfo = response
			},err=>{
				that.$message.error('获取数据失败');
			})
		},
		//自定义过滤器截取字符串
		subStr(str,length){
			return str.substring(0,length)
		},
		methodfilter(flag){
			let str = ''
			switch(flag){
				case 0:
					str = 'GET|POST'
					break
				case 1:
					str = 'GET'
					break
				case 2:
					str = 'POST'
					break
			}
			return str
		}
	}
}   
</script>

<style lang="scss" scoped>
.main{
	height:100%;
}
.left{
	width:155px;
	padding: 10px 0 10px 10px;
	border-right: 1px solid #ECECEC;
	height:100%;
	float: left;
	ul{
		li{
			cursor:pointer;
		}
	}
}    
.right{
	float: left;
	width:1100px;
	margin-left:20px;
	padding-top:10px;
	table{
		text-align: left;
    	width: 100%;
    	border-collapse: collapse;
    	border-spacing: 0;
    	border-color: grey;
    	display: table;
    	thead{
    		display: table-header-group;
		    vertical-align: middle;
		    border-color: inherit;
		    tr{
		    	display: table-row;
			    vertical-align: inherit;
			    border-color: inherit;
		    }
		     .td-1 {
			    width: 20%;
			    word-break: break-all;
			    word-wrap: break-word;
			}
		    th{
		    	font-weight: 400;
			    padding: 12px 0;
			    background: #e9e9e9;
			    border: 1px solid #cecece;
			    padding-left: 10px;
		    }
    	}
    	tbody {
		    display: table-row-group;
		    vertical-align: middle;
		    border-color: inherit;
		    tr {
			    display: table-row;
			    vertical-align: inherit;
			    border-color: inherit;
			}
			.td-1 {
			    width: 20%;
			    word-break: break-all;
			    word-wrap: break-word;
			}
			td {
			    padding: 12px 0;
			    background: #fff;
			    border: 1px solid #cecece;
			    padding-left: 10px;
			}
		}
	}
}
</style>