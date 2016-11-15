-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2016 at 03:05 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sgrh`
--

-- --------------------------------------------------------

--
-- Table structure for table `carreiras`
--

CREATE TABLE IF NOT EXISTS `carreiras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `carreiras`
--

INSERT INTO `carreiras` (`id`, `nome`) VALUES
(1, 'Tecnico de Saude'),
(2, 'Electricista'),
(3, 'Tecnico superior N1');

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `carreira_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categorias_fk_carreiras_idx` (`carreira_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`id`, `nome`, `carreira_id`) VALUES
(1, 'Categoria 1', 2),
(2, 'Categoria 2', 2),
(3, 'Categoria 3', 1),
(4, 'Categoria 4', 3);

-- --------------------------------------------------------

--
-- Table structure for table `cds`
--

CREATE TABLE IF NOT EXISTS `cds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cadeira` varchar(100) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `funcionario_id_UNIQUE` (`funcionario_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `cds`
--

INSERT INTO `cds` (`id`, `cadeira`, `funcionario_id`) VALUES
(1, 'Geografia', 2),
(2, 'Fisica Nuclear', 9),
(3, 'Linguagens formais e automatos', 10);

-- --------------------------------------------------------

--
-- Table structure for table `clazzes`
--

CREATE TABLE IF NOT EXISTS `clazzes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `carreira_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classes_fk_carreiras_idx` (`carreira_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `clazzes`
--

INSERT INTO `clazzes` (`id`, `nome`, `carreira_id`) VALUES
(1, 'Classe number one', 3),
(2, 'Classe E', 3);

-- --------------------------------------------------------

--
-- Table structure for table `concursos`
--

CREATE TABLE IF NOT EXISTS `concursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_aprovacao` date DEFAULT NULL,
  `data_registo` datetime DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `concursos`
--

INSERT INTO `concursos` (`id`, `data_aprovacao`, `data_registo`, `nome`) VALUES
(1, '2016-10-29', '2016-10-29 10:41:00', 'Concurso de recrutamento de tecnicos'),
(2, '2016-10-29', '2016-10-29 10:42:00', 'Recrutamento de CD'),
(3, '2016-10-29', '2016-11-02 18:12:00', 'Recrutamento de ctas'),
(4, '2016-11-14', NULL, 'novo6');

-- --------------------------------------------------------

--
-- Table structure for table `ctas`
--

CREATE TABLE IF NOT EXISTS `ctas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `funcionario_id_UNIQUE` (`funcionario_id`),
  KEY `ctas_fk_funcionarios_idx` (`funcionario_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ctas`
--

INSERT INTO `ctas` (`id`, `funcionario_id`) VALUES
(6, 7),
(5, 8),
(7, 11),
(8, 12);

-- --------------------------------------------------------

--
-- Table structure for table `delegacaos`
--

CREATE TABLE IF NOT EXISTS `delegacaos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `delegacaos`
--

INSERT INTO `delegacaos` (`id`, `nome`) VALUES
(1, 'Gaza'),
(2, 'Niassa'),
(3, 'Sofala'),
(4, 'Sede'),
(5, 'Nampula'),
(6, 'Tete'),
(7, 'Zambezia');

-- --------------------------------------------------------

--
-- Table structure for table `documentacaos`
--

CREATE TABLE IF NOT EXISTS `documentacaos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `carreira_id` int(11) DEFAULT NULL,
  `concurso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `documentacao_fk_carreira_idx` (`carreira_id`),
  KEY `documentacao_fk_concurso_idx` (`concurso_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `documentacaos`
--

INSERT INTO `documentacaos` (`id`, `nome`, `carreira_id`, `concurso_id`) VALUES
(1, 'Carta de Recomendacao', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `escalaos`
--

CREATE TABLE IF NOT EXISTS `escalaos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `clazze_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `escalao_fk_categoria_idx` (`categoria_id`),
  KEY `escalao_fk_classe_idx` (`clazze_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `escalaos`
--

INSERT INTO `escalaos` (`id`, `nome`, `categoria_id`, `clazze_id`) VALUES
(1, 'Escalao 1', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `nuit` int(9) DEFAULT NULL,
  `bi` int(13) DEFAULT NULL,
  `data_emissao` date DEFAULT NULL,
  `local_emissao` varchar(50) DEFAULT NULL,
  `contacto_pessoal` int(9) DEFAULT NULL,
  `contacto_trabalho` int(9) DEFAULT NULL,
  `contacto_alternativo` int(9) DEFAULT NULL,
  `email_pessoal` varchar(100) DEFAULT NULL,
  `email_corporativo` varchar(100) DEFAULT NULL,
  `curso` varchar(120) DEFAULT NULL,
  `especialidade` varchar(80) DEFAULT NULL,
  `ano_conclusao` datetime DEFAULT NULL,
  `carreira_id` int(11) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `clazze_id` int(11) DEFAULT NULL,
  `escalao_id` int(11) DEFAULT NULL,
  `delegacao_id` int(11) DEFAULT NULL,
  `sector_id` int(11) DEFAULT NULL,
  `departamento_id` int(11) DEFAULT NULL,
  `tipo_ingresso_id` int(11) DEFAULT NULL,
  `concurso_id` int(11) DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `funcionarios_fk_carreiras_idx` (`carreira_id`),
  KEY `funcionarios_fk_categorias_idx` (`categoria_id`),
  KEY `funcionarios_fk_clazzes_idx` (`clazze_id`),
  KEY `funcionarios_fk_escalaos_idx` (`escalao_id`),
  KEY `funcionarios_fk_delegacaos_idx` (`delegacao_id`),
  KEY `funcionarios_fk_sectores_idx` (`sector_id`),
  KEY `funcionarios_fk_tipo_ingressos_idx` (`tipo_ingresso_id`),
  KEY `funcionarios_fk_concursos_idx` (`concurso_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `funcionarios`
--

INSERT INTO `funcionarios` (`id`, `nome`, `apelido`, `data_nascimento`, `sexo`, `nuit`, `bi`, `data_emissao`, `local_emissao`, `contacto_pessoal`, `contacto_trabalho`, `contacto_alternativo`, `email_pessoal`, `email_corporativo`, `curso`, `especialidade`, `ano_conclusao`, `carreira_id`, `categoria_id`, `clazze_id`, `escalao_id`, `delegacao_id`, `sector_id`, `departamento_id`, `tipo_ingresso_id`, `concurso_id`, `created`) VALUES
(1, 'Estanislau', 'Marques', NULL, 'M', NULL, NULL, NULL, NULL, 787878787, NULL, 878787887, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 05:53:15'),
(2, 'Nome do docente', 'Apelido do docente', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 05:54:14'),
(3, '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 09:31:00'),
(4, 'Estanislau', 'Marques', NULL, NULL, NULL, NULL, NULL, NULL, 844871791, NULL, 878787887, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 12:53:21'),
(5, 'Estanislau', 'Marques', NULL, NULL, NULL, NULL, NULL, NULL, 844871791, NULL, 8888888, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 12:54:06'),
(6, 'Faira', 'Cossa', NULL, NULL, NULL, NULL, NULL, NULL, 2147483647, NULL, 2147483647, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 12:54:44'),
(7, 'Faira', 'Cossa', '1998-01-27', 'F', NULL, NULL, NULL, NULL, 2147483647, NULL, 2147483647, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 13:11:25'),
(8, 'Estanislau', 'Marques', '2016-11-08', 'M', NULL, NULL, NULL, NULL, 844871791, NULL, 8888888, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-08 13:11:41'),
(9, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-09 21:55:36'),
(10, 'Estanislau Samussone', 'Marques', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-09 21:56:41'),
(11, 'Jay', 'Z', NULL, 'M', NULL, NULL, NULL, NULL, 978876897, NULL, 2147483647, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-09 22:05:37'),
(12, 'Kanye', 'West', NULL, 'M', NULL, NULL, NULL, NULL, 34343434, NULL, 4345345, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-11-09 22:06:12');

-- --------------------------------------------------------

--
-- Table structure for table `pessoas`
--

CREATE TABLE IF NOT EXISTS `pessoas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `pessoas`
--

INSERT INTO `pessoas` (`id`, `nome`, `apelido`, `data`) VALUES
(2, 'Estanislau', 'Marques', '2016-10-04 17:40:20'),
(3, 'Faira', 'Cossa', '2016-10-04 17:40:20'),
(4, 'Imelda', 'Marques', '2016-10-04 17:40:20'),
(5, 'Sheila ', 'Marques', '2016-10-04 17:40:20'),
(6, 'Morcego', 'Batman', '2016-10-04 17:40:20'),
(7, 'Konvict', 'Akon label', '2016-10-04 17:43:00');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `sku` varchar(100) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT 'default.png',
  `referencia` varchar(255) DEFAULT 'N/A',
  `preco_aquisicao` double DEFAULT NULL,
  `data_de_registo` date DEFAULT NULL,
  `estoque_minimo` int(11) DEFAULT NULL,
  `data_de_validade` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sectores`
--

CREATE TABLE IF NOT EXISTS `sectores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `designacao` varchar(100) DEFAULT NULL,
  `delegacao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sectores_fk_delegacao_idx` (`delegacao_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `sectores`
--

INSERT INTO `sectores` (`id`, `designacao`, `delegacao_id`) VALUES
(1, 'Direccao de recursos humanos', 1),
(2, 'Direccao de financas', 2),
(3, 'Novo', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_ingressos`
--

CREATE TABLE IF NOT EXISTS `tipo_ingressos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `designacao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tipo_ingressos`
--

INSERT INTO `tipo_ingressos` (`id`, `designacao`) VALUES
(1, 'INGRESSO POR CONTRATACAO');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `data_de_registo` date DEFAULT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `foto_perfil` varchar(255) DEFAULT 'perfil_default.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `apelido`, `email`, `data_de_registo`, `contacto`, `foto_perfil`) VALUES
(1, 'Estanislau Marques', 'Samussone', 'estanislau@live.com', '2016-10-18', '844871791', 'upload/5493627_Q8IRG.jpeg'),
(3, 'Imelda Adelaide Fernando', 'Marques', 'imeldaafmarques@gmail.com', '2016-10-21', '825548705', ''),
(4, 'Deny Edgar', 'Cumaio', 'massango@gmail.com', '2016-10-21', '8465665', 'upload/WhatsApp Image 2016-09-28 at 08.52.36.jpeg'),
(5, 'sdfdfdg', 'dfgsdgsd', 'gsdfgsd@gfg.vo', '2016-10-21', '56345345', ''),
(6, 'sdfgsd', 'dgdfg', 'dsfg@eff.fghfh', '2016-10-21', '34534534', ''),
(7, 'fadfadf', 'adfasdf', 'dfa@fgdg.fghg', '2016-10-21', '4353453', 'upload\\5493627_Q8IRG.jpeg'),
(8, 'asfasdf', 'asdfasd', 'dsfd@dfdf.fgfd', '2016-10-21', '454353', 'upload\\logo.png'),
(9, 'Alberto ', 'Maregue', 'alberto.maregue@up.ac.mz', '2016-10-24', '828478987', 'upload\\logo.png'),
(10, 'Peter ', 'Mataavel', 'matavel@perter.com', '2016-10-24', '787878787', 'upload/logo.png');

-- --------------------------------------------------------

--
-- Table structure for table `vagas`
--

CREATE TABLE IF NOT EXISTS `vagas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `designacao` varchar(100) DEFAULT NULL,
  `concurso_id` int(11) DEFAULT NULL,
  `carreira_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vagas_fk_concursos_idx` (`concurso_id`),
  KEY `vagas_fk_carreiras_idx` (`carreira_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `vagas`
--

INSERT INTO `vagas` (`id`, `designacao`, `concurso_id`, `carreira_id`) VALUES
(1, '50', 2, 3),
(2, '90', 2, 2),
(3, '100', 2, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categorias`
--
ALTER TABLE `categorias`
  ADD CONSTRAINT `categorias_fk_carreiras` FOREIGN KEY (`carreira_id`) REFERENCES `carreiras` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `cds`
--
ALTER TABLE `cds`
  ADD CONSTRAINT `cds_fk_funcionarios` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `clazzes`
--
ALTER TABLE `clazzes`
  ADD CONSTRAINT `classes_fk_carreiras` FOREIGN KEY (`carreira_id`) REFERENCES `carreiras` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `ctas`
--
ALTER TABLE `ctas`
  ADD CONSTRAINT `ctas_fk_funcionarios` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `documentacaos`
--
ALTER TABLE `documentacaos`
  ADD CONSTRAINT `documentacao_fk_carreira` FOREIGN KEY (`carreira_id`) REFERENCES `carreiras` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `documentacao_fk_concurso` FOREIGN KEY (`concurso_id`) REFERENCES `concursos` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `escalaos`
--
ALTER TABLE `escalaos`
  ADD CONSTRAINT `escalao_fk_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `escalao_fk_clazze` FOREIGN KEY (`clazze_id`) REFERENCES `clazzes` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD CONSTRAINT `funcionarios_fk_carreiras` FOREIGN KEY (`carreira_id`) REFERENCES `carreiras` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_categorias` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_clazzes` FOREIGN KEY (`clazze_id`) REFERENCES `clazzes` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_concursos` FOREIGN KEY (`concurso_id`) REFERENCES `concursos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_delegacaos` FOREIGN KEY (`delegacao_id`) REFERENCES `delegacaos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_escalaos` FOREIGN KEY (`escalao_id`) REFERENCES `escalaos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_sectores` FOREIGN KEY (`sector_id`) REFERENCES `sectores` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionarios_fk_tipo_ingressos` FOREIGN KEY (`tipo_ingresso_id`) REFERENCES `tipo_ingressos` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `sectores`
--
ALTER TABLE `sectores`
  ADD CONSTRAINT `sectores_fk_delegacao` FOREIGN KEY (`delegacao_id`) REFERENCES `delegacaos` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `vagas`
--
ALTER TABLE `vagas`
  ADD CONSTRAINT `vagas_fk_carreiras` FOREIGN KEY (`carreira_id`) REFERENCES `carreiras` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vagas_fk_concursos` FOREIGN KEY (`concurso_id`) REFERENCES `concursos` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
