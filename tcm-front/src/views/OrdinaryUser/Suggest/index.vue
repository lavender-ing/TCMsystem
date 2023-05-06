<template>
  <div>
    <div style="width: 800px; margin-top: 50px; margin-left: 50px;">
    <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="建议反馈">
      <el-input type="textarea" v-model="textarea" placeholder="请输入内容" rows="6"></el-input>
    </el-form-item>
    <br>
    <el-button type="primary">提交</el-button>
    </el-form>
    </div>
  </div>
</template>
  
  <script>
  export default {
    data() {
    return {
      textarea: ''
    }
  }
  }
  </script>
  
  <style>
  
  </style>