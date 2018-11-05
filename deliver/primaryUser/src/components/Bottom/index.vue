<template>
    <yd-tabbar :fixed="true" activeColor="#F05000">
        <yd-tabbar-item title="首页" link="/" :active="active==0" >
            <yd-icon name="home-outline" slot="icon" size="0.54rem"></yd-icon>
        </yd-tabbar-item>
        <yd-tabbar-item title="发快递" link="/send" :active="active==1" >
            <yd-icon name="order" slot="icon" size="0.54rem"></yd-icon>
        </yd-tabbar-item>
        <yd-tabbar-item title="我的快递" link="/deliver" :active="active==2" >
            <yd-icon name="compose" slot="icon" size="0.54rem"></yd-icon>
            <yd-badge slot="badge" type="danger">2</yd-badge>
        </yd-tabbar-item>

        <yd-tabbar-item title="我的" link="/user" :active="active==3" >
            <yd-icon name="ucenter" slot="icon" size="0.54rem"></yd-icon>
            <!-- <yd-badge slot="badge" type="danger">2</yd-badge> -->
        </yd-tabbar-item>
    </yd-tabbar>
</template>

<script>
export default{
    props:{
        active:{
            type:Number,
            default:0
        }
    },
}   
</script>

<style lang="" scoped>
    
</style>