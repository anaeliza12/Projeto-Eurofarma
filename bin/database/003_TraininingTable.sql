CREATE TABLE `treinamentos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_treinamento` varchar(255) NOT NULL,
  `departamento_id` bigint NOT NULL,
  `duracao` varchar(255) NOT NULL,  
  `data` date NOT NULL,
  `horario` time(6) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `modalidade` enum('ONLINE','PRESENCIAL') NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjw29a0p5qqiyifli0j5a555p` (`departamento_id`),
  CONSTRAINT `FKhjw29a0p5qqiyifli0j5a555p` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`id`)
) ENGINE=InnoDB;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO eurofarma.treinamentos
VALUES (null, "Desenvolvimento de Liderança", 1, "44min", '2024-08-29', '15:30', "Treinamento focado em desenvolver habilidades de liderança, incluindo técnicas de motivação, comunicação eficaz e gestão de equipes. Ideal para líderes atuais e futuros.", "ONLINE", "Sala 11");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Gestão de Conflitos", 1, "1h30", '2024-08-30', '11:00', "Curso sobre técnicas para identificar, gerenciar e resolver conflitos no ambiente de trabalho, promovendo um ambiente colaborativo e harmonioso.", "ONLINE", "Sala 7");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Introdução à Cibersegurança", 2, "1h", '2024-10-15', '16:00', "Princípios básicos da cibersegurança, abordando ameaças comuns, estratégias de proteção e melhores práticas para garantir a segurança dos dados.", "PRESENCIAL", "Sala 1");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Implementação de Senhas Seguras", 2, "30min", '2024-11-09', '12:00', "Melhores práticas para criar e gerenciar senhas seguras, incluindo políticas de senha e ferramentas de gerenciamento.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Metodologias Ágeis em P&D", 3, "2h", '2024-09-13', '14:45', "Princípios e práticas das metodologias ágeis aplicadas à pesquisa e desenvolvimento, incluindo Scrum e Kanban para gerenciar projetos de inovação.", "PRESENCIAL", "Sala 6");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Desenvolivimento de Liderança", 3, "44min", '2024-08-29', '15:30', "Métodos de análise de dados para interpretar resultados de pesquisas e experimentos, utilizando ferramentas estatísticas e de visualização.", "PRESENCIAL", "Auditório");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Auditoria de Qualidade", 4, "50min", '2025-02-08', '15:50', "Técnicas e procedimentos para realizar auditorias de qualidade, identificando não conformidades e oportunidades de melhoria.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Inspeção de Produtos e Processos", 4, "1h45", '2024-08-18', '17:00', "Métodos para inspecionar produtos e processos, assegurando que atendam aos padrões de qualidade e requisitos técnicos.", "ONLINE", "Teams");
INSERT INTO eurofarma.treinamentos
VALUES (null, "Operação de Máquinas e Equipamentos", 5, "5h", '2024-11-13', '10:00', "Formação prática e teórica sobre a operação segura e eficiente de máquinas e equipamentos de produção.", "PRESENCIAL", "Auditório");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Manutenção Preventiva", 5, "1h20", '2024-08-29', '16:40', "Procedimentos e melhores práticas para realizar a manutenção preventiva em equipamentos e máquinas, evitando falhas e prolongando a vida útil.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Treinamento em Primeiros Socorros", 6, "2h", '2024-10-04', '14:30', "Formação para fornecer primeiros socorros em situações de emergência, incluindo procedimentos de ressuscitação e tratamento de lesões.", "PRESENCIAL", "Sala 1");

INSERT INTO eurofarma.treinamentos
VALUES (null, "NRs na Indústria Farmacêutica", 6, "50min", '2024-09-12', '16:45',  "Conhecimento das normas regulamentadoras aplicáveis à indústria farmacêutica, garantindo a conformidade e segurança no ambiente de trabalho.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Ética e Compliance Corporativo", 7, "50min", '2024-08-31', '16:30', "Princípios e práticas de ética e conformidade dentro da empresa, abordando políticas e procedimentos para garantir práticas comerciais corretas.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Políticas de Privacidade e Proteção de Dados", 7, "1h", '2024-09-18', '11:00', "Implementação e gestão de políticas de privacidade e proteção de dados, em conformidade com regulamentações como o GDPR.", "PRESENCIAL", "Sala 10");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Gestão de Custos e Precificação", 8, "1h", '2024-10-10', '15:30', "Métodos para gerenciar custos e definir preços de produtos e serviços, garantindo a rentabilidade e competitividade.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Planejamento Orçamentário", 8, "2h20", '2024-11-14', '11:20', "Processo de planejamento e controle do orçamento da empresa, incluindo elaboração de previsões e monitoramento de despesas.", "ONLINE", "Teams");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Atendimento ao Cliente de Excelência", 9, "1h10", '2024-12-04', '16:45', "Melhores práticas para oferecer um atendimento ao cliente excepcional, incluindo técnicas de comunicação e resolução de problemas.", "PRESENCIAL", "Auditório");

INSERT INTO eurofarma.treinamentos
VALUES (null, "Marketing Digital e Redes Sociais", 9, "2h45", '2024-08-29', '15:30', "Treinamento focado em desenvolver habilidades de liderança, incluindo técnicas de motivação, comunicação eficaz e gestão de equipes. Ideal para líderes atuais e futuros.", "ONLINE", "Teams");