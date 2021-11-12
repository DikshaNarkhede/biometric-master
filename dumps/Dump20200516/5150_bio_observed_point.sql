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
-- Table structure for table `bio_observed_point`
--

DROP TABLE IF EXISTS `bio_observed_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_observed_point` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `added_by` varchar(255) DEFAULT NULL,
  `citation` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `doi` varchar(255) DEFAULT NULL,
  `error_value` double NOT NULL,
  `is_approved` varchar(255) DEFAULT NULL,
  `material_id` bigint NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `x_observed_value` double NOT NULL,
  `x_variable_id` int NOT NULL,
  `y_observed_value` double NOT NULL,
  `y_variable_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmgtbjvjgdp7tmg1rptnu16w07` (`material_id`),
  KEY `FK4ij78hn6hrfm39e8h9u5gf0l5` (`x_variable_id`),
  KEY `FKcnxhap3i2149qemkej7w6f0k` (`y_variable_id`),
  CONSTRAINT `FK4ij78hn6hrfm39e8h9u5gf0l5` FOREIGN KEY (`x_variable_id`) REFERENCES `bio_variable` (`id`),
  CONSTRAINT `FKcnxhap3i2149qemkej7w6f0k` FOREIGN KEY (`y_variable_id`) REFERENCES `bio_variable` (`id`),
  CONSTRAINT `FKmgtbjvjgdp7tmg1rptnu16w07` FOREIGN KEY (`material_id`) REFERENCES `bio_material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_observed_point`
--

LOCK TABLES `bio_observed_point` WRITE;
/*!40000 ALTER TABLE `bio_observed_point` DISABLE KEYS */;
INSERT INTO `bio_observed_point` VALUES (1,'test','xiaoyu','2020-04-05 22:29:42','xiaoyu',100,NULL,9003,'2020-04-05 22:29:42',NULL,100,10002,100,10005);
/*!40000 ALTER TABLE `bio_observed_point` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-16 10:02:19
