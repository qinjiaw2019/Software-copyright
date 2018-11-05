<template>
    <div>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
         
         	<el-submenu :index="index+''"
          	v-for="(item,index) in list"
          	:key="index"
          	@click="routerGo(item.router)">
            <template slot="title" >
              <i :class="item.icon"></i>
              <span @click="routerGo(item.router,'/list')">{{item.name}}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item 
              	:index="index + '-' + j" 
              	v-for="(i,j) in item.methods" 
              	:key="j"
              	@click="routerGo(item.router,i.router)">{{i.name}}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
         
          
    </el-menu>
    <div class="add">
    		<i class="el-icon-plus"></i>
    </div>
    </div>
</template>

<script>
import {role} from 'service'
export default {
    created(){
        const that = this // 如果要访问data中的变量则需要这句话
        //TODO 这里要使用getRoles函数
        let username = localStorage.getItem('username')
        role.getUserRoles(username).
        then(response=>{//请求成功 response返回的是数据
            that.list = response //把response数据赋值给变量userForm  这里不能用this  
        },err=>{//请求失败
            that.$message.error('获取数据失败');
        })
    },
    data(){
        return{
            list:[],
        }
    },
    methods: {
    	 routerGo(pr,cr){
    	 	if(cr==undefined){
    	 		
    	 		this.$router.push(pr)
    	 	}
    	 	else
    	 	{
    	 		if(pr!=undefined)
    	 			this.$router.push('/index'+pr+cr)
    	 	}
    	 },
    }
  }
</script>

<style lang="scss" scoped>
.add{
	line-height: 30px;
	height: 30px;
	i{
		color: white;
	}
	i:hover{
		cursor: pointer;
	}
}
</style>
