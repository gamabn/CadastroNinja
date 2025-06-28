--V2:Migration para adicionar a coluna de Dificuldade na tabela de cadstro

ALTER TABLE tb_cadastro
ADD COLUMN dificuldade VARCHAR(255);