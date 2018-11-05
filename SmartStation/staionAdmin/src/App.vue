<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  created(){
    let parm = {
        carNumber:'冀Jqjw123',
        carNumberType:'奥迪',
        userId:2,
        carType:'',
        photo:'',
        carXH:'',
        carYear:2015,
        carColor:'',
        code:'',
    }
    this.$api.carinfo.bind(parm).then(response=>{
      console.log(response)
    })
  },
}
</script>

<style>
@import '../static/font/iconfont.css';
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
</style>
