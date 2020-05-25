<template>
  <div id="app">
    <div class="content">
      <div>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
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
