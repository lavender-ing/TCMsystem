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
        <span slot="title">管理员</span>
      </el-menu-item>

      <el-menu-item index="/manager/usermanagement/list">
        <i class="el-icon-s-home"></i>
        <span slot="title">用户管理</span>
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