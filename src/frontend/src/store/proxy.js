import axios from 'axios'

const state = {
    context: 'http://localhost:5000/',
    crawler : {},
    fail: false
}
const actions = {
    async crawler({commit}) {
        const url = state.context+`proxy/crawler`

        axios.get(url)
            .then(()=>{
                    commit('CRAWLER_COMMIT')
            })
            .catch(()=>{
                    commit('FAIL_COMMIT')
            })
    }
}
const mutations = {
    CRAWLER_COMMIT(){
      alert('크롤링 성공')
    },
    FAIL_COMMIT(){
        alert('서버전송실패')
    }
}
const getters = {

}
export default {
    name: 'crawler',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}