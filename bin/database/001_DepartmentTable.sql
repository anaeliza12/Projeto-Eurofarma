CREATE TABLE `departamentos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO eurofarma.departamentos
VALUES (null, "Recursos Humanos ");

INSERT INTO eurofarma.departamentos
VALUES (null, "Segurança da Informação");

INSERT INTO eurofarma.departamentos
VALUES (null, "Pesquisa e Desenvolvimento");

INSERT INTO eurofarma.departamentos
VALUES (null, "Controle de Qualidade");

INSERT INTO eurofarma.departamentos
VALUES (null, "Produção e Manufatura");

INSERT INTO eurofarma.departamentos
VALUES (null, "Segurança do Trabalho");

INSERT INTO eurofarma.departamentos
VALUES (null, "Jurídico e Compliance");

INSERT INTO eurofarma.departamentos
VALUES (null, "Finanças e Contabilidade");

INSERT INTO eurofarma.departamentos
VALUES (null, "Vendas e Marketing");