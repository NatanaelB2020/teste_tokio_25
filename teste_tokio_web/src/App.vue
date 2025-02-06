<template>
  <div class="flex h-screen bg-gray-100">
    <!-- Menu Lateral -->
    <aside class="w-64 bg-blue-200 text-white p-6 border-r-2 border-gray-300">
      <h2 class="text-2xl font-bold text-center mb-6">Banco Digital</h2>
      <nav>
        <ul>
          <li class="mb-4">
            <router-link 
              to="/" 
              class="menu-item"
              :class="{ 'bg-blue-300': isActive('/') }"
              @click="setActive('/')"
            >
              Agendar Transferência
            </router-link>
          </li>
          <li>
            <router-link 
              to="/extrato" 
              class="menu-item"
              :class="{ 'bg-blue-300': isActive('/extrato') }"
              @click="setActive('/extrato')"
            >
              Extrato
            </router-link>
          </li>
        </ul>
      </nav>
    </aside>

    <!-- Conteúdo Principal -->
    <main class="flex-1 p-8 overflow-auto">
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeRoute: '/'
    };
  },
  methods: {
    setActive(route) {
      this.activeRoute = route;
    },
    isActive(route) {
      return this.activeRoute === route;
    }
  }
};
</script>

<style scoped>
/* Estilização para garantir que o menu lateral e conteúdo principal fiquem bem alinhados */
.flex {
  display: flex;
}

h2 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center; /* Centraliza o texto horizontalmente */
}

aside {
  min-width: 240px; /* Ajuste da largura do menu lateral */
  height: 100vh; /* A altura será 100% da tela */
  position: fixed; /* Fixa o menu na tela */
  border-right: 2px solid #e5e7eb; /* Adiciona uma borda para separar o menu */
  background-color: #93c5fd; /* Azul claro para o menu lateral */
  display: flex;
  flex-direction: column; /* Empilha os itens verticalmente */
  justify-content: flex-start; /* Alinha os itens na parte superior */
}

main {
  margin-left: 240px; /* Compensa a largura do menu lateral */
  width: 100%;
  padding: 20px;
  background-color: #f9fafb;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 15px;
}

.menu-item {
  display: block;
  padding: 12px 20px;
  text-decoration: none;
  color: white;
  border-radius: 4px;
  width: 100%; /* Faz com que o link ocupe toda a linha */
}

.menu-item:hover {
  background-color: #bfd9fc; /* Azul ainda mais claro para o hover */
}

.bg-blue-300 {
  background-color: #60a5fa; /* Azul mais claro para o item ativo */
}
</style>
