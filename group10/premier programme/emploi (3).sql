-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 20 Juin 2015 à 14:20
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `emploi`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE IF NOT EXISTS `annonce` (
  `ID_ANNONCE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_EMPLOYEUR` varchar(11) DEFAULT NULL,
  `LIBELLE` varchar(20) DEFAULT NULL,
  `DATE_PUBLI` varchar(20) DEFAULT NULL,
  `entreprise` varchar(50) NOT NULL,
  `profil` text NOT NULL,
  `mail` varchar(50) NOT NULL,
  `domaine` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_ANNONCE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `annonce`
--

INSERT INTO `annonce` (`ID_ANNONCE`, `ID_EMPLOYEUR`, `LIBELLE`, `DATE_PUBLI`, `entreprise`, `profil`, `mail`, `domaine`) VALUES
(1, '0', 'inf', 'decembre', 'ORANGE', 'excellent agent informatique avec des capacités en informatique et en langage java', 'orange.sn', 'informatique'),
(2, '', 'excellent agent', 'decembre', 'TIGO', 'AGENT MARKETING', 'www.orange.sn', 'marketing'),
(3, '', 'un bon balayeur moti', 'decembre', 'NEUROTECH', 'Balayeur', 'neurotech.sn', 'marketing');

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `ID_CANDIDAT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CANDIDAT` varchar(20) DEFAULT NULL,
  `PRENOM_CANDIDAT` varchar(20) DEFAULT NULL,
  `sexe_candidat` varchar(20) NOT NULL,
  `ADRESSE_CANDIDAT` varchar(20) DEFAULT NULL,
  `TELEPHONE_CANDIDAT` varchar(20) DEFAULT NULL,
  `login_candidat` varchar(20) NOT NULL,
  `password_candidat` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_CANDIDAT`),
  UNIQUE KEY `CANDIDAT_PK` (`ID_CANDIDAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`ID_CANDIDAT`, `NOM_CANDIDAT`, `PRENOM_CANDIDAT`, `sexe_candidat`, `ADRESSE_CANDIDAT`, `TELEPHONE_CANDIDAT`, `login_candidat`, `password_candidat`) VALUES
(1, 'ndoye', 'abdoulaye', 'HOMME', 'ouakam', '778452146', 'ondoye', 'passer');

-- --------------------------------------------------------

--
-- Structure de la table `employeur`
--

CREATE TABLE IF NOT EXISTS `employeur` (
  `ID_EMPLOYEUR` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_EMPLOYEUR` varchar(50) DEFAULT NULL,
  `PRENOM_EMPLOYEUR` varchar(20) DEFAULT NULL,
  `sexe_employeur` varchar(20) NOT NULL,
  `ADRESSE_EMPLOYEUR` varchar(50) DEFAULT NULL,
  `TEL_EMPLOYEUR` varchar(20) DEFAULT NULL,
  `login_employeur` varchar(20) NOT NULL,
  `password_employeur` varchar(20) NOT NULL,
  `nb_annonce` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYEUR`),
  UNIQUE KEY `EMPLOYEUR_PK` (`ID_EMPLOYEUR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `employeur`
--

INSERT INTO `employeur` (`ID_EMPLOYEUR`, `NOM_EMPLOYEUR`, `PRENOM_EMPLOYEUR`, `sexe_employeur`, `ADRESSE_EMPLOYEUR`, `TEL_EMPLOYEUR`, `login_employeur`, `password_employeur`, `nb_annonce`) VALUES
(1, 'DIEYE', 'PAPA MALICK', 'HOMME', 'VIRAGE', '777222046', 'pdieye', 'passer', 0);

-- --------------------------------------------------------

--
-- Structure de la table `postule`
--

CREATE TABLE IF NOT EXISTS `postule` (
  `ID_ANNONCE` int(11) NOT NULL,
  `ID_CANDIDAT` int(11) NOT NULL,
  `ID_EMPLOYEUR` varchar(20) NOT NULL,
  `date` date NOT NULL,
  KEY `ID_ANNONCE` (`ID_ANNONCE`),
  KEY `ID_ANNONCE_2` (`ID_ANNONCE`),
  KEY `ID_ANNONCE_3` (`ID_ANNONCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `postule`
--

INSERT INTO `postule` (`ID_ANNONCE`, `ID_CANDIDAT`, `ID_EMPLOYEUR`, `date`) VALUES
(1, 1, '1', '2015-06-02');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
