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
              @click="handleUpdate=true">修改</el-button>



            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)" v-if="scope.row.character!='管理员'">删除</el-button>
          </template>
        </el-table-column>



      </el-table>

    </div>
    <el-dialog title="修改聚类标记信息" :visible.sync="handleUpdate">
          <el-form :model="tableData">
            <el-form-item label="聚类名称" :label-width="formLabelWidth">
            <el-input v-model="tableData.name" autocomplete="off"></el-input>
             </el-form-item>
        
             <el-form-item label="视图数量" :label-width="formLabelWidth">
                <el-select v-model="tableData.viewnumber" placeholder="请选择视图数量">
              <el-option label="1" value="1种视图"></el-option>
             <el-option label="2" value="2种视图"></el-option>
             <el-option label="3" value="3种视图"></el-option>
             
               </el-select>
          </el-form-item>
         
        </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="handleUpdate = false" >取 消</el-button>
    <el-button type="primary" @click="handleUpdate = false" >确 定</el-button>
  </div>
          </el-dialog>


  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      srcList: [''],
      handleUpdate: false,
      formLabelWidth: '120px'
      
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
   /* handleDetail(index, row) {
        this.$alert('该聚类簇包括88个样本，每个样本包括2个视图的信息，属于该簇的样本均被标记为“具有高血压症状”。', '聚类详情', {
          confirmButtonText: '确定',
          callback: action => {
            this.$message({
              type: 'info',
              message: `action: ${ action }`
            });
          }
        });
    }*/
    handleDetail(index, row)  {
      const h = this.$createElement;
      var str = row.name.replace('数据聚类', '');
        this.$msgbox({
          title: '聚类详情',
          message: h('p', null, [
            h('span', null, '该聚类簇包括 '),
            h('i', { style: 'color: teal' }, '88'),
            h('span', null, ' 个样本，每个样本包括 '),
            h('i', { style: 'color: teal' }, row.viewnumber),
            h('span', null, ' 个视图的信息，属于该簇的样本均被标记为'),
            
            h('i', { style: 'color: teal' }, ' 具有'+str+'症状'),
            h('span', null, '。'),

          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
              done();
          }
        })
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