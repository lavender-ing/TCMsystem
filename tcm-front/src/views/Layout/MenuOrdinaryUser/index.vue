<template>
  <div>
    <el-menu
      router
      default-active="/"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">

      <el-menu-item>
        <span slot="title">医务人员</span>
      </el-menu-item>

      <el-menu-item index="/ordinaryuser/onlinecluster">
        <i class="el-icon-s-home"></i>
        <span slot="title">在线聚类</span>
      </el-menu-item>

      <el-menu-item index="/ordinaryuser/note">
        <i class="el-icon-s-home"></i>
        <span slot="title">证型标注</span>
      </el-menu-item>

      <el-menu-item index="/ordinaryuser/suggest">
        <i class="el-icon-s-home"></i>
        <span slot="title">建议反馈</span>
      </el-menu-item>

    </el-menu>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.el-menu{
  border-right:none;
}
*{
  text-align: left;
}
</style>