<template>
    <div>
      <div style="text-align: left; margin-left: 10%;">
      <el-select v-model="value" placeholder="请选择数据">
      <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
      </el-option>
      </el-select>
      <el-button type="primary" size="small" round style="margin-left: 35px;">查询结果</el-button>
      </div>
      <el-card class="box-card" style="width: 50%; margin-left: 24%; margin-top: 35px;">
        <el-image :src="src"></el-image>
      </el-card>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        src: require('./cluster.png'),
        options: [{
          value: '选项1',
          label: '高血压数据聚类'
        }, {
          value: '选项2',
          label: '糖尿病数据聚类'
        }, {
          value: '选项3',
          label: '感冒数据聚类'
        }],
        value: '感冒数据聚类'
      }
    },
    methods: {
        //加载信息
        
    },
  }
  </script>
  
  <style>
  .table{
    margin:20px;
  }
    
    .btn{
      margin: 0px;
      margin-bottom: 20px;
      margin-right: 20px;
      float: right;
    }
    
    </style>