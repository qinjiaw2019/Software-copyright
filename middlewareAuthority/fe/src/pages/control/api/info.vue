<template>
    <div class="main">
    	<div class="title">
    		<div class="left">
    			<h5>API列表</h5>
    		</div>
    		<div class="right">
    			<span >创建AccessToken</span>
    		</div>
    	</div>
    	<!-- <div class="tip">
    		提示：只有通过审核的应用才能够使用相关项目的API
    	</div> -->

    	<div class="list">
    		<table>
    			<thead>
    				<tr>
    					<th style="width:200px">名称</th>
    					<th style="width:50px">请求方式</th>
    					<th style="width:80px">次/小时</th>
    					<th style="width:80px">次/天</th>
    					<th style="width:700px">接口地址</th>
    					<th style="width:80px">操作</th>
    				</tr>
    			</thead>
    			<tbody v-for="n in 10">
    				<tr>
    					<td>1</td>
    					<td>1</td>
    					<td>1</td>
    					<td>1</td>
    					<td>1</td>
    					<td>显示 | 隐藏</td>
    				</tr>
    			</tbody>
    		</table>
    		 <div>
    		 	<el-pagination
				    layout="prev, pager, next"
				    :total="50">
				  </el-pagination>
    		 </div>
    	</div>
    </div>
</template>

<script>
export default{
	
}   
</script>

<style lang="scss" scoped>
.main{
	position:absolute;
	left:10px;
	top:10px;
	right:10px;
	bottom:10px;
	background:#fff;
	overflow:auto;
	.title{
		// padding: 16px 0px;
    	min-height: 70px;
    	border-bottom: 1px solid #DDD;
    	.left{
    		float: left;
    		padding-left:20px;
    		padding-top:15px;
    		h5{
    			margin-top: 8px;
    			margin-bottom: 8px;
    			display: inline-block;
			    text-indent: 8px;
			    border-left: 2px solid #88B7E0;
    		}
    	}
    	.right{
    		float: right;
    		padding-top:20px;
    		padding-right:10px;
    		span{
    			font-size: 12px;
			    border-radius: 0px;
			    padding: 8px 16px;
			    height: 32px;
			    line-height: 14px;
			    background-color: #428bca;
   				border-color: #357ebd;
   				color:#fff;
   				cursor:pointer;
    		}
    	}
	}

	.tip{
		color: #555;
	    background-color: #F9F9F9;
	    border-color: #DDD;
	    margin-top:10px;
	    margin-left: 10px;
	    margin-right: 10px;
	    border: 1px solid #DDDDDD;
	    padding: 5px;
	    text-align:left;

	}
	.list{
		margin-top:10px;
	    margin-left: 10px;
	    margin-right: 10px;
	    table{
	    	background: #FFF;
		    font-size: 12px;
		    border-top: 1px solid #E1E6EB;
		    margin-top: 8px;
		    border: 1px solid #E1E6EB;
		    width: 100%;
   			margin-bottom: 20px;
   			thead{
   				    display: table-header-group;
			    vertical-align: middle;
			    border-color: inherit;
			    tr{
			    	th{
			    		padding: 8px 8px;
					    font-weight: normal;
					    color: #999;
					    border-bottom: 1px solid #E1E6EB;
					    background-color: #F5F6FA;
			    	}
			    }
   			}
   			tbody{
   				td{
   					padding: 12px 8px;
				    border-top: 0px;
				    border-bottom: 1px solid #E1E6EB;
				    vertical-align: middle;
   				}
   				tr:hover{
   					background:#F9F9FA;
   				}
   			}
	    }
	}
}    
</style>