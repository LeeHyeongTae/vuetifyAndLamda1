<template>
    <div>
        <v-textarea
        outlined
        v-model="memo"
        label="todolist input"
        value="">
        </v-textarea>
        <v-btn @click="listAdd">리스트 추가</v-btn>
    </div>
</template>

<script>
    export default {
        name: "ListAdd",
        data(){
            return {
                memo: null
            }
        },
        methods: {
            listAdd(){
                alert('리스트추')
            }
        }
    }
</script>

<style scoped>
</style>