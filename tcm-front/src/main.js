import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router/index.js'
import store from './store/index.js'
import moment from 'moment'
import echarts from 'echarts';

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8081/'
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.prototype.$echarts = echarts;

Vue.use(ElementUI);

Vue.filter('dateFormat', function (dateStr,pattern = "YYYY-MM-DD HH:mm:ss") {
  return moment(dateStr).format(pattern);
})

//登录拦截器
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.isLogin) {
      next()
    } else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})

new Vue({
  render: h => h(App),
  router: router,
  store: store,
}).$mount('#app')
