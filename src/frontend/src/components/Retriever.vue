<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
        <a @click="myalert('aaaa')">테스트</a>
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
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.movieSeq">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank }}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <div style="margin: 0 auto; width: 500px; height: 100px;">
            <span v-if="pager.existPrev" @click="prevBlock" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">이전</span>
            <span @click="transferPage(i)" v-for="i of pages" :key="i" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">{{ i }}</span>
            <span v-if="pager.existNext" @click="nextBlock" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">다음</span>
<!--    <v-pagination v-model="pageNumber" :length="5" :total-visible="5"></v-pagination>-->
            </div>
        </div>
    </div>
</template>
<script>
    import {mapState} from "vuex"
    import {proxy} from "./mixins/proxy";
    export default {
        mixins: [proxy],
        created() {
            console.log('페이징 가기전')
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            this.$store.state.search.searchContent = 'movie'
            console.log('크리에이티드 : '+json.temp.pageSize)
        },
        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager,
                searchContent: state => state.search.searchContent
            }),
        },
        methods: {
            prevBlock(){
                //
            },
            nextBlock(){
                //
            },
            transferPage(d){
                this.$store.dispatch("search/transferPage",{cate:'movies',searchWord:'null',pageNumber:d-1})
            }
        }
    };
</script>