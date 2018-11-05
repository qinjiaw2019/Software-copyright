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
import {Addseven} from 'pages/tpl'
components:{
		'v-add': Addseven,
	},
data() {
      return {
      		Visible:true,
      	}
</script>