<template>
    <div style="border:solid 1px gray; padding:5px;">
        이름 : <input type="text" v-model="name"/>
        <!-- <button @click="$emit('nameChanged', {name})">이벤트 발신</button> -->
        <button @click="valid">이벤트 발신</button>
    </div>
</template>
<script>
    export default{
        name: "InputName",
        data(){
            return {
                name : ""
            }
        },
        methods:{
            valid(){
                if(this.name.trim().length >= 3){
                    this.$emit('nameChanged', {name:this.name}) //{a}는 {a: a}와 같음, {b: 'two'}
                }else{
                    alert('3자이상 입력하세요')
                }
            }
        }
    }
</script>