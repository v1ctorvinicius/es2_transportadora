INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Ana Luiza', 'rua da manga quadra 8', '(98) 98666-4321');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Ana Silva', 'Rua das Flores, 123', '(11) 98765-4321');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('José Santos', 'Avenida do Sol, 456', '(21) 3456-7890');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Mariana Oliveira', 'Praça da Liberdade, 789', '(31) 2345-6789');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Lucas Pereira', 'Rua das Palmeiras, 321', '(41) 7654-3210');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Isabella Costa', 'Avenida Copacabana, 876', '(71) 8901-2345');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Rafael Almeida', 'Estrada do Samba, 654', '(81) 2345-5678');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Larissa Lima', 'Praia da Esperança, 987', '(51) 6789-1234');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Gustavo Souza', 'Rua do Maracanã, 234', '(61) 4321-7654');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Carolina Santos', 'Avenida da Sereia, 543', '(85) 5678-9876');
INSERT INTO cliente (nome, endereco, telefone)
VALUES ('Fernando Rodrigues', 'Praça da Corcovado, 765', '(91) 1234-5678');

INSERT INTO frete (codigo_cidade, codigo_cliente, descricao, peso, valor)
VALUES (1, 1, 'Frete 1', 50.5, 150.0),
       (2, 1, 'Frete 2', 75.2, 220.5),
       (3, 1, 'Frete 3', 45.0, 130.2),
       (4, 1, 'Frete 4', 30.5, 95.0),
       (5, 1, 'Frete 5', 80.0, 250.5),
       (1, 2, 'Frete 6', 40.2, 120.0),
       (2, 3, 'Frete 7', 55.5, 180.2),
       (3, 4, 'Frete 8', 70.0, 210.5),
       (4, 5, 'Frete 9', 65.8, 200.0),
       (5, 6, 'Frete 10', 90.0, 350.5);

INSERT INTO cidade (nome, UF, taxa)
VALUES ('São Paulo', 'SP', 2.5),
       ('Belo Horizonte', 'MG', 1.8),
       ('Salvador', 'BA', 1.3),
       ('Porto Alegre', 'RS', 1.6),
       ('Manaus', 'AM', 2.0),
       ('Curitiba', 'PR', 1.2),
       ('Goiânia', 'GO', 1.5),
       ('Brasília', 'DF', 1.7),
       ('Belém', 'PA', 1.4),
       ('Campinas', 'SP', 2.2);