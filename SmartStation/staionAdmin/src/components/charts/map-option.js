export default {
  title : {
      x:'center'
  },
  tooltip : {
      trigger: 'item'
  },
  legend: {
      orient: 'vertical',
      x:'left',
      data:['已注册停车场数'],
      left:20,
      top:20
  },
  dataRange: {
      min: 0,
      max: 1000,
      x: 'left',
      y: 'bottom',
      text:['高','低'],           
      calculable : true
  },
  roamController: {
      show: true,
      x: 'right',
      mapTypeControl: {
          'china': true
      }
  },
  series : [
      {
          name: '已注册停车场数',
          type: 'map',
          mapType: 'china',
          roam: false,
          itemStyle:{
              normal:{label:{show:true}},
              emphasis:{label:{show:true}}
          },
          data:[
              {name: '北京',value: 220},
              {name: '天津',value: 182},
              {name: '上海',value: 191},
              {name: '重庆',value: 234},
              {name: '河北',value: 290},
              {name: '河南',value: 330},
              {name: '云南',value: 310},
              {name: '辽宁',value: 123},
              {name: '黑龙江',value: 442},
              {name: '湖南',value: 321},
              {name: '安徽',value: 90},
              {name: '山东',value: 149},
              {name: '江苏',value: 210},
              {name: '浙江',value: 122},
              {name: '江西',value: 133},
              {name: '湖北',value: 334},
              {name: '广西',value: 198},
              {name: '甘肃',value: 123},
              {name: '山西',value: 125},
              {name: '新疆',value: 220},
              {name: '内蒙古',value:133},
              {name: '陕西',value: 334},
              {name: '吉林',value: 198},
              {name: '福建',value: 123},
              {name: '贵州',value: 125},
              {name: '广东',value: 220},
              {name: '青海',value: 133},
              {name: '西藏',value: 334},
              {name: '四川',value: 198},
              {name: '宁夏',value: 123},
              {name: '海南',value: 125},
              {name: '台湾',value: 220},
              {name: '香港',value: 133},
              {name: '澳门',value: 334}
          ]
      }
  ]
};