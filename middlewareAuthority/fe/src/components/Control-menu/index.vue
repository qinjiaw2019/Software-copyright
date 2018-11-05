<template>
	<div class="control-left">
		<el-menu
			default-active="1-4-1"
			mode="vertical"
			class="el-menu-vertical-demo"
			background-color="rgb(51,55,68)"
			@open="handleOpen"
			@close="handleClose"
			@select="handleSelect"
			text-color="#fff"
			:collapse="isCollapse">
			<el-radio-group v-model="isCollapse">
				<el-radio-button :label="sou">
					<i class="fa fa-bars btn-icon"
						@click="labelSou"></i>
				</el-radio-button>
			</el-radio-group>

			<span v-for="(item,index) in leftList">
			    <el-submenu :index="index+''" v-if="item.children!=null">
				    <template slot="title">
				        <i :class="item.icon"></i>&nbsp;
				        <span slot="title">{{item.name}}</span>
				    </template>
				    <el-menu-item-group >
				        <el-menu-item :index="index+'-'+j" v-for="(i,j) in item.children" :key= "index">
				        	<i :class="i.icon"></i>&nbsp;
				        	{{i.name}}</el-menu-item>
				    </el-menu-item-group>
			    </el-submenu>

			    <el-menu-item :index="index+''" v-if="item.children==null">
			        <i :class="item.icon"></i>&nbsp;
			        <span slot="title">{{item.name}}</span>
			    </el-menu-item>
			</span>

		</el-menu>
	</div>
</template>

<script>
import Bus from 'common/utils/eventBus.js'
export default{
	data() {
		return {
			isCollapse: false,
			sou: true,
			leftList:[
				{
					id:0,
					name:'用户中心',
					icon:'fa fa-user',
					router:'/control/user',
					children:[
            {
							id:1,
							name:'基本信息',
							icon:'fa fa-list-alt',
							router:'/control/list',
						}
          ]
				},
				{
					id:1,
					name:'应用管理',
					icon:'fa fa-futbol-o',
					router:'/control/list',
					children:[
						{
							id:1,
							name:'应用列表',
							icon:'fa fa-list-alt',
							router:'/control/list',
						},
						{
							id:2,
							name:'创建应用',
							icon:'fa fa-list-ol',
							router:'/control/add',
						},
						{
							id:2,
							name:'授权管理',
							icon:'fa fa-list-ol',
							router:'/control/oauth',
						},
					]
				},
				{
					id:2,
					name:'API管理 ',
					icon:'fa fa-th-large',
					router:'/control/api',
					children:[]
				},
				{
					id:3,
					name:'数据统计',
					icon:'fa fa-expeditedssl',
					router:'/control',
					children:[
						{
							id:2,
							name:'API使用统计',
							icon:'fa fa-list-ol',
							router:'/control/oauth',
						}
					]
				},
				{
					id:3,
					name:'消息中心',
					icon:'fa fa-expeditedssl',
					router:'/control',
					children:[
						{
							id:2,
							name:'我的消息',
							icon:'fa fa-list-ol',
							router:'/control/oauth',
						},
						{
							id:2,
							name:'历史消息',
							icon:'fa fa-list-ol',
							router:'/control/oauth',
						}
					]
				}
			]
		}
	},
	methods: {
		labelSou(event){
			let showSou = this.sou;
			showSou =!this.sou;
			this.sou = showSou;
			Bus.$emit('controlMenu', event.target);
		},
        handleSelect(key, keyPath) {
          let index = key.substring(0,key.indexOf('-'))
          let sub_index = key.substring(key.indexOf('-')+1)
          let router = this.leftList[index].children[sub_index].router
          this.routerGo(router)
        },
        handleOpen(key, keyPath) {
          let router = this.leftList[key].router
          this.routerGo(router)
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
        routerGo(router){
        	if(router!=undefined)
        		this.$router.push(router)
        }
   },
}
</script>

<style scoped>

/*control页面的左边菜单栏*/
.control-left{
	position: absolute;
	top: 60px;
	left: 0;
	bottom: 0;
	background-color: rgb(51,55,68);
}
.el-menu-vertical-demo:not(.el-menu--collapse){
	position: absolute;
	height: 100%;
    width: 200px;
    bottom: 0;
}
.el-radio-button{
	height: 17px;
	width: 17px;
	background-color: rgb(55,55,68)!important;
	margin-top: 2px;
	border-radius: 5px;
	overflow: hidden;
}
.btn-icon{
	position: absolute;
	top: -1px;
	left: -1px;
	height: 17px;
	width: 17px;
	color: white;
	background-color: rgb(55,55,68)!important;
	font-size: 16px;
}
.btn-icon:hover{
	color: deepskyblue;
}
.classSou{
	position: absolute;
	left: 100px;
}
.el-menu-vertical-demo li{
	text-align: left;
}
</style>
