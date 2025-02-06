import api from './api';

export default {
  // Método para agendar transferência com payload correto
  agendarTransferencia(transferencia) {
    console.log("Payload enviado:", transferencia); // Mostra o payload recebido
    return api.post('/agendar', transferencia)
      .then(response => response.data)
      .catch(error => {
        console.error('Erro ao agendar transferência:', error);
        throw error; // Propaga o erro para o componente Vue
      });
  },

  // Método para listar transferências
  listarTransferencias() {
    return api.get('/extrato')
      .then(response => response.data)
      .catch(error => {
        console.error('Erro ao listar transferências:', error);
        throw error;
      });
  },
};
