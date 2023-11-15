import { createRouter, createWebHistory } from "vue-router"

import Home from '@/pages/Home.vue'
import Login from '@/pages/Login.vue'
import Signup from '@/pages/Signup.vue'

const router = createRouter({
  history: createWebHistory(), //라우팅모드설정
  routes: [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/signup", component: Signup },

  ]
})
export default router;
