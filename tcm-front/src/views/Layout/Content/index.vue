<template>
  <div>
    <div class="header">

      <el-button style="float:right;margin:20px;font-weight: bold;" @click.native="logout">退出登录</el-button>

      <el-tooltip placement="bottom">
        <div slot="content">点击查看用户详情</div>
        <el-button style="float:right;margin:20px;font-weight: bold;" @click.native="userinfo">用户： {{this.$store.state.user.username}}</el-button>
      </el-tooltip>

    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  methods:{
    //查看用户详情
    userinfo(){
      this.$router.push('/myinfo')
    },
    //退出登录
    logout(){
      this.$store.commit('logout')
      this.$router.replace("/")
      window.location.reload()
    },
  }
}
</script>

<style scoped>
.header{
    background: skyblue;
    height: 80px;
    width: 100%;
}
</style>