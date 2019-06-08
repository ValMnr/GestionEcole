-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 juin 2019 à 14:33
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`) VALUES
(2015),
(2016),
(2017);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trimestreId` int(11) NOT NULL,
  `inscriptionId` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trimestreId` (`trimestreId`),
  KEY `inscriptionId` (`inscriptionId`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `trimestreId`, `inscriptionId`, `appreciation`) VALUES
(1, 14, 1, 'Lorem ipsum lorem ispum lorem ipsum'),
(2, 3, 2, 'Lorem ipsum lorem ispum lorem ipsum'),
(3, 13, 3, 'Lorem ipsum lorem ispum lorem ipsum'),
(4, 2, 4, 'Lorem ipsum lorem ispum lorem ipsum'),
(5, 5, 5, 'Lorem ipsum lorem ispum lorem ipsum'),
(6, 18, 6, 'Lorem ipsum lorem ispum lorem ipsum'),
(7, 5, 7, 'Lorem ipsum lorem ispum lorem ipsum'),
(8, 12, 8, 'Lorem ipsum lorem ispum lorem ipsum'),
(9, 1, 9, 'Lorem ipsum lorem ispum lorem ipsum'),
(10, 3, 10, 'Lorem ipsum lorem ispum lorem ipsum'),
(11, 18, 11, 'Lorem ipsum lorem ispum lorem ipsum'),
(12, 3, 12, 'Lorem ipsum lorem ispum lorem ipsum'),
(13, 17, 13, 'Lorem ipsum lorem ispum lorem ipsum'),
(14, 16, 14, 'Lorem ipsum lorem ispum lorem ipsum'),
(15, 1, 15, 'Lorem ipsum lorem ispum lorem ipsum'),
(16, 15, 16, 'Lorem ipsum lorem ispum lorem ipsum'),
(17, 9, 17, 'Lorem ipsum lorem ispum lorem ipsum'),
(18, 9, 18, 'Lorem ipsum lorem ispum lorem ipsum'),
(19, 16, 19, 'Lorem ipsum lorem ispum lorem ipsum');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `ecoleId` int(11) NOT NULL,
  `niveauId` int(11) NOT NULL,
  `anneescolaireId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `anneescolaireId` (`anneescolaireId`),
  KEY `ecoleId` (`ecoleId`),
  KEY `niveauId` (`niveauId`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `ecoleId`, `niveauId`, `anneescolaireId`) VALUES
(1, 'Seconde 1', 1, 1, 2015),
(2, 'Seconde 2', 1, 1, 2015),
(3, 'Premiere 1', 1, 2, 2015),
(4, 'Premiere 2', 1, 2, 2015),
(5, 'Terminale 1', 1, 3, 2015),
(6, 'Terminale 2', 1, 3, 2015),
(7, 'Seconde 1', 1, 1, 2016),
(8, 'Seconde 2', 1, 1, 2016),
(9, 'Premiere 1', 1, 2, 2016),
(10, 'Premiere 2', 1, 2, 2016),
(11, 'Terminale 1', 1, 3, 2016),
(12, 'Terminale 2', 1, 3, 2016),
(13, 'Seconde 1', 1, 1, 2017),
(14, 'Seconde 2', 1, 1, 2017),
(15, 'Premiere 1', 1, 2, 2017),
(16, 'Premiere 2', 1, 2, 2017),
(17, 'Terminale 1', 1, 3, 2017),
(18, 'Terminale 2', 1, 3, 2017);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BulletinId` int(11) NOT NULL,
  `EnseignementId` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BulletinId` (`BulletinId`),
  KEY `enseignementId` (`EnseignementId`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `BulletinId`, `EnseignementId`, `appreciation`) VALUES
(19, 19, 3, 'Lorem ipsum lorem ispum lorem ipsum'),
(18, 18, 18, 'Lorem ipsum lorem ispum lorem ipsum'),
(17, 17, 22, 'Lorem ipsum lorem ispum lorem ipsum'),
(16, 16, 10, 'Lorem ipsum lorem ispum lorem ipsum'),
(15, 15, 12, 'Lorem ipsum lorem ispum lorem ipsum'),
(14, 14, 5, 'Lorem ipsum lorem ispum lorem ipsum'),
(13, 13, 5, 'Lorem ipsum lorem ispum lorem ipsum'),
(12, 12, 16, 'Lorem ipsum lorem ispum lorem ipsum'),
(11, 11, 27, 'Lorem ipsum lorem ispum lorem ipsum'),
(10, 10, 3, 'Lorem ipsum lorem ispum lorem ipsum'),
(9, 9, 24, 'Lorem ipsum lorem ispum lorem ipsum'),
(8, 8, 13, 'Lorem ipsum lorem ispum lorem ipsum'),
(7, 7, 1, 'Lorem ipsum lorem ispum lorem ipsum'),
(6, 6, 18, 'Lorem ipsum lorem ispum lorem ipsum'),
(5, 5, 7, 'Lorem ipsum lorem ispum lorem ipsum'),
(4, 4, 12, 'Lorem ipsum lorem ispum lorem ipsum'),
(3, 3, 18, 'Lorem ipsum lorem ispum lorem ipsum'),
(2, 2, 28, 'Lorem ipsum lorem ispum lorem ipsum'),
(1, 1, 3, 'Lorem ipsum lorem ispum lorem ipsum');

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Maths'),
(2, 'Francais'),
(3, 'Physique'),
(4, 'Anglais'),
(5, 'Philo'),
(6, 'SVT'),
(7, 'EPS'),
(8, 'Histoire Géographie');

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ecole` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classeId` int(11) NOT NULL,
  `disciplineId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classeId` (`classeId`),
  KEY `disciplineId` (`disciplineId`),
  KEY `personneId` (`personneId`)
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `classeId`, `disciplineId`, `personneId`) VALUES
(1, 1, 3, 25),
(2, 2, 7, 30),
(3, 3, 7, 27),
(4, 4, 6, 26),
(5, 5, 6, 28),
(6, 6, 2, 22),
(7, 7, 1, 23),
(8, 8, 1, 22),
(9, 9, 3, 26),
(10, 10, 2, 28),
(11, 11, 4, 29),
(12, 12, 8, 30),
(13, 13, 6, 24),
(14, 14, 8, 25),
(15, 15, 6, 26),
(16, 16, 2, 22),
(17, 17, 5, 30),
(18, 0, 5, 23),
(19, 1, 5, 23),
(20, 2, 1, 30),
(21, 3, 8, 30),
(22, 4, 1, 30),
(23, 5, 1, 25),
(24, 6, 7, 25),
(25, 7, 7, 22),
(26, 8, 5, 25),
(27, 9, 5, 25),
(28, 10, 2, 23),
(29, 11, 5, 29),
(30, 12, 1, 23),
(31, 13, 7, 29),
(32, 14, 7, 28),
(33, 15, 6, 24),
(34, 16, 8, 22),
(35, 17, 8, 27),
(36, 0, 7, 24),
(37, 1, 4, 22),
(38, 2, 3, 30),
(39, 3, 3, 23),
(40, 4, 5, 25),
(41, 5, 1, 22),
(42, 6, 7, 29),
(43, 7, 3, 25),
(44, 8, 6, 21),
(45, 9, 3, 21),
(46, 10, 3, 23),
(47, 11, 3, 30),
(48, 12, 1, 24),
(49, 13, 8, 28),
(50, 14, 3, 26),
(51, 15, 7, 29),
(52, 16, 8, 29),
(53, 17, 7, 21),
(54, 0, 6, 22),
(55, 1, 8, 28),
(56, 2, 3, 21),
(57, 3, 5, 21),
(58, 4, 4, 30),
(59, 5, 2, 21),
(60, 6, 8, 29),
(61, 7, 4, 30),
(62, 8, 4, 26),
(63, 9, 2, 30),
(64, 10, 3, 30),
(65, 11, 3, 21),
(66, 12, 1, 22),
(67, 13, 6, 21),
(68, 14, 1, 30),
(69, 15, 3, 24);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detailbulletinId` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `detailbulletinId` (`detailbulletinId`)
) ENGINE=MyISAM AUTO_INCREMENT=200 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `detailbulletinId`, `note`, `appreciation`) VALUES
(1, 20, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(2, 18, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(3, 20, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(4, 14, 19, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(5, 14, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(6, 11, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(7, 13, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(8, 18, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(9, 14, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(10, 11, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(11, 20, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(12, 9, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(13, 7, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(14, 6, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(15, 8, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(16, 5, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(17, 14, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(18, 19, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(19, 14, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(20, 18, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(21, 7, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(22, 18, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(23, 5, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(24, 16, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(25, 10, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(26, 9, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(27, 16, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(28, 3, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(29, 2, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(30, 10, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(31, 15, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(32, 7, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(33, 1, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(34, 19, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(35, 12, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(36, 13, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(37, 11, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(38, 6, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(39, 13, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(40, 17, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(41, 9, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(42, 14, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(43, 15, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(44, 18, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(45, 6, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(46, 11, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(47, 8, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(48, 3, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(49, 18, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(50, 2, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(51, 16, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(52, 16, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(53, 2, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(54, 13, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(55, 13, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(56, 7, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(57, 5, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(58, 19, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(59, 8, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(60, 16, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(61, 20, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(62, 7, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(63, 13, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(64, 13, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(65, 5, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(66, 7, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(67, 3, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(68, 10, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(69, 1, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(70, 19, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(71, 19, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(72, 16, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(73, 20, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(74, 16, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(75, 3, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(76, 9, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(77, 10, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(78, 11, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(79, 20, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(80, 2, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(81, 17, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(82, 15, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(83, 16, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(84, 14, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(85, 3, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(86, 18, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(87, 20, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(88, 11, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(89, 10, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(90, 5, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(91, 13, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(92, 8, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(93, 1, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(94, 6, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(95, 20, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(96, 6, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(97, 17, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(98, 4, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(99, 12, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(100, 14, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(101, 18, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(102, 19, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(103, 19, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(104, 12, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(105, 17, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(106, 1, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(107, 12, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(108, 17, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(109, 4, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(110, 12, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(111, 18, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(112, 20, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(113, 17, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(114, 5, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(115, 16, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(116, 2, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(117, 7, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(118, 1, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(119, 13, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(120, 4, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(121, 12, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(122, 6, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(123, 19, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(124, 17, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(125, 5, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(126, 10, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(127, 7, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(128, 7, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(129, 20, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(130, 18, 19, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(131, 10, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(132, 16, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(133, 3, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(134, 5, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(135, 10, 2, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(136, 3, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(137, 19, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(138, 6, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(139, 15, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(140, 9, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(141, 1, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(142, 3, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(143, 12, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(144, 8, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(145, 17, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(146, 14, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(147, 3, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(148, 6, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(149, 16, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(150, 5, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(151, 4, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(152, 7, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(153, 4, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(154, 1, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(155, 1, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(156, 16, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(157, 15, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(158, 1, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(159, 3, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(160, 15, 19, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(161, 20, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(162, 12, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(163, 1, 16, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(164, 10, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(165, 20, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(166, 7, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(167, 18, 10, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(168, 3, 19, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(169, 2, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(170, 5, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(171, 5, 4, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(172, 11, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(173, 8, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(174, 4, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(175, 1, 5, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(176, 20, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(177, 17, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(178, 20, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(179, 18, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(180, 15, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(181, 17, 13, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(182, 15, 9, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(183, 4, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(184, 19, 17, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(185, 15, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(186, 11, 1, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(187, 6, 6, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(188, 19, 18, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(189, 9, 12, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(190, 14, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(191, 20, 15, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(192, 11, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(193, 9, 7, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(194, 14, 20, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(195, 17, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(196, 11, 3, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(197, 10, 14, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(198, 17, 8, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum'),
(199, 11, 11, 'Lorem Ipsum lorem isspiu lorem ipsum lorem ipsum');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classeId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classeId` (`classeId`),
  KEY `personneId` (`personneId`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `classeId`, `personneId`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 4),
(5, 2, 5),
(6, 2, 6),
(7, 3, 7),
(8, 3, 8),
(9, 3, 9),
(10, 4, 10),
(11, 4, 11),
(12, 4, 12),
(13, 5, 13),
(14, 5, 14),
(15, 5, 15),
(16, 6, 16),
(17, 6, 17),
(18, 6, 18),
(19, 7, 19),
(20, 7, 20);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, '2nde'),
(2, '1ère'),
(3, 'Terminale');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(1, 'Monnier', 'Valentin', '1'),
(2, 'Sorring', 'Marius', '1'),
(3, 'Pech', 'Manolis', '1'),
(4, 'Dupont', 'JEan', '1'),
(5, 'Durant', 'Jacques', '1'),
(6, 'David', 'Sarah', '1'),
(7, 'Galibert', 'Louis', '1'),
(8, 'Sartoris', 'Louis', '1'),
(9, 'Bezri', 'Nizar', '1'),
(10, 'Philbert', 'Pierre', '1'),
(11, 'Kardache', 'Sarah', '1'),
(12, 'Herve', 'Anne-lise', '1'),
(13, 'Lang', 'Jean', '1'),
(14, 'Porter', 'Jack', '1'),
(15, 'Vidal', 'Henri', '1'),
(16, 'Chang', 'Auguste', '1'),
(17, 'Leor', 'Camille', '1'),
(18, 'Peair', 'Fred', '1'),
(19, 'Trusce', 'Jean-Pierre', '1'),
(20, 'Acope', 'David', '1'),
(21, 'Cohen', 'Sarah', '2'),
(22, 'Villemard', 'Thomas', '2'),
(23, 'De la fosse', 'Pierre', '2'),
(24, 'Christel', 'Victor', '2'),
(25, 'Albert', 'Iulian', '2'),
(26, 'Gilbart', 'Simon', '2'),
(27, 'Tronis', 'Nawel', '2'),
(28, 'Berth', 'Nico', '2'),
(29, 'Mailleux', 'Antoine', '2'),
(30, 'Comolais', 'Maxime', '2');

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `debut` char(8) NOT NULL,
  `fin` char(8) NOT NULL,
  `anneescolaireId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_key` (`anneescolaireId`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `anneescolaireId`) VALUES
(1, 1, '01/09/15', '31/12/16', 2015),
(2, 2, '01/01/16', '31/03/16', 2015),
(3, 3, '01/04/16', '31/06/16', 2015),
(4, 4, '01/09/16', '31/12/16', 2016),
(5, 5, '01/01/17', '31/03/17', 2016),
(6, 6, '01/04/17', '31/06/17', 2016),
(7, 7, '01/09/17', '31/12/17', 2017),
(8, 8, '01/01/18', '31/03/18', 2017),
(9, 9, '01/04/18', '31/06/18', 2017),
(10, 10, '01/09/18', '31/12/18', 2018),
(11, 11, '01/01/19', '31/03/19', 2018),
(12, 12, '01/04/19', '31/06/19', 2018),
(15, 15, '01/01/01', '01/01/01', 2019);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
