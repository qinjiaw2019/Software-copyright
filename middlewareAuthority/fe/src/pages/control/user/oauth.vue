<template>
    <div class="main">
    	<div class="title">
    		<div class="left">
    			<h5>应用授权管理</h5>
    		</div>
    		<div class="right">
    			<span >创建AccessToken</span>
    		</div>
    	</div>
    	<div class="tip">
    		提示：只有通过审核的应用才能够使用相关项目的API
    	</div>

    	<div class="list">
    		<table>
    			<thead>
    				<tr>
    					<th>应用名称</th>
    					<th>应用地址</th>
    					<th>回调地址</th>
    					<th>审核状态</th>
    				</tr>
    			</thead>
    			<tbody>
    				<tr>
    					<td>图书借阅伴侣</td>
    					<td>47.94.167.18</td>
    					<td>47.94.167.18/index.html</td>
    					<td>通过</td>
    				</tr>
    			</tbody>
    		</table>
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
