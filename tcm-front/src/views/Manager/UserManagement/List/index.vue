<template>
  <div>

    <div class="btn">
      <el-button type="primary" size="small" @click="add">新增用户</el-button>
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
          label="用户名"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="password"
          label="用户密码"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="character"
          label="角色"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="phone"
          label="联系电话"
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
        this.$axios.get('/user/getall')
        .then(res=>{
          if(res.data.code==200){
            this.tableData=res.data.result
          }else{
            this.$alert(res.data.message, '提示', {
                confirmButtonText: '确定'
            })
          }
        })
      },
      //新增
      add(){
        this.$router.push({
          name:'usermanagementinsert'
        })
      },
      //修改
      handleUpdate(index, row) {
        this.$router.push({
          name:'usermanagementupdate',
          query:{
            data:JSON.stringify(row)
          }
        })
      },
      //详情
      handleDetail(index, row) {
        this.$router.push({
          name:'usermanagementdetail',
          query:{
            data:JSON.stringify(row)
          }
        })
      },
      //删除
      handleDelete(index, row) {
        this.$confirm('是否删除该用户?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(res=>{
          this.$axios.delete('/user/delete/'+row.id)
          .then(res=>{
            if(res.data.code==200){
              //删除成功
              this.$message({
                type: 'success',
                message: '删除成功!',
              });
              location.reload();
            }else{
              //删除失败
              this.$message({
                type: 'error',
                message: res.data.message,
              });
            }
          })
        }).catch(fail=>{
          this.$message({
            type: 'info',
            message: '已取消'
          });          
        });
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