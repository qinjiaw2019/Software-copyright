<template>          
    <div>
        <div id="mapContainer" style="width:600px; height:600px"></div>
    </div>
</template>
        
<script>
	let echarts = require('echarts')
    import option from './map-option'  //引入配置项
    
    export default {
        name: '',
        data () {
          return {  
          }
        },
        methods: {
          drawChinaMap() {
            var myChart = this.$echarts.init(document.getElementById('mapContainer'));
            myChart.setOption(option);
          }
        },
        mounted() {
          this.drawChinaMap();
        }
    }
</script>
        
<style scoped>
       
</style>