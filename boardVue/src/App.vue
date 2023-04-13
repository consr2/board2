<template>
  
  <div class="black-bg" v-if="modal == true">
    <div class="white-bg">
      <h4>상세페이지</h4>
      <p>상세 페이지 내용</p>
      <p @click="modal = false">닫기</p>
    </div>

  </div>


  <div class="nav">
    <a v-for="i in navList" :key="i" href="#">{{ i }}</a>
  </div>
  
  <div class="oneroom">
    <div v-for="(oneroom,i) in onerooms" :key="i">
      <img :src="oneroom.image" alt="roomIMG">
      <h4 @click="modal = true">{{ oneroom.title }}</h4>
      <p>{{ oneroom.content }}</p>
      <p>{{ oneroom.price }}만원</p>
    </div>
  </div>


</template>

<script>
import data from './assets/oneroom';

export default {
  name: 'App',
  data(){
    return{
      navList : ['Home', 'about', 'color'],
      modal : false,
      onerooms : data,
    }
  },
  methods:{
    addclick(i){
      this.oneroom[i].recomend += 1;
    }
  },
  components: {
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.nav{
  padding: 15px;
  border-radius: 5px;
  background: rgb(203, 106, 42);
}
.nav a{
  color: #dfd9c6;
  padding: 5px;
}
.oneroom{
  border: 1px;
  border-color: black;
  border-radius: 1px;
}

.black-bg{
  width: 100%; height: 100%;
  background: rgb(0, 0, 0, 0.5);
  position: fixed; padding: 20px;
}
.white-bg{
  width: 100%; background: white;
  border-radius: 8px;
  padding: 20px;
}
</style>
