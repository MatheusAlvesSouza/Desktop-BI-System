CREATE DATABASE  IF NOT EXISTS `native_american` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `native_american`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: native_american
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.33-MariaDB

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
-- Table structure for table `tbl_cidade`
--

DROP TABLE IF EXISTS `tbl_cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idEstado` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CIDADE_ESTADO` (`idEstado`),
  KEY `CIDADE_NOME` (`nome`) USING BTREE,
  CONSTRAINT `fk_estado_cidade` FOREIGN KEY (`idEstado`) REFERENCES `tbl_estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cidade`
--

LOCK TABLES `tbl_cidade` WRITE;
/*!40000 ALTER TABLE `tbl_cidade` DISABLE KEYS */;
INSERT INTO `tbl_cidade` VALUES (1,1,'Rio Branco'),(2,1,'Cruzeiro do Sul'),(3,4,'Manaus'),(4,2,'Maceió'),(5,3,'Macapá'),(6,5,'Salvador'),(7,5,'Pilão Arcado'),(8,6,'Fortaleza'),(9,7,'Brasilia'),(10,8,'Vitória'),(11,9,'Goiania'),(12,10,'São Luis'),(13,11,'Cuiabá'),(14,12,'Campo Grande'),(15,13,'Belo Horizonte'),(16,14,'Belém'),(17,17,'Recife'),(18,18,'Teresina'),(19,19,'Rio de Janeiro'),(20,20,'Natal'),(21,21,'Porto Alegre'),(22,22,'Porto Velho'),(23,23,'Boa Vista'),(24,24,'Florianópolis'),(25,25,'São Paulo'),(26,25,'Campinas'),(27,26,'Aracaju'),(28,27,'Pindorama'),(29,27,'Palmas'),(30,6,'Nova Capela'),(31,3,'Distrito Novo'),(32,16,'Curitiba');
/*!40000 ALTER TABLE `tbl_cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_denuncia_desmatamento`
--

DROP TABLE IF EXISTS `tbl_denuncia_desmatamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_denuncia_desmatamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCidade` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descricao` text NOT NULL,
  `data` date NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `DENUNCIA_CIDADE` (`idCidade`),
  KEY `DENUNCIA_ATIVO` (`ativo`) USING BTREE,
  CONSTRAINT `fk_denuncia_cidade` FOREIGN KEY (`idCidade`) REFERENCES `tbl_cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_denuncia_desmatamento`
--

LOCK TABLES `tbl_denuncia_desmatamento` WRITE;
/*!40000 ALTER TABLE `tbl_denuncia_desmatamento` DISABLE KEYS */;
INSERT INTO `tbl_denuncia_desmatamento` VALUES (1,2,'Pesca Ilegal','Foi realizado uma denúncia anônima sobre a pesca ilegal no rio Caruaru próximo ao pier 37.','2018-11-01',1),(2,3,'Corte de Arvores','Corte de arvores ilegal na região do Jardim Pequi, lado oeste do centro de Manaus.\r\n\r\n\r\n','2018-11-19',1),(38,19,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-07-23',1),(39,4,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-03-26',1),(40,10,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-05-12',1),(41,1,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-07-26',1),(42,8,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-09-24',1),(43,7,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-03-10',1),(44,21,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-05-25',1),(45,27,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-06-10',1),(46,20,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-08-24',1),(47,4,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-04-07',1),(48,23,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-05-15',1),(49,3,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-08-22',1),(50,28,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-07-19',1),(51,7,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-10-27',1),(52,13,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-04-13',1),(53,7,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-04-16',1),(54,14,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-02-06',1),(55,3,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-06-15',1),(56,27,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-01-27',1),(57,18,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-02-06',1),(58,1,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-07-07',1),(59,1,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-08-16',1),(60,16,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-06-01',1),(61,16,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-02-13',1),(62,4,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-06-18',1),(63,20,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-03-23',1),(64,22,'Corte de Arvores','Corte ilegal de arvores que estão entrando em extinção','2016-05-16',1),(65,17,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-07-25',1),(66,13,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-07-23',1),(67,9,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-10-27',1),(68,4,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-05-19',1),(69,13,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-01-03',1),(70,24,'Pesca Ilegal','Pesca ilegal denunciada na região que compromete o periodo fertil dos peixes','2016-04-25',1),(71,15,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-09-20',1),(72,5,'Pesticida Ilegal','Uso de pesticida em colheitas, estão afetando regiões populadas','2016-02-04',0);
/*!40000 ALTER TABLE `tbl_denuncia_desmatamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estado`
--

DROP TABLE IF EXISTS `tbl_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPais` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ESTADO_PAIS` (`idPais`),
  KEY `ESTADO_NOME` (`nome`) USING BTREE,
  CONSTRAINT `fk_pais_estado` FOREIGN KEY (`idPais`) REFERENCES `tbl_pais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estado`
--

LOCK TABLES `tbl_estado` WRITE;
/*!40000 ALTER TABLE `tbl_estado` DISABLE KEYS */;
INSERT INTO `tbl_estado` VALUES (1,1,'Acre'),(2,1,'Alagoas'),(3,1,'Amapá'),(4,1,'Amazonas'),(5,1,'Bahia'),(6,1,'Ceará'),(7,1,'Distrito Federal'),(8,1,'Espírito Santo'),(9,1,'Goías'),(10,1,'Maranhão'),(11,1,'Mato Grosso'),(12,1,'Mato Grosso do Sul'),(13,1,'Minas Gerais'),(14,1,'Pará'),(15,1,'Paraíba'),(16,1,'Paraná'),(17,1,'Pernambuco'),(18,1,'Piauí'),(19,1,'Rio de Janeiro'),(20,1,'Rio Grande do Norte'),(21,1,'Rio Grande do Sul'),(22,1,'Rondônia'),(23,1,'Roraima'),(24,1,'Santa Catarina'),(25,1,'São Paulo'),(26,1,'Sergipe'),(27,1,'Tocantins');
/*!40000 ALTER TABLE `tbl_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_indio`
--

DROP TABLE IF EXISTS `tbl_indio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_indio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idReservaIndigena` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `dtNasc` date NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `INDIO_RESERVA` (`idReservaIndigena`),
  KEY `INDIO_ATIVO` (`ativo`) USING BTREE,
  CONSTRAINT `fk_indio_reserva` FOREIGN KEY (`idReservaIndigena`) REFERENCES `tbl_reserva_indigena` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=440 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_indio`
--

LOCK TABLES `tbl_indio` WRITE;
/*!40000 ALTER TABLE `tbl_indio` DISABLE KEYS */;
INSERT INTO `tbl_indio` VALUES (1,1,'Janaina Pirajá','F','2000-10-07',1),(2,1,'Mayara Aruaco','F','1995-01-25',1),(3,1,'Moacir Pirajá','M','1980-05-07',0),(4,2,'Jaci Tadeu','M','1995-05-08',1),(5,1,'Jana Taku','F','2018-11-19',1),(6,3,'Take Urucuma','M','2018-11-05',1),(7,3,'Angelo Tupi','M','2017-05-12',1),(8,2,'Marcelo Rama','M','2005-06-10',1),(9,3,'Piatã Tabajara','M','1992-06-14',1),(10,12,'Yank Suaçuna','M','1993-11-09',1),(11,11,'Apoema Murici','M','1986-06-09',1),(12,1,'Piatã Araripe','M','1986-02-13',1),(13,5,'Jacir Jaguaribe','M','2003-02-12',1),(14,7,'Acir Tabajara','M','1986-08-13',1),(15,9,'Kaue Murici','M','2010-09-11',1),(16,10,'Jacir Acatauassú','M','1950-09-03',1),(17,6,'Araruna Acatauassú','M','2001-07-14',1),(18,1,'Yancy Jaguaribe','M','2007-06-20',1),(19,12,'Piatã Cairu','M','2015-04-17',1),(20,13,'Tibiriça Pitangui','M','1969-08-03',1),(21,8,'Poti Tibiriçá','M','1955-08-04',1),(22,8,'Endi Jaguaribe','M','2007-05-05',1),(23,10,'Yank Paraguaçu','M','1969-01-07',1),(24,7,'Iberê Pitangui','M','2000-09-05',1),(25,5,'Tibiriça Jaguaribe','M','1992-11-07',1),(26,12,'Iberê Tibiriçá','M','2010-07-07',1),(27,1,'Iberê Tibiriçá','M','1975-01-06',1),(28,3,'Araruna Cairu','M','1959-06-13',1),(29,5,'Iberê Acatauassú','M','1965-10-23',1),(30,7,'Ubiratã Pitangui','M','2015-07-08',1),(31,9,'Yancy Jaguaribe','M','2001-09-26',1),(32,14,'Taiguara Paraguaçu','M','1997-09-15',1),(33,2,'Itaú Paraguaçu','M','1970-08-11',1),(34,12,'Xamã Capiperibe','M','1955-08-11',1),(35,1,'Itambé Paraguaçu','M','2015-03-03',1),(36,12,'Endi Tibiriçá','M','1960-04-01',1),(37,6,'Jacir Tabajara','M','2011-04-22',1),(38,1,'Endi Paraguaçu','M','1959-01-02',1),(39,1,'Yancy Jaguaribe','M','1968-03-05',1),(40,10,'Grajaú Tibiriçá','M','2000-08-17',1),(41,5,'Xamã Jatobá','M','1989-01-21',1),(42,11,'Yank Saraíba','M','2014-05-27',1),(43,13,'Ubiratã Murici','M','1957-03-21',1),(44,3,'Apoema Saraíba','M','1970-04-20',1),(45,10,'Endi Capiperibe','M','1976-06-17',1),(46,14,'Kaue Murici','M','1990-10-16',1),(47,8,'Porã Saraíba','M','1972-08-23',1),(48,14,'Joaci Tabajara','M','1961-06-15',1),(49,14,'Joaci Jaguaribe','M','1991-11-03',1),(50,4,'Joaci Paraguaçu','M','1959-05-13',1),(51,11,'Apoema Cairu','M','1994-11-27',1),(52,7,'Poti Jatobá','M','1985-11-08',1),(53,11,'Jacir Paraguaçu','M','1987-05-22',1),(54,5,'Ubiratã Tabajara','M','1983-03-18',1),(55,14,'Porã Murici','M','2009-06-14',1),(56,7,'Jacir Capiperibe','M','1963-06-10',1),(57,5,'Araruna Tabajara','M','1960-11-10',1),(58,14,'Kaue Tibiriçá','M','1990-04-04',1),(59,7,'Araruna Saraíba','M','2008-10-04',1),(60,4,'Piatã Pari','M','2015-09-26',1),(61,2,'Apoema Tibiriçá','M','1972-07-25',1),(62,6,'Acir Jaguaribe','M','1964-09-06',1),(63,10,'Tupã Tibiriçá','M','1998-11-23',1),(64,10,'Kaue Cairu','M','1989-11-15',1),(65,8,'Tibiriça Pari','M','1957-11-06',1),(66,9,'Acir Jaguaribe','M','1975-01-04',1),(67,5,'Kaue Araripe','M','1963-01-19',1),(68,1,'Yank Jatobá','M','2005-04-02',1),(69,11,'Endi Suaçuna','M','1956-07-16',1),(70,2,'Poti Suaçuna','M','1965-09-27',1),(71,9,'Acir Paraguaçu','M','1978-08-02',1),(72,14,'Kaue Jatobá','M','2014-05-27',1),(73,4,'Kaue Murici','M','1992-08-13',1),(74,7,'Piatã Jaguaribe','M','2005-02-04',1),(75,11,'Itaú Jatobá','M','2004-06-24',1),(76,11,'Xamã Araripe','M','1994-03-07',1),(77,13,'Endi Acatauassú','M','1952-08-24',1),(78,2,'Apoema Acatauassú','M','1984-05-04',1),(79,2,'Kaue Acatauassú','M','1980-11-01',1),(80,12,'Ubiratã Suaçuna','M','1962-11-24',1),(81,1,'Ubiratã Pari','M','1957-10-02',1),(82,9,'Yancy Acatauassú','M','2009-02-09',1),(83,7,'Yancy Acatauassú','M','1992-07-15',1),(84,6,'Acir Tabajara','M','2006-03-22',1),(85,10,'Itaú Capiperibe','M','2004-04-12',1),(86,10,'Yancy Pari','M','1973-02-07',1),(87,11,'Grajaú Suaçuna','M','1995-02-11',1),(88,9,'Kaue Suaçuna','M','2008-06-23',1),(89,12,'Acir Cairu','M','1954-07-01',1),(90,4,'Porã Suaçuna','M','1998-04-10',1),(91,6,'Tibiriça Saraíba','M','2013-06-03',1),(92,10,'Poti Jatobá','M','1958-04-18',1),(93,2,'Grajaú Capiperibe','M','1953-03-04',1),(94,13,'Kaue Pitangui','M','2001-08-01',1),(95,12,'Itambé Pitangui','M','1962-05-16',1),(96,14,'Yancy Suaçuna','M','1958-03-27',1),(97,14,'Kaue Cairu','M','1977-10-11',1),(98,5,'Itaú Paraguaçu','M','1998-03-15',1),(99,14,'Iberê Cairu','M','1954-10-19',1),(100,3,'Moacir Jaguaribe','M','2012-05-15',1),(101,4,'Grajaú Jatobá','M','1962-11-16',1),(102,7,'Tupã Acatauassú','M','2010-08-05',1),(103,12,'Araruna Paraguaçu','M','1993-03-16',1),(104,8,'Tupã Tabajara','M','1981-02-11',1),(105,2,'Yank Capiperibe','M','1998-08-24',1),(106,13,'Moacir Araripe','M','2016-08-20',1),(107,13,'Grajaú Jaguaribe','M','1962-01-17',1),(108,2,'Itambé Tabajara','M','1972-06-27',1),(109,11,'Jacir Murici','M','1977-07-25',1),(110,8,'Itaú Tibiriçá','M','2013-01-20',1),(111,3,'Piatã Araripe','M','1999-02-23',1),(112,6,'Yank Pitangui','M','1979-06-14',1),(113,4,'Grajaú Paraguaçu','M','1998-11-09',1),(114,13,'Taiguara Suaçuna','M','1997-03-15',1),(115,12,'Tupã Pitangui','M','1989-09-08',1),(116,1,'Porã Araripe','M','1989-07-16',1),(117,6,'Kaue Tabajara','M','1981-06-11',1),(118,8,'Tupã Murici','M','1999-06-05',1),(119,1,'Acir Jaguaribe','M','1992-03-18',1),(120,10,'Grajaú Acatauassú','M','2009-10-11',1),(121,1,'Acir Araripe','M','1979-03-18',1),(122,9,'Tibiriça Tabajara','M','1950-07-27',1),(123,11,'Taiguara Tibiriçá','M','1981-11-03',1),(124,9,'Endi Capiperibe','M','1964-03-01',1),(125,6,'Tupã Tabajara','M','1951-06-24',1),(126,13,'Jacir Murici','M','2016-06-05',1),(127,13,'Jacir Jaguaribe','M','1977-05-10',1),(128,13,'Tibiriça Tibiriçá','M','1990-11-05',1),(129,6,'Moacir Capiperibe','M','1969-01-23',1),(130,8,'Piatã Pari','M','1991-03-01',1),(131,6,'Poti Acatauassú','M','1972-08-18',1),(132,12,'Araruna Murici','M','1969-09-27',1),(133,13,'Tibiriça Saraíba','M','1984-07-06',1),(134,8,'Araruna Cairu','M','1964-03-26',1),(135,8,'Kaue Jaguaribe','M','2013-10-12',1),(136,4,'Jacir Pitangui','M','2008-09-23',1),(137,9,'Tupã Tibiriçá','M','1972-04-22',1),(138,11,'Porã Cairu','M','2015-05-19',1),(139,5,'Acir Tabajara','M','1955-11-04',1),(140,14,'Kaue Pari','M','1969-02-07',1),(141,4,'Tibiriça Araripe','M','1975-07-24',1),(142,4,'Itambé Jaguaribe','M','1992-07-20',1),(143,4,'Joaci Jatobá','M','1958-02-16',1),(144,11,'Tibiriça Araripe','M','1989-01-21',1),(145,9,'Poti Saraíba','M','2001-05-10',1),(146,10,'Acir Jaguaribe','M','1961-05-26',1),(147,1,'Apoema Suaçuna','M','1969-10-09',1),(148,4,'Jacir Jaguaribe','M','1960-04-15',1),(149,1,'Endi Jaguaribe','M','1969-04-10',1),(150,2,'Yank Acatauassú','M','1954-10-10',1),(151,11,'Iberê Saraíba','M','1952-05-21',1),(152,7,'Tibiriça Tabajara','M','1962-01-04',1),(153,7,'Iberê Murici','M','1987-10-08',1),(154,10,'Itambé Murici','M','1968-07-04',1),(155,2,'Endi Paraguaçu','M','1988-06-25',1),(156,8,'Taiguara Acatauassú','M','1999-09-24',1),(157,1,'Jacir Capiperibe','M','2010-03-24',1),(158,9,'Araruna Capiperibe','M','2014-11-27',1),(159,2,'Grajaú Tabajara','M','2014-03-06',1),(160,3,'Jacir Pari','M','1995-09-18',1),(161,8,'Piatã Pari','M','1966-05-01',1),(162,2,'Iberê Tabajara','M','1974-05-23',1),(163,1,'Iberê Murici','M','2007-10-15',1),(164,6,'Jacir Pari','M','1991-02-08',1),(165,2,'Piatã Murici','M','1961-11-21',1),(166,14,'Yank Suaçuna','M','1992-05-19',1),(167,14,'Yank Pari','M','1985-10-08',1),(168,5,'Itambé Murici','M','1958-07-01',1),(169,2,'Ubiratã Acatauassú','M','1956-05-01',1),(170,8,'Xamã Acatauassú','M','1974-01-18',1),(171,4,'Ubiratã Cairu','M','1969-03-13',1),(172,6,'Poti Tabajara','M','1994-07-13',1),(173,13,'Taiguara Cairu','M','1996-04-15',1),(174,1,'Porã Suaçuna','M','2003-11-13',1),(175,12,'Iberê Tibiriçá','M','1981-08-13',1),(176,12,'Kaue Jaguaribe','M','1982-08-15',1),(177,14,'Acir Acatauassú','M','1995-05-16',1),(178,4,'Joaci Pitangui','M','1991-09-23',1),(179,14,'Joaci Tibiriçá','M','1980-11-11',1),(180,10,'Yancy Jatobá','M','2013-07-19',1),(181,12,'Kaue Acatauassú','M','1955-08-23',1),(182,7,'Apoema Suaçuna','M','1962-04-19',1),(183,5,'Kaue Saraíba','M','1969-10-01',1),(184,13,'Tibiriça Paraguaçu','M','1959-05-26',1),(185,3,'Porã Capiperibe','M','1957-01-23',1),(186,10,'Poti Jatobá','M','2000-03-08',1),(187,1,'Ubiratã Capiperibe','M','1971-04-04',1),(188,3,'Endi Tibiriçá','M','2001-11-19',1),(189,1,'Poti Cairu','M','1988-05-27',1),(190,10,'Piatã Capiperibe','M','1993-08-12',1),(191,8,'Moacir Acatauassú','M','1969-04-22',1),(192,1,'Porã Capiperibe','M','1954-01-11',1),(193,5,'Acir Cairu','M','2012-08-04',1),(194,4,'Itaú Murici','M','1975-10-10',1),(195,12,'Itaú Araripe','M','1990-02-21',1),(196,3,'Ubiratã Capiperibe','M','1983-07-26',1),(197,6,'Iberê Tibiriçá','M','1970-04-08',1),(198,4,'Acir Murici','M','1982-01-19',1),(199,3,'Joaci Pitangui','M','2015-08-03',1),(200,11,'Moacir Araripe','M','1959-08-12',1),(201,10,'Itambé Tabajara','M','1964-08-10',1),(202,14,'Endi Pari','M','1958-04-25',1),(203,5,'Ubiratã Tabajara','M','2001-10-08',1),(204,14,'Ubiratã Araripe','M','1976-09-02',1),(205,14,'Acir Jatobá','M','2002-10-10',1),(206,13,'Apoema Murici','M','1983-08-02',1),(207,3,'Taiguara Suaçuna','M','1962-06-05',1),(208,1,'Endi Pari','M','1954-03-12',1),(209,4,'Tibiriça Pari','M','1972-04-17',1),(210,14,'Grajaú Pitangui','M','1954-08-18',1),(211,1,'Yank Pari','M','1996-01-08',1),(212,12,'Yancy Capiperibe','M','2003-10-23',1),(213,14,'Moacir Cairu','M','1971-07-23',1),(214,13,'Endi Capiperibe','M','1967-09-23',1),(215,14,'Araruna Pitangui','M','1995-02-13',1),(216,1,'Piatã Jatobá','M','1953-03-23',1),(217,2,'Iberê Tibiriçá','M','1978-10-04',1),(218,1,'Taiguara Pari','M','1984-02-25',1),(219,1,'Tibiriça Murici','M','1996-08-04',1),(220,14,'Araruna Saraíba','M','1998-11-07',1),(221,9,'Apoema Pari','M','1975-06-18',1),(222,10,'Jacir Pitangui','M','1955-05-05',1),(223,14,'Poti Jatobá','M','1966-08-03',1),(224,12,'Kaue Saraíba','M','1995-04-26',1),(225,3,'Piatã Pari','M','1967-05-14',1),(226,2,'Jacir Paraguaçu','M','1981-09-11',1),(227,13,'Apoema Acatauassú','M','1969-08-14',1),(228,5,'Piatã Pitangui','M','1967-10-16',1),(229,6,'Poti Tabajara','M','1977-03-17',1),(230,10,'Tibiriça Pitangui','M','1966-09-02',1),(231,5,'Grajaú Paraguaçu','M','1974-03-16',1),(232,8,'Piatã Suaçuna','M','1963-03-27',1),(233,2,'Piatã Acatauassú','M','1962-05-21',1),(234,9,'Porã Tibiriçá','M','1966-11-02',1),(235,10,'Jacir Tibiriçá','M','1978-04-22',1),(236,14,'Moacir Pari','M','1990-10-07',1),(237,1,'Joaci Suaçuna','M','1979-03-12',1),(238,10,'Itaú Tibiriçá','M','1952-08-01',1),(239,11,'Tibiriça Paraguaçu','M','2003-11-09',1),(240,10,'Poti Pari','M','1984-09-02',1),(241,14,'Grajaú Pitangui','M','1952-05-22',1),(242,10,'Yoki Paraguaçu','F','2010-04-06',1),(243,9,'Jaci Suaçuna','F','1999-01-02',1),(244,14,'Juraci Tabajara','F','2001-04-16',1),(245,13,'Aruana Tabajara','F','1954-09-19',1),(246,14,'Dakota Murici','F','2000-01-01',1),(247,13,'Juraci Jatobá','F','1961-04-08',1),(248,3,'Aritana Suaçuna','F','1958-02-06',1),(249,8,'Juraci Pitangui','F','1991-05-09',1),(250,8,'Jaciara Suaçuna','F','2004-08-04',1),(251,11,'Aiyra Cairu','F','1995-02-04',1),(252,8,'Kauana Murici','F','1982-01-20',1),(253,11,'Moema Jaguaribe','F','1972-04-04',1),(254,1,'Aruana Pari','F','2015-10-02',1),(255,9,'Bartira Araripe','F','1989-09-03',1),(256,3,'Juraci Paraguaçu','F','1963-10-15',1),(257,5,'Jaciara Acatauassú','F','1997-05-21',1),(258,4,'Tuane Jatobá','F','1971-10-27',1),(259,2,'Raíra Pari','F','1983-08-06',1),(260,7,'Aruana Suaçuna','F','1981-01-07',1),(261,4,'Potira Pari','F','1990-10-10',1),(262,13,'Aruana Jaguaribe','F','2014-10-07',1),(263,1,'Lauany Murici','F','2012-03-17',1),(264,10,'Lauany Cairu','F','1954-08-15',1),(265,3,'Aiyra Murici','F','1964-05-11',1),(266,3,'Aruana Capiperibe','F','1995-07-05',1),(267,7,'Niara Suaçuna','F','2015-06-19',1),(268,14,'Aiyra Murici','F','2006-01-12',1),(269,12,'Jaci Jatobá','F','1976-05-15',1),(270,8,'Moara Araripe','F','1960-10-06',1),(271,8,'Anahí Suaçuna','F','1960-06-03',1),(272,4,'Dakota Pitangui','F','1954-05-21',1),(273,2,'Potira Acatauassú','F','1978-08-19',1),(274,6,'Tuane Cairu','F','2008-10-08',1),(275,1,'Tuane Acatauassú','F','1975-11-14',1),(276,8,'Aritana Tibiriçá','F','1973-02-09',1),(277,2,'Niara Murici','F','1974-04-22',1),(278,3,'Aritana Tabajara','F','1975-09-23',1),(279,4,'Yoki Saraíba','F','2009-04-23',1),(280,12,'Anahí Araripe','F','2009-04-03',1),(281,1,'Raíra Pitangui','F','2015-05-07',1),(282,2,'Moema Suaçuna','F','2011-06-09',1),(283,6,'Tuane Jatobá','F','1982-06-20',1),(284,5,'Jurema Cairu','F','2001-09-07',1),(285,11,'Niara Murici','F','1996-06-26',1),(286,10,'Bartira Paraguaçu','F','2001-03-09',1),(287,2,'Jurema Tabajara','F','1951-06-05',1),(288,5,'Aruana Murici','F','1988-01-03',1),(289,2,'Iandara Jatobá','F','2014-11-07',1),(290,7,'Niara Araripe','F','1969-11-19',1),(291,3,'Yoki Pari','F','2014-01-24',1),(292,12,'Dakota Araripe','F','1957-01-13',1),(293,13,'Kauana Murici','F','1998-10-21',1),(294,2,'Raíra Acatauassú','F','2006-11-02',1),(295,5,'Yoki Pari','F','1968-08-19',1),(296,9,'Aiyra Jaguaribe','F','2009-01-14',1),(297,7,'Kauana Murici','F','2013-05-21',1),(298,7,'Niara Jaguaribe','F','1951-07-18',1),(299,13,'Yoki Jatobá','F','1971-10-08',1),(300,7,'Jurema Suaçuna','F','1999-09-09',1),(301,6,'Jaciara Tabajara','F','1997-06-01',1),(302,1,'Jaci Araripe','F','1974-03-08',1),(303,7,'Bartira Jaguaribe','F','1967-08-12',1),(304,6,'Aritana Acatauassú','F','1982-08-03',1),(305,12,'Lauany Saraíba','F','1974-08-16',1),(306,13,'Aritana Pari','F','1975-05-24',1),(307,4,'Jaci Paraguaçu','F','1981-05-11',1),(308,4,'Jaci Pitangui','F','1972-04-14',1),(309,8,'Niara Cairu','F','2013-10-01',1),(310,9,'Moara Murici','F','1997-11-02',1),(311,9,'Niara Tabajara','F','2009-08-25',1),(312,12,'Tuane Tabajara','F','1976-02-14',1),(313,3,'Jurema Saraíba','F','1971-04-22',1),(314,3,'Moema Pitangui','F','1951-06-06',1),(315,12,'Moema Tibiriçá','F','1978-06-11',1),(316,11,'Kauana Araripe','F','1950-10-24',1),(317,4,'Dakota Jatobá','F','1981-02-14',1),(318,13,'Bartira Suaçuna','F','1993-05-24',1),(319,10,'Juraci Acatauassú','F','1982-04-09',1),(320,2,'Potira Tabajara','F','1999-10-22',1),(321,7,'Aiyra Capiperibe','F','1965-03-09',1),(322,10,'Niara Murici','F','1957-07-08',1),(323,1,'Dakota Pari','F','1988-01-18',1),(324,11,'Juraci Tibiriçá','F','1967-02-26',1),(325,1,'Yoki Saraíba','F','1996-02-21',1),(326,10,'Tuane Jatobá','F','1979-02-06',1),(327,13,'Juraci Pari','F','1958-05-25',1),(328,10,'Bartira Pitangui','F','1976-09-08',1),(329,1,'Kauana Pitangui','F','1967-04-07',1),(330,9,'Jurema Jatobá','F','1976-01-18',1),(331,8,'Aruana Suaçuna','F','1958-03-02',1),(332,5,'Anahí Capiperibe','F','1967-01-19',1),(333,1,'Jaciara Pari','F','1952-02-24',1),(334,10,'Yoki Saraíba','F','2010-10-22',1),(335,12,'Iandara Jatobá','F','1953-05-17',1),(336,13,'Aiyra Murici','F','2001-11-08',1),(337,10,'Anahí Tabajara','F','1951-03-23',1),(338,1,'Yoki Saraíba','F','1963-06-20',1),(339,14,'Yoki Tabajara','F','1981-06-14',1),(340,13,'Jaci Pari','F','1950-05-17',1),(341,5,'Moema Pari','F','1988-03-21',1),(342,12,'Aiyra Suaçuna','F','2009-11-16',1),(343,6,'Potira Cairu','F','1964-11-23',1),(344,8,'Jaciara Capiperibe','F','2006-09-14',1),(345,13,'Lauany Araripe','F','1992-02-08',1),(346,4,'Aritana Saraíba','F','2005-10-27',1),(347,6,'Aruana Cairu','F','1958-06-03',1),(348,14,'Aruana Pari','F','2009-09-12',1),(349,14,'Raíra Capiperibe','F','2004-08-06',1),(350,2,'Moema Araripe','F','1987-05-01',1),(351,9,'Juraci Saraíba','F','1957-06-19',1),(352,6,'Iandara Pari','F','2001-09-06',1),(353,7,'Jaciara Jatobá','F','1971-07-12',1),(354,2,'Potira Capiperibe','F','1977-06-08',1),(355,10,'Aiyra Jatobá','F','1968-11-12',1),(356,2,'Niara Jaguaribe','F','1970-02-22',1),(357,14,'Niara Pitangui','F','1971-11-27',1),(358,5,'Jurema Tibiriçá','F','1986-01-03',1),(359,14,'Jaciara Paraguaçu','F','1989-02-18',1),(360,1,'Niara Saraíba','F','1996-11-07',1),(361,10,'Raíra Suaçuna','F','1952-04-09',1),(362,11,'Bartira Jaguaribe','F','2013-10-23',1),(363,9,'Aruana Tibiriçá','F','1963-02-13',1),(364,7,'Potira Cairu','F','1995-10-06',1),(365,14,'Lauany Capiperibe','F','1981-07-13',1),(366,14,'Iandara Araripe','F','2011-03-20',1),(367,12,'Aritana Murici','F','1999-02-20',1),(368,9,'Moema Pari','F','1988-05-16',1),(369,6,'Moara Jatobá','F','1959-07-01',1),(370,10,'Aruana Araripe','F','1984-03-25',1),(371,11,'Potira Acatauassú','F','1966-04-11',1),(372,5,'Bartira Jaguaribe','F','1991-07-23',1),(373,11,'Anahí Tabajara','F','1973-03-02',1),(374,11,'Aritana Cairu','F','1967-02-01',1),(375,12,'Iandara Tabajara','F','1999-10-14',1),(376,9,'Aiyra Cairu','F','1996-03-11',1),(377,12,'Moema Acatauassú','F','2010-04-24',1),(378,3,'Potira Capiperibe','F','1985-11-19',1),(379,9,'Jaciara Suaçuna','F','1982-01-01',1),(380,10,'Anahí Pitangui','F','1996-01-18',1),(381,4,'Jaci Murici','F','2006-08-18',1),(382,12,'Kauana Paraguaçu','F','2008-02-24',1),(383,3,'Lauany Murici','F','1985-09-18',1),(384,13,'Moema Murici','F','2001-02-11',1),(385,11,'Raíra Cairu','F','2009-04-22',1),(386,9,'Aruana Tabajara','F','1954-07-05',1),(387,10,'Aiyra Murici','F','2012-01-09',1),(388,7,'Anahí Acatauassú','F','1982-10-01',1),(389,4,'Tuane Araripe','F','1964-07-23',1),(390,9,'Aritana Jatobá','F','1992-11-19',1),(391,14,'Aiyra Pari','F','2011-09-18',1),(392,12,'Moara Capiperibe','F','1996-10-01',1),(393,13,'Potira Saraíba','F','1985-06-18',1),(394,9,'Bartira Murici','F','2004-06-01',1),(395,11,'Lauany Paraguaçu','F','1969-11-20',1),(396,9,'Moema Jatobá','F','1991-01-05',1),(397,12,'Yoki Araripe','F','1967-06-19',1),(398,13,'Tuane Pari','F','1975-07-16',1),(399,13,'Potira Murici','F','2000-11-09',1),(400,13,'Jaci Jatobá','F','2005-01-15',1),(401,4,'Jaci Tabajara','F','2014-04-26',1),(402,14,'Yoki Araripe','F','2002-08-16',1),(403,2,'Juraci Cairu','F','1997-02-22',1),(404,13,'Moema Jaguaribe','F','1968-08-04',1),(405,9,'Raíra Acatauassú','F','1969-01-04',1),(406,6,'Jaci Tabajara','F','1966-05-05',1),(407,14,'Raíra Murici','F','1971-08-18',1),(408,7,'Dakota Jatobá','F','1965-06-14',1),(409,7,'Iandara Araripe','F','1993-09-22',1),(410,3,'Kauana Tabajara','F','2003-03-07',1),(411,7,'Raíra Suaçuna','F','1987-07-27',1),(412,6,'Anahí Jatobá','F','1955-10-26',1),(413,14,'Moema Pari','F','1951-01-20',1),(414,9,'Potira Pitangui','F','2008-07-06',1),(415,11,'Aiyra Tabajara','F','1991-02-20',1),(416,1,'Dakota Murici','F','1957-07-02',1),(417,14,'Kauana Pitangui','F','1999-01-11',1),(418,12,'Yoki Tabajara','F','1953-07-25',1),(419,10,'Yoki Saraíba','F','1951-10-08',1),(420,3,'Aiyra Capiperibe','F','1952-02-04',1),(421,11,'Potira Pitangui','F','1989-08-17',1),(422,10,'Lauany Capiperibe','F','1966-05-21',1),(423,5,'Moara Saraíba','F','2008-06-19',1),(424,8,'Moara Tibiriçá','F','1958-04-15',1),(425,12,'Juraci Paraguaçu','F','1971-07-01',1),(426,3,'Kauana Pari','F','1954-01-10',1),(427,11,'Jaci Paraguaçu','F','2011-09-13',1),(428,11,'Niara Saraíba','F','2000-08-21',1),(429,10,'Iandara Saraíba','F','1962-10-26',1),(430,11,'Kauana Araripe','F','2000-05-17',1),(431,3,'Moara Capiperibe','F','1962-10-06',1),(432,14,'Bartira Jaguaribe','F','1957-07-14',1),(433,1,'Yoki Jatobá','F','1955-08-14',1),(434,8,'Yoki Saraíba','F','1982-03-25',1),(435,14,'Tuane Araripe','F','1988-06-26',1),(436,3,'Lauany Suaçuna','F','1997-09-18',1),(437,12,'Jaciara Araripe','F','1974-01-11',1),(438,8,'Yoki Cairu','F','1988-02-14',1),(439,10,'Niara Pitangui','F','2008-04-26',1);
/*!40000 ALTER TABLE `tbl_indio` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER after_insert_indio AFTER INSERT 
    ON tbl_indio
    FOR EACH ROW BEGIN
        INSERT INTO tbl_reserva_indigena_log(idReservaIndigena, idIndio, tipo, data)
		VALUES(NEW.idReservaIndigena, NEW.id, 'INCREASE', NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tbl_pais`
--

DROP TABLE IF EXISTS `tbl_pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PAIS_NOME` (`nome`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pais`
--

LOCK TABLES `tbl_pais` WRITE;
/*!40000 ALTER TABLE `tbl_pais` DISABLE KEYS */;
INSERT INTO `tbl_pais` VALUES (1,'Brasil');
/*!40000 ALTER TABLE `tbl_pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reserva_indigena`
--

DROP TABLE IF EXISTS `tbl_reserva_indigena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reserva_indigena` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCidade` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RESEVA_CIDADE` (`idCidade`),
  KEY `RESERVA_POP` (`idCidade`) USING BTREE,
  CONSTRAINT `fk_reserva_cidade` FOREIGN KEY (`idCidade`) REFERENCES `tbl_cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reserva_indigena`
--

LOCK TABLES `tbl_reserva_indigena` WRITE;
/*!40000 ALTER TABLE `tbl_reserva_indigena` DISABLE KEYS */;
INSERT INTO `tbl_reserva_indigena` VALUES (1,1,'Takuari'),(2,2,'Ibotirama'),(3,3,'Tupis'),(4,16,'Tuxã'),(5,5,'Maupi'),(6,5,'Aconã'),(7,3,'Pankararú'),(8,28,'Maopé'),(9,26,'Javari'),(10,16,'Itaú'),(11,24,'Ubuntu'),(12,23,'Canapis'),(13,14,'Maré'),(14,18,'Kanaros'),(15,19,'Xumpan');
/*!40000 ALTER TABLE `tbl_reserva_indigena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reserva_indigena_log`
--

DROP TABLE IF EXISTS `tbl_reserva_indigena_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reserva_indigena_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idReservaIndigena` int(11) NOT NULL,
  `idIndio` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LOG_RESERVA` (`idReservaIndigena`),
  KEY `LOG_DATA` (`data`) USING BTREE,
  KEY `fk_log_indio_idx` (`idIndio`),
  CONSTRAINT `fk_log_indio` FOREIGN KEY (`idIndio`) REFERENCES `tbl_indio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_log_reserva` FOREIGN KEY (`idReservaIndigena`) REFERENCES `tbl_reserva_indigena` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=442 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reserva_indigena_log`
--

LOCK TABLES `tbl_reserva_indigena_log` WRITE;
/*!40000 ALTER TABLE `tbl_reserva_indigena_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_reserva_indigena_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20 15:33:57
