DROP SCHEMA IF EXISTS `cookbook_group1`;
CREATE DATABASE  IF NOT EXISTS `cookbook_group1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cookbook_group1`;
-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)

-- Created by Bo Jiao & Hanzhi Zhuang

-- Host: localhost    Database: cookbook_group1
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ingredientName` varchar(30) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `pretreatment` varchar(50) DEFAULT NULL,
  `recipeID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb3 COMMENT='ingredient table for digital cookbook';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (23,'potato noodles',1,'bunch',NULL,3),(24,'peanuts',2,'tablespoon','roasted',3),(25,'spring onion',1,'tablespoon','chopped',3),(26,'coriander',1,'tablespoon','chopped',3),(27,'pickled Sichuan vegetable',2,'tablespoon','chopped',3),(28,'garlic',3,'cloves',NULL,3),(29,'peanut oil',1,'tablespoon',NULL,3),(30,'Sichuan peppercorn powder',1,'teaspoon',NULL,3),(31,'Chinese five spicy powder',1,'teaspoon',NULL,3),(32,'chili powder',1,'teaspoon',NULL,3),(33,'vinegar',1,'tablespoon',NULL,3),(34,'light soy sauce',1,'tablespoon',NULL,3),(35,'salt',1,'teaspoon',NULL,3),(36,'very hot waterr',13,'kgg','boil it',3),(67,'pork belly',1,'kg','cut into 2cm pieces',2),(68,'cooking oil',2,'tablespoon',NULL,2),(69,'brown sugar',1,'tablespoon',NULL,2),(70,'Shaoxin rice wine',3,'tablespoon',NULL,2),(71,'light soy sauce',1,'tablespoon',NULL,2),(72,'dark soy sauce',1,'tablespoon',NULL,2),(73,'chicken stock or water',2,'cups',NULL,2),(106,'cornstarch',1,'tablespoon',NULL,1),(107,'soy sauce',4,'tablespoon',NULL,1),(108,'chicken breast',1,'kg',NULL,1),(109,'Shaoxin rice wine',3,'tablespoon',NULL,1),(110,'sugar',2,'tablespoon',NULL,1),(111,'chicken stock',3,'tablespoon',NULL,1),(112,'Chiangang vinegar',4,'teaspoon',NULL,1),(113,'sesame oil',4,'tablespoon',NULL,1),(114,'dark soy sauce',2,'teaspoon',NULL,1),(115,'peanut oil',3,'tablespoon',NULL,1),(116,'dried red chilis',12,'pieces','stemmed, halved crosswise, and seeded',1),(117,'scallions',5,'pieces','white part onyl, thickly sliced crosswise',1),(118,'garlic',1,'cloves','peeled, thinly sliced',1),(119,'ginger',1,'pieces','peeled, minced',1),(120,'peanuts',1,'cups','peeled, thinly sliced',1),(122,'shrimp',300,'g','',4),(123,'yellow chives',20,'g','cut into small pieces',4),(124,'wonton wrapper',100,'g',NULL,4),(125,'chicken broth',300,'ml','dilute with water',4),(126,'steamed chao mian noodles',230,'g',NULL,5),(127,'soy sauce',1,'tablespoon',NULL,5),(128,'oyster sauce',1,'tablespoon',NULL,5),(129,'sugar',1,'tablespoon',NULL,5),(130,'dark soy sauce',2,'tablespoon',NULL,5),(131,'water',3,'tablespoon',NULL,5),(132,'cooking oil',2,'tablespoon',NULL,5),(133,'garlic',3,'clove','finely minced',5),(134,'chicken',50,'g','cut into thin strips',5),(135,'shrimp',9,'item','shelled and deveined',5),(136,'cabbage',100,'g','cut into pieces',5),(137,'scallion',2,'stalk','cut into two-inch strips',5);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recipeName` varchar(50) DEFAULT NULL,
  `preparationTime` varchar(10) DEFAULT NULL,
  `cookingTime` varchar(10) DEFAULT NULL,
  `peopleAvailable` int DEFAULT NULL,
  `imagePath` varchar(50) DEFAULT NULL,
  `instruction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isFavourited` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='recipe table in the digital cookbook';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Hong Shao Rou','25 min','50 min',4,'hsr.jpg','1.Mix together cornstarch and 1 tbsp. of the soy sauce in a medium bowl.\n2.Add chicken, toss well, and set aside to marinate for 30 minutes.\n3.Meanwhile, mix together the remaining 3 tbsp. soy sauce, rice wine, sugar, stock, vinegar, sesame oil, and dark soy sauce.\n4.Set aside.\n5.Heat peanut oil in a wok or large nonstick skillet over high heat until just beginning to smoke.\n6.Add chilis, half the scallions, garlic, ginger, and chicken and stir-fry until chicken is golden, 3-5 minutes.\n7.Add soy sauce mixture and stir-fry until sauce thickens, about 2 minutes.\n8.Stir in peanuts.\n9.Garnish with remaining scallions.',0),(2,'Gong Bao Ji Ding','30 min','10 min',4,'gbjd.jpg','1.Bring a pot of water to a boil and blanch the pork for a couple minutes.\n2.Take the pork out of the pot and set aside.\n3.Over low heat, add oil and sugar to your wok.\n4.Melt the sugar slightly and add the pork.\n5.Raise the heat to medium and cook until the pork is lightly browned.\n6.Turn the heat back down to low and add cooking wine, light soy sauce, dark soy sauce, and chicken stock.\n7.Cover and simmer for about 60 minutes to 90 minutes until pork is fork tender.\n8.Every 5-10 minutes, stir to prevent burning and add water if it gets too dry.\n',0),(3,'Suan La Fen','10 min','60 min',2,'slf.jpg','1.Soak the sweet potato noodles with hot water around 30 minutes.\\n2.Transfer out and set aside.\\n3.In the serving bowls and mix all the seasonings.\\n4.Heat up peanuts oil in pan to stir-fry the mashed garlic until aroma.\\n5.Mix the garlic oil with the seasonings.\\n6.Add some spring onions and corianders in serving bowls.\\n7.Pour in boiling water or stock to tune the seasonings.\\n8.Mix well and set aside.\\n9.Cook soaked sweet potato noodles till it is soft.\\n10.Transfer the noodles out to the serving bowls and then add pickled vegetables, roasted peanuts and chopped spring onions and coriander on the top.',0),(4,'Wonton','20 min','15 min',2,'wt.jpg','1.Make the wonton filling.\\n2.Wrap the wonton with the filling using a store-bought wonton wrapper.\\n3.Cook the wrapped wontons in the broth.\\n4.Boil till the wrapped wontons float onto the top level of water.',1),(5,'Chao Mian','15 min','10 min',2,'cm.jpg','1.Soak the chow mein noodles in cold water for about 5 minutes.\\n2.Rinse a few times until water turns clear and noodles become soft.\\n3.Drain the excess water and set aside.\\n4.Mix all the ingredients of the Chow Mein Sauce together in a bowl and set aside.\\n5.Heat up a skillet or wok with the oil, then add in the garlic and stir-fry until light brown or aromatic.\\n6.Add the chicken and shrimp and stir fry until they are half cooked.\\n7.Add the shredded cabbage and carrot into the wok and do a few quick stirs.\\n8.Add the noodles and the soy sauce mixture.\\n9.Continue to stir fry until the noodles are well combined with the soy sauce mixture and completely cooked through.',1);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-04 20:14:03
