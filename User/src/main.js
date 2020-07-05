// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import VueAxios from "vue-axios";
import htmlToPdf from "./components/htmlToPdf";
import store from "./Vuex/store";
// import VueResource from "vue-resource"
import layer from 'vue-layer';

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(VueAxios,axios)
Vue.use(htmlToPdf)
// Vue.use(VueResource);
Vue.prototype.$layer = layer(Vue);
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
/* eslint-disable no-new */
new Vue({
  el: '#app',

  router:router,
  store:store,
  components: { App },
  template: '<App/>',

})

