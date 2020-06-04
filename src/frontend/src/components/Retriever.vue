<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
        <span><input id="searchWord" @keyup.enter="search" type="text" style="border: 1px solid black"><button @click="search">검색</button></span>
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
                    <td ><a @click="selectOne(item.movieSeq)" href="#">{{ item.title }}</a></td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <div style="margin: 0 auto; width: 500px; height: 100px;">
            <span v-if="pager.existPrev" @click="transferPage(pager.prevBlock)" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">이전</span>
            <span @click="transferPage(i-1)" v-for="i of pages" :key="i" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">{{ i }}</span>
            <span v-if="pager.existNext" @click="transferPage(pager.nextBlock)" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">다음</span>
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
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            this.$store.state.search.searchContent = 'movie'
        },
        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager,
                searchContent: state => state.search.searchContent,
                detail: state => state.search.detail
            }),
        },
        methods: {
            transferPage(d){
                this.$store.dispatch("search/transferPage",{cate:'movies',searchWord:document.getElementById('searchWord').value,pageNumber:d})
            },
            search(){
                let searchWord = document.getElementById('searchWord').value
                if(searchWord === ''){searchWord= 'null'}
                this.$store.dispatch("search/transferPage",{cate:'movies',searchWord:searchWord,pageNumber:0})
            },
            selectOne(movieSeq){
                proxy.methods.tester(movieSeq)
                this.$store.dispatch("search/selectOne",{cate:'movies',seq:movieSeq})
            }
        }
    };
</script>