<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data: function(){
    return {
      isRouterAlive: true
    }
  },
  //存储store数据
  created() {
    //读取
    if (window.sessionStorage.getItem("store")) {
      this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(window.sessionStorage.getItem("store"))))
    } 
    //刷新前存储数据
    window.addEventListener("beforeunload",()=>{
      window.sessionStorage.setItem("store",JSON.stringify(this.$store.state))
    })
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  },
  components: {
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
*{
  margin: 0;
  padding: 0;
}
</style>