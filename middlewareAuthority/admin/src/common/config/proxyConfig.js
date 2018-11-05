module.exports = {
 proxy: {
    '/http://47.94.167.18:8089': {  //将www.exaple.com印射为/apis
      target: 'http://localhost:8000', // 接口域名
      changeOrigin: true, //是否跨域
      pathRewrite: {
        '^/http://47.94.167.18:8089': ''  //需要rewrite的,
      }       
    }
 }
}