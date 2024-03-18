--Inserir dados na tabela bibliotecário
INSERT INTO bibliotecario (nome, email, senha)
VALUES
    ('João Silva', 'joao@example.com', 'senha123'),
    ('Maria Santos', 'maria@example.com', 'senha456'),
    ('Carlos Oliveira', 'carlos@example.com', 'senha789'),
    ('Ana Pereira', 'ana@example.com', 'senhaabc'),
    ('Lucas Mendes', 'lucas@example.com', 'senhaxyz');

--Inserir dados na tabela empréstimos
INSERT INTO emprestimos (data_emprestimo, data_devolucao, id_livro, id_membro, id_bibliotecario)
VALUES
    ('18/03/2024', '25/03/2024', 1, 5, 4),
    ('19/03/2024', '26/03/2024', 2, 1, 5),
    ('20/03/2024', '27/03/2024', 3, 2, 1),
    ('21/03/2024', '28/03/2024', 4, 3, 2),
    ('22/03/2024', '29/03/2024', 5, 4, 3);

--Inserir dados na tabela livro
INSERT INTO livro (titulo, autor, ano_publicacao)
VALUES
    ('Dom Casmurro', 'Machado de Assis', 1899),
    ('Memórias Póstumas de Brás Cubas', 'Machado de Assis', 1881),
    ('O Príncipe', 'Nicolau Maquiavel', 1532),
    ('1984', 'George Orwell', 1949),
    ('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 1943);

--Inserir dados na tabela membros
INSERT INTO membros (nome, endereco, telefone)
VALUES
    ('Maria Oliveira', 'Rua das Flores, 123', '(48) 98765-4321'),
    ('Paulo Santos', 'Avenida Central, 456', '(48) 91234-5678'),
    ('Carla Lima', 'Travessa das Palmeiras, 789', '(48) 94567-8901'),
    ('Ricardo Mendes', 'Rua das Águias, 101', '(48) 97890-1234'),
    ('Amanda Pereira', 'Avenida dos Pássaros, 202', '(48) 93456-7890');


--Inserir dados na tabela visitantes
INSERT INTO visitante (nome, telefone)
VALUES
    ('Pedro Souza', '(48) 99876-5432'),
    ('Camila Oliveira', '(48) 98765-4321'),
    ('Felipe Santos', '(48) 97654-3210'),
    ('Sara Lima', '(48) 96543-2109'),
    ('Lucas Pereira', '(48) 95432-1098');