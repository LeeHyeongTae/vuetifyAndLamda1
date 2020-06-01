<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table v-if="searchContent==='music'">
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
                <tr v-for="item of container" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td><img :src="item.thumbnail"></td>
                    <td>{{ item.artist }}</td>
                    <td>{{ item.title }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <v-simple-table v-else-if="searchContent==='movie'">
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of container" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.date }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                page: 1
            }
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
                container: state => state.crawling.container,
                searchContent: state => state.crawling.searchContent
            })
        }
    };
</script>