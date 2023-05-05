<template>
  <div style="margin:30px">
    <h1>重置密码</h1>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username" disabled></el-input>
      </el-form-item>

      <el-form-item label="新密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>

      <el-form-item label="安全问题" prop="question">
        <el-input v-model="ruleForm.question" disabled></el-input>
      </el-form-item>

      <el-form-item label="问题答案" prop="answer">
        <el-input v-model="ruleForm.answer"></el-input>
      </el-form-item>
      
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
export default {
  data() {

    return {
      ruleForm: {
        username:'',
        password:'',
        question:'',
        answer:''
      },
      rules: {
        username: [{required: true, message: '', trigger: 'blur'}],
        password: [{required: true, message: '', trigger: 'blur'}],
        question: [{required: true, message: '', trigger: 'blur'}],
        answer: [{required: true, message: '', trigger: 'blur'}],
      }
    };
  },
  created(){
    this.ruleForm.username=this.$route.query.username
    this.loadData()
  },
  methods: {
    loadData(){
      this.$axios.get('/user/getquestion/'+this.ruleForm.username)
      .then(res=>{
        if(res.data.code==200){
          this.ruleForm.question=res.data.result
        }else{
          /*登陆失败*/
          this.$alert(res.data.message, '提示', {
              confirmButtonText: '确定'
          })
        }
      }).catch(err=>{
        console.log(err)
      })
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post('/user/reset',{
            username:this.ruleForm.username,
            password:this.ruleForm.password,
            answer:this.ruleForm.answer
          }).then(res=>{
            if(res.data.code==200){
              this.$message({
                type: 'success',
                message: "重置成功！",
              });
              this.$router.replace('/login')
            }else{
              this.$message({
                type: 'error',
                message: res.data.message,
              });
            }
          })
        } else {
          this.$message({
            type: 'error',
            message: "请检查输入信息！",
          });
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.el-form{
  margin: auto;
  margin-top:20px;
  width:50%;
}

</style>