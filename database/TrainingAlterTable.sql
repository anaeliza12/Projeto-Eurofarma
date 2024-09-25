ALTER TABLE `eurofarma`.`treinamentos` 
CHANGE COLUMN `id` `id` BIGINT NOT NULL AUTO_INCREMENT FIRST,
CHANGE COLUMN `nome_treinamento` `nome_treinamento` VARCHAR(255) NOT NULL AFTER `id`,
CHANGE COLUMN `departamento_id` `departamento_id` BIGINT NOT NULL AFTER `nome_treinamento`,
CHANGE COLUMN `duracao` `duracao` VARCHAR(255) NOT NULL AFTER `departamento_id`,
CHANGE COLUMN `modalidade` `modalidade` ENUM('ONLINE', 'PRESENCIAL') NOT NULL AFTER `descricao`;
