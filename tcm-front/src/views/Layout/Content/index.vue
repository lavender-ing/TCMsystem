<template>
  <div>
    <div class="header" style="height: 50px;">

      <el-button plain round style="float:right;margin:20px;font-weight: bold;" @click.native="logout">退出登录</el-button>
      <el-tooltip placement="bottom">
        <div slot="content">点击查看用户详情</div>
        <el-button type="primary" plain round style="float:right;margin-top:20px;font-weight: bold;" @click.native="userinfo">{{this.$store.state.user.username}}</el-button>
      </el-tooltip>
      <i class="el-icon-user-solid" style="float:right;font-size: 35px;color: #222;padding-top: 20px"></i>
    </div>
    <el-divider style="margin-top: -50px;"></el-divider>
    <router-view/>
  </div>

  <!-- <el-menu
      :default-active="'/index'"
      router
      mode="horizontal"
      background-color="#eeeeee"
      text-color="#222"
      active-text-color="#4180FF"
      style="min-width: 1300px;margin-top: -8px;">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <el-button type="text" @click="requestUser" style="font-size: 15px; color: #222;float: right;padding: 20px;">
        用户: {{this.$store.state.user.username}}
      </el-button>
      <i class="el-icon-user-solid" style="float:right;font-size: 35px;color: #222;padding-top: 12px"></i>
      <span style="position: absolute;padding-top: 15px;right: 43%;font-size: 24px;font-weight: bold">Title</span>
    </el-menu> -->

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
    background: rgb(255, 255, 255);
    height: 80px;
    width: 100%;
}
</style>