<template>
    HOME파일경로- @/pages/Home.vue
    <p>전체경로: {{ $route.fullPath }}</p>
    <p>URI경로: {{ $route.path }}</p>
    <p>요청전달데이터: {{ $route.params }}</p>
    <p>요청쿼리스트링: {{ $route.query }}</p>
</template>
<script>
export default{
    name: "Home"
}
</script>