<template>
  <div class="pdf" v-show="fileType == 'pdf'">
    <h3 >{{times}}</h3>
    <pdf :src="src" > // 加载事件

    </pdf>
<!--    <button type="button" class="btn btn-primary"v-on:click="gettim/*;setcookies('localhost:8081/ToPicture')*/">Look</button>-->
  </div>
</template>

<script>
  import pdf from 'vue-pdf'



  export default {

    components: {

      pdf,

    },
    data() {
      return {
        fileType: 'pdf',
        src: '/static/pic.pdf',
        times:'',

      }
    },
    mounted() {
      this.gettim()
    },

    methods:{
      gettim(){
        this.times=JSON.parse(localStorage.getItem("T")),


        localStorage.removeItem("T")
      }
    },



  }
  </script>

<style scoped>

</style>
