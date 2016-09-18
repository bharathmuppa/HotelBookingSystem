-- MySQL dump 10.11
--
-- Host: localhost    Database: bat
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt

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
-- Table structure for table `bookedrooms`
--

DROP TABLE IF EXISTS `bookedrooms`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `bookedrooms` (
  `roomNo` int(11) NOT NULL default '0',
  `bookedOn` date NOT NULL default '0000-00-00',
  `customerId` int(11) default NULL,
  `transId` int(11) default NULL,
  PRIMARY KEY  (`roomNo`,`bookedOn`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `bookedrooms_ibfk_1` FOREIGN KEY (`roomNo`) REFERENCES `room` (`roomNo`),
  CONSTRAINT `bookedrooms_ibfk_2` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `bookedrooms`
--

LOCK TABLES `bookedrooms` WRITE;
/*!40000 ALTER TABLE `bookedrooms` DISABLE KEYS */;
INSERT INTO `bookedrooms` VALUES (101,'2015-12-10',5,10),(101,'2015-12-11',5,10),(102,'2015-12-11',5,20),(103,'2015-12-10',5,61),(103,'2015-12-11',5,61),(103,'2015-12-12',6,30),(103,'2015-12-13',6,30),(104,'2015-12-11',5,62),(104,'2015-12-12',5,62),(107,'2015-12-15',7,50),(201,'2015-12-14',7,40);
/*!40000 ALTER TABLE `bookedrooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `comments` (
  `firstname` varchar(30) default NULL,
  `mobile` varchar(15) default NULL,
  `message` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES ('joseph','8008909081','I would like what are the offers available'),('stephen','999999999','I would like know any negotiaions regarding room fare'),('Viswas','99481233445','Hi there'),('asd','','ad'),('bat','','gia'),('bat','8008008930','hi there'),('bharath','9948','mimy'),('banana','90009','dasdasdasda');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercomments`
--

DROP TABLE IF EXISTS `customercomments`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `customercomments` (
  `firstname` varchar(30) default NULL,
  `message` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `customercomments`
--

LOCK TABLES `customercomments` WRITE;
/*!40000 ALTER TABLE `customercomments` DISABLE KEYS */;
INSERT INTO `customercomments` VALUES ('joseph','I would like what are the offers available');
/*!40000 ALTER TABLE `customercomments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL auto_increment,
  `firstName` varchar(30) default NULL,
  `lastName` varchar(30) default NULL,
  `pWord` varchar(150) default NULL,
  `country` varchar(30) default NULL,
  `state` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `phoneNo` varchar(15) default NULL,
  `role` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (5,'bharath','muppa','bat@1234','india','andhra pradesh','hyderabad','918008008930','M','bharathmuppa@gmail.com'),(6,'prasanna','maredu','lucky@123','india','andhra pradesh','hyderabad','8008006919','M','press@gmail.com'),(7,'Aditya','kalyan','kalyan@123','india','andhra pradesh','hyderabad','9948123344','C','kalyanaditya@gmail.com'),(9,'Ram','narayanam','ram@123','us','alabama','cincinati','9945678912','C','ram.narayan@gmail.com'),(10,'bunny','cool','bunny@123','0','Alabama','asdass','null','C','bunnycool777@gmail.com'),(11,'pawan','kalyan','null','0','null','null','null','C','pawankalyan@gmail.com'),(12,'ram','charan','ram@123','2','Andhra Pradesh','rampul','null','C','ramcharan@gmail.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `room` (
  `roomNo` int(11) NOT NULL,
  `floor` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY  (`roomNo`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `roomtype` (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (101,1,1),(102,1,1),(103,1,1),(104,1,1),(105,1,2),(106,1,2),(107,1,2),(108,1,2),(109,1,2),(201,2,3),(202,2,3),(203,2,3),(204,2,3),(205,2,3),(206,2,4),(207,2,4),(208,2,4),(209,2,4);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `roomtype` (
  `typeId` int(11) NOT NULL auto_increment,
  `area` varchar(10) default NULL,
  `ac` varchar(10) default NULL,
  `kitchen` varchar(10) default NULL,
  `price` int(11) NOT NULL default '0',
  PRIMARY KEY  (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `roomtype`
--

LOCK TABLES `roomtype` WRITE;
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
INSERT INTO `roomtype` VALUES (1,'1BED','YES','YES',1000),(2,'1BED','YES','NO',500),(3,'2BED','YES','YES',2000),(4,'2BED','YES','NO',1500);
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-10  3:35:43
