<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Академический год</p>
            <div class="form-border">
                <select name="year">
                    <option value="option0">2021/2022</option>
                    <option value="option1">2022/2023</option>
                    <option value="option2">2023/2024</option>
                    <option value="option3">2024/2025</option>
                    <option value="option4">2025/2026</option>
                    <option value="option5">2026/2027</option>
                </select>
            </div>
        </div>
        <div class="article">
            <p class="main-p">Новая запись</p>
            <div class="form-border">
                <p>Специальность</p>
                <select v-model="model.specialization">
                    <option disabled value="">Выберите специальность</option>
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization">{{specialization.specialization}}</option>
                </select>
                <p>Наименование кабинета</p>
                <select>
                  <option value=""></option>
                </select>
                <p>Вид деятельности</p>
                <select v-model="model.activityType">
                    <option disabled value="">Выберите вид деятельности</option>
                    <option v-for="activityType in GET_ENUMS().ActivityType" :key="activityType" :value="activityType">{{$t('enum.ActivityType.' + activityType)}}</option>
                </select><br>
                <p>Вид УПД</p>
                <select>
                    <option value=""></option>
                </select><br>
                <p>Дата</p>
                <input type="text">
                <button @click="addAcademicProduct()">Добавить</button> 
            </div>    
        </div>
        <div class="export">
            <div class="form-border">
                <button><img src="../../../assets/img/print.png"> Версия для печати</button>
                <button class="last-button"><img src="../../../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations} from 'vuex';
import AcademicProduct from "../../../model/academicProduction";

export default{
    name: "AcaProdWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: 1,
          specialization: '',
          activityType: ''
        },
        
      }
    },
    methods: {
    ...mapActions([
      'LOAD_ENUMS',
      'LOAD_SPECIALIZATION',
      'UPLOAD_ACADEMIC_PRODUCTION'
    ]),
    ...mapMutations([
        'ADD_ACADEMIC_PRODUCTION'
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_ALL_SPECIALIZATIONS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    ]),

    addAcademicProduct(){
      let product = new AcademicProduct(
          this.id,
          this.model.specialization,
          this.model.activityType,
      )
      this.UPLOAD_ACADEMIC_PRODUCTION(product)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_SPECIALIZATION()
    //this.
  },

}

</script>

