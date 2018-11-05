<template>
	<div>
		<div class="popoer-updata">
			<el-dialog 
				width="45%"
				:visible.sync="updataVisible"
				title="添加" 
				>
		        <div class="add-form">
		            <el-form ref="form" :model="form" label-width="80px">
		                <el-form-item label="描述一">
		                <textarea class="textarea" v-model="form.desc"></textarea>
		              </el-form-item>
		              <el-form-item label="备注">
		                <el-input v-model="form.name" style="width: 80%;"></el-input>
		              </el-form-item>
		              <el-form-item label="相应选择">
		                <el-select v-model="form.region" placeholder="请选择">
		                  <el-option label="选择一" value="shanghai"></el-option>
		                  <el-option label="选择二" value="beijing"></el-option>
		                </el-select>
		              </el-form-item>
		              <el-form-item label="级联选择">
		                <el-cascader
		                    placeholder="三级级联"
		                    :options="form.list"
		                    filterable
		                    change-on-select
		                  ></el-cascader>
		              </el-form-item>
		              <el-form-item label="复选框">
		                <el-checkbox-group v-model="form.type">
		                  <el-checkbox label="复选框1" name="type"></el-checkbox>
		                  <el-checkbox label="复选框2" name="type"></el-checkbox>
		                  <el-checkbox label="复选框3" name="type"></el-checkbox>
		                  <el-checkbox label="复选框4" name="type"></el-checkbox>
		                </el-checkbox-group>
		              </el-form-item>
		              <el-form-item label="单选框">
		                <el-radio-group v-model="form.resource">
		                  <el-radio label="单选框1"></el-radio>
		                  <el-radio label="单选框2"></el-radio>
		                </el-radio-group>
		              </el-form-item>
		            </el-form>
		        </div>
		        <div class="add-but">
		            <el-button size="small">取消</el-button>
		            <el-button type="primary" size="small" @click="onSubmit">立即创建</el-button>  
		        </div>
		    </el-dialog>		
	    </div>
    </div>
</template>
<script>
import {tplAdd} from 'service'
export default {
created(){
        const that = this // 如果要访问data中的变量则需要这句话
        tplAdd.getcascade().
        then(response=>{//请求成功 response返回的是数据
            that.form.list = response //把response数据赋值给变量userForm  这里不能用this  
        },err=>{//请求失败
            console.log(err)
        })
    },
props:{
	updataVisible:{
			type:Boolean,
			default:false,
	},
},
data() {
      return {
//    	updataVisible:false,
Visible:true,
        form: {
          list:[],
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
    methods: {
      onSubmit() {
      	   console.log(this.form)
      		tplAdd.getaddone(this.form).
            then(response=>{//请求成功 response返回的是数据
                console.log(response)
            },err=>{//请求失败
                console.log(err)
            })
      },
    }
}
</script>
<style lang="scss" scoped>
    .add-header{
        padding-left: 20px;
        line-height: 40px;
        height: 40px;
        background: #e6e9ee;
        color: black;
    }
    .add-form{
        padding-left: 20px;
        text-align: left;
    }
    .textarea{
        height: 80px;
        width: 79%;
        border: 1px solid rgba(200,200,200,1);
        border-radius: 5px;
    }

.add-but{
    text-align: right;
    padding-right: 40px;
    line-height: 50px;
    height: 50px;
    color: black;
}
</style>