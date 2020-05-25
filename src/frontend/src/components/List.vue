<template>
   <v-container>
      <v-list three-line>
          <template v-for="(item, index) ">
              <v-subheader v-if="" :key=""></v-subheader>
              <v-divider v-else-if="" :inset="" :key=""></v-divider>
              <v-list-item>
                  <v-list-item-avatar>
                    <img src="searchResult.thumbnail">
                  </v-list-item-avatar>
                  <v-list-item-content>
                      <v-list-item-title></v-list-item-title>
                      <v-list-item-subtitle></v-list-item-subtitle>
                  </v-list-item-content>
              </v-list-item>
          </template>
      </v-list>
   </v-container>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        computed: {
            ...mapState({
                searchResult : (state)=> state.proxy.searchResult
            })
        },
        name: "List",
        data () {
            return {
                searchResult: [

                ]
            }
            },
        methods: {

        }
    }
</script>

<style scoped>
</style>