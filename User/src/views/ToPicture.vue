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
         <button type="button" class="btn btn-primary"v-on:click="getPdf(),open()">ToPDF</button>
        </el-form-item>
        <el-form-item>

          <button type="button" class="btn btn-primary"v-on:click="lookPdf">LookPDF</button>
          {{this.time}}
        </el-form-item>

      </el-form>

    </div>
</template>

<script>
  import layer from 'vue-layer'
    export default {
      name: "ToPicture",
      data() {
        return {
          htmlTitle: 'pic',
          time: new Date(),
          html:'http://localhost:8080/PDF',
          form: {
            textarea: '',
          }
        }
      },
      mounted() {
        this.setcookies(window.location.href)
        this.Function();
      },

      beforeDestroy:function(){
        if(this.timer){
          clearInterval(this.timer);  //在Vue实例销毁前，清除定时器
        }
      },


      methods: {
        lookPdf(){
        this.$router.push('/Login')
        },
        open(){

            this.axios({
              method: 'post',
              url: "http://localhost:8090/log",

              data :{ URL : JSON.stringify(this.htmlTitle+".pdf")},

            }).then(function (resp){
            setTimeout(function () {
               alert(resp.data)
            },5000)
            })
        },

        setcookies(key) {
          let now = new Date()
          let data = new Date()
          data.setDate(data.getDate() + 5)
          document.cookie = now + key
          console.log(document.cookie)
        },
        Function(){
          var _this = this; //声明一个变量指向Vue实例this，保证作用域一致
          this.timer = setInterval(function(){
            //设置定时器，每秒执行一次function函数，
            //函数是获取当前时间并给date变量赋值(每秒赋值一次)
            _this.time = new Date();  //修改数据date
          },1000);
        },
        // gettime() {
        //   localStorage.removeItem("T")
        //
        //   this.time = new Date().toString()
        //   // alert(this.time)
        //   localStorage.setItem("T", JSON.stringify(this.time))
        // }
      }
    }


      //   getPdf(){
      //     var title = this.htmlTitle  //DPF标题
      //     console.log(title)
      //     html2Canvas(document.querySelector('#pdfDom'), {
      //       allowTaint: true,
      //       taintTest: false,
      //       useCORS: true,
      //       //width:960,
      //       //height:5072,
      //       dpi: window.devicePixelRatio*4, //将分辨率提高到特定的DPI 提高四倍
      //       scale:4 //按比例增加分辨率
      //     }).then(function (canvas) {
      //         let contentWidth = canvas.width
      //         let contentHeight = canvas.height
      //         let pageHeight = contentWidth / 592.28 * 841.89
      //         let leftHeight = contentHeight
      //         let position = 0
      //         let imgWidth = 595.28
      //         let imgHeight = 592.28 / contentWidth * contentHeight
      //         let pageData = canvas.toDataURL('image/jpeg', 1.0)
      //         let PDF = new JsPDF('', 'pt', 'a4')
      //         if (leftHeight < pageHeight) {
      //           PDF.addImage(pageData, 'JPEG', 0, 0, imgWidth, imgHeight)
      //         } else {
      //           while (leftHeight > 0) {
      //             PDF.addImage(pageData, 'JPEG', 0, position, imgWidth, imgHeight)
      //             leftHeight -= pageHeight
      //             position -= 841.89
      //             if (leftHeight > 0) {
      //               PDF.addPage()
      //             }
      //           }
      //         }
      //
      //         PDF.save( title+'.pdf')
      //         var buffer = PDF.output('datauristring')
      //         var pdfName = title + ".pdf"
      //
      //         // 将base64格式的字符串转换为file文件
      //         var myfile = this.dataURLtoFile(buffer, pdfName)
      //         console.log( pdfName )
      //         var formdata = new FormData()
      //         formdata.append(name, myfile)
      //       }
      //     )
      //   },
      //   dataURLtoFile(dataurl, filename) {
      //     var arr = dataurl.split(',');
      //     var mime = arr[0].match(/:(.*?);/)[1];
      //     var bstr = atob(arr[1]);
      //     var n = bstr.length;
      //     var u8arr = new Uint8Array(n);
      //     while(n--){
      //       u8arr[n] = bstr.charCodeAt(n);
      //     }
      //     //转换成file对象
      //     return new File([u8arr], filename, {type:mime});
      //     //转换成成blob对象
      //     //return new Blob([u8arr],{type:mime});
      //   }
      // }

   // }
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

