<template lang="">
    <div>
        <!-- root component : App2.vue, child component : components/InputName2.vue-->
        <h1>App2.vue 컴포넌트입니다</h1>
        <InputName/>
    </div>
</template>
<script>
import InputName from "./components/InputName2.vue";
export default {
    name: 'App2',
    components: { InputName },
}
</script>
<style lang="">
    
</style>