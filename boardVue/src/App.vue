<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <div class="nav">
    <a v-for="i in navList" :key="i" href="#">{{ i }}</a>
  </div>
  
  <div class="oneroom">
    <div v-for="(oneroom,i) in oneroom" :key="oneroom">
      <p>{{ oneroom.name }}</p>
      <p>{{ oneroom.price }}만원</p>
      <button @click="addclick(i)">추천</button>
      <span>{{ oneroom.recomend }}</span>
    </div>
  </div>


</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      navList : ['Home', 'about', 'color'],
      oneroom : [
        {
          name : '소원원룸',
          price : 60,
          recomend : 0
        },
        {
          name : '미소원룸',
          price : 30,
          recomend : 0
        },
        {
          name : '창원원룸',
          price : 70,
          recomend : 0
        },
      ],
      
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
</style>
