<template>
  <div >
    <p>{{"Just can see 10 s"}}
      </p>
    {{this.times}}
    <img :src="this.src" alt=""/>
    <meta http-equiv="refresh" content = "10;url = http://localhost:8080/#/Login" >

<!--    <button type="button" class="btn btn-primary"v-on:click="gettim/*;setcookies('localhost:8081/ToPicture')*/">Look</button>-->
  </div>
</template>

<script>
  import pdf from 'vue-pdf'
  export default {
    // components: {
    //   pdf,
    // },
    data() {
      return {
        fileType: 'pdf',
        src:localStorage.getItem('APP'),

        times:'',
        last:'',
      }
    },
mounted() {
      this.gettim()
},

    methods:{
      gettim(){
        this.times=JSON.parse(localStorage.getItem("T")),

        this.last = JSON.parse(localStorage.getItem("last")),
        localStorage.removeItem("T")
        localStorage.removeItem("last")
      }
    },



  }
  </script>

<style scoped>

</style>
