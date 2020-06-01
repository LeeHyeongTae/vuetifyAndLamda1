import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home.vue";
import Retriever from "../components/Retriever"
Vue.use(VueRouter);

const routes = [
  { path: "/", name: "Home", component: Home },
  { path: "/retriever", name: "Retriever", component: Retriever },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
