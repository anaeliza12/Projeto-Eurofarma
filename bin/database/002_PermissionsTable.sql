CREATE TABLE `permissoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(180) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO eurofarma.permissoes
VALUES (null, "User");

INSERT INTO eurofarma.permissoes
VALUES (null, "Admin");