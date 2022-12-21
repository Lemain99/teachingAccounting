<template>
    <div class="authorization">
        <div class="guest">
            <a href="#">Гость</a>
        </div>
        <div class="auth">
          <p><router-link to="/authorization">Вход</router-link></p>
        </div>
        <div class="auth">
          <p><router-link to="/registration">Регистрация</router-link></p>
        </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "Auth"
  }
  </script>
  
  <style scoped>
    .authorization{
        background-color: #3e65a0;
        color: white;
        padding: 10px;
        text-align: right;
    }
    .authorization a{
        color: white;
    }
    .guest{
        padding: 0.4em 0.1em;
        border-radius: 8px;
        display: inline;
    }
    .auth{
        margin: 0.2em 0.4em;
        padding: 0.4em 0.5em;
        background-color: #343434;
        border-radius: 8px;
        display: inline-block;
        font: bold;
    }
  </style>