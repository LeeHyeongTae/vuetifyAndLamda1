import axios from "axios";
import router from "@/router";

const state = {
    context: "http://localhost:5000/",
    container: [],
    soccer : "",
    searchContent: "",
    count: 0
};
const actions = {
    async soccer({commit}, searchWord){
        axios.get(state.context+`proxy/soccer/`+searchWord)
            .then(({data})=>{
                commit("SOCCER", data)
            })
            .catch(()=>{
                alert('축구 통신 실패')
            })
    },
    async bugsmusic({ commit }, searchWord) {
        axios.get(state.context + `proxy/bugsmusic/${searchWord}`)
            .then(({ data }) => {
                commit("BUGSMUSIC", data);
                router.push("/retriever");
            })
            .catch(() => {
                alert("통신 실패 !");
            });
    },
    async movie({commit}, searchWord){
        axios.get(state.context+`movie/list/1/${searchWord}`)
            .then(({data})=>{
                commit("MOVIE", data)
                router.push("/retriever")
            })
            .catch(()=>{
                alert('영화 통신 실패')
            })
    }
};
const mutations = {
    SOCCER(state, data) {
        state.soccer = data.soccer
        state.searchContent = 'soccer'
    },
    BUGSMUSIC(state, data) {
        state.container = [];
        state.searchContent = 'music'
        state.count = data.count;
        data.list.forEach(item => {
            state.container.push({
                seq: item.seq,
                artist: item.artist,
                title: item.title,
                thumbnail: item.thumbnail
            });
        });
    },
    MOVIE(state, data) {
        state.container = [];
        state.searchContent = 'movie'
        data.forEach(item => {
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
    soccer: state => state.soccer,
    container: state => state.container,
    count: state => state.count,
};

export default {
    name: "crawling",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
};