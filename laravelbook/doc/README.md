# 项目结构说明

> laravelbook：后台源代码 采用PHP+Laravel5.2框架

> wchart_tp ：微信后台源代码 采用PHP+ThinkPHP3.2

> wchart :微信前台编译代码

> life-app-vue:微信前台源代码

> front : PC前台编译代码

> front :PC 前台源代码

> admin : 后台管理系统编译代码

> vue-admin-master ：后台管理系统源代码

# 框架技术
> 后台：PHP+Mysql+Laravel+ThinkPHP

> 前台：vue+vue-router+fetch

# 数据文件：larbook.sql

# 前台代码编译
``` bash
本地调试启动：

第零步：代码clone到本地： git clone https://github.com/shaqihe/life-app-vue.git

# install dependencies
第一步：npm install（
           或者用淘宝的cnpm代理安装会更快，方法是：
             1.安装cnpm：npm install -g cnpm --registry=https://registry.npm.taobao.org 
             2.用cnpm代理npm安装： cnpm install
       ）

# serve with hot reload at localhost:8088
第二步：npm run dev


打包：
# build for production with minification
npm run build
```

 1. 在vue-cli2.0 脚手架基础上开发的
 2. 方便管理，抽取了一下common文件，和cache文件
 3. 也是为了熟悉下vue的流程，功能上不太复杂
 4. 样式用了sass，在移动适配用了‘rem方案’
 5. 本地启动 上面两个步骤应该就能起来

