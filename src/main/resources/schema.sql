--Criar banco de dados
CREATE DATABASE biblioteca;

--Criar tabela bibliotecário
CREATE TABLE bibliotecario(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

--Criar tabela empréstimos
CREATE TABLE emprestimos(
    id BIGSERIAL PRIMARY KEY,
    data_emprestimo VARCHAR(255) NOT NULL,
    data_devolucao VARCHAR(255),
    id_livro BIGINT,
    id_membro BIGINT,
    id_bibliotecario BIGINT,
    FOREIGN KEY (id_livro) REFERENCES livro(id),
    FOREIGN KEY (id_membro) REFERENCES membros(id),
    FOREIGN KEY (id_bibliotecario) REFERENCES bibliotecario(id)
);

--Criar tabela livro
CREATE TABLE livro(
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano_publicacao INTEGER
);

--Criar tabela membros
CREATE TABLE membros(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(255)
);

--Criar tabela visitantes
CREATE TABLE visitante(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255)
);

