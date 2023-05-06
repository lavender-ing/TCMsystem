<template>
  <div>
    <el-page-header @back="goBack" content="用户详情" style="margin:20px;"></el-page-header>

    <el-descriptions class="margin-top" title="详细信息" :column="1" :border="true" :data="tableData">

      <el-descriptions-item>
        <template slot="label">
          ID
        </template>
        {{this.tableData.id}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          用户名
        </template>
        {{this.tableData.username}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          用户密码
        </template>
        {{this.tableData.password}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          角色
        </template>
        {{this.tableData.character}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          联系电话
        </template>
        {{this.tableData.phone}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          邮箱
        </template>
        {{this.tableData.mail}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          地址
        </template>
        {{this.tableData.address}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          密保问题
        </template>
        {{this.tableData.question}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          密保答案
        </template>
        {{this.tableData.answer}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          上次登录时间
        </template>
        {{this.tableData.lastlogin}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          注册时间
        </template>
        {{this.tableData.registertime}}
      </el-descriptions-item>

    </el-descriptions>

  </div>

</template>

<script>
import dateformat from '@/utils/dateformat';

export default {
  data() {
    return {
      tableData: [],
    }
  },
  created(){
    this.tableData=JSON.parse(this.$route.query.data)
    this.tableData.lastlogin=dateformat.format(this.tableData.lastlogin)
    this.tableData.registertime=dateformat.format(this.tableData.registertime)
  },
  methods:{
    goBack(){
      this.$router.back()
    },
  }
}
</script>

<style scoped>
.el-descriptions{
  margin:20px;
}
</style>