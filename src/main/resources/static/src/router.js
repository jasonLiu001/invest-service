import Vue from "vue";
import VueRouter from "vue-router";

// 引入组件
import about from "./pages/About";
import profit from "./pages/Profit";

// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

//路由
const routes = [
  {
    path: "/about",
    component: about
  },
  {
    path: "/profit",
    component: profit
  }
];

let router = new VueRouter({
  routes
});
export default router;
