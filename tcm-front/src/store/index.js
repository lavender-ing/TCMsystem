import Vue from 'vue'
import Vuex from 'vuex'
import dateformat from '@/utils/dateformat'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    user: null,
    isLogin: false,
    character:null,
  },
  mutations: {
    login(state, payload){
      state.user=payload.user
      state.user.registertime=dateformat.format(state.user.registertime)
      state.user.lastlogin=dateformat.format(state.user.lastlogin)
      state.isLogin=payload.isLogin
      state.character=state.user.character
    },
    logout(state){
      state.user=null,
      state.isLogin=false,
      state.character=null
    },
    changeProfile(state,payload){
      state.user.picturepath=payload.picturepath
    }
  }
})

export default store