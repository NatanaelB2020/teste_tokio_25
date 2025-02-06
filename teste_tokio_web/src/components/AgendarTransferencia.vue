<template>
  <div class="max-w-2xl mx-auto mt-10">
    <h2 class="text-2xl font-semibold text-center mb-6">Agendar Transferência</h2>
    <form @submit.prevent="agendarTransferencia">
      <div class="mb-4">
        <label for="contaOrigem" class="block text-sm font-semibold">Conta Origem:</label>
        <input type="text" v-model="transferencia.contaOrigem" id="contaOrigem" class="border p-2 rounded w-full" required />
      </div>
      <div class="mb-4">
        <label for="contaDestino" class="block text-sm font-semibold">Conta Destino:</label>
        <input type="text" v-model="transferencia.contaDestino" id="contaDestino" class="border p-2 rounded w-full" required />
      </div>
      <div class="mb-4">
        <label for="valor" class="block text-sm font-semibold">Valor:</label>
        <input type="number" v-model="transferencia.valor" id="valor" class="border p-2 rounded w-full" required />
      </div>
      <div class="mb-4">
        <label for="dataTransferencia" class="block text-sm font-semibold">Data de Transferência:</label>
        <input type="date" v-model="transferencia.dataTransferencia" id="dataTransferencia" class="border p-2 rounded w-full" required />
      </div>
      <button type="submit" class="bg-blue-500 text-white px-6 py-2 rounded mt-4 w-full">Agendar</button>
    </form>

    <div v-if="erro" class="mt-4">
      <p style="color: red;">Erro ao agendar transferência</p>
    </div>
  </div>
</template>

<script>
import transferenciaService from '@/services/transferenciaService';

export default {
  data() {
    return {
      transferencia: {
        contaOrigem: '',  // Adicionado
        contaDestino: '', // Adicionado
        valor: 0,
        dataTransferencia: '',
      },
      erro: false,
    };
  },
  methods: {
    agendarTransferencia() {
      transferenciaService.agendarTransferencia(this.transferencia)
        .then(() => {
          alert('Transferência agendada com sucesso!');
          this.transferencia = { contaOrigem: '', contaDestino: '', valor: 0, dataTransferencia: '' }; // Limpa o formulário
        })
        .catch(() => {
          this.erro = true;
        });
    },
  },
};
</script>

<style scoped>
/* Estilo adicional para melhorar o design do formulário */
form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9fafb;
}

input {
  width: 100%;
  margin-top: 8px;
}

button {
  width: 100%;
  cursor: pointer;
}

button:hover {
  background-color: #3182ce;
}

.mb-4 {
  margin-bottom: 16px;
}

.text-sm {
  font-size: 0.875rem;
}

.font-semibold {
  font-weight: 600;
}

input, button {
  font-size: 1rem;
}

/* Ajustando para garantir que o título fique centralizado */
h2 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
