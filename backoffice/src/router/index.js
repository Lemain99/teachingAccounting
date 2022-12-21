import {createRouter, createWebHistory} from 'vue-router'
import UsersView from "../view/UsersView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/users',
      alias: '/users',
      name: 'users',
      component: UsersView
    },


  ]
})

export default router
