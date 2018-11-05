<template>
    <yd-tabbar :fixed="true" activeColor="#3681EB">
        <yd-tabbar-item title="首页" link="/" :active="activeIndex==0" @click.native="HandlerClick(0)">
            <yd-icon name="home-outline" slot="icon" size="0.54rem"></yd-icon>
        </yd-tabbar-item>
        <yd-tabbar-item title="派送" link="/test" :active="activeIndex==1" @click.native="HandlerClick(1)">
            <yd-icon name="order" slot="icon" size="0.54rem"></yd-icon>
        </yd-tabbar-item>
        <yd-tabbar-item title="揽件" link="#" :active="activeIndex==2" @click.native="HandlerClick(2)">
            <yd-icon name="compose" slot="icon" size="0.54rem"></yd-icon>
            <yd-badge slot="badge" type="danger">2</yd-badge>
        </yd-tabbar-item>

        <yd-tabbar-item title="我的" link="/user" :active="activeIndex==3" @click.native="HandlerClick(3)">
            <yd-icon name="ucenter" slot="icon" size="0.54rem"></yd-icon>
            <!-- <yd-badge slot="badge" type="danger">2</yd-badge> -->
        </yd-tabbar-item>
    </yd-tabbar>
</template>

<script>
export default{
	data(){
		return {
			activeIndex:0,
		}
	},
	methods:{
		HandlerClick(index){
			this.activeIndex = index
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>