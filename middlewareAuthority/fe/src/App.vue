<template>
  <div id="app">
   <!----> <mw-header/>
    <div class="main">
      <router-view/>
    </div>
  </div>
</template>

<script>
import {Header} from 'components'
export default {
  name: 'app',
  components:{
    'mw-header': Header,
  }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#main{
  position: absolute;
  top:61px;
  bottom: 0;
  left: 0;
  right: 0;
  overflow: auto;

}
body{
  background-color: #F7F7F7;
}
</style>
