ALTER TABLE topicos ADD COLUMN ativo BOOLEAN;
UPDATE topicos SET ativo = true;