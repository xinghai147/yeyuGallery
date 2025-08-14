import { message } from "ant-design-vue";
import router from "./router";
import { useLoginUserStore } from "./stores/useLoginUserStore";

//判断是否首次获取登录用户
let firstFetchLoginUser:boolean = true;

/**
 * 全局权限校验
 */
router.beforeEach(async(to, from, next) => {
  const loginUserStore = useLoginUserStore();
  let loginUser = loginUserStore.loginUser;
  if(firstFetchLoginUser) {
    await loginUserStore.fetchLoginUser();
    loginUser = loginUserStore.loginUser;
    firstFetchLoginUser = false;
  }
  const toUrl = to.fullPath
  //自定义权限校验逻辑
  if(toUrl.startsWith('/admin')) {
    if(!loginUser ||  loginUser.userRole !== 'admin') {
      message.error('您没有权限访问该页面');
      next(`/user/login?redirect=${to.fullPath}`);
      return;
    }
  }
  next();
})