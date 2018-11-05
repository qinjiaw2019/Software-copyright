<template>
	<div class="box">
		<el-row>
		  <el-col :span="22">
		  	<div class="name">
		  		<!--<span>{{info}}</span>-->
		  		<span>{{info.account}}</span>
		  	</div>
		  </el-col>
		  <el-col :span="2">
		  	<div class="face">
				<el-dropdown>
			      	<face :src="src"></face>
			        <el-dropdown-menu slot="dropdown">
			          <el-dropdown-item>账号名称</el-dropdown-item>
			          <el-dropdown-item>安全设置</el-dropdown-item>
			          <el-dropdown-item @click.native="logout">退出账号</el-dropdown-item>
			        </el-dropdown-menu>
			    </el-dropdown>
		  	</div>
		  </el-col>
		</el-row>
	</div>
</template>

<script>
import Face from '@/components/face'
export default {
	props:{
		src:{
			type:String,
			default:'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1573319585,2854301896&fm=27&gp=0.jpg'
		},
	},
	data(){
		return{
			info:'',
		}
	},
	components: {
		'face': Face,
	},
	methods:{
		getinfo(){
			let uid = localStorage.getItem('uid')
			let utype = localStorage.getItem('usertype')
			this.$api.user.info(uid,utype).then(response=>{
				this.info = response.data
	        })
		},
		logout(){
			this.$api.user.logout()
			this.$router.push('/')
		}
	},
	created(){
		this.getinfo()
	}
}
</script>

<style lang="scss" scoped>
.icon{
	font-size: 2em;
	color: rgba(65, 158, 251, 1.0);
}
.margin{
	margin: 0 20px 0 20px;
}
.box{
	background: rgba(220, 225, 228, 1.0);
}
.face{
	margin-top: 15px;
	margin-left: 20px;
}
.name{
	float: right;
	line-height: 100px;
	color: gray;
}
</style>
