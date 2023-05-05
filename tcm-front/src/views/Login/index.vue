<template>
  <div class="root">
    <el-card class="login-form-layout">
      <el-form
        autocomplete="on"
        :model="loginForm"
        ref="loginForm"
        label-position="left"
      >
        
        <h2 class="login-title color-main">中医系统</h2>
        <br>

        <el-form-item prop="username">
          <el-input
            name="username"
            type="text"
            v-model="loginForm.username"
            autocomplete="on"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input
            name="password"
            :type="pwdType"
            v-model="loginForm.password"
            autocomplete="on"
            placeholder="请输入密码"
          >
          </el-input>
        </el-form-item>

        <el-form-item style="margin-bottom: 10px">
          <el-button
            style="width: 100%"
            type="primary"
            :loading="loading"
            @click.native="login"
          >登录</el-button>
        </el-form-item>

        <el-form-item style="margin-bottom: 10px">
          <el-button
            style="width: 100%"
            type="primary"
            :loading="loading"
            @click.native="register"
          >注册</el-button>
        </el-form-item>

        <el-form-item style="margin-bottom: 10px">
          <el-button
            style="width: 100%"
            type="primary"
            :loading="loading"
            @click.native="reset"
          >重置密码</el-button>
        </el-form-item>
        
      </el-form>
    </el-card>
  </div>
</template>
 
<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "admin",
        password: "123456"
      },
      loading: false,
      pwdType: "password",
    };
  },
  created(){
    //若store中已有登录信息则直接跳转
    if(this.$store.state.isLogin){
      this.$router.replace('/')
    }
  },
  methods: {
    //登录
    login() {
      this.$axios.get('/user/login',{
        params:{
          username:this.loginForm.username,
          password:this.loginForm.password
        }
      }).then(res=>{
          /*登陆成功*/
        if(res.data.code==200){
          this.$store.commit('login',{
            user:res.data.result,
            isLogin:true
          })
          if(res.data.result.character=='管理员'){
            this.$router.replace('/manager')
          }else{
            this.$router.replace('/ordinaryuser')
          }
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
    //注册
    register(){
      this.$router.push('/register')
    },
    //重置密码
    reset(){
      this.$router.push({
        path:'/reset',
        query:{
          username:this.loginForm.username
        }
      })
    }
  }
};
</script>
 
<style scoped>
.root {
  background:url("../../assets/login.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

.login-form-layout {
  /* position: absolute;
  left: 0;
  right: 0;
  width: 360px;
  margin: 140px auto;
  border-top: 10px solid #409eff; */
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
 
.login-title {
  text-align: center;
}
 
.login-center-layout {
  background: #409eff;
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
  margin-top: 200px;
}
</style>