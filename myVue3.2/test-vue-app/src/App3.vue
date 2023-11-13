<template lang="">
    <div>
        <h1>App3.vue 컴포넌트입니다</h1>
        <InputNamePropsEmit3 v-model:word="parentWord"/>
        자식컴포턴트가 보내준 데이터 {{parentWord}}
    </div>
</template>
<script>
import InputNamePropsEmit3 from "./components/InputNamePropsEmit3.vue";
export default {
    name: 'App1',
    components: { InputNamePropsEmit3 },
    data() {
        return {
            parentWord: ''
        }
    },
    methods:{

    }
}
</script>