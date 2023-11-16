import { createRouter, createWebHistory } from "vue-router"

import Home from '@/pages/Home.vue'
import Login from '@/pages/Login.vue'
import Signup from '@/pages/Signup.vue'
import ProductList from '@/pages/ProductList.vue'

const router = createRouter({
  history: createWebHistory(), //라우팅모드설정
  routes: [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/signup", component: Signup },
    { path: "/productlist", component: ProductList },
    { path: "/productlist/:currentPage", component: ProductList },

  ]
})
export default router;
