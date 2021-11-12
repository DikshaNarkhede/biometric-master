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
-- Table structure for table `bio_variable`
--

DROP TABLE IF EXISTS `bio_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_variable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `symbol` varchar(55) NOT NULL,
  `uom` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `added_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `symbol_UNIQUE` (`symbol`)
) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_variable`
--

LOCK TABLES `bio_variable` WRITE;
/*!40000 ALTER TABLE `bio_variable` DISABLE KEYS */;
INSERT INTO `bio_variable` VALUES (10001,'Temparature in C','Tempararure in Celcius','T','C',NULL,'2019-03-18 07:06:19',NULL,'test'),(10002,'Thermal Conductivity','Thermal Conductivity of a Material','K','W/m K',NULL,'2019-03-14 17:12:11',NULL,'system'),(10003,'Viscosity','Viscosity of a material','µ','Pa*s',NULL,'2019-03-18 07:04:24',NULL,'test'),(10004,'Temperature in Kelvin','Temperature in Kelvin','Tk','K',NULL,'2020-02-29 17:07:36','test','test'),(10005,'Density','Density of Material','rho','kg/m^3',NULL,'2020-05-11 09:48:29','test','test'),(10006,'shape','shape of something','SH','m','2020-02-29 17:08:41','2020-02-29 17:08:41','test','test'),(10007,'Pressure','Pressure in MPa','p','MPa',NULL,NULL,NULL,NULL),(10008,'kkk','d','o','c','2020-05-09 13:53:34','2020-05-09 13:53:34','test','test');
/*!40000 ALTER TABLE `bio_variable` ENABLE KEYS */;
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
