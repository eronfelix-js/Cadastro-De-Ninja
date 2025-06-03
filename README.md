# 🥷 Cadastro de Ninjas

Projeto desenvolvido com **Java**, **Spring Boot**, **Thymeleaf** e **H2 Database**, com o objetivo de realizar o cadastro completo de ninjas. A aplicação permite **criar**, **listar**, **atualizar** e **deletar** informações de ninjas.

## 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
- Thymeleaf
- Maven

## 📋 Funcionalidades

- ✅ Cadastro de novos ninjas  
- ✅ Listagem de todos os ninjas cadastrados  
- ✅ Edição das informações de um ninja existente  
- ✅ Exclusão de ninjas  
- ✅ Interface web com Thymeleaf

## 🗃️ Modelo de dados

A entidade `Ninja` possui os seguintes campos:

- `id` (Long): identificador único
- `nome` (String): nome do ninja
- `vila` (String): vila de origem
- `rank` (String): rank ninja (Genin, Chunin, Jounin, etc.)

## 💻 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cadastro-de-ninjas.git
   cd cadastro-de-ninjas
