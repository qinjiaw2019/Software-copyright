export const roleMothods = {
	code:0,
	data:[{
		id: 1,
		modelIds: "1,2,3",
		modules: [
		{
			id: 1,
			name: "权限管理",
			desc: "",
			router: "/author",
			methods: [ ]
		},
		{
			id: 3,
			name: "角色管理",
			desc: "",
			router: "/role",
			methods: [
			{
				id: 1,
				name: "添加角色",
				desc: "",
				router: "/add",
				moduleId: null
			},
			{
				id: 2,
				name: "修改角色",
				desc: "",
				router: "/edit",
				moduleId: null
			},
			{
				id: 3,
				name: "删除角色",
				desc: "",
				router: "/del",
				moduleId: null
			},
			{
				id: 4,
				name: "查询角色",
				desc: "",
				router: "/get",
				moduleId: null
			},
			{
					id: 5,
					name: "角色列表",
					desc: "",
					router: "/list",
					moduleId: null
				}
				]
			}
			]
	}],
msg:'',
	                          
}
