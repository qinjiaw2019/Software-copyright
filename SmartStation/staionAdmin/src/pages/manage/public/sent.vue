<template>
	<div>
		<el-collapse v-model="activeNames" @change="handleChange">
		  <el-collapse-item v-for="(item,index) in Publi" :name="index">
		  	<template slot="title">
		      {{item.title}}
		      <span style="float: right;margin-right: 20px;color: gray;">{{item.time}}</span>
		    </template>
		    <div>{{item.content}}</div>
		  </el-collapse-item>
		</el-collapse>
	</div>
</template>

<script>
import {Public} from './sent.js'
export default {
	data(){
		return{
			Publi:[],
		}
	},
	created(){
		this.Publi = Public
	}
}
</script>

<style scoped>

</style>
