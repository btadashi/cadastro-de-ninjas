-- V2: Migration para adicionar a coluna de RANK na tabela de ninjas.

ALTER TABLE tb_ninja
ADD COLUMN rank VARCHAR(255);