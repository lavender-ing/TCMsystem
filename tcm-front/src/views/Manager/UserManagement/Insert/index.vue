<template>
  <div>
    <el-page-header @back="goBack" content="新增用户" style="margin:20px;"></el-page-header>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>

      <el-form-item label="用户密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>

      <el-form-item label="角色" prop="character">
        <el-select v-model="ruleForm.character" placeholder="请选择">
          <el-option
            v-for="item in types"
            :key="item.value"
            :label="item.value"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>

      <el-form-item label="密保问题" prop="question">
        <el-input v-model="ruleForm.question"></el-input>
      </el-form-item>

      <el-form-item label="密保答案" prop="answer">
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
      types:[
        {
          value:'医务人员',
        },
        {
          value:'管理员'
        }
      ],
      ruleForm: {
        username:'',
        password:'',
        character:'医务人员',
        phone:'',
        question:'',
        answer:'',
      },
      rules: {
        username: [{required: true, message: '', trigger: 'blur'}],
        password: [{required: true, message: '', trigger: 'blur'}],
        character: [{required: true, message: '', trigger: 'blur'}],
        phone: [{required: true, message: '', trigger: 'blur'}],
        question: [{required: true, message: '', trigger: 'blur'}],
        answer: [{required: true, message: '', trigger: 'blur'}],
      }
    };
  },
  created(){
    
  },
  methods: {
    goBack(){
      this.$router.back()
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post('/user/register',{
            username:this.ruleForm.username,
            password:this.ruleForm.password,
            character:this.ruleForm.character,
            phone:this.ruleForm.phone,
            question:this.ruleForm.question,
            answer:this.ruleForm.answer,
            registertime:new Date(),
            lastlogin:new Date(),
          }).then(res=>{
            if(res.data.code==200){
              this.$message({
                type: 'success',
                message: "添加成功！",
              });
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
    },
  }
}
</script>

<style scoped>
.el-form{
  margin: auto;
  margin-top:20px;
  width:50%;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}

</style>