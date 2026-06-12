-- Schema para banco financeiro (PostgreSQL)
-- Ajustado para ficar consistente com as classes Java do projeto

-- Opcional: criar database (pode falhar se já estiver conectado a outro DB)
-- CREATE DATABASE dbFinanceiro;

-- Tabelas
DROP TABLE IF EXISTS conta_cliente;
DROP TABLE IF EXISTS pessoa;

CREATE TABLE pessoa (
        id_pessoa SERIAL PRIMARY KEY,
        nome VARCHAR(60) NOT NULL,
        cpf VARCHAR(11) NOT NULL UNIQUE,
        endereco VARCHAR(255),
        telefone VARCHAR(20),
        email VARCHAR(100)
);

CREATE TABLE conta_cliente (
        agencia INTEGER NOT NULL,
        num_conta INTEGER PRIMARY KEY,
        tipo_conta TEXT,
        saldo NUMERIC(15,2) DEFAULT 0,
        limite_credito NUMERIC(15,2) DEFAULT 0,
        nome TEXT,
        cpf TEXT,
        endereco TEXT,
        telefone TEXT,
        email TEXT
);

-- Dados de exemplo (apenas pessoas e contas)
INSERT INTO pessoa (nome, cpf, endereco, telefone, email) VALUES
    ('Pablo Felipe', '12345678901', 'Rua Exemplo, 123', '11999998888', 'pablo@example.com')
ON CONFLICT (cpf) DO NOTHING;

INSERT INTO conta_cliente (agencia, num_conta, tipo_conta, saldo, limite_credito, nome, cpf, endereco, telefone, email) VALUES
    (1, 1001, 'Corrente', 150.00, 500.00, 'Pablo Felipe', '12345678901', 'Rua Exemplo, 123', '11999998888', 'pablo@example.com')
ON CONFLICT DO NOTHING;

SELECT * FROM pessoa;
SELECT * FROM conta_cliente;
