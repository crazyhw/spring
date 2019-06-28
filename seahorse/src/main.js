// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Axios from 'axios'
import router from './router'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(Axios);
Axios.defaults.baseURL='http://192.168.43.116:8080/seahorse/';
Vue.prototype.$axios=Axios;
Vue.prototype.HOST = '/api';
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.use(VueAxios);

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
