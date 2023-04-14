<template>
  <div class="container my-5">
    <main class="form-signin w-50 m-auto">
      <form>
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        
        <div class="form-floating">
          <input class="form-control" id="floatingInput" placeholder="name@example.com" v-model="state.form.name">
          <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="state.form.password">
          <label for="floatingPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" @click="submit()">Sign in</button>
      </form>
    </main>
  </div>
</template>

<script>
import { reactive } from 'vue'
import axios from 'axios'

export default {
  name: 'Login',
  setup(){
    const state = reactive({
      form:{
        name:"",
        password:""
      }
    })

    const submit = ()=>{
      axios({
        method:'GET',
        url:'/api/v1/login',
        params: state.form,
        headers:{'Content-Type': 'application/json'}
      }).then((res)=>{
        console.log(res)
        alert(res.data)
      })
  
    }

  

    return {state, submit}
  }
}

</script>

<style scoped>

</style>

