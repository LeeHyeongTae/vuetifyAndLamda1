<template>
    <v-content>
      <div>
        <router-link to="/"><img
                src="https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_160x56dp.png"
        ></router-link>
      </div>
      <HelloWorld/>
    </v-content>
</template>

<script>
import HelloWorld from "../components/HelloWorld";
export default {
  name: "Home",
  components: {
    HelloWorld
  }
};
</script>
