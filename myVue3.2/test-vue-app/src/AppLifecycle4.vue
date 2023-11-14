<template lang="">
    <Lifecycle/>
</template>
<script>
import Lifecycle from "./components/Lifecycle.vue";
export default {
    name: 'App1',
    components: { Lifecycle },
    // data() {

    // },
    methods:{

    },
    beforeCreate(){
        //DOM트리 완성전 DOM접근불가
        console.log("beforeCreate")
    },
    created(){
        //DOM트리 완성후
        console.log("created")
    },
    beforeMount(){
        //template태그 실행 후에 호출됨(렌더링 전) 
        console.log("beforeMount")
    },
    mounted(){
        //렌더링 후
        console.log("mounted")
    },
    beforeUpdate(){
        //data(data옵션, props옵션) 변경되고 렌더링 전
        console.log("beforeUpdate")
    },
    updated(){
        //data(data옵션, props옵션) 변경되고 렌더링 후
        console.log("updated")
        //함수내부에서 data를 변경하면 beforeUpdate->updated->beforeUpdate->updated...무한반복한다
    },
    beforeUnmount(){
        console.log("beforeUnmount")
    },
    unmounted(){
        console.log("unmounted")
    }
}
</script>