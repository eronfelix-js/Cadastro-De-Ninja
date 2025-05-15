--V2: Migrations para adicionar a coluna de rank dentro da tabela de cadastro

ALTER TABLE CADASTRO_DE_NINJAS
ADD COLUMN RANK VARCHAR(255);