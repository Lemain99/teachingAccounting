<script setup>
import Navbar from "./components/Navbar.vue";
import Header from "./components/Header.vue";
import Auth from "./components/Auth.vue";
</script>

<template>

  <div class="wrapper">
    <Auth/>
    <Header/>
    <Navbar/>
    <RouterView/>
  </div>

</template>

<style scoped>
.wrapper {
  grid-template-areas: "left-nav table table";
  background-color: #e1e1e1;
}
Navbar {
  grid-area: left-nav;
}
</style>
