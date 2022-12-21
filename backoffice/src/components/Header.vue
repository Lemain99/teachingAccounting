<template>
  <header class="global_header">
    <h1>
      Государственное бюджетное профессиональное образовательное учреждение города Москвы <br> 
      «Образовательный комплекс «Юго-Запад» <br> Индивидуальный план педагогического работника
    </h1>
  </header>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
  .global_header{
    padding: 0.5em 0;
    background-color: #2b4e84;
    color: #f2f2f2;
    font-size: 1.4em;
    text-align: center;
    justify-content: center;
 }   
 .global_header h1{
  line-height: 1.4em;
  padding: 0 10em;
  text-align: center;
 }
</style>