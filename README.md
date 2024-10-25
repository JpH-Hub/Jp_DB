---

User Management API

Descrição

A User Management API é uma API RESTful básica desenvolvida com Spring Boot, Groovy e JPA, permitindo realizar operações CRUD (Create, Read, Update, Delete) em usuários. A API suporta operações como criar, listar, atualizar, e excluir usuários, além de filtrar usuários por nome. Toda a lógica de negócio está encapsulada em uma camada de serviço, e o tratamento de exceções é feito com respostas em formato JSON.

Sumário

Funcionalidades

Tecnologias Utilizadas

Instalação

Execução

Endpoints

Exemplos de cURL

Tratamento de Exceções

Contribuições

Licença


Funcionalidades

Criar usuário: Adicionar novos usuários ao sistema.

Listar usuários: Obter a lista de todos os usuários ou filtrar por nome.

Atualizar usuário: Atualizar informações de um usuário existente.

Deletar usuário: Remover um usuário do sistema.

Tratamento de Exceções: Retorno de mensagens de erro no formato JSON com o código HTTP adequado.


Tecnologias Utilizadas

Linguagem: Groovy

Framework: Spring Boot

Persistência: JPA com banco de dados relacional

Banco de Dados: PostgreSQL (pode ser configurado conforme necessário)

Construção: Gradle


Instalação

Pré-requisitos

JDK 8+: Baixar aqui

Gradle: Baixar aqui

PostgreSQL: Banco de dados relacional para armazenar os dados da aplicação.

Docker (opcional): Para rodar o banco de dados PostgreSQL via container.


Passos de Instalação

1. Clone este repositório:

git clone https://github.com/seu-usuario/user-management-api.git
cd user-management-api


2. Configure o arquivo application.yml com as credenciais do banco de dados:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/seu_banco
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update


3. Compile o projeto:

gradle build


4. Execute a aplicação:

gradle bootRun



Execução

Rodando o Banco de Dados no Docker (opcional)

Você pode rodar um container PostgreSQL com Docker para facilitar o setup do ambiente:

docker run --name user-postgres -e POSTGRES_USER=seu_usuario -e POSTGRES_PASSWORD=sua_senha -e POSTGRES_DB=seu_banco -p 5432:5432 -d postgres

Rodando a Aplicação Localmente

Após configurar o banco de dados, basta rodar o comando abaixo para iniciar o servidor local:

gradle bootRun

A aplicação estará disponível em http://localhost:8080.

Endpoints

Base URL: /api/users

Exemplos de cURL

Criar um novo usuário

curl -X POST http://localhost:8080/api/users \
    -H "Content-Type: application/json" \
    -d '{
          "name": "João",
          "email": "joao@email.com"
        }'

Obter todos os usuários

curl -X GET http://localhost:8080/api/users

Obter um usuário específico por ID

curl -X GET http://localhost:8080/api/users/1

Atualizar um usuário

curl -X PUT http://localhost:8080/api/users/1 \
    -H "Content-Type: application/json" \
    -d '{
          "name": "João Silva",
          "email": "joao.silva@email.com"
        }'

Deletar um usuário

curl -X DELETE http://localhost:8080/api/users/1

Tratamento de Exceções

A API retorna erros no formato JSON com as seguintes exceções personalizadas:

UserNotFoundException: Quando um usuário não é encontrado, a resposta será:

{
  "erro": "User not found with id: {id}"
}

InvalidRequestException: Quando a requisição é inválida (ex.: falta de dados obrigatórios), a resposta será:

{
  "erro": "Name and email are required."
}

Exception Genérica: Para erros internos, a resposta será:

{
  "erro": "Ocorreu um erro inesperado."
}


Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias e correções.

Como Contribuir

1. Fork este repositório.


2. Crie uma branch com sua feature (git checkout -b feature/MinhaFeature).


3. Commit suas mudanças (git commit -am 'Adiciona nova feature').


4. Faça o push para a branch (git push origin feature/MinhaFeature).


5. Abra um pull request.



Licença

Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.


---
