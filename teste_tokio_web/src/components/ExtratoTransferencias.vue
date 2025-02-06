<template>
  <div class="bg-white shadow-lg rounded-lg p-6 max-w-2xl mx-auto mt-10">
    <h2 class="text-2xl font-semibold text-gray-800 mb-6 text-center bg-blue-100 p-4 rounded-md">Extrato de Transferências</h2>
    <div v-if="extrato.length > 0">
      <table class="min-w-full bg-white border-separate border border-gray-200 rounded-lg">
        <thead>
          <tr class="bg-blue-100">
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Conta Origem</th>
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Conta Destino</th>
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Valor</th>
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Taxa</th>
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Data Transferência</th>
            <th class="py-3 px-6 text-sm font-semibold text-gray-600 text-center">Data Agendamento</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in extrato" :key="index" :class="{'bg-gray-100': index % 2 === 0, 'bg-white': index % 2 !== 0}" class="hover:bg-gray-200">
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ item.contaOrigem }}</td>
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ item.contaDestino }}</td>
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ formatCurrency(item.valor) }}</td>
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ formatCurrency(item.taxa) }}</td>
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ formatDate(item.dataTransferencia) }}</td>
            <td class="py-3 px-6 text-sm text-gray-700 text-center">{{ formatDate(item.dataAgendamento) }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <p v-else class="text-gray-500 text-center mt-4">Nenhuma transferência encontrada.</p>
  </div>
</template>

<script>
import transferenciaService from '@/services/transferenciaService';

export default {
  data() {
    return { extrato: [] };
  },
  mounted() {
    transferenciaService.listarTransferencias()
      .then(data => this.extrato = data)
      .catch(() => alert('Erro ao carregar extrato.'));
  },
  methods: {
    formatCurrency(value) {
      return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(value);
    },
    formatDate(date) {
      const d = new Date(date);
      return `${d.getDate().toString().padStart(2, '0')}/${(d.getMonth() + 1).toString().padStart(2, '0')}/${d.getFullYear()}`;
    }
  }
};
</script>

<style scoped>
/* Melhorias na estilização da tabela */
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #e5e7eb; /* Bordas finas e elegantes */
}

th {
  background-color: #e0f7fa; /* Azul bem claro para o título */
}

tr:hover {
  background-color: #f9fafb; /* Cor de hover para linhas */
}

td {
  padding: 10px;
}

tbody tr:nth-child(even) {
  background-color: #f9fafb; /* Linha de cor alternada mais clara */
}

tbody tr:nth-child(odd) {
  background-color: #ffffff; /* Linha de cor alternada branca */
}

tbody tr:hover {
  background-color: #e5e7eb; /* Hover nas linhas */
}

.text-center {
  text-align: center;
}
</style>
