<template>
    <!-- <TheWelcome /> -->
    <Header />
    <router-view></router-view>
</template>

<script>
// import TheWelcome from "./components/TheWelcome.vue"
import Header from "./components/Header.vue"
export default{
  name: "App",
  // components: {TheWelcome}
  components: {Header}
}
</script>
<style scoped>
</style>