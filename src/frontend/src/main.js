import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import Vuex from "vuex";
import axios from "axios";
Vue.config.productionTip = false;

new Vue({
  Vuex,
  axios,
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
