import router from "@/router";

const state = {
    context: "http://localhost:5000",
    container: [],
    pager: {},
    searchContent: "",
    searchWord: "null",
    pageNumber: '0',
    count: 0
};
const actions = {
    async find({commit}, searchWord){
        commit("SEARCHWORD", searchWord)
        switch (searchWord) {
            case '영화' :
                router.push("/retriever")
                this.state.searchContent = 'movie';
                break;
            default : alert('영화만 입력'); break;
        }
    }
};
const mutations = {
    MOVIE(state, data) {
        state.container = [];
        state.searchContent = 'movie'
        state.count = data.count
        data.list.forEach(item => {
            state.container.push({
                movieSeq: item.movieSeq,
                rank: item.rank,
                title: item.title,
                rankDate: item.rankDate
            });
        });
    },
    SEARCHWORD(state, data){
        alert(`뮤테이션::${data}`)
        state.searchWord = data
    }
};
const getters = {};

export default {
    name: "search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};