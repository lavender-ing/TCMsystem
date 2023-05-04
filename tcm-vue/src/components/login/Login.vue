<template>
    <div id="login">
      <el-form class="login-container" label-position="left" label-width="0px">
        <h3 class="login_title">系统登录</h3>
        <el-form-item>
          <el-input type="text" v-model="loginForm.username"
                    auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="loginForm.password"
                    auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 100%;
        background: #505458;border: none" v-on:click="login">登录</el-button>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 100%;
        background: #505458;border: none" v-on:click="setRegisterDialog">注册</el-button>
        </el-form-item>
        <el-form-item>
        <el-button type="text" @click="setFindPasswordDialog">忘记密码</el-button>
      </el-form-item>
      </el-form>
      <!-- <Register ref="register"></Register>
      <FindPassword ref="findPassword"></FindPassword> -->
    </div>
  </template>
  
  <script>
//   import Register from './Register'
//   import FindPassword from './FindPassword'
  export default {
    name: 'Login',
    data () {
      return {
        loginForm: {
          username: 'admin',
          password: '123',
        },
        responseResult: []
      }
    },
    methods: {
      login () {
        var _this = this // 因为在回调函数中this就是返回的数据了
        console.log(this.$store.state)
      }
    },
    components: {
    //   Register,
    //   FindPassword
    }
  }
  </script>
  
  <style>
    .login-container {
      border-radius: 15px;
      background-clip: padding-box;
      margin: 90px auto;
      width: 350px;
      padding: 35px 35px 15px 35px;
      background: #fff;
      border: 1px solid #eaeaea;
      box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
    #login {
      background:url("../../assets/login.jpg") no-repeat;
      background-position: center;
      height: 100%;
      width: 100%;
      background-size: cover;
      position: fixed;
    }
    body{
      margin: 0px;
      margin-top: -60px;
    }
    /* 去除首页背景图片上方和左方的小空白间隔 */
  </style>
  