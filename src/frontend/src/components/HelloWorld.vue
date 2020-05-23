<template>
    <v-content>
        <v-container fluid fill-height>
            <v-layout align-center justify-center>
                <v-flex xs6>
                    <v-text-field @keyup.enter="search" type="text" label="search" v-model="input"></v-text-field>
                </v-flex>
            </v-layout>
            <v-layout align-center justify-center>
                <v-flex>
                    <v-btn color="red" @click="action">크롤링</v-btn>
                </v-flex>
            </v-layout>
        </v-container>
    </v-content>
</template>

<script>
export default {
  data: () => ({
      input: ''
  }),
  name: "HelloWorld",
  methods: {
      action(){
        this.$store.dispatch('crawler/crawler')
      },
      search(){
          alert(this.input)
      }
  },
};
</script>