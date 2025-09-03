<template>
  <div id="userLoginPage">
    <h2 class="title">Login Page</h2>
    <a-form :model="formState" name="basic" autocomplete="off" @finish="handleSubnit">
      <a-form-item name="userAccount" :rules="[{ required: true, message: '请输入账号' }]">
        <a-input v-model:value="formState.userAccount" placeholder="账号" />
      </a-form-item>

      <a-form-item
        name="userPassword"
        :rules="[
          { required: true, message: '请输入密码' },
          { min: 8, message: '密码长度不能小于8位' },
        ]"
      >
        <a-input-password v-model:value="formState.userPassword" placeholder="密码" />
      </a-form-item>
      <div class="tips">
        <RouterLink to="/user/register">注册账号</RouterLink>
      </div>

      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 100%">登录</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
import { userLoginUsingPost } from '@/api/userController'
import router from '@/router'
import { useLoginUserStore } from '@/stores/useLoginUserStore'
import { message } from 'ant-design-vue'
import { reactive } from 'vue'
//接受表单输入值
const formState = reactive<API.UserLoginRequest>({
  userAccount: '',
  userPassword: '',
})

const loginUserStore = useLoginUserStore()

//处理表单提交
const handleSubnit = async (values: any) => {
  try {
    const res = await userLoginUsingPost(values)
    if (res.data.code === 0 && res.data.data) {
      await loginUserStore.fetchLoginUser()
      message.success('登录成功')
      router.push({
        path: '/',
        replace: true,
      })
    } else {
      message.error('登录失败' + res.data.message)
    }
  } catch (error) {
    message.error('登录失败')
  }
}
</script>

<style scoped>
#userLoginPage {
  max-width: 360px;
  margin: 0 auto;
}
.title {
  text-align: center;
  margin-bottom: 20px;
}
.tips {
  text-align: right;
  margin-bottom: 16px;
  font-size: 13px;
}
.desc {
  color: #bbb;
  text-align: center;
  margin-bottom: 20px;
}
</style>
