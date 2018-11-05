<template>
    <yd-navbar :title="title" :bgcolor="bgcolor" :color="color" fixed>
        <router-link :to="linkLeft" slot="left" @click.native="HandlerLeft">
            <slot name="left">
            	<yd-navbar-back-icon :color="color"></yd-navbar-back-icon>
            </slot>
        </router-link>
     
       	<router-link :to="linkRight" slot="center" @click.native="HandlerRight" v-if="title==''">
            <slot name="center"><!-- <input type="text"> --></slot>
        </router-link>
        <router-link :to="linkRight" slot="right" @click.native="HandlerRight">
            <slot name="right">
            	<yd-navbar-next-icon :color="color"></yd-navbar-next-icon>
            </slot>
        </router-link>
    </yd-navbar>
</template>

<script>
export default{
	name:'v-header',
	props:{
		title:{
			type:String,
			default:'',
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
			default:'#F05000'
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