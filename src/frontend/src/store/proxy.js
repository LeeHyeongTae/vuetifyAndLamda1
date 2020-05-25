import axios from 'axios'

const state = {
    context: 'http://localhost:5000/',
    searchResult : [],
}
const actions = {
    async search({commit}, searchWord){//{commit}의 컬브레이스는 vuex 안의 commit 함수를 가르킨다.
        const headers = {
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        }
        alert('검색어 : '+searchWord)
        axios.post(state.context+`proxy/bugsmusic`, searchWord, headers)
            .then(({data})=>{
                alert('검색한 결과 수: '+data.count)
                commit('SEARCH', data)
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
    },
    SEARCH(state, data){
        state.searchResult = []
        state.searchResult = data
        // data.forEach( item => {
        //     alert(item)
        //     state.searchResult.push([])
        // })
    }
}
const getters = {
    searchResult : state => state.searchResult
}
export default {
    name: 'crawler',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}
