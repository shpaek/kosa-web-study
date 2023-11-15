
<template lang="">
    <div>
        <Header />
        <Section />
        <Footer />
        
    </div>
</template>
<script>
import Header from './Header.vue'
import Section from './Section.vue'
import Footer from './Footer.vue'
export default {
    name: 'Main',
    components: {Header, Section, Footer}
}
</script>
<style scoped>
    
</style>