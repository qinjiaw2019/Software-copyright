<template>
	<div class="home">
		<div class="home-search"></div>
		<div class="home-list">
			<ul class="type-list"
				v-for="(item,index) in typelist">
				<li>
					<h3 v-if="item.project!=''"><span></span>{{item.name}}</h3>
					<ul class="list-text"
					    v-for="(it,index) in item.project" >
						<li @click="routerGo('/api/list',item.id,it.id)"><a :href="it.router">
							<img class="img-icon" 
							     :src="(it.img==undefined || it.img=='')? '/static/img/computer.png':it.img"/>
							<div class="home-desc">
								<h2 class="home-it-title">{{it.name}}</h2>
								<p class="home-it-tips">{{it.desc}}</p>
							</div>
						</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import {project} from 'service'
export default{
	data(){
		return{
			typelist:[],
			params:{page:1,limit:50,page_sub:1,limit_sub:7},//分页信息
		}
	},
	created(){
		const that = this
		project.get(this.params).then(response=>{
			that.typelist = response
		},err=>{
			that.$message.error('获取数据失败');
		})
	},
	methods:{
		routerGo(router,typeId,id){
        	if(router!=undefined)
        		this.$router.push({path:router,query:{typeId:typeId,project_id:id}})
        }
	},
}
</script>

<style scoped>
.home{

}
/*预留的页面搜索区*/
.home-search{
	position: absolute;
	top: 50px;
	background-color: rgb(35, 41, 64);
	height: 300px;
	width: 100%;
	left: 0;
	right: 0;
}
/*内容部分*/
.home-list{
	position: absolute;
	left: 0;
	right: 0;
	top: 350px;
	padding: 50px;
	box-sizing: border-box;
    -webkit-box-sizing: border-box;
	background-color: rgb(246, 246, 247);
}
.type-list{
	zoom: 1;
	text-align: left;
}
.list-text{
	display: inline-block;
}
.type-list h3{
	line-height: 30px;
	font-size: 16px;
}
.type-list h3 span{
	border: 5px solid blue;
	border-top-width: 0;
	border-right-width: 0;
	border-bottom-width: 0;
	border-radius: 4px;	
}
.list-text li{
	width: 309px;
	height: 118px;
	float: left;
	line-height: 118px;
	margin-right: -1px;
    margin-top: -4px;
	cursor: pointer;
	display: list-item;
    text-align: -webkit-match-parent;
	background-color: white;
	border: 1px solid rgb(223, 223, 223);
	position: relative;
}
.list-text li:hover{
	border:1px solid #108ee9;
    box-shadow:0px 10px 20px 0px rgba(126,166,194,0.30);
    z-index:1000;
}
.img-icon{
	width: 50px;
    height: 50px;
    margin-top: 20px;
    float:left;
    margin-left:26px;
}
.home-desc{
	float:left;
    width: 161px;
    text-align: left;	
}
.home-it-title{
	color: #1a1a1a;
    font-size: 18px;
    line-height:1.4;
    margin-top: 20px;
}
.home-it-tips{
	color: #808080;
    font-size: 12px;
    line-height:1.5;	
}
</style>