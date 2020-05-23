import Vue from "vue";
import Vuex from "vuex";
import proxy from "./proxy";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    proxy
  }
});