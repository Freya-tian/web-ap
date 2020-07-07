<template>
    <div class="ToPicture" ref="imageTofile" id="pdfDom" style="padding-top: 55px;background-color:#fff;">
      <el-form ref="form" :model="form" label-width="80px">

        <el-form-item label="">
          <el-input

            type="textarea"
            name="textarea"
            :rows="8"
            placeholder="please enter information"
            v-model="form.textarea">
          </el-input>
        </el-form-item>
        <el-form-item>
         <button type="button" class="btn btn-primary"v-on:click="topdf(),gettime()">ToPDF</button>
          <button type="button" class="btn btn-primary"v-on:click="lookPdf()">LookPDF</button>
<!--          {{this.time}}-->
        </el-form-item>


      </el-form>

    </div>
</template>

<script>
  import layer from 'vue-layer'
  import html2canvas from 'html2canvas'
    export default {
      name: "ToPicture",
      data() {
        return {
          htmlTitle: 'pic',
          imgUrl:'',
          time: new Date(),
          html:'http://localhost:8080/PDF',
          form: {
            textarea: '',
          }
        }
      },
      mounted() {
        this.setcookies(window.location.href)
        // this.Function();
      },
      //
      // beforeDestroy:function(){
      //   if(this.timer){
      //     clearInterval(this.timer);  //在Vue实例销毁前，清除定时器
      //   }
      // },


      methods: {
        topdf(){
          html2canvas(this.$refs.imageTofile).then(canvas => {
            // 转成图片，生成图片地址
             this.imgUrl = canvas.toDataURL("image/png"); //可将 canvas 转为 base64 格式
            // this.imgUrl.replace(/=+$/,'');
            // localStorage.setItem('APP',JSON.stringify(this.imgUrl))
            // console.log(this.imgUrl)
            this.axios({
              method: 'post',
              url: "http://localhost:8090/log",

              data: {URL: JSON.stringify(this.imgUrl)},

            }).then(function (resp) {
              setTimeout(function () {
                alert(resp.data)
              }, 1000)
            })
          })


        },
        lookPdf(){

        this.$router.push('/Login')
        },
       
        setcookies(key) {
          let now = new Date()
          let data = new Date()
          data.setDate(data.getDate() + 5)
          document.cookie = now + key
          console.log(document.cookie)
        },
       
        gettime() {
          localStorage.removeItem("T")

          this.time = new Date().toString()
          // alert(this.time)
          localStorage.setItem("T", JSON.stringify(this.time))
        }
      }
    }



      
</script>

<style scoped>
  .ToPicture{
    width:500px;
    height:300px;
    border:1px solid #DCDFE6;
    margin:150px auto;
    padding: 70px 150px 0px 60px;
    border-radius: 20px;
    box-shadow: 0px 0px 20px #DCDFE6;

  }



</style>
