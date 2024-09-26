CREATE TABLE `usuario_permissoes` (
  `id_permission` bigint NOT NULL,
  `id_user` bigint NOT NULL,
  KEY `FK7ktnp2lxifpi58tvm2spktl81` (`id_permission`),
  KEY `FKedq70ivilhtvd9htag1006hmx` (`id_user`),
  CONSTRAINT `FK7ktnp2lxifpi58tvm2spktl81` FOREIGN KEY (`id_permission`) REFERENCES `permissoes` (`id`),
  CONSTRAINT `FKedq70ivilhtvd9htag1006hmx` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO eurofarma.usuario_permissoes
VALUES (1,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (2,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (3,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (4,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (5,1);

INSERT INTO eurofarma.usuario_permissoes
VALUES (6,1);