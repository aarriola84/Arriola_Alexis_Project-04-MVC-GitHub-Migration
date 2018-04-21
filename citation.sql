-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: citation
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `citation`
--

DROP TABLE IF EXISTS `citation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citation` (
  `id` int(11) NOT NULL,
  `paid` tinyint(4) DEFAULT NULL,
  `licenseNo` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `permitNo` varchar(45) DEFAULT NULL,
  `vehicle` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `issuer` varchar(45) DEFAULT NULL,
  `reason` varchar(128) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `feedback` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citation`
--

LOCK TABLES `citation` WRITE;
/*!40000 ALTER TABLE `citation` DISABLE KEYS */;
INSERT INTO `citation` VALUES (1,1,'ADF122','TX','12345','Pontiac Vibe','Blue','03/22/2018','SETB','11:00AM','Saul Molina','Parked in hadicap zone','Paid','none'),(2,0,'AJK234','TX','N/A','Ford Mustang','Black','04/08/2018','LHSB','10:00AM','Ray Leal','No permit','Unpaid','Advice to purchase a permit'),(3,0,'AEF222','TX','N/A','Honda Civic','Red','02/11/2018','MAIN','9:00AM','Saul Molina','No permit','Unpaid','Advice to purchase permit'),(4,1,'EDM214','TX','12233','Nissan Sentra','Gray','01/22/2018','SETB','8:30AM','Ray Leal','Illegally parked','Paid','none'),(5,1,'ESD144','TX','12445','Chevy Trailblazer','Black','04/02/2018','MAIN','2:00PM','Luis Chapa','Blocking an entrance','Paid','none'),(6,0,'AED156','TX','12322','Dodge Neon','Tan','03/15/2018','SETB','1:00PM','Luis Chapa','Parked in handicap zone','Unpaid','none'),(7,0,'AJK765','TX','12897','Ford Focus','Green','04/20/2018','MAIN','9:30AM','Saul Molina','Parked in wrong zone.','Unpaid',''),(8,0,'ABD566','TX','12987','Ford Fiesta','Red','02/14/2018','LHSB','9:00AM','Saul Molina','Taking up two spaces','Unpaid',''),(9,0,'AER388','TX','N/A','BMW X1','Gray','04/11/2018','MAIN','8:45AM','Luis Chapa','No permit','Unpaid',''),(10,0,'AJT995','TX','N/A','Audi A1','Blue','04/02/2018','SETB','8:00AM','Saul Molina','No permit','Unpaid','');
/*!40000 ALTER TABLE `citation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-20 23:15:04
