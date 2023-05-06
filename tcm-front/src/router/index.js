import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/views/Login'
import Register from '@/views/Register'
import Layout from '@/views/Layout'
import MyInfo from '@/views/MyInfo'
import Reset from '@/views/Reset'

//管理员——————————————————————————————
import Manager from '@/views/Manager'
//用户管理
import UserManagement from '@/views/Manager/UserManagement'
import UserManagementList from '@/views/Manager/UserManagement/List'
import UserManagementInsert from '@/views/Manager/UserManagement/Insert'
import UserManagementDetail from '@/views/Manager/UserManagement/Detail'
import UserManagementUpdate from '@/views/Manager/UserManagement/Update'


//普通用户————————————————————————————————
import OrdinaryUser from '@/views/OrdinaryUser'

Vue.use(Router)

const router = new Router({

  mode: 'history',

  routes: [

    //登录
    {
      path: '/login',
      name: 'login',
      component: Login,
    },

    //注册
    {
      path: '/register',
      name: 'register',
      component: Register,
    },

    //重置密码
    {
      path: '/reset',
      name: 'reset',
      component: Reset,
    },

    //其他界面
    {
      path: '/',
      component: Layout,
      meta:{
        requireAuth:true
      },
      children:[
        //当前用户详情——————————————
        {
          path:'/myinfo',
          name:'myinfo',
          component:MyInfo,
        },
        //管理员
        {
          path:'/manager',
          name:'manager',
          component:Manager,
          children:[
            {
              path:'usermanagement',
              name:'usermanagement',
              component:UserManagement,

              children:[
                {
                  path:'insert',
                  name:'usermanagementinsert',
                  component:UserManagementInsert
                },
                {
                  path:'list',
                  name:'usermanagementlist',
                  component:UserManagementList
                },
                {
                  path:'detail',
                  name:'usermanagementdetail',
                  component:UserManagementDetail
                },
                {
                  path:'update',
                  name:'usermanagementupdate',
                  component:UserManagementUpdate
                },
              ]
            }
          ]
        },
        //普通用户
        {
          path:'/ordinaryuser',
          name:'ordinaryuser',
          component:OrdinaryUser,
          children:[

          ]
        },
      ]
    },
  ]
})

export default router