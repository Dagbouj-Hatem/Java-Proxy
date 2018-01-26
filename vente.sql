-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2017 at 08:30 PM
-- Server version: 5.6.15-log
-- PHP Version: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vente`
--

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomC` varchar(25) NOT NULL,
  `PrenomC` varchar(25) NOT NULL,
  `marqueV` varchar(25) NOT NULL,
  `num_immat` varchar(25) NOT NULL,
  `prix` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id`, `nomC`, `PrenomC`, `marqueV`, `num_immat`, `prix`) VALUES
(1, 'hatem', 'dagbouj', 'BMW', '122 tunis 7815', '89.000'),
(2, 'saber', 'el ghoul', 'Clio', '124 tunis', '87.000'),
(6, 'sana', 'ben ali', 'BMW', '1002 tunis 1457', '98.000'),
(7, 'ali', 'amine mahmoudi', 'Clio', '845 france 45781', '900,000'),
(10, 'hatem', 'dagbouj', 'BMW', '505 Tunis 48239', '108,000'),
(11, 'kariem', 'el fthili', 'clio berlango', '124 tunis 465', '900,000'),
(12, 'ahlem', 'nefzi', 'BMW', '54 tunis', '900,000');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
