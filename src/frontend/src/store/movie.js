import axios from "axios"
import router from "@/router";

const state = {
    context : "http://localhost:5000/",
    movie : "",
    count : 0
}
const actions = {
    async search({commit}, searchWord){
        alert("검색어: "+searchWord)
        axios.get(state.context+`proxy/movie/`+searchWord)
            .then(({data})=>{
                commit("SEARCH", data)
                router.push("/movie")
            })
            .catch(()=>{
                alert('영화 통신 실패')
            })
    }
}
const mutations = {
    SEARCH(state, data) {
        alert("자바 회신 메세지 :"+state.movie)
        state.movie = [];
        state.count = data.count;
        data.list.forEach(item => {
            state.movie.push({
                seq: item.seq,
                title: item.title,
            });
        });
    }
}
const getters = {
    movie: state => state.movie,
    count: state => state.count
}
export default {
    name: "movie",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}
