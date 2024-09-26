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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO eurofarma.usuarios
VALUES (null, "ana.perobelli@eurofarma.com.br",1234, 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "vini.panessa@eurofarma.com.br",1234, 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "lara.goncalves@eurofarma.com.br",1234, 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "leo.alves@eurofarma.com.br",1234, 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "maria.silva@eurofarma.com.br",1234, 1,1,1,1);

INSERT INTO eurofarma.usuarios
VALUES (null, "pedro.santos@eurofarma.com.br",1234, 1,1,1,1);