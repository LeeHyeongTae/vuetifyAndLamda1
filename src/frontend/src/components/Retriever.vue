<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
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
            <span @click="testClick(i)" v-for="i of pages" :key="i" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">{{ i }}</span>
            <span v-if="pager.existNext" @click="nextBlock" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px; cursor: pointer;">다음</span>
<!--    <v-pagination v-model="pageNumber" :length="5" :total-visible="5"></v-pagination>-->
            </div>
        </div>
    </div>
</template>
<script>
    import axios from "axios"
    import { mapState } from "vuex";
    export default {
        data() {
            return{
                searchContent: 'movie',
                pageNumber: 0,
                pages: [],
                list: [],
                pager: {},
                totalCount: '',
            }
        },
        created() {
            axios
                .get(`${this.$store.state.search.context}/movies/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res => {
                    res.data.list.forEach(elem => {this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.pageStart + 1
                    const arr = []
                    console.log(`페이지 끝: ${this.pager.pageEnd}`)
                    for(; i<= this.pager.pageEnd + 1; i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err => {
                    alert(`영화 통신 실패 ${err}`)
                })
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
                container: state => state.crawling.container,
            })
        },
        methods: {
            prevBlock(){
                //
            },
            nextBlock(){
                //
            },
            testClick(d){
                this.pageNumber = d;
            }
        }
    };
</script>