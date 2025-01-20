CREATE TABLE topicos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(50) NOT NULL
);