CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(180) DEFAULT NULL,
  `senha` varchar(180) NOT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO eurofarma.usuarios
VALUES (null, "ana.perobelli@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "vini.panessa@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "lara.goncalves@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "leo.alves@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "maria.silva@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "pedro.santos@eurofarma.com.br",'c29e18ca269444bc03f1e2baa2282116f0d59a291f1e15dcbdb6cf4db0a3ee1d7cf19bc287e7b1c9', 1,1,1,1);