-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: 5150
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `bio_relation`
--

DROP TABLE IF EXISTS `bio_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `y_variable_id` int NOT NULL,
  `x1_variable_id` int NOT NULL,
  `x2_variable_id` int DEFAULT NULL,
  `x3_variable_id` int DEFAULT NULL,
  `x4_variable_id` int DEFAULT NULL,
  `x5_variable_id` int DEFAULT NULL,
  `x6_variable_id` int DEFAULT NULL,
  `x7_variable_id` int DEFAULT NULL,
  `x8_variable_id` int DEFAULT NULL,
  `x9_variable_id` int DEFAULT NULL,
  `x10_variable_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `added_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `y_variableId_idx` (`y_variable_id`),
  KEY `x1_variable_id_idx` (`x1_variable_id`),
  KEY `x2_variable_id_idx` (`x2_variable_id`),
  KEY `x3_variable_id_idx` (`x3_variable_id`),
  KEY `x4_variable_id_idx` (`x4_variable_id`),
  KEY `x5_variable_id_idx` (`x5_variable_id`),
  KEY `x6_variable_id_idx` (`x6_variable_id`),
  KEY `x7_variable_id_idx` (`x7_variable_id`),
  KEY `x8_variable_id_idx` (`x8_variable_id`),
  KEY `x9_variable_id_idx` (`x9_variable_id`),
  KEY `x10_variable_id_idx` (`x10_variable_id`),
  CONSTRAINT `y_variable_id` FOREIGN KEY (`y_variable_id`) REFERENCES `bio_variable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_relation`
--

LOCK TABLES `bio_relation` WRITE;
/*!40000 ALTER TABLE `bio_relation` DISABLE KEYS */;
INSERT INTO `bio_relation` VALUES (1,10005,10007,10001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bio_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-16 10:02:20
