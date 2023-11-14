import { createRouter, createWebHistory } from "vue-router"
//경로 별칭 : @은 'src/' 경로를 의미합니다
import Home from '@/pages/Home.vue'
import About from '@/pages/About.vue'
import Members from '@/pages/Members.vue'
import MemberInfo from '@/pages/MemberInfo.vue'
const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", component: Home },
    { path: "/about", component: About },
    { path: "/members", component: Members },

    // 동적라우팅방법
    { path: "/members/:id", component: MemberInfo },
  ]
})
export default router;
