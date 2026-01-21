-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: streetpulse
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `cleaning_task`
--

DROP TABLE IF EXISTS `cleaning_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cleaning_task` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `complaint_id` bigint DEFAULT NULL,
  `volunteer_id` bigint DEFAULT NULL,
  `status` enum('ASSIGNED','IN_PROGRESS','COMPLETED') DEFAULT NULL,
  `assigned_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cleaning_task`
--

LOCK TABLES `cleaning_task` WRITE;
/*!40000 ALTER TABLE `cleaning_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `cleaning_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `priority` enum('CRITICAL','HIGH','LOW','MEDIUM') DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (1,'2026-01-07 19:36:26.941621','Resolved',12.9716,77.5946,NULL,NULL,'HIGH',NULL),(2,'2026-01-07 23:32:18.012213','Pending',NULL,NULL,NULL,NULL,NULL,NULL),(3,'2026-01-13 20:15:45.874387','Pending',NULL,NULL,'Main Road','Big hole near school',NULL,NULL),(4,'2026-01-13 22:25:29.030825','Pending',NULL,NULL,'Main Road','Big hole near school',NULL,NULL),(5,'2026-01-14 20:11:44.543257','Pending',NULL,NULL,'Udipalya','A pothole in udipalya is causing accidents','LOW',NULL);
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint_image`
--

DROP TABLE IF EXISTS `complaint_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `complaint_id` bigint DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `uploaded_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint_image`
--

LOCK TABLES `complaint_image` WRITE;
/*!40000 ALTER TABLE `complaint_image` DISABLE KEYS */;
INSERT INTO `complaint_image` VALUES (1,1,'C:\\Users\\270303\\Downloads\\streetpulse\\uploads\\1767815570483_Screenshot 2025-12-27 221105.png','2026-01-07 19:52:50'),(2,124160,'C:\\Users\\270303\\Downloads\\streetpulse\\uploads\\1768020353814_Screenshot 2025-12-27 221105.png','2026-01-10 04:45:54');
/*!40000 ALTER TABLE `complaint_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaints` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `priority` enum('LOW','MEDIUM','HIGH','CRITICAL') NOT NULL,
  `status` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaints`
--

LOCK TABLES `complaints` WRITE;
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
INSERT INTO `complaints` VALUES (1,'Udipalya, Banglore','2026-01-19 12:09:22.909247','Water leakage is a major issue in udipalya',NULL,NULL,'LOW','Resolved','Water Leakage',NULL),(2,'Udipalya, Banglore','2026-01-19 13:37:27.210977','Water leakage',NULL,NULL,'MEDIUM','Resolved','Water Leakage ',NULL),(3,'J P Nagar, Banglore','2026-01-20 14:40:26.566633','Potholes in J P Nagar is a major issue causing accidents',NULL,NULL,'LOW','Pending','Pothole',NULL),(4,'J P Nagar, Banglore','2026-01-20 14:55:51.701324','Potholes in J P Nagar is a major issue causing accidents',NULL,NULL,'LOW','Pending','Pothole',NULL),(5,'Udipalya, Banglore','2026-01-20 16:05:53.709563','Water Leakage',NULL,NULL,'LOW','Pending','Water Leakage','1768905353655_water leakage in udipalya.jpg'),(6,'Udipalya, Banglore','2026-01-20 16:05:53.709563','Water Leakage',NULL,NULL,'LOW','Pending','Water Leakage','1768905353660_water leakage in udipalya.jpg'),(7,'Udipalya, Banglore','2026-01-20 16:13:52.146804','Water Leakage',NULL,NULL,'MEDIUM','Pending','Water Leakage','1768905832124_water leakage in udipalya.jpg'),(8,'Udipalya, Banglore','2026-01-20 16:13:52.201154','Water Leakage',NULL,NULL,'MEDIUM','Pending','Water Leakage','1768905832129_water leakage in udipalya.jpg');
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('CITIZEN','VOLUNTEER','ADMIN') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` enum('CITIZEN','VOLUNTEER','ADMIN') DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Alice','alice@test.com','1234','CITIZEN',_binary '\0'),(2,'Bob','bob@test.com','1234','VOLUNTEER',_binary '\0'),(3,'Admin','admin@test.com','admin','ADMIN',_binary ''),(5,'Mohitha Y','gowdamohitha29@gmail.com','131582','CITIZEN',_binary '\0'),(6,'Mohitha Y','1dt24cs160@dsatm.edu.in','123456','CITIZEN',_binary '\0'),(7,'Kushal','kushalgowda25@gmail.com','kushal','CITIZEN',_binary '\0'),(8,'Namratha','namrthaishq25@gmail.com','ishq','CITIZEN',_binary '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-21  6:52:49
