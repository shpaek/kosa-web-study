<template lang="">
    <div>
        <h1>App2.vue 컴포넌트입니다</h1>
        <InputNameEmit2 @nameChanged="nameChangedHandler" />
        <hr>
        자식컴포넌트가 전달해준 데이터 : {{parentName}}
    </div>
</template>
<script>
import InputNameEmit2 from "./components/InputNameEmit2.vue";
export default {
    name: 'App1',
    components: { InputNameEmit2 },
    data() {
        return {
            parentName: ''
        }
    },
    methods:{
        nameChangedHandler(e){
            this.parentName = e.name
        }
    }
}
</script>