<template>
    <yd-navbar :title="title" :bgcolor="bgcolor" :color="color" fixed>
        <router-link :to="linkLeft" slot="left" @click.native="HandlerLeft">
            <!-- <yd-navbar-back-icon :color="color"></yd-navbar-back-icon> -->
            <slot name="left"></slot>
        </router-link>
     
       	<router-link :to="linkRight" slot="center" @click.native="HandlerRight" v-if="title==''">
            <slot name="center"><input type="text"></slot>
        </router-link>
        <router-link :to="linkRight" slot="right" @click.native="HandlerRight">
            <!-- <yd-navbar-next-icon :color="color"></yd-navbar-next-icon> -->
            <slot name="right"></slot>
        </router-link>
    </yd-navbar>
</template>

<script>
export default{
	name:'v-header',
	props:{
		title:{
			type:String,
			default:'title',
		},
		iconLeft:{
			type:String,
			default:'home',
		},
		iconRight:{
			type:String,
			default:'user',
		},
		linkLeft:{
			type:String,
			default:'/'
		},
		linkRight:{
			type:String,
			default:'/'
		},
		bgcolor:{
			type:String,
			default:'#317EE7'
		},
		color:{
			type:String,
			default:'#fff'
		}
	},
	methods:{
		HandlerLeft(){
			this.$emit('HandlerLeft')
		},
		HandlerRight(){
			this.$emit('HandlerRight')
		}
	}
}   
</script>

<style lang="" scoped>
    
</style>