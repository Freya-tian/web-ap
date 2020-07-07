<template>
   <div class="login-box">
     <el-form ref="form" :model="form" :rules="rules" label-width="80px">
       <h2>Welcome</h2>

       <el-form-item label="Password" prop="password">
         <el-input type="password" v-model="form.password"> placeholder="please enter the password" </el-input>
       </el-form-item>
       <el-form-item>
         <el-button type="primary" @click="onSubmit('form')">Submit</el-button>
       </el-form-item>

     </el-form>


   </div>
</template>

<script>

    export default {
        name: "Login",
      data(){
          return{
            form:{
              password:"",
              time:''
            },
            rules:{
              password: [
                { required: true, message: 'please enter the password', trigger: 'blur' },
                { min: 6, max: 20, message: 'Length between 6-20', trigger: 'blur' }
              ],

            }
          }



      },
      mounted() {
          this.setcookies(window.location.href)
      },

      methods:{
        setcookies(key)
        {
          let now = new Date()
          let data = new Date()
          data.setDate(data.getDate() + 5)
          document.cookie = now + key
          console.log(document.cookie)
        },

        onSubmit(formName,time){
          this.$refs[formName].validate((valid) => {
            var vm = this;
            var num=0;
            if (valid) {
              //发送axios请求
              this.axios({
                method:'post',
                url:'http://localhost:8090/login',
                data:{
                  password:vm.form.password
                }
              }).then(function (resp) {
                if(resp.data){
                  // num+=1;
                   alert('success!'  );
                  localStorage.removeItem('APP')
                     setTimeout(function () {
                      localStorage.setItem('APP',resp.data)
                       vm.$router.push('/PDF')
                       vm.setcookies(window.location.href)

                     },1000)
                }else{
                  vm.$message.error('wrong password!!! ')
                }

              })

            } else {
              this.$message.error('wrong password!!! ')
              return false;
            }
          });
        },


      },



    }
</script>

<style scoped>
  .login-box{
    width:500px;
    height:200px;
    border:1px solid #DCDFE6;
    margin:150px auto;
    padding: 60px 50px 20px 30px;
    border-radius: 20px;
    box-shadow: 0px 0px 20px #DCDFE6;


  }

</style>
