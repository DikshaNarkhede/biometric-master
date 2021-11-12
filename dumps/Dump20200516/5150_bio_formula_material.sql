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
-- Table structure for table `bio_formula_material`
--

DROP TABLE IF EXISTS `bio_formula_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_formula_material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `formula_id` bigint NOT NULL,
  `material_id` bigint NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `added_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `is_approved` varchar(1) DEFAULT NULL,
  `approved_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqe_formula_material` (`formula_id`,`material_id`),
  KEY `formula_id_idx` (`formula_id`),
  KEY `material_id_fk_idx` (`material_id`),
  KEY `material_id_fk_idx1` (`material_id`),
  CONSTRAINT `formula_id_fk` FOREIGN KEY (`formula_id`) REFERENCES `bio_formula` (`id`),
  CONSTRAINT `material_id_fk` FOREIGN KEY (`material_id`) REFERENCES `bio_material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_formula_material`
--

LOCK TABLES `bio_formula_material` WRITE;
/*!40000 ALTER TABLE `bio_formula_material` DISABLE KEYS */;
INSERT INTO `bio_formula_material` VALUES (1,49,0,'2019-05-30 08:40:57','2019-05-30 08:40:57','test',NULL,NULL,NULL),(2,48,0,'2019-05-30 08:41:08','2019-05-30 08:41:08','test',NULL,NULL,NULL),(3,50,5000,'2020-02-29 17:05:13','2020-02-29 17:05:13','test',NULL,NULL,NULL),(4,50,9003,'2020-02-29 17:05:25','2020-02-29 17:05:25','test',NULL,NULL,NULL),(5,50,0,'2020-02-29 17:06:33','2020-02-29 17:06:33','test',NULL,NULL,NULL);
/*!40000 ALTER TABLE `bio_formula_material` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-16 10:02:24
