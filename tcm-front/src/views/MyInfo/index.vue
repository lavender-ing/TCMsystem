<template>
  <div>
    
    <el-upload
      class="avatar-uploader"
      action="http://localhost:8081/upload/file"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
      style="margin:50px;">
      <img v-if="ruleForm.picturepath" :src="`http://localhost:8081/`+ruleForm.picturepath" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="用户ID" prop="id">
        <el-input v-model="ruleForm.id" disabled></el-input>
      </el-form-item>

      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username" disabled></el-input>
      </el-form-item>

      <el-form-item label="用户密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>

      <el-form-item label="角色" prop="character">
        <el-input v-model="ruleForm.character" disabled></el-input>
      </el-form-item>

      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>

      <el-form-item label="邮箱" prop="mail">
        <el-input v-model="ruleForm.mail"></el-input>
      </el-form-item>

      <el-form-item label="住址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>

      <el-form-item label="用户性别" prop="sex">
        <el-radio-group v-model="ruleForm.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="安全问题" prop="question">
        <el-input v-model="ruleForm.question"></el-input>
      </el-form-item>

      <el-form-item label="问题答案" prop="answer">
        <el-input v-model="ruleForm.answer"></el-input>
      </el-form-item>

      <el-form-item label="注册时间" prop="registertime">
        <el-input v-model="ruleForm.registertime" disabled></el-input>
      </el-form-item>

      <el-form-item label="上次登录" prop="lastlogin">
        <el-input v-model="ruleForm.lastlogin" disabled></el-input>
      </el-form-item>
      
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import dateformat from '@/utils/dateformat';
export default {
  data() {

    //验证邮箱
    var checkEmail = (rule,value,cb) => {
      const regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
      if(regEmail.test(value)){
        //合法
        return cb();
      }
      //不合法
      cb(new Error('请输入合法的邮箱！'));
    }

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

      },
      rules: {
        id: [{required: true, message: '', trigger: 'blur'}],
        username: [{required: true, message: '', trigger: 'blur'}],
        password: [{required: true, message: '', trigger: 'blur'}],
        character: [{required: true, message: '', trigger: 'blur'}],
        phone: [{required: true, message: '', trigger: 'blur'},{validator: checkMobile, trigger: 'blur'}],
        mail: [{required: true, message: '', trigger: 'blur'},{validator: checkEmail, trigger: 'blur'}],
        address: [{required: true, message: '', trigger: 'blur'}],
        sex: [{required: true, message: '', trigger: 'blur'}],
        lastlogin: [{required: true, message: '', trigger: 'blur'}],
        registertime: [{required: true, message: '', trigger: 'blur'}],
        question: [{required: true, message: '', trigger: 'blur'}],
        answer: [{required: true, message: '', trigger: 'blur'}],
      },
    };
  },
  created(){
    this.ruleForm=this.$store.state.user
    this.ruleForm.registertime=dateformat.format(this.ruleForm.registertime)
    this.ruleForm.lastlogin=dateformat.format(this.ruleForm.lastlogin)
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.put('/user/update',{
            id:this.ruleForm.id,
            username:this.ruleForm.username,
            password:this.ruleForm.password,
            character:this.ruleForm.character,
            phone:this.ruleForm.phone,
            mail:this.ruleForm.mail,
            address:this.ruleForm.address,
            sex:this.ruleForm.sex,
            picturepath:this.ruleForm.picturepath,
            question:this.ruleForm.question,
            answer:this.ruleForm.answer
          }).then(res=>{
            if(res.data.code==200){
              this.$message({
                type: 'success',
                message: "更新成功！",
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
    //图片上传
    handleAvatarSuccess(res, file) {
      this.ruleForm.picturepath=res.result
      this.$store.commit('changeProfile',{
        picturepath:res.result
      })
    },

    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
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