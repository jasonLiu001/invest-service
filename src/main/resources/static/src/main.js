import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import Vuetify from 'vuetify';
// import 'vuetify/dist/vuetify.min.css'
// import 'material-design-icons-iconfont/dist/material-design-icons.css';

Vue.use(Vuetify);

new Vue({
  el: '#main',
  router,//注册路由
  render: h => h(App)
});
