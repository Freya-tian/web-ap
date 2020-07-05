import Vue from 'vue'
import Router from 'vue-router'

import ToPicture from "../views/ToPicture";
import Login from "../views/Login";
import PDF from "../views/PDF";
Vue.use(Router)

const router = new Router({
   routes: [
     {
       path: '/',
       redirect:'/ToPicture'

     },


    {
      path: '/ToPicture',
      name: 'ToPicture',
      component: ToPicture,

    },
    {
      path: '/Login',
      name: 'Login',
      component:Login
    },

    {
      path: '/PDF',
      name: 'PDF',
      component: PDF,
      meta:{needlogin: true}

    }
  ],

})
router.beforeEach((to, from, next) => {
  console.log(to);
  console.log(from);
  if (to.meta.needlogin) { // 判断该路由是否需要登录权限

    if(JSON.parse(localStorage.getItem('islogin'))){ //判断本地是否存在access_token
      next();
    }else {
      next({
        path:'/Login'
      })
    }
  }
  else {
    next();
  }
  /*如果本地 存在 token 则 不允许直接跳转到 登录页面*/
  if(to.fullPath == "/Login"){
    if(JSON.parse(localStorage.getItem('islogin'))){
      next({
        path:from.fullPath
      });
    }else {
      next();
    }
  }
});
export default router;

