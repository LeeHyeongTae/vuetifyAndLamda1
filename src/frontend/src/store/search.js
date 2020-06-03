import axios from "axios";
import router from "@/router";

const state = {
    context: "http://localhost:5000",
    pageNumber: 0,
    searchWord: 'null',
    pages: [],
    list: [],
    pager: {},
    searchContent: ''
};
const actions = {
    async find({commit}, searchWord){ // commit은 vuex의 commit이다. 디스트럭처
        commit("SEARCHWORD", searchWord)
        switch (searchWord) {
            case '영화' :router.push("/retriever"); break;
            default : alert('영화만 입력'); break;
        }
    },
    async transferPage({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                commit("TRANSFER", data)
            })
            .catch(()=>{
                alert('page 바꾸는 통신 에러')
            })
    }
};
const mutations = {
    SEARCHWORD(state, data){
        alert(`뮤테이션::${data}`)
        state.searchContent = 'movie'
        state.searchWord = data
    },
    TRANSFER(state, data){
        state.searchContent = 'movie'
        state.pager = data.pager
        state.list = data.list
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