<template>
    <div style="    width:100%;
    height:100%;
    position:relative;
    background-size:cover;">
        <h1>当前证型标注</h1>
        <br>
        <Picture></Picture>
        <br>
        <div style="padding-left: 35%; padding-bottom:10px ;"> <el-button size="mini"  @click="addItem" type="primary">增加新的标记类型</el-button>
    </div>


            <el-form :inline="true" :model="form" >
 <div v-for="(item, index) in form.items" :key="index">     
    <el-form-item label-width="50px">{{index+1}}</el-form-item>
  <el-form-item label="标记名称">
    <el-input v-model="item.name" size="mini"></el-input>
  </el-form-item>

  <el-form-item
        label-width="120px"
        label="已标记数量"
        >
   <el-input-number size="mini" v-model="item.number" @change="handleChange" ></el-input-number>
</el-form-item>
      
 

  <el-form-item>
        <el-button size="mini"  @click="deleteItem(item, index)" type="danger">删除</el-button>
        
    </el-form-item> 
   

       
 
     
</div>
</el-form>
   
    
    </div>
  

    
  </template>
  
  
  <script>
  
  import Picture from '../Note/Picture'
  export default {
  
  
  components: {
      Picture
      },
      data() {
      return {
            form: {
            items:[
             {
                      name: '高血压',
                     number: ''
                      },
                      {
                        name: '糖尿病',
                     number: ''
                }
            ]
        
        },
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
          },
          handleChange(value) {
        console.log(value);
          },
          addItem() {
          var len=this.form.items.length;
            this.form.items.push({
                name: "",
              
                number: "",
            });
           
        },
        deleteItem(item, index) {
            this.form.items.splice(index, 1);
            console.log(this.form.items, "删除");
        },

    }
  
  }
  </script>
  
  <style>
  
  </style>