CREATE TABLE `usuario_treinamento` (
  `treinamento_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  `status` enum('CONCLUIDO','EM_ANDAMENTO','PENDENTE') NOT NULL,
  PRIMARY KEY (`treinamento_id`,`usuario_id`),
  KEY `FK8oy2yr20croq35mgi7jcs8de5` (`usuario_id`),
  CONSTRAINT `FK8oy2yr20croq35mgi7jcs8de5` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKr2s6ouog93hu583m7wc7sqrpj` FOREIGN KEY (`treinamento_id`) REFERENCES `treinamentos` (`id`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;