<template>
  <div>

    <div class="btn">
      <el-button type="primary" size="small" @click="add">新增主题</el-button>
    </div>

    <div class="table">
      <el-table
        :data="tableData"
        :border=true
        style="width: 100%"
        :stripe=true
        :header-cell-style="{'text-align':'center'}"
        :cell-style="{'text-align':'center'}">

        <el-table-column
          prop="id"
          label="ID"
          width="60px"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="username"
          label="创建用户"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="createtime"
          label="创建时间"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="name"
          label="聚类名称"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="viewnumber"
          label="视图数量"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="info"
              @click="handleDetail(scope.$index, scope.row)">详情</el-button>

            <el-button
              size="mini"
              @click="handleUpdate(scope.$index, scope.row)">修改</el-button>

            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)" v-if="scope.row.character!='管理员'">删除</el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      srcList:['']
    }
  },
  created(){
    this.loadData()
  },
  methods: {
      //加载信息
      loadData(){
        this.tableData = [{
          id: '1',
          username: 'user2',
          createtime: '2022-12-12',
          name: '高血压数据聚类',
          viewnumber: '2'
        }, {
          id: '2',
          username: 'user3',
          createtime: '2022-12-12',
          name: '糖尿病数据聚类',
          viewnumber: '2'
        }, {
          id: '3',
          username: 'user4',
          createtime: '2022-12-12',
          name: '感冒数据聚类',
          viewnumber: '2'
        }]
      },
    }
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