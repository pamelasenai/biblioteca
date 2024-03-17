![logo](images/logo.png)

# Projeto Biblioteca
#### _Exercícios da Semana 9 - (11/03/2024 a 15/03/2024)_

## ✏️ Descrição
Este projeto Java baseado em Spring com PostgreSQL e JPA foi desenvolvido como uma solução para as atividades propostas 
pelo professor no contexto de um sistema de biblioteca. <br/>
O objetivo é fornecer uma aplicação robusta para gerenciar o acervo de livros, os membros da biblioteca, os empréstimos 
realizados, os bibliotecários responsáveis e os visitantes eventuais. <br/>

## 📌 Entidades do Projeto
### Livro
- A entidade representa um livro na biblioteca.
- Atributos: id, título, autor, ano de publicação.

### Membro
- Representa um membro da biblioteca, que pode realizar empréstimos.
- Atributos: id, nome, endereço, telefone.

### Empréstimo
- Registra os empréstimos de livros realizados pelos membros.
- Atributos: id, livro (id_livro), membro (id_membro), data de empréstimo, data de devolução.

### Bibliotecário
- Usuário responsável pela gestão do sistema.
- Atributos: id, nome, email, senha.

### Visitante
- Representa um visitante da biblioteca.
- Atributos: id, nome, telefone.

## 📈 Diagrama de Entidade-Relacionamento (MER)
O [diagrama de entidade-relacionamento](images/diagrama-mer.png) pode ser encontrado na pasta images na raiz do projeto.

--- 
## 🎯 Endpoints
### CREATE
- POST ```/livro```: Cria um novo livro.
  * RequestBody: 
    ```json
      {
        "titulo" : "Harry Potter e a pedra filosofal",
        "autor" : "J. K. Rowling",
        "anoPublicacao": 2017
      }
    ```
- POST ```/membros```: Cria um novo membro.
   * RequestBody:
  <!-- TODO: Adicionar JSON -->
- POST ```/empréstimos```: Registra um novo empréstimo.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- POST ```/bibliotecarios```: Cria um novo bibliotecário.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- POST ```/visitantes```: Cria um novo visitante.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->

### READ
As rotas abaixo retornam um array vazio caso não haja cadastrados.
- GET ```/livro```: Obtém a lista completa de livros.
- GET ```/membros```: Obtém a lista completa de membros.
- GET ```/empréstimos```: Obtém a lista completa de empréstimos.
- GET ```/bibliotecarios```: Obtém a lista completa de bibliotecários.
- GET ```/visitantes```: Obtém a lista completa de visitantes.

### DELETE
- DELETE ```/livro/{id}```: Deleta um livro.
- DELETE ```/membros/{id}```: Deleta um membro.
- DELETE ```/empréstimos/{id}```: Deleta um empréstimo.
- DELETE ```/bibliotecarios/{id}```: Deleta um bibliotecário.
- DELETE ```/visitantes/{id}```: Deleta um visitante.

### UPDATE
- PUT ```/livro/{id}```: Atualiza as informações de um livro.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- PUT ```/membros/{id}```: Atualiza as informações de um membro.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- PUT ```/empréstimos/{id}```: Atualiza as informações de um empréstimo.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- PUT ```/bibliotecarios/{id}```: Atualiza as informações de um bibliotecário.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->
- PUT ```/visitantes/{id}```: Atualiza as informações de um visitante.
    * RequestBody:
  <!-- TODO: Adicionar JSON -->

## ✨ Queries de Atualização
Foram criadas queries SQL usando a anotação @Query para atualizar as informações de cada entidade. <br/>
Essas queries utilizam JPQL ou Native Queries. <br/>

## 🚀 Scripts de Criação de Tabelas
- No arquivo 'schema.sql' estão os scripts para criar o banco de dados 'biblioteca' e as tabelas necessárias.
- No arquivo 'data.sql' estão os scripts para inserir pelo menos uma linha de dados para cada tabela.
<!-- TODO: Adicionar link para schema.sql e data.sql -->

--- 
## 📋 Todo List
- [ ] [Exercício 1 - Entidades do projeto](#-m1s09-ex-1---entidades-do-projeto)
- [x] [Exercício 2 - MER](#-m1s09-ex-2---mer)
- [ ] [Exercício 3 - Endpoints CREATE](#-m1s09-ex-3---endpoints-create)
- [ ] [Exercício 4 - Endpoints READ](#-m1s09-ex-4---endpoints-read)
- [ ] [Exercício 5 - Endpoints DELETE](#-m1s09-ex-5---endpoints-delete)
- [ ] [Exercício 6 - Queries UPDATE](#-m1s09-ex-6---queries-update)
- [ ] [Exercício 7 - Endpoints UPDATE](#-m1s09-ex-7---endpoints-update)
- [ ] [Exercício 8 - Scripts de criação de tabelas](#-m1s09-ex-8---scripts-de-criação-de-tabelas)

## 📂 Descrição dos exercícios
### 📖 [M1S09] Ex 1 - Entidades do Projeto
O projeto será baseado nas seguintes Entidades:

- Livro: id, titulo, autor, anoPublicacao
- Membros: id, nome, endereco, telefone
- Empréstimos: id, livro(id_livro), membro(id_membro), dataEmprestimo, dataDevolucao
- Bibliotecario: id, nome, email, senha
- Visitante: id, nome, telefone

### 📖 [M1S09] Ex 2 - MER
Baseado no exercício anterior desenhe as entidades e os relacionamentos entre elas. <br/>
Adicione esse desenho como uma imagem na pasta base do projeto (o diretório raiz).<br/>

### 📖 [M1S09] Ex 3 - Endpoints CREATE
Cria os endpoints POST para cada uma das entidades. <br/>
Lembrando que para empréstimos teremos que receber os ids de um livro e um membro pré-existentes. <br/>
Exemplo de caminho das entidades:

- /livro
- /membros
- /bibliotecarios
- /vistantes
- /emprestimos

### 📖 [M1S09] Ex 4 - Endpoints READ
Cria os endpoints GET para cada uma das entidades. <br/>
Esse get deve retornar uma lista completa dos objetos da entidade que ele representa. <br/>
Os caminhos devem ser os mesmo do exercício CREATE, mas devem ter métodos HTTP diferentes. <br/>

### 📖 [M1S09] Ex 5 - Endpoints DELETE
Cria os endpoints DELETE para cada uma das entidades. <br/>
Se uma tabela tem um relacionamento, ela deve poder ser deletada se o objeto relacionado for deletado primeiro. <br/>
Os caminhos devem ser os mesmo do exercício CREATE, mas devem ter métodos HTTP diferentes. <br/>

### 📖 [M1S09] Ex 6 - Queries UPDATE
Cria queries SQL usando a anotação @‌Query para criar um método update para cada entidade. <br/>
Essas queries devem usar JPQL ou Native Queries. <br/>

### 📖 [M1S09] Ex 7 - Endpoints UPDATE
Cria os endpoints UPDATE para cada uma das entidades, use o método update criado anteriormente. <br/>
Os caminhos devem ser os mesmo do exercício CREATE, mas devem ter métodos HTTP diferentes. <br/>

### 📖 [M1S09] Ex 8 - Scripts de Criação de Tabelas
Crie Scripts para a criação de um banco de dados chamado biblioteca, e adicione os comando para criar o banco de dados e as tabelas.<br/> 
Coloque os scripts no arquivo 'schema.sql'.<br/>
Adicione também scripts para inserir pelo menos uma linha de dados para cada tabela.<br/> 
Coloque os scripts no arquivo 'data.sql'.<br/>