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
-- Table structure for table `bio_user`
--

DROP TABLE IF EXISTS `bio_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bio_user` (
  `user_name` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_role` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `active` varchar(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `added_by` varchar(50) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bio_user`
--

LOCK TABLES `bio_user` WRITE;
/*!40000 ALTER TABLE `bio_user` DISABLE KEYS */;
INSERT INTO `bio_user` VALUES ('test','test test','test tst','test@gmail.com','CONTRIBUTOR','$2a$11$SoEhiqducR.1v4SPkrg3POwlKcGnw3UR4K/c813Qe2vZ8EEKNs7pW','1',NULL,NULL,NULL,NULL,1),('venky','Venkata','Kambhampaty','kvrayudu@gmail.com','CONTRIBUTOR','$2a$15$MofYcLUYpb17V8qvnzaZa.peVE5.nr4E190loDeHDrQFGyonKuAvC','1',NULL,NULL,NULL,NULL,2),('kvrayudu@gmail.com','VENKATA','KAMBHAMPATY','kvrayudu@gmail.com','CONTRIBUTOR','$2a$15$rKTe5HI0yBr17C615zDsYuJS617dRRIlkjgMrOxgAdqgnM3IpBNrm','1','2018-10-13 10:43:55','2018-10-13 10:43:55','kvrayudu@gmail.com',NULL,6),('kvrayudu@gmail.com1','KAMBHAMPATY','VENKATA','kvrayudu@gmail.com1','CONTRIBUTOR','$2a$15$eS0uX9sfRb7iM9xOME5eN.xb6isWhUV9lLBSU7Kyi/uVJnem4.1GW','1','2018-10-16 18:05:03','2018-10-16 18:05:03','kvrayudu@gmail.com1',NULL,8);
/*!40000 ALTER TABLE `bio_user` ENABLE KEYS */;
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
