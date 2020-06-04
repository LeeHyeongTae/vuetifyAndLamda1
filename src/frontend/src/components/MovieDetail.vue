<template>
    <div style="margin: auto">
        <h1>영화 디테일</h1>
        <header style="border: #4485f3; font-size: x-large">{{item.title}}</header>
        <body>
        <td>현재 순위 : {{item.rank}}</td><br>
        <td>{{item.rankDate}}</td>
        </body>
    </div>
</template>
일
<script>
    import {mapState} from "vuex"
    export default {
        computed: {
            ...mapState({
                item: state => state.search.item
            })
        }
    }

</script>

<style scoped>

</style>