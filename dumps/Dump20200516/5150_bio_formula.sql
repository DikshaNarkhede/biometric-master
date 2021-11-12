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
-- Table structure for table `bio_formula`
--

DROP TABLE IF EXISTS `bio_formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_formula` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `formula` varchar(1024) NOT NULL,
  `variable_id` int NOT NULL,
  `citation` varchar(1024) DEFAULT NULL,
  `doi` varchar(1024) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `added_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `is_approved` varchar(1) DEFAULT NULL,
  `approved_by` varchar(45) DEFAULT NULL,
  `formula_desc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `FKqurhm7bqu3vodbrnwlpkgpa4n` (`variable_id`),
  CONSTRAINT `FKqurhm7bqu3vodbrnwlpkgpa4n` FOREIGN KEY (`variable_id`) REFERENCES `bio_variable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_formula`
--

LOCK TABLES `bio_formula` WRITE;
/*!40000 ALTER TABLE `bio_formula` DISABLE KEYS */;
INSERT INTO `bio_formula` VALUES (1,'K_WATER','0.57109 + (1.762 * pow(10,-3) * T) - (6.7036 * pow(10,-6) * pow(T,2))',10001,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504','DOI',NULL,'2019-06-17 09:17:01','test','test','0',NULL,'Thermal Conductivity of Water'),(2,'K_ICE','2.21960  - (6.2489 * pow(10,-3) * T) +(1.0154 * pow(10,-4) * pow(T,2))',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of ICE'),(3,'K_PROCNT','0.17881- (1.1958* pow(10,-3) * T) - (2.7178 * pow(10,-6) * pow(T,2))',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of Protein'),(4,'K_FAT','0.18071- (2.7604* pow(10,-3) * T) - (1.7749* pow(10,-7) * pow(T,2)) ',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of FAT'),(5,'K_CHOCDF','0.20141- (1.3874* pow(10,-3) * T) - (4.3312* pow(10,-6) * pow(T,2))',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of CARB'),(6,'K_FIBTG','0.18331- (1.2497* pow(10,-3) * T) - (3.1683* pow(10,-6) * pow(T,2))',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of CARB'),(7,'K_ASH','0.32961- (1.4011 * pow(10,-3)* T) - (2.9069 * pow(10,-6) * pow(T,2))',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of ASH'),(8,'K_A','0.025',10002,'T. Gulati, A.K. Datta, Journal of Food Engineering 116 (2013) 483-504',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Thermal Conductivity of AIR'),(19,'VISCOSITY_SOYBEAN_TSENG','(5.12 * pow(10,-6)) * exp((2215.65 / Tk))',10003,'Tseng et al, 1996; Gulati & Datta, 2013',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Viscosity Prediction Formula for Soybean Oil'),(20,'VISCOSITY_OLIVE_OIL','pow(10,(-4.9110 + (-699.70) / (110.30 - Tk)))',10003,'Viswanath & Natarajan, 1989; Steffe, 1996',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Viscosity Prediction Formula for Olive Oil'),(21,'VISCOSITY_SUNFLOWER_OIL','pow(10,(-3.6505 + (-304.27) / (168.98 - Tk)))',10003,'Viswanath & Natarajan, 1989; Steffe, 1996',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Viscosity Prediction for Sunflower Oil'),(22,'VISCOSITY_PEANUT_OIL','pow(10,(-3.9621 + (-407.46) / (151.23 - Tk)))',10003,'Viswanath & Natarajan, 1989; Steffe, 1996',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Viscosity Prediction for Peanut Oil'),(23,'VISCOSITY_RAPSEED_OIL','pow(10,((-4.4802) + (-597.20) / (119.99 - Tk)))',10003,'Viswanath & Natarajan, 1989; Steffe, 1996',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Viscosity Prediction for Rapseed  Oil'),(38,'RHO_AIR','12.847-3.2358*pow(10,-3)*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:48:02','2019-05-30 07:56:41','test','test','0',NULL,'Density of Air'),(39,'RHO_WATER','9.9718*pow(10,2)+3.1439*pow(10,-3)*T-3.7574*pow(10,-3)*pow(T,2)',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:52:17','2019-03-23 13:52:17','test','test','0',NULL,'Density of Water'),(40,'RHO_ICE','9.1689*pow(10,2)-0.1307*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:52:42','2019-03-23 13:52:42','test','test','0',NULL,'Density of Water'),(41,'RHO_PROCNT','1.3300*pow(10,3)-0.5184*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:53:28','2019-03-23 13:53:28','test','test','0',NULL,'Density of Protein'),(42,'RHO_CHOCDF','1.5991*pow(10,3)-0.31046*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:53:56','2019-03-23 13:53:56','test','test','0',NULL,'Density of Carbohydrates'),(43,'RHO_FAT','9.2559*pow(10,2)-0.41757*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:54:25','2019-03-23 13:54:25','test','test','0',NULL,'Density of FAT'),(44,'RHO_FIBTG','1.3115*pow(10,3)-0.36589*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:54:56','2019-03-23 13:54:56','test','test','0',NULL,'Density of FIBER'),(45,'RHO_ASH','2.4238*pow(10,3)-0.28063*T',10001,'Choi,Y. and Okos, M.R., Food Engineering and Process Applications, 1986','DOI','2019-03-23 13:55:20','2019-03-23 13:55:20','test','test','0',NULL,'Density of ASH'),(46,'K_TEMP','(1/(((WATER/100)/D_WATER)  + (( PROCNT /100)/D_ PROCNT)))/D_WATER  *  K_WATER * WATER/100 + (1/(((WATER/100)/D_WATER)  + (( PROCNT /100)/D_ PROCNT)))/D_PROCNT * K_PROCNT * PROCNT/100 ',10002,'dd','DOI',NULL,NULL,NULL,NULL,NULL,NULL,'TEST'),(48,'RHO','1/(((WATER/100)/RHO_WATER) + ((AIR/100)/RHO_AIR) + ((ICE/100)/RHO_ICE) + ((PROCNT/100)/RHO_PROCNT) + ((CHOCDF/100)/RHO_CHOCDF) + ((FAT/100)/RHO_FAT) + ((FIBTG/100)/RHO_FIBTG) + ((ASH/100)/RHO_ASH))',10001,'Density of Any Material','Density of Any Material','2019-03-24 15:30:13','2019-05-30 09:11:58','test','test','0',NULL,'Density of Any Material'),(49,'K','RHO_WATER * K_WATER * WATER/100 + \r\nRHO_PROCNT * K_PROCNT * PROCNT/100 +\r\nRHO_CHOCDF * K_CHOCDF * CHOCDF/100  +\r\nRHO_FIBTG * K_FIBTG * FIBTG/100 +\r\nRHO_ASH * K_ASH * ASH/100 + \r\nRHO_FAT * K_FAT * FAT/100',10002,'Thermal Conductivity of Any Material','Thermal Conductivity of Any Material','2019-03-24 15:39:37','2019-03-24 15:39:37','test','test','0',NULL,'Thermal Conductivity of Any Material'),(50,'OLIVIA_FORMULA','0.57109 + (1.762 * pow(10,-3) * T) - (6.7036 * pow(10,-4) * pow(T,2))',10005,'11','10','2020-02-29 17:04:04','2020-05-11 00:28:54','test','test','0',NULL,'rho computation'),(51,'RHO_PRESSURE','9.9718*pow(10,2)+3.1439*pow(10,-3)*T-3.7574*pow(10,-3)*pow(p,2)',10005,'0','0','2020-05-03 18:23:51','2020-05-03 18:23:51','test','test','0',NULL,'density: pressure and temperature'),(52,'RHO_PRESSURE OLIVIA','9.9718*pow(10,2)+3.1439*pow(10,-3)*T-3.7574*pow(10,-3)*pow(p,2)',10005,'0','0','2020-05-03 18:25:00','2020-05-03 18:25:00','test','test','0',NULL,'rho_pressure and temprature');
/*!40000 ALTER TABLE `bio_formula` ENABLE KEYS */;
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
