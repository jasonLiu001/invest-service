import Vue from 'vue'
import App from './App.vue'
import router from "./router";

new Vue({
  el: '#main',
  router,//注册路由
  render: h => h(App)
});
