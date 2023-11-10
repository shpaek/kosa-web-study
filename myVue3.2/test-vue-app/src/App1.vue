<template lang="">
    <div>
        <h1>App1.vue 컴포넌트입니다</h1>
        <!-- <Checkbox1/>
        <Checkbox1/>
        <Checkbox1/> -->
        <ul>
            <!-- <Checkbox1 v-for="p in products" :chk="p.checked" :name="p.prodName"/> -->
            <Checkbox1 v-for="p in products" v-bind:p="p"/>
        </ul>
    </div>
</template>
<script>
import Checkbox1 from "./components/Checkbox1.vue";
export default {
    name: 'App1',
    components: { Checkbox1 },
    data() {
        return {
            products: [
                { prodNo: 'C0001', prodName: '아메리카노', checked: false },
                { prodNo: 'C0002', prodName: 'ICE아메리카노', checked: true },
                { prodNo: 'C0003', prodName: '라테', checked: false }
            ]
        }
    }
}
</script>
<style lang="">
    
</style>