import { createApp } from 'vue'
import App from './App.vue'

//router/index.js에서 생성한 라우터객체를 app에 추가
import router from './router/index.js'
import 'bootstrap/dist/css/bootstrap.css'

// createApp(App).mount('#app')
const app = createApp(App)
app.use(router)
app.mount('#app')