<template>
  <div>

    <div class="table">
      <el-table 
        :data="tableData"
        :border=true
        style="width: 100% ;text-align:left"
        :stripe=true
        :header-cell-style="{'text-align':'center'}"
        :cell-style="{'text-align':'center'}">

        <el-table-column
          prop="clusterid"
          label="簇ID"
          width="60px"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="describe"
          label="簇标注"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="operationid"
          label="聚类主题ID"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="describeuser"
          label="标注者"
          :show-overflow-tooltip=true>
        </el-table-column>

        <el-table-column
          prop="describetime"
          label="标注时间"
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
               @click.native="create">标注</el-button>

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
          clusterid: '1',
          describe: '气短',
          operationid: '1',
          describeuser: 'user1',
          describetime: '2022-12-12 23:59:59'
        }, {
          clusterid: '2',
          describe: '风寒束表证',
          operationid: '1',
          describeuser: 'user1',
          describetime: '2022-12-12 23:59:59'
        }, {
          clusterid: '3',
          describe: '风热犯表证',
          operationid: '1',
          describeuser: 'user1',
          describetime: '2022-12-13 8:00:20'
        }, {
          clusterid: '4',
          describe: '心气虚证',
          operationid: '1',
          describeuser: 'user1',
          describetime: '2022-12-13 8:00:20'
        }
      ]
    },
    handleDetail(index, row)  {
      const h = this.$createElement;
     var str= row.describe.replace('证','')
        this.$msgbox({
          title: '标注详情',
          
          message: h('p', null, [
            h('span', null, '该标注包括 '),
            h('i', { style: 'color: teal' }, '79'),
            h('span', null, ' 个样本，每个样本均被标注为具有 '),
            h('i', { style: 'color: teal' }, str),
            h('span', null, '  的特征。'),
            
            
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
              done();
          }
        })
    },
    create() {
      this.$router.push('create')
    }

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
  
  .el-dialog__body{
    text-align: left;
  }
  </style>