import Vue from "vue";
import Vuex from "vuex";
import crawler from "./crawler";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    crawler
  }
});