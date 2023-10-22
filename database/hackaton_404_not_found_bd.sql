CREATE DATABASE  IF NOT EXISTS `hackaton_bd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hackaton_bd`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: hackaton_bd
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `achievements`
--

DROP TABLE IF EXISTS `achievements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievements` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `data_de_inicio` date NOT NULL,
  `data_de_fim` date NOT NULL,
  `nome` varchar(128) DEFAULT NULL,
  `descricao` varchar(512) DEFAULT NULL,
  `recompensa_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_recompensa` (`recompensa_id`),
  CONSTRAINT `fk_recompensa` FOREIGN KEY (`recompensa_id`) REFERENCES `recompensas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievements`
--

LOCK TABLES `achievements` WRITE;
/*!40000 ALTER TABLE `achievements` DISABLE KEYS */;
INSERT INTO `achievements` VALUES (12,'2023-10-22','2024-10-21','Conhecendo um pedaço do céu: São João del-Rei.','Passar por todas as igrejas de São João del-Rei.',21),(13,'2023-10-22','2024-10-21','Conhecendo um pedaço do céu: Tiradentes.','Passar por todas as igrejas de Tirandentes.',21),(14,'2023-10-22','2024-10-21','Passeio pelas cachoeiras.','Passar por todas as cachoeiras do campos das vertentes.',22),(15,'2023-10-22','2024-10-21','Caminho das vertentes.','Passar em pelo menos 1 cidade de cada microrregião das vertentes.',23),(16,'2023-10-22','2024-10-21','Caminho do bebum.','Passar pelos bares da rua da cachaça.',24),(17,'2023-10-22','2024-10-21','Romeiro das vertentes.','Passar em pelo menos 1 igreja de cada microrregião das vertentes.',25),(18,'2023-10-22','2024-10-21','Naturalista.','Passar por ao menos 5 pontos turísticos da natureza.',26),(19,'2023-10-22','2024-10-21','Trilheiro.','Passar por uma trilha.',27),(20,'2023-10-22','2024-10-21','Trupica mas não cai.','Passar por todas as ruas com bares indicados no mapa.',28),(21,'2023-10-22','2024-10-21','Piui até tiradentes.','Pegar o trem de São João del-Rei para Tirandentes.',29),(22,'2023-10-22','2024-10-21','O caminho da roça.','Andar de carroça.',30);
/*!40000 ALTER TABLE `achievements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievements_conquistados`
--

DROP TABLE IF EXISTS `achievements_conquistados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievements_conquistados` (
  `id_usuario` int unsigned NOT NULL,
  `id_achievement` int unsigned NOT NULL,
  `data_de_expiracao` date NOT NULL,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `consumido` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_usuario_achievement` (`id_usuario`),
  KEY `fk_conquista` (`id_achievement`),
  CONSTRAINT `fk_conquista` FOREIGN KEY (`id_achievement`) REFERENCES `achievements` (`id`),
  CONSTRAINT `fk_usuario_achievement` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievements_conquistados`
--

LOCK TABLES `achievements_conquistados` WRITE;
/*!40000 ALTER TABLE `achievements_conquistados` DISABLE KEYS */;
INSERT INTO `achievements_conquistados` VALUES (11,14,'2023-10-25',75,1),(11,18,'2024-10-21',76,1),(11,19,'2024-10-21',77,1),(47,19,'2024-10-30',78,1),(47,14,'2024-10-30',79,0),(47,16,'2024-10-30',80,0),(11,16,'2024-10-30',81,0),(11,14,'2024-10-30',82,0);
/*!40000 ALTER TABLE `achievements_conquistados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidades` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `microrregiao` int unsigned DEFAULT NULL,
  `latitude` decimal(10,6) NOT NULL,
  `longitude` decimal(10,6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_microrregiao` (`microrregiao`),
  CONSTRAINT `fk_microrregiao` FOREIGN KEY (`microrregiao`) REFERENCES `microrregioes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (45,'Alfredo Vasconcelos',1,-21.148600,-43.766900),(46,'Antônio Carlos',1,-21.319200,-43.750200),(47,'Barbacena',1,-21.222000,-43.772400),(48,'Barroso',1,-21.188000,-43.976000),(49,'Capela Nova',1,-20.923600,-43.618400),(50,'Caranaíba',1,-20.874600,-43.737600),(51,'Carandaí',1,-20.953800,-43.802100),(52,'Desterro do Melo',1,-21.147700,-43.518200),(53,'Ibertioga',1,-21.147700,-43.518200),(54,'Ressaquinha',1,-21.433400,-43.964200),(55,'Santa Bárbara do Tugúrio',1,-21.062000,-43.762100),(56,'Microrregião de Lavras',1,-21.246300,-43.559100),(57,'Carrancas',2,-21.488500,-44.643700),(58,'Ijaci',2,-21.171400,-44.926200),(59,'Ingaí',2,-21.401700,-44.918700),(60,'Itumirim',2,-21.317100,-44.871100),(61,'Itutinga',2,-21.297600,-44.658800),(62,'Lavras',2,-21.239900,-44.998400),(63,'Luminárias',2,-21.510800,-44.904200),(64,'Nepomuceno',2,-21.234100,-45.236000),(65,'Ribeirão Vermelho',2,-21.187600,-45.060700),(66,'Conceição da Barra de Minas',3,-21.202700,-44.463700),(67,'Coronel Xavier Chaves',3,-21.023000,-44.166200),(68,'Dores de Campos',3,-21.119100,-44.017900),(69,'Lagoa Dourada',3,-20.886600,-44.068100),(70,'Madre de Deus de Minas',3,-21.484000,-44.332900),(71,'Nazareno',3,-21.212700,-44.598400),(72,'Piedade do Rio Grande',3,-21.450300,-44.193500),(73,'Prados',3,-21.053500,-44.090100),(74,'Resende Costa',3,-20.898200,-44.243100),(75,'Ritápolis',3,-21.022200,-44.315200),(76,'Santa Cruz de Minas',3,-21.121700,-44.223500),(77,'Santana do Garambéu',3,-21.602000,-44.107900),(78,'São João del-Rei',3,-21.136500,-44.261900),(79,'Tiradentes',3,-21.111300,-44.168500),(80,'São Tiago',3,-20.911100,-44.508700);
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades_visitadas`
--

DROP TABLE IF EXISTS `cidades_visitadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidades_visitadas` (
  `id_usuario` int unsigned NOT NULL,
  `id_cidade` int unsigned NOT NULL,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_visitacao_cidade_usuario` (`id_usuario`),
  KEY `fk_visitacao_cidade` (`id_cidade`),
  CONSTRAINT `fk_visitacao_cidade` FOREIGN KEY (`id_cidade`) REFERENCES `cidades` (`id`),
  CONSTRAINT `fk_visitacao_cidade_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades_visitadas`
--

LOCK TABLES `cidades_visitadas` WRITE;
/*!40000 ALTER TABLE `cidades_visitadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidades_visitadas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`henrique_hott`@`172.16.175.235`*/ /*!50003 TRIGGER `check_caminho_das_vertentes` AFTER INSERT ON `cidades_visitadas` FOR EACH ROW BEGIN
	# -----------------------------------------------------
	DECLARE num_mr_max INT;
	DECLARE num_mr INT;

	SELECT COUNT(DISTINCT(nome)) FROM microrregioes INTO num_mr_max;

	select COUNT(DISTINCT(c.microrregiao))
	FROM cidades_visitadas AS cv INNER JOIN cidades AS c ON c.id = cv.id_cidade
	WHERE cv.id_usuario = new.id_usuario
	INTO num_mr;

	IF num_mr_max = num_mr THEN
		INSERT INTO achievements_conquistados(    id_usuario, id_achievement,               data_de_expiracao)
	           VALUES                        (NEW.id_usuario,             15, DATE_ADD(now(), interval 3 day));
	END IF;
	# -----------------------------------------------------
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `estabelecimentos`
--

DROP TABLE IF EXISTS `estabelecimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estabelecimentos` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) DEFAULT NULL,
  `descricao` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estabelecimentos`
--

LOCK TABLES `estabelecimentos` WRITE;
/*!40000 ALTER TABLE `estabelecimentos` DISABLE KEYS */;
INSERT INTO `estabelecimentos` VALUES (6,'Taberna do Omar','Cozinha e Padaria Artesanal.'),(7,'Ovelha Negra Cervejaria','Experimente já a melhor cerveja artesanal de São João del Rei.'),(8,'Alambique','Cerveja gelada e um bom apelitivo.'),(9,'Rota 66','Bar para descontrair com sua turma, com cerveja gelada e comida boa!'),(10,'Boemios','Venha beber uma cerveja e curtir uma musica.');
/*!40000 ALTER TABLE `estabelecimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `imagem_url` varchar(2048) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `date_fim` datetime DEFAULT NULL,
  `cidade_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cidade_evento` (`cidade_id`),
  CONSTRAINT `fk_cidade_evento` FOREIGN KEY (`cidade_id`) REFERENCES `cidades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (3,'Arapuca','https://cbissn.ibict.br/images/phocagallery/galeria2/thumbs/phoca_thumb_l_image03_grd.png','2023-10-21 19:31:07','2023-10-30 23:14:07',62),(4,'Arapuca','https://cbissn.ibict.br/images/phocagallery/galeria2/thumbs/phoca_thumb_l_image03_grd.png','2023-10-21 19:31:07','2023-10-30 23:14:07',62);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `microrregioes`
--

DROP TABLE IF EXISTS `microrregioes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `microrregioes` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `microrregioes`
--

LOCK TABLES `microrregioes` WRITE;
/*!40000 ALTER TABLE `microrregioes` DISABLE KEYS */;
INSERT INTO `microrregioes` VALUES (1,'Barbacena'),(2,'Lavras'),(3,'São João del-Rei');
/*!40000 ALTER TABLE `microrregioes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pontos_turistico`
--

DROP TABLE IF EXISTS `pontos_turistico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pontos_turistico` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cidade_id` int unsigned NOT NULL,
  `tipo_ponto_turistico_id` int unsigned NOT NULL,
  `imagem_url` varchar(2048) NOT NULL,
  `cordenada_x` decimal(10,6) NOT NULL,
  `cordenada_y` decimal(10,6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ponto_turistico_cidade` (`cidade_id`),
  KEY `fk_ponto_turistico_tipo` (`tipo_ponto_turistico_id`),
  CONSTRAINT `fk_ponto_turistico_cidade` FOREIGN KEY (`cidade_id`) REFERENCES `cidades` (`id`),
  CONSTRAINT `fk_ponto_turistico_tipo` FOREIGN KEY (`tipo_ponto_turistico_id`) REFERENCES `tipos_ponto_turistico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pontos_turistico`
--

LOCK TABLES `pontos_turistico` WRITE;
/*!40000 ALTER TABLE `pontos_turistico` DISABLE KEYS */;
INSERT INTO `pontos_turistico` VALUES (5,'Catedral Basílica de Nossa Senhora do Pilar',78,1,'https://lh5.googleusercontent.com/p/AF1QipNLa8c44g3a4XhVHDzlg8oLC-RK_koNs8Z3v-Xg=w408-h312-k-no',-21.135124,-44.261942),(6,'Museu Ferroviário',78,4,'https://lh5.googleusercontent.com/p/AF1QipNKHNEWMY7DbUWUjF5qB57XVCyPEI7GjG8VahGr=w408-h306-k-no',-21.133042,-44.257328),(7,'Igreja de São Francisco de Assis',78,1,'https://lh5.googleusercontent.com/p/AF1QipOxyLqX38yeMZTNM33uC2iAkN8Upx9s5Yr0BsJj=w408-h544-k-no',-21.138859,-44.260136),(8,'Museu Casa Padre Toledo',79,4,'https://lh5.googleusercontent.com/p/AF1QipO_2QQ6ZPGR93BIK4W0HibE6YBp3V-kBe_dtgnV=w408-h873-k-no',-21.110507,-44.176632),(9,'Queijos Tiradentes',79,3,'https://lh5.googleusercontent.com/p/AF1QipMLEJ7Y6TydS5kgD4U9aN4RTOHGLvIo3uCmU0rd=w408-h544-k-no',-21.110507,-44.176632),(10,'Museu da Moto Tiradentes',79,4,'https://lh5.googleusercontent.com/p/AF1QipObMi3xOKyv4Eovk-mJ_lV4rSMZXScthYpgDFAR=w426-h240-k-no',-21.117681,-44.168140),(11,'Cachoeira Mãe do Sete',78,2,'https://lh5.googleusercontent.com/p/AF1QipObMi3xOKyv4Eovk-mJ_lV4rSMZXScthYpgDFAR=w426-h240-k-no',-21.145962,-44.288751),(12,'Igreja de Santo Antonio',79,1,'https://lh5.googleusercontent.com/p/AF1QipNtoBqzMC2w5GDjCp5vfmQDF7N3iQlrivo19Qeq=w408-h272-k-no',-21.109138,-44.178537);
/*!40000 ALTER TABLE `pontos_turistico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pontos_turisticos_visitados`
--

DROP TABLE IF EXISTS `pontos_turisticos_visitados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pontos_turisticos_visitados` (
  `id_usuario` int unsigned NOT NULL,
  `id_ponto_turistico` int unsigned NOT NULL,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_visitacao_pontos_usuario` (`id_usuario`),
  KEY `fk_visitacao_pontos` (`id_ponto_turistico`),
  CONSTRAINT `fk_visitacao_pontos` FOREIGN KEY (`id_ponto_turistico`) REFERENCES `pontos_turistico` (`id`),
  CONSTRAINT `fk_visitacao_pontos_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pontos_turisticos_visitados`
--

LOCK TABLES `pontos_turisticos_visitados` WRITE;
/*!40000 ALTER TABLE `pontos_turisticos_visitados` DISABLE KEYS */;
INSERT INTO `pontos_turisticos_visitados` VALUES (11,6,51);
/*!40000 ALTER TABLE `pontos_turisticos_visitados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`henrique_hott`@`172.16.175.235`*/ /*!50003 TRIGGER `check_pedaco_do_ceu_sjdr` AFTER INSERT ON `pontos_turisticos_visitados` FOR EACH ROW BEGIN
	# -----------------------------------------------------
	DECLARE num_religiosos INT;
	DECLARE num_religiosos_max INT;

	select COUNT(DISTINCT(pt.id))
	from pontos_turistico as pt inner join cidades as c
	on pt.cidade_id = c.id
	where pt.tipo_ponto_turistico_id = 1 and c.nome = 'São João del-Rei'
	into num_religiosos_max;

	select COUNT(DISTINCT(pt.id))
	from pontos_turisticos_visitados as ptv inner join pontos_turistico as pt inner join cidades as c 
	on pt.cidade_id = c.id and ptv.id_ponto_turistico = pt.id
	where ptv.id_usuario = new.id_usuario and c.nome = 'São João del-Rei' and pt.tipo_ponto_turistico_id = 1
	into num_religiosos;
	
	IF num_religiosos = num_religiosos_max THEN
		INSERT INTO achievements_conquistados(    id_usuario, id_achievement,               data_de_expiracao)
	           VALUES                        (NEW.id_usuario,             12, DATE_ADD(now(), interval 3 day));
	END IF;
	# -----------------------------------------------------
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`henrique_hott`@`172.16.175.235`*/ /*!50003 TRIGGER `check_pedaco_do_ceu_tiradentes` AFTER INSERT ON `pontos_turisticos_visitados` FOR EACH ROW BEGIN
	# -----------------------------------------------------
	DECLARE num_religiosos INT;
	DECLARE num_religiosos_max INT;

	select COUNT(DISTINCT(pt.id))
	from pontos_turistico as pt inner join cidades as c
	on pt.cidade_id = c.id
	where pt.tipo_ponto_turistico_id = 1 and c.nome = 'Tiradentes'
	into num_religiosos_max;

	select COUNT(DISTINCT(pt.id))
	from pontos_turisticos_visitados as ptv inner join pontos_turistico as pt inner join cidades as c 
	on pt.cidade_id = c.id and ptv.id_ponto_turistico = pt.id
	where ptv.id_usuario = new.id_usuario and c.nome = 'Tiradentes' and pt.tipo_ponto_turistico_id = 1
	into num_religiosos;
	
	IF num_religiosos = num_religiosos_max THEN
		INSERT INTO achievements_conquistados(    id_usuario, id_achievement,               data_de_expiracao)
	           VALUES                        (NEW.id_usuario,             13, DATE_ADD(now(), interval 3 day));
	END IF;
	# -----------------------------------------------------
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`henrique_hott`@`172.16.175.235`*/ /*!50003 TRIGGER `check_passeio_das_cachoeiras` AFTER INSERT ON `pontos_turisticos_visitados` FOR EACH ROW begin
	DECLARE n INT;
	DECLARE n_max INT;
	
	SELECT count(DISTINCT(pt.id)) from
	pontos_turistico as pt
	WHERE pt.tipo_ponto_turistico_id = 6 into n_max;
	
	SELECT count(DISTINCT(ptv.id_ponto_turistico)) from
	pontos_turisticos_visitados as ptv inner join pontos_turistico as pt ON ptv.id_ponto_turistico = pt.id
	WHERE ptv.id_usuario = NEW.id_usuario and pt.tipo_ponto_turistico_id = 6 into n;

	if n = n_max then
		INSERT INTO achievements_conquistados(    id_usuario, id_achievement,               data_de_expiracao)
	           VALUES                        (NEW.id_usuario,             14, DATE_ADD(now(), interval 3 day));
	end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recompensas`
--

DROP TABLE IF EXISTS `recompensas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recompensas` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(128) DEFAULT NULL,
  `descricao` varchar(512) DEFAULT NULL,
  `estabelecimento_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_estabelecimento` (`estabelecimento_id`),
  CONSTRAINT `fk_estabelecimento` FOREIGN KEY (`estabelecimento_id`) REFERENCES `estabelecimentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recompensas`
--

LOCK TABLES `recompensas` WRITE;
/*!40000 ALTER TABLE `recompensas` DISABLE KEYS */;
INSERT INTO `recompensas` VALUES (21,'Desconto na cerveja','10% de desconto na cerveja.',6),(22,'Sessão de apelitivos','5% de desconto em qualquer aperitivo.',6),(23,'Pra gringo é mais barato: Ipa','10% de desconto na cerveja ipa.',7),(24,'Pra gringo é mais barato: Pielsen','10% de desconto na cerveja pielsen.',7),(25,'Cachaça ta mais barata...','5% de desconto na dose de cachaça.',8),(26,'Cachaça ta bem barata...','10% de desconto na cerveja.',8),(27,'Hamburgue depois da caminhada.','5% de desconto em qualquer lanche da casa.',9),(28,'Cerveja depois da caminhada.','10% de desconto na cerveja.',9),(29,'Pra afogar as lagrimas.','5% de desconto na cerveja.',10),(30,'Toca Aquela','Escolha a próxima música da banda da noite.',10);
/*!40000 ALTER TABLE `recompensas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_ponto_turistico`
--

DROP TABLE IF EXISTS `tipos_ponto_turistico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_ponto_turistico` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_ponto_turistico`
--

LOCK TABLES `tipos_ponto_turistico` WRITE;
/*!40000 ALTER TABLE `tipos_ponto_turistico` DISABLE KEYS */;
INSERT INTO `tipos_ponto_turistico` VALUES (1,'Religioso'),(2,'Natureza'),(3,'Alimentação'),(4,'Atração'),(5,'Hospedagem'),(6,'Cachoeira');
/*!40000 ALTER TABLE `tipos_ponto_turistico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(128) NOT NULL,
  `senha` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token` varchar(64) NOT NULL,
  `email` varchar(320) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (11,'gabriel-dp','$2b$12$b3ZX1iKGXpN2CUdu.pNfoeyZ2U.0/lgRmu2rEswXc0twyE62AJ8ke','7724056c-3c5f-46e0-b9db-6a37f54f46e8','gabriel.meira.2004@gmail.com'),(40,'amoraasda','poiuytrewq','141caa74-bfe0-462f-aaa7-3a154c5590cc','kasjldfasd@fsf'),(41,'detominho','detominho','5f848eb7-cd95-443d-a588-0f3d686cbf9e','detominho@gmail.com'),(42,'giancarlo','asdfghjkl','cc1ccabc-6978-4d40-b269-d7a77bf2d6bb','giancarloprados@gmail.com'),(43,'gabriel-dpa','123456789','f68bc9ad-af27-4e27-8097-7fd7af3b021f','gabriel@gmail.com'),(44,'pauloamaral','poiuytrewwq','cde4a5ba-ae6d-4710-8307-32353b98d3c8','paulao@gmail.com'),(45,'testeteste','lzksfhlskf','69ebf885-53d6-486b-a686-332c987e855b','gabrikjlasd@gmail.com'),(46,'ladraoladrao','asdfghjklç','7a649941-1e2f-47ae-a6e0-6a68c6c04af7','lkasjdfh@gnalskjd'),(47,'saviofrancisco','savio123456','9829e659-499a-4586-8433-025fadff27e8','savio@gmail.com');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hackaton_bd'
--

--
-- Dumping routines for database 'hackaton_bd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 15:35:39
