<template>
  <div class="layout" v-if="this.$store.state.isLogin">
    <!-- 导航栏 -->
    <div class="menu">
      <MenuManager v-if="管理员"></MenuManager>
      <MenuOrdinaryUser v-else></MenuOrdinaryUser>
    </div>
    <!-- 内容 -->
    <div class="content">
      <Content></Content>
    </div>
  </div>
</template>

<script>
import Content from './Content'
import MenuOrdinaryUser from './MenuOrdinaryUser'
import MenuManager from './MenuManager'
export default {
  components:{
      Content,
      MenuManager,
      MenuOrdinaryUser
  }
}
</script>

<style scoped>

.menu{
    position: fixed;
    left:0;
    top:0;
    bottom: 0;
    width: 200px;
    background: #545c64;
}
.content{
    padding-left: 200px;
}
</style>