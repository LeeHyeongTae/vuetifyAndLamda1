import axios from 'axios'

const state = {
    context: 'http://localhost:5000/',
    crawler : {},
    searchResult : {},
    fail: false
}
const actions = {
    async search({commit}, searchWord){//{commit}의 컬브레이스는 vuex 안의 commit 함수를 가르킨다.
        const url = state.context+`proxy/${searchWord}/search`
        const headers = {
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(url, searchWord, headers)
            .then(({data})=>{
                if(data.result){
                    commit('SEARCH_COMMIT', data)
                    state.searchResult = data.result
                }else{
                    commit('받아오기 실패')
                }
            })
            .catch(()=>{
                alert('서버 전송실패')
            })
    },
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
        alert('서버전송 실패')
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
