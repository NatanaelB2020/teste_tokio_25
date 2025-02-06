# Teste Tokio 25 - Frontend & Backend

Este repositório contém o código de um teste de vaga de emprego, com duas aplicações principais:

- **Backend**: Aplicação desenvolvida utilizando Spring Boot, Java e banco de dados H2.
- **Frontend**: Aplicação em Vue.js para interação com o backend via APIs REST.

## Descrição do Projeto

O projeto foi desenvolvido para demonstrar o uso de tecnologias modernas para construir uma aplicação web completa. O backend foi desenvolvido utilizando o framework Spring Boot para fornecer uma API RESTful, enquanto o frontend foi criado em Vue.js, com comunicação via chamadas HTTP para consumir os endpoints expostos pelo backend.

---

## Backend (Spring Boot)

### Tecnologias Utilizadas:

- **Spring Boot**: Framework principal utilizado para construir a aplicação backend. Ele fornece uma base simplificada para criar serviços e microserviços RESTful de forma rápida e eficiente.
  
- **Spring Data JPA**: Utilizado para facilitar a integração com o banco de dados relacional, utilizando o conceito de ORM (Object-Relational Mapping). Ele elimina a necessidade de escrever SQL manualmente, gerenciando as operações de banco de dados de maneira eficiente.

- **Banco de Dados H2**: Banco de dados relacional em memória, utilizado para persistir os dados da aplicação. Ideal para testes e desenvolvimento rápido, sem a necessidade de configurar um banco de dados completo.

- **Lombok**: Biblioteca que elimina a necessidade de escrever código repetitivo, como getters, setters, construtores, entre outros, gerando-os automaticamente no código-fonte.

- **JUnit**: Framework de testes utilizado para garantir a qualidade e confiabilidade do código. Ele permite a criação de testes unitários e de integração para verificar se as funcionalidades da aplicação estão funcionando corretamente.

### Como rodar o Backend:

1. Clone o repositório.
2. Navegue até o diretório do projeto e execute o comando:
   ```bash
   mvn spring-boot:run
