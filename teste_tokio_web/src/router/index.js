import { createRouter, createWebHistory } from 'vue-router';
import AgendarTransferencia from '@/components/AgendarTransferencia.vue';
import ExtratoTransferencias from '@/components/ExtratoTransferencias.vue'; 

const routes = [
  { path: '/', component: AgendarTransferencia },
  { path: '/extrato', component: ExtratoTransferencias }
];

const router = createRouter({
  history: createWebHistory(),  
  routes
});

export default router;
