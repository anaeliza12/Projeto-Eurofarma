CREATE TABLE `usuario_permissoes` (
  `id_permission` bigint NOT NULL,
  `id_user` bigint NOT NULL,
  KEY `FK7ktnp2lxifpi58tvm2spktl81` (`id_permission`),
  KEY `FKedq70ivilhtvd9htag1006hmx` (`id_user`),
  CONSTRAINT `FK7ktnp2lxifpi58tvm2spktl81` FOREIGN KEY (`id_permission`) REFERENCES `permissoes` (`id`),
  CONSTRAINT `FKedq70ivilhtvd9htag1006hmx` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO eurofarma.usuario_permissoes
VALUES (1,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (2,2);

INSERT INTO eurofarma.usuario_permissoes
VALUES (2,3);

INSERT INTO eurofarma.usuario_permissoes
VALUES (2,4);

INSERT INTO eurofarma.usuario_permissoes
VALUES (1,5);

INSERT INTO eurofarma.usuario_permissoes
VALUES (1,6);