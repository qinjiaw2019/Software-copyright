export const month_num = {
	  time_data:['2017年2月', '2017年3月', '2017年4月', '2017年5月', '2017年6月', '2017年7月', '2017年8月','2017年9月', '2017年10月', '2017年11月', '2017年12月', '2018年1月', '2018年2月'],
	  show_data:['月总订单','揽件订单','派送订单'],
	  seri:[{
			    	    name: '月总订单',
			    	    data: [820, 932, 901, 934, 1290, 1330, 1320,1120,980,1023,1345,1234,1349],
			        type: 'line'
			    },
			    {
			    	    name: '揽件订单',
			    	    data: [320, 332, 401, 334, 490, 530, 520,432,111,234,342,290,278],
			        type: 'line'
			    },
			    {
			    	    name: '派送订单',
			    	    data: [500, 600, 400, 600, 800, 800, 800,688,869,789,1003,944,1071],
			        type: 'line'
			    }]
}

export const finish_not = {
	    all_num: 2083,
	    finished_rate:'88.72%',
	    lable:['已完成', '未完成'],
	    data:[
	                {value:1848,name: '已完成'},
	                {value:235, name: '未完成'},
	            ],
}