####添加弹出框
````
控制弹出框显藏，默认为false
updataVisible:{
			type:Boolean,
			default:false,
	},
````
####使用实例
````
<v-add :updataVisible="Visible"></v-add>
<script>
import {Add} from 'pages/tpl'
components:{
		'v-add': Add,
	},
data() {
      return {
      		Visible:true,
      	}
</script>