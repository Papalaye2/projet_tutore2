-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 06 Juillet 2015 à 16:35
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `institut2`
--
CREATE DATABASE IF NOT EXISTS `institut2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `institut2`;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE IF NOT EXISTS `annonce` (
  `ID_ANNONCE` int(11) NOT NULL,
  `ID_EMPLOYEUR` int(11) NOT NULL,
  `LIBELLE` varchar(20) DEFAULT NULL,
  `DATE_PUBLI` date DEFAULT NULL,
  PRIMARY KEY (`ID_ANNONCE`),
  UNIQUE KEY `ANNONCE_PK` (`ID_ANNONCE`),
  KEY `POSTE_FK` (`ID_EMPLOYEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `NOM_CANDIDAT` varchar(20) DEFAULT NULL,
  `PRENOM_CANDIDAT` varchar(20) DEFAULT NULL,
  `ADRESSE_CANDIDAT` varchar(20) DEFAULT NULL,
  `TELEPHONE_CANDIDAT` varchar(20) DEFAULT NULL,
  `LOGIN_CANDI` varchar(50) DEFAULT NULL,
  `MDP_CANDI` varchar(50) DEFAULT NULL,
  `Email_candidat` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_CANDIDAT`),
  UNIQUE KEY `CANDIDAT_PK` (`ID_CANDIDAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `candidat`
--

INSERT INTO `candidat` (`ID_CANDIDAT`, `NOM_CANDIDAT`, `PRENOM_CANDIDAT`, `ADRESSE_CANDIDAT`, `TELEPHONE_CANDIDAT`, `LOGIN_CANDI`, `MDP_CANDI`, `Email_candidat`) VALUES
(0, 'ndoye', 'Khadi', 'wakam', '1111', 'pas', 'pas', 'Femme'),
(1, 'Ndiaye', 'Momar', 'wakam Cite Avion', '772235589', 'passe', 'passe', 'laye.ndoye@hotmail.fr'),
(5, 'papi', 'dieye', 'wakam', '7773373', 'mati', 'mati', 'laye@gmail.com'),
(10, 'awa', 'fal', 'Pa', '2222', 'awa', 'awa', 'awa'),
(15, 'ibou', 'ibou', 'Pa', '777777', 'pa', 'pa', 'null'),
(17, 'ama', ' gueye', 'wakam', '111111', 'ama', 'ama', 'Homme');

-- --------------------------------------------------------

--
-- Structure de la table `detail_pro`
--

CREATE TABLE IF NOT EXISTS `detail_pro` (
  `id_candit` int(11) NOT NULL,
  `desc_dp` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `detail_pro`
--

INSERT INTO `detail_pro` (`id_candit`, `desc_dp`) VALUES
(1, 'Ce CV a pour objectif de faire valoir mes compétences dans le domaine des TICS pour pouvoir intégrer votre entreprise en tant que stagiaire.'),
(1, 'je suis etuduian'),
(1, 'je suis etuduian22'),
(1, 'je sui a esMT'),
(1, 'je suis entrain de decouter de la music'),
(17, 'ce  cv  apour de montrer mes capaciter en informatique'),
(17, 'colso el la ');

-- --------------------------------------------------------

--
-- Structure de la table `educatiobn`
--

CREATE TABLE IF NOT EXISTS `educatiobn` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `ANNE_EDU` varchar(20) DEFAULT NULL,
  `ETABLISEMENT_EDU` varchar(50) DEFAULT NULL,
  `INTITULECEDU` varchar(60) DEFAULT NULL,
  `id_education` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_education`),
  KEY `AS_CANDI_EDU_FK` (`ID_CANDIDAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `educatiobn`
--

INSERT INTO `educatiobn` (`ID_CANDIDAT`, `ANNE_EDU`, `ETABLISEMENT_EDU`, `INTITULECEDU`, `id_education`) VALUES
(1, '2012-2014', 'Ecole Superieure Polytecnique', 'Diplome de Technicien Superieur 1', 1),
(1, '2012-2014', 'Ecole Superieure Polytecnique', 'Diplome de Technicien Superieur 2', 2),
(1, '2013-2014', 'Ecole Superieur Polytechnique', 'Licence Professionel en Reseau', 3),
(1, '1000-3000', 'castor', 'cetificat', 4),
(0, '', '', '', 5),
(0, '', '', '', 6),
(17, '2012-2013', 'Ecole Superieur Polytechnique', 'Diplome de Technicien Superieur en inf', 7);

-- --------------------------------------------------------

--
-- Structure de la table `employeur`
--

CREATE TABLE IF NOT EXISTS `employeur` (
  `ID_EMPLOYEUR` int(11) NOT NULL,
  `NOM_EMPLOYEUR` varchar(50) DEFAULT NULL,
  `PRENOM_EMPLOYEUR` varchar(20) DEFAULT NULL,
  `ADRESSE_EMPLOYEUR` varchar(50) DEFAULT NULL,
  `TEL_EMPLOYEUR` varchar(20) DEFAULT NULL,
  `LONGITUDE` int(11) DEFAULT NULL,
  `LATITUDE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYEUR`),
  UNIQUE KEY `EMPLOYEUR_PK` (`ID_EMPLOYEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hobbies`
--

CREATE TABLE IF NOT EXISTS `hobbies` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `NOM_HOBIE` varchar(20) DEFAULT NULL,
  `id_hobbie` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_hobbie`),
  KEY `AS_CANDI_HOBBIES_FK` (`ID_CANDIDAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `hobbies`
--

INSERT INTO `hobbies` (`ID_CANDIDAT`, `NOM_HOBIE`, `id_hobbie`) VALUES
(1, 'Lecture', 1),
(1, 'Football', 4),
(1, 'Basketball', 5),
(0, 'thaiat', 6),
(0, 'sall', 15),
(0, '', 16),
(1, 'papi', 17),
(1, 'laye', 18),
(1, 'awafalll', 19),
(0, '', 20),
(1, 'film', 21),
(17, 'eau', 22),
(1, 'sport', 23),
(1, 'foot', 24);

-- --------------------------------------------------------

--
-- Structure de la table `langue`
--

CREATE TABLE IF NOT EXISTS `langue` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `NOM_LANGUE` varchar(20) DEFAULT NULL,
  `NIVEAU_LANGUE` varchar(20) DEFAULT NULL,
  `id_langue` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_langue`),
  KEY `AS_CANDI_LANGUE_FK` (`ID_CANDIDAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `langue`
--

INSERT INTO `langue` (`ID_CANDIDAT`, `NOM_LANGUE`, `NIVEAU_LANGUE`, `id_langue`) VALUES
(1, 'Russe', '(notion)', 5),
(1, 'chinois', '(tres bon)', 6),
(1, 'Espagnol', '(moyen)', 7),
(1, 'Arabe', '(moyen)', 8),
(0, 'wolof', 'bien', 12),
(1, 'diolaa', 'bien', 13),
(17, 'francais', 'bien', 14),
(1, 'serre', 'moyen', 15);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id_candi` int(11) NOT NULL,
  `id_employ` int(11) NOT NULL,
  `txt_message` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id_candi`, `id_employ`, `txt_message`) VALUES
(0, 1, 'votre demande a etait prise en compte par la sonatel'),
(0, 1, 'votre demande a etait prise en compte par la sonatel22'),
(1, 1, 'votre demande a etait prise en compte par la sonatel3333');

-- --------------------------------------------------------

--
-- Structure de la table `motivation`
--

CREATE TABLE IF NOT EXISTS `motivation` (
  `id_motiv` int(11) NOT NULL AUTO_INCREMENT,
  `id_candidat` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `motiv` varchar(250) NOT NULL,
  PRIMARY KEY (`id_motiv`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `motivation`
--

INSERT INTO `motivation` (`id_motiv`, `id_candidat`, `id_annonce`, `motiv`) VALUES
(1, 1, 1, 'je suis tres motive pour ce job');

-- --------------------------------------------------------

--
-- Structure de la table `postule`
--

CREATE TABLE IF NOT EXISTS `postule` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `ID_ANNONCE` int(11) NOT NULL,
  `DATE_POSTULE` date DEFAULT NULL,
  PRIMARY KEY (`ID_CANDIDAT`,`ID_ANNONCE`),
  KEY `FK_POSTULE_POSTULE2_ANNONCE` (`ID_ANNONCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `work_expe`
--

CREATE TABLE IF NOT EXISTS `work_expe` (
  `ID_CANDIDAT` int(11) NOT NULL,
  `ANNE_WORK` varchar(50) DEFAULT NULL,
  `LIEU_WORK` varchar(50) DEFAULT NULL,
  `DECRIPTION_WORK` varchar(50) DEFAULT NULL,
  `id_we` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_we`),
  KEY `AS_CANDI_WORK_EXPE_FK` (`ID_CANDIDAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `work_expe`
--

INSERT INTO `work_expe` (`ID_CANDIDAT`, `ANNE_WORK`, `LIEU_WORK`, `DECRIPTION_WORK`, `id_we`) VALUES
(1, 'Mai 2012-Septembre 2012', 'Orange', 'Stage:Configuration Serveur DHCP DNS adressage IP ', 1),
(1, 'Juin 2015-Aout 2015', 'Neurotech', 'Stage: Realisation d un Application web', 2),
(1, '1000-2000', 'ESMT', 'LP', 3),
(0, '', '', '', 4),
(0, '12', 'dakar', '', 5),
(0, '12', 'dakar', 'appliiiii', 6),
(0, '12', 'dakar', 'appliiiii', 7),
(17, 'jjjjjjj', 'kkkkkk', 'llllll', 8),
(17, '2222-2222', 'ESMT', 'dddddd', 9);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_ANNONCE_POSTE_EMPLOYEU` FOREIGN KEY (`ID_EMPLOYEUR`) REFERENCES `employeur` (`ID_EMPLOYEUR`);

--
-- Contraintes pour la table `educatiobn`
--
ALTER TABLE `educatiobn`
  ADD CONSTRAINT `FK_EDUCATIO_AS_CANDI__CANDIDAT` FOREIGN KEY (`ID_CANDIDAT`) REFERENCES `candidat` (`ID_CANDIDAT`);

--
-- Contraintes pour la table `hobbies`
--
ALTER TABLE `hobbies`
  ADD CONSTRAINT `FK_HOBBIES_AS_CANDI__CANDIDAT` FOREIGN KEY (`ID_CANDIDAT`) REFERENCES `candidat` (`ID_CANDIDAT`);

--
-- Contraintes pour la table `langue`
--
ALTER TABLE `langue`
  ADD CONSTRAINT `FK_LANGUE_AS_CANDI__CANDIDAT` FOREIGN KEY (`ID_CANDIDAT`) REFERENCES `candidat` (`ID_CANDIDAT`);

--
-- Contraintes pour la table `postule`
--
ALTER TABLE `postule`
  ADD CONSTRAINT `FK_POSTULE_POSTULE2_ANNONCE` FOREIGN KEY (`ID_ANNONCE`) REFERENCES `annonce` (`ID_ANNONCE`),
  ADD CONSTRAINT `FK_POSTULE_POSTULE_CANDIDAT` FOREIGN KEY (`ID_CANDIDAT`) REFERENCES `candidat` (`ID_CANDIDAT`);

--
-- Contraintes pour la table `work_expe`
--
ALTER TABLE `work_expe`
  ADD CONSTRAINT `FK_WORK_EXP_AS_CANDI__CANDIDAT` FOREIGN KEY (`ID_CANDIDAT`) REFERENCES `candidat` (`ID_CANDIDAT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
