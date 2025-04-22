/*CREATE DATABASE DbMyFinance;
USE DbMyFinance;
SHOW TABLES;*/

CREATE TABLE usuario (
    cdUsuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    dataDeNascimento DATE NOT NULL
);

CREATE TABLE bancos (
    codigoBanco BIGINT AUTO_INCREMENT PRIMARY KEY,
    nomeDoBanco VARCHAR(100)
);

CREATE TABLE contaBancaria (
    cdContaBancaria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nmContaBancaria VARCHAR(50) NOT NULL,
    idTipoDaConta INT NOT NULL,
    cdUsuarioConta BIGINT NOT NULL,
    cdBanco BIGINT NULL,
    FOREIGN KEY (cdUsuarioConta) REFERENCES usuario(cdUsuario),
    FOREIGN KEY (cdBanco) REFERENCES bancos(codigoBanco)
);


CREATE TABLE tipoRenda (
    cdTipoRenda BIGINT AUTO_INCREMENT PRIMARY KEY,
    dsRenda VARCHAR(50) NOT NULL,
    idVigente INT NOT NULL
);

CREATE TABLE tipoDespesa (
    cdTipoDespesa BIGINT AUTO_INCREMENT PRIMARY KEY,
    dsDespesa VARCHAR(50) NOT NULL,
    idVigente INT NOT NULL
);

CREATE TABLE receita (
    cdReceita BIGINT AUTO_INCREMENT PRIMARY KEY,
    cdContaBancaria BIGINT NOT NULL,
    cdTipoReceita BIGINT NOT NULL,
    dsReceita VARCHAR(100) NOT NULL,
    valorRenda DOUBLE NOT NULL,
    dataRenda DATE NOT NULL,
    observacaoRenda VARCHAR(255),
    repetir CHAR(1) NOT NULL,
    dataCriacao DATE NOT NULL,
    FOREIGN KEY (cdContaBancaria) REFERENCES contaBancaria(cdContaBancaria),
    FOREIGN KEY (cdTipoReceita) REFERENCES tipoRenda(cdTipoRenda)
);

CREATE TABLE despesa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dsDespesa VARCHAR(255) NOT NULL,
    valorDespesa DECIMAL(10, 2) NOT NULL,
    dataDespesa DATE NOT NULL,
    cdTipoDespesa BIGINT NOT NULL,
    cdContaBancaria BIGINT NOT NULL,
    observacoes VARCHAR(500),
    idRepetir BOOLEAN NOT NULL,
    FOREIGN KEY (cdContaBancaria) REFERENCES contaBancaria(cdContaBancaria),
    FOREIGN KEY (cdTipoDespesa) REFERENCES tipoDespesa(cdTipoDespesa)
);

CREATE TABLE cartao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nmCartao VARCHAR(100) NOT NULL,
    dsCartao VARCHAR(255) NOT NULL,
    cdContaCartao BIGINT NOT NULL,
    idTipoCartao INT NOT NULL,
    idVigente INT NOT NULL,
    FOREIGN KEY (cdContaCartao) REFERENCES contaBancaria(cdContaBancaria)
);

/*
-- Inserindo usuário admin primeiro
INSERT INTO usuario (usuario, senha, dataDeNascimento)
VALUES ('admin', 'senha123', '1990-01-01');

-- Inserindo demais usuários
INSERT INTO usuario (usuario, senha, dataDeNascimento) VALUES 
('joao_silva', 'senha123', '1990-05-15'),
('maria_oliveira', 'senha456', '1985-08-20'),
('carlos_santos', 'senha789', '1995-02-10');

-- Inserindo Bancos
INSERT INTO bancos (nomeDoBanco) VALUES 
('Banco do Brasil'),
('Caixa Econômica Federal'),
('Itaú'),
('Bradesco'),
('Nubank');

-- Inserindo tipos de renda
INSERT INTO tipoRenda (dsRenda, idVigente) VALUES 
('Salário', 1),
('Freelance', 1),
('Aluguel', 1),
('Investimentos', 1);

-- Inserindo tipos de despesa
INSERT INTO tipoDespesa (dsDespesa, idVigente) VALUES 
('Alimentação', 1),
('Transporte', 1),
('Lazer', 1),
('Saúde', 1),
('Educação', 1),
('Moradia', 1);

-- Inserindo contas bancárias associadas aos usuários
INSERT INTO contaBancaria (nmContaBancaria, idTipoDaConta, cdUsuarioConta, cdBanco) VALUES 
('Conta Admin', 1, 1, 3), -- Admin com conta no Itaú
('Conta Corrente João', 1, 2, 1),
('Conta Poupança Maria', 2, 3, 2),
('Conta Digital Carlos', 1, 4, 5);

-- Inserindo receitas
INSERT INTO receita (cdContaBancaria, cdTipoReceita, dsReceita, valorRenda, dataRenda, observacaoRenda, repetir, dataCriacao) VALUES 
(1, 1, 'Salário Admin', 10000.00, '2025-03-01', 'Pagamento mensal', 'N', '2025-03-01'),
(1, 4, 'Investimentos', 2000.00, '2025-03-10', 'Lucros da bolsa', 'N', '2025-03-10'),
(2, 1, 'Salário mensal', 5000.00, '2025-03-01', 'Salário recebido', 'N', '2025-03-01'),
(3, 3, 'Aluguel apartamento', 1200.00, '2025-03-05', 'Aluguel recebido', 'N', '2025-03-05'),
(4, 2, 'Freelance site', 800.00, '2025-03-10', 'Pagamento por site desenvolvido', 'N', '2025-03-10');

-- Inserindo despesas
INSERT INTO despesa (dsDespesa, valorDespesa, dataDespesa, cdTipoDespesa, cdContaBancaria, observacoes, idRepetir) VALUES 
('Assinatura de software', 150.00, '2025-03-02', 6, 1, 'Ferramentas para trabalho', 1),
('Internet', 120.00, '2025-03-03', 6, 1, 'Plano mensal', 1),
('Café da manhã', 20.00, '2025-03-04', 1, 1, 'Cafeteria local', 0),
('Compra no mercado', 350.00, '2025-03-02', 1, 2, 'Supermercado', 0),
('Combustível', 200.00, '2025-03-03', 2, 2, 'Posto de gasolina', 0),
('Academia', 100.00, '2025-03-05', 3, 3, 'Mensalidade', 1),
('Plano de saúde', 500.00, '2025-03-06', 4, 2, 'Plano médico', 1),
('Curso online', 300.00, '2025-03-07', 5, 4, 'Curso de programação', 0);

-- Inserindo cartões vinculados às contas bancárias
INSERT INTO cartao (nmCartao, dsCartao, cdContaCartao, idTipoCartao, idVigente) VALUES 
('Cartão Admin Black', 'Cartão premium com cashback', 1, 1, 1),
('Cartão João Platinum', 'Cartão de crédito com benefícios', 2, 1, 1),
('Cartão Maria Gold', 'Cartão de débito e crédito', 3, 2, 1),
('Cartão Carlos Black', 'Cartão digital sem anuidade', 4, 1, 1);

*/


/*SELECT * FROM usuario;
SELECT * FROM bancos;
SELECT * FROM contaBancaria;
SELECT * FROM tipoRenda;
SELECT * FROM tipoDespesa;
SELECT * FROM receita;
SELECT * FROM despesa;
SELECT * FROM cartao;*/

