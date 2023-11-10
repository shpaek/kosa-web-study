<template lang="">
    <!-- <li><input type="checkbox" v-model="checked"/>선택</li> -->
    <!-- <li><input type="checkbox" v-bind:checked="chk"/>{{name}}</li> -->
    <li><input type="checkbox" v-bind:checked="p.checked"/>{{p.prodName}}</li>
</template>
<script>
export default {
    name: 'Checkbox1',
    data(){
        checked : false
    },
    // props:['chk', 'name']
    props:['p']
}
</script>
<style lang="">
    
</style>