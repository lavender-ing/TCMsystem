<template>
  <div style="margin:30px">
    <h1>用户注册</h1>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>

      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>

      <el-form-item label="安全问题" prop="question">
        <el-input v-model="ruleForm.question"></el-input>
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

      //验证手机号
      var checkMobile = (rule,value,cb) =>{
        const regMobile = /^(0|86|17951)?(13[0-9]|15[0123456789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        if(regMobile.test(value)){
          //合法
          return cb();
        }
        //不合法
        cb(new Error('请输入合法的手机号！'));
      }

    return {
      ruleForm: {
        username:'',
        password:'',
        phone:'',
        question:'',
        answer:''
      },
      rules: {
        username: [{required: true, message: '', trigger: 'blur'}],
        password: [{required: true, message: '', trigger: 'blur'}],
        phone: [{required: true, message: '', trigger: 'blur'},{validator: checkMobile, trigger: 'blur'}],
        question: [{required: true, message: '', trigger: 'blur'}],
        answer: [{required: true, message: '', trigger: 'blur'}],
      }
    };
  },
  created(){

  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post('/user/register',{
            username:this.ruleForm.username,
            password:this.ruleForm.password,
            character:'普通用户',
            phone:this.ruleForm.phone,
            registertime:new Date(),
            lastlogin:new Date(),
            question:this.ruleForm.question,
            answer:this.ruleForm.answer
          }).then(res=>{
            if(res.data.code==200){
              this.$message({
                type: 'success',
                message: "注册成功！",
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