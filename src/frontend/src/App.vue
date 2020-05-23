<template>
  <div id="app">
    <div class="content">
    <div>
      <img src="https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_160x56dp.png">
    </div>
    <div>
  <HelloWorld/>
    </div>
  </div>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld";

export default {
  name: "App",

  components: {
    HelloWorld
  },

  data: () => ({
    drawer: false
  })
};
</script>

<style scoped>
  .content {
    position: absolute;
    top: 30%;
    left: 40%;
    width: max-content;
  }
</style>
