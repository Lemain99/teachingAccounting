<template>
  <div class="left-nav">
    <p><router-link to="/users">Пользователи</router-link></p>
    <p><router-link to="/academic-work">Справочники</router-link></p>
    <p><router-link to="/academic-work">Учебная работа</router-link></p>
    <p><router-link to="/academ-method">Учебно-методическая работа</router-link></p>
    <p><router-link to="/organiz-method">Организационно-методическая работа</router-link></p>
    <p><router-link to="/scien-method">Научно-методическая работа</router-link></p>
    <p><router-link to="/academic-product-work">Учебно-производственная работа</router-link></p>
    <p><router-link to="/educate-work">Воспитательная работа</router-link></p>
    <p><router-link to="/promotion-qualific-lvl">Повышение уровня квалификации</router-link></p>
  </div>
</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>
.left-nav {
  width: 300px;
  font-size: 1.1em;
  text-align: center;
  justify-content: center;
  border-left: #282828;
}
.left-nav > p {
  margin-top: 10px;
}
</style>