<template lang="">
    생명주기용 메서드 실습
</template>
<script>
import axios from 'axios';
export default {
    name: 'Checkbox1',
    methods: {

    },
    beforeCreate() {
        //DOM트리 완성전 DOM접근불가
        console.log("하위컴포넌트 beforeCreate")
    },
    created() {
        //DOM트리 완성후
        console.log("하위컴포넌트 created")
        const url = "http://192.168.1.20:8888/back2/productlistjson?currentPage=1"
        axios
        .get(url)
        .then((response)=>{
            console.log(response.data)
        })
    },
    beforeMount() {
        //template태그 실행 후에 호출됨(렌더링 전) 
        console.log("하위컴포넌트 beforeMount")
    },
    mounted() {
        //렌더링 후
        console.log("하위컴포넌트 mounted")
    },
    beforeUpdate() {
        //data(data옵션, props옵션) 변경되고 렌더링 전
        console.log("하위컴포넌트 beforeUpdate")
    },
    updated() {
        //data(data옵션, props옵션) 변경되고 렌더링 후
        console.log("하위컴포넌트 updated")
        //함수내부에서 data를 변경하면 beforeUpdate->updated->beforeUpdate->updated...무한반복한다
    },
    beforeUnmount() {
        console.log("하위컴포넌트 beforeUnmount")
    },
    unmounted() {
        console.log("하위컴포넌트 unmounted")
    }
}
</script>
<style lang="">
    
</style>