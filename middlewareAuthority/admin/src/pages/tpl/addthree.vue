<template>
    <div id="add">
        <div class="add-header">
            添加标题
        </div>
        <div class="add-form">
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="输入框">
                <el-input v-model="form.name" style="width: 400px;"></el-input>
              </el-form-item>
              <el-form-item label="相应选择">
                <el-select v-model="form.region" placeholder="请选择" style="width: 400px;">
                  <el-option label="选择一" value="shanghai"></el-option>
                  <el-option label="选择二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
               <el-form-item label="复选框" style="padding-right: 20px;">
                <el-checkbox-group v-model="form.typeone">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                  <el-checkbox label="复选框5" name="type"></el-checkbox>
                  <el-checkbox label="复选框6" name="type"></el-checkbox>
                  <el-checkbox label="复选框7" name="type"></el-checkbox>
                  <el-checkbox label="复选框8" name="type"></el-checkbox>
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                  <el-checkbox label="复选框5" name="type"></el-checkbox>
                  <el-checkbox label="复选框6" name="type"></el-checkbox>
                  <el-checkbox label="复选框7" name="type"></el-checkbox>
                  <el-checkbox label="复选框8" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item> <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typetwo">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item> <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typethree">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
              <el-form-item label="复选框">
                <el-checkbox-group v-model="form.typefore">
                  <el-checkbox label="复选框1" name="type"></el-checkbox>
                  <el-checkbox label="复选框2" name="type"></el-checkbox>
                  <el-checkbox label="复选框3" name="type"></el-checkbox>
                  <el-checkbox label="复选框4" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-form>
        </div>
        <div class="add-but">
            <el-button size="small">取消</el-button>
            <el-button type="primary" size="small" @click="onSubmit">立即创建</el-button>  
        </div>
    </div>
</template>
<script>
import {tplAdd} from 'service'
export default {
data() {
      return {
        form: {
          name: '',
          region: '',
          typeone: [],
          typetwo: [],
          typethree: [],
          typefour: [],
        }
      }
    },
    methods: {
      onSubmit() {
      	   console.log(this.form)
      		tplAdd.addthree(this.form).
            then(response=>{//请求成功 response返回的是数据
                console.log(response)
            },err=>{//请求失败
                console.log(err)
            })
      }
    }
}
</script>
<style lang="scss" scoped>
#add{
    margin: 20px;
    border-radius: 3px;
    border: 1px solid rgba(200,200,200,1);
    width: 720px;
    /*height: 550px;*/
    text-align: left;
    .add-header{
        padding-left: 20px;
        line-height: 40px;
        height: 40px;
        background: #e6e9ee;
        color: black;
    }
    .add-form{
        padding-top: 25px;
        padding-left: 20px;
    }
    .textarea{
        height: 80px;
        width: 400px;
        border: 1px solid rgba(200,200,200,1);
        border-radius: 5px;
    }
}
.add-but{
    padding-right: 10px;
    text-align: right;
    padding-left: 20px;
    line-height: 50px;
    height: 50px;
    background: #e6e9ee;
    color: black;
}
</style>