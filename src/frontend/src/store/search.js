import axios from "axios";
import router from "@/router";

const state = {
    context: "http://localhost:5000/",
    container: [],
    pager: {},
    searchContent: "",
    count: 0
};
const actions = {
    async find({commit}, searchWord){
        commit("TEST")
            switch (searchWord) {
                case'영화': router.push("/retriever"); break
                case'축구': router.push("/movie"); break
                case'뮤직': routr.push("/movie"); break
            }
            },
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
    }
};
const getters = {
    container: state => state.container,
    count: state => state.count,
};

export default {
    name: "search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};