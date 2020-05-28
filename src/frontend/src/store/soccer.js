import axios from "axios"

const state = {
    context : "http://localhost:5000/",
    soccer : "",
}
const actions = {
    async search({commit}, searchWord){
        alert("검색어: "+searchWord)
        axios.get(state.context+`proxy/soccer/`+searchWord)
            .then(({data})=>{
                commit("SEARCH", data)
            })
            .catch(()=>{
                alert('축구 통신 실패')
            })
    }
}
const mutations = {
    SEARCH(state, data) {
        state.soccer = data.soccer
        alert("자바 회신 메세지 :"+state.soccer)
    }
}
const getters = {}
export default {
    name: "soccer",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}
