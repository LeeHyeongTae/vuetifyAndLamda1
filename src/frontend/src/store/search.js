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
            case '영화' :router.push("/retriever"); break;
            default : alert('영화만 입력'); break;
        }
    }
};
const mutations = {
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