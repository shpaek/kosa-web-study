<template lang="">
    <!-- <li><input type="checkbox" v-model="checked"/>선택</li> -->
    <!-- <li><input type="checkbox" v-bind:checked="chk"/>{{name}}</li> -->
    <li><input type="checkbox" v-bind:checked="p.checked"/>{{p.prodName}}</li>
</template>
<script>
export default {
    name: 'Checkbox1',
    data() {
        checked: false
    },
    //부모가 전달해준 자료를 자식쪽에서 유효성검사하기
    //props : {
    // chk : {
    //     type : Boolean,
    //     default: false,
    // },
    // name:{
    //     validator(v){
    //        return typeof(v) !== 'string'? false: v.trim().length>=4 ? true: false 
    //     }
    // }
    //}
    props: ['p']
}
</script>
<style lang="">
    
</style>