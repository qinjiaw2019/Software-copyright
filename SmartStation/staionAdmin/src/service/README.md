接口使用
this.$api.[模块名].[方法名].then([成功回调])
具体请查看具体的代码

例如：用户登陆

规则
模块名为service下各个文件的名称，方法名查看对应文件

this.$api.user.login("root","root").then(response=>{
        console.log(response)
})

//用户注册
    let form = {
        account:'13541741901',
        tel:'13541741901',
        face:'',
        idCard:'422802199512027419',
        pwd:'qjw'
    }
    this.$api.user.register(form).then(response=>{
        console.log(response)
    })