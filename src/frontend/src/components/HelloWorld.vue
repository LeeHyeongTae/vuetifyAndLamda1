<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center>
      <v-flex xs6>
          <v-text-field
          @keyup.enter="search"
          type="text"
          label="search"
          v-model="input">
          </v-text-field>
      </v-flex>
    <v-flex>
       <v-btn color="red" @click="action">크롤링</v-btn>
    </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    input: ""
  }),
  name: "HelloWorld",
  methods: {
    action(){
      alert("크롤링버튼 클릭")
      this.$store.dispatch("proxy/crawler")
    },
    search(){
      alert(this.input)
      this.$store.dispatch("proxy/search", this.input)
      this.input = ''
      }
  }
};
</script>