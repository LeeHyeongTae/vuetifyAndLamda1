<template>
    <v-simple-table>
        <template v-slot:default>
            <thead>
            <tr>
                <th class="text-left">No.</th>
                <th class="text-left">이미지</th>
                <th class="text-left">가 수</th>
                <th class="text-left">노래제목</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="item of player" :key="item.seq">
                <td>{{ item.seq }}</td>
                <td><img :src="item.thumbnail"></td>
                <td>{{ item.artist }}</td>
                <td>{{ item.title }}</td>
            </tr>
            </tbody>
        </template>
    </v-simple-table>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        name: "PlayerList",
        computed: {
            ...mapState({
                player: state => state.soccer.soccer
            })
        }
    }
</script>

<style scoped>

</style>