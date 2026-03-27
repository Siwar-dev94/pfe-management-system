-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 27 Mars 2026 à 11:16
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gestion_pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `encad`
--

CREATE TABLE IF NOT EXISTS `encad` (
`id_encad` int(11) NOT NULL,
  `nom_encad` varchar(50) NOT NULL,
  `prenom_encad` varchar(50) NOT NULL,
  `grade` varchar(50) NOT NULL,
  `email_encad` varchar(100) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `encad`
--

INSERT INTO `encad` (`id_encad`, `nom_encad`, `prenom_encad`, `grade`, `email_encad`) VALUES
(1, 'Ahmed', 'Trabelsi', 'Maître Assistant', 'm.trabelsi@univ.tn'),
(2, 'siwar', 'harzli', 'Professeur', 'm.trabelsi@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `encadrement`
--

CREATE TABLE IF NOT EXISTS `encadrement` (
  `id_pfe` int(11) NOT NULL,
  `id_encad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `encadrement`
--

INSERT INTO `encadrement` (`id_pfe`, `id_encad`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 2),
(8, 2),
(9, 2),
(12, 2),
(13, 1),
(14, 2),
(15, 1),
(15, 2);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
`id_etud` int(11) NOT NULL,
  `nom_etud` varchar(50) NOT NULL,
  `prenom_etud` varchar(50) NOT NULL,
  `email_etud` varchar(100) NOT NULL,
  `classe` varchar(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etud`, `nom_etud`, `prenom_etud`, `email_etud`, `classe`) VALUES
(1, 'Ali', 'Ben Salah', 'ali@gmail.com', '3INFO'),
(2, 'Ali', 'Ben Salah', 'ali@gmail.com', '3INFO'),
(3, 'Ali', 'Ben Salah', 'ali@gmail.com', '3INFO'),
(8, 'Ali', 'Ben Salah', 'ali@gmail.com', '3INFO'),
(9, 'ahmed', 'Ben Salah', 'ali@gmail.com', '3INFO'),
(10, 'harzli', 'sarra', 'ddd@gmail.com', '2gmam'),
(12, 'harzli', 'siwar', 'ddd@gmail.com', '2gmam');

-- --------------------------------------------------------

--
-- Structure de la table `pfe`
--

CREATE TABLE IF NOT EXISTS `pfe` (
`id_pfe` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `description` text,
  `etat` varchar(20) NOT NULL,
  `date_soutenance` date DEFAULT NULL,
  `id_etud` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `pfe`
--

INSERT INTO `pfe` (`id_pfe`, `titre`, `description`, `etat`, `date_soutenance`, `id_etud`) VALUES
(1, 'Plateforme de gestion des PFE', 'Application Java / MySQL', 'Validé', NULL, 1),
(2, 'Plateforme de gestion des PFE', 'Application Java / MySQL', 'Validé', NULL, 1),
(3, 'Plateforme de gestion des PFE', 'Application Java / MySQL', 'Soutenu', NULL, 1),
(4, 'Plateforme de gestion des PFE', 'Application Java / MySQL', 'Validé', NULL, 1),
(5, 'PFE Modifié', 'Description modifiée', 'En cours', NULL, 1),
(6, 'pfe', 'dddddddd', 'En cours', NULL, 9),
(7, 'pfesiwar', '', 'En cours', NULL, 1),
(8, 'pfe', 'dddddddd', 'En cours', NULL, 1),
(9, 'pfe', 'dddddddd', 'En cours', NULL, 1),
(12, 'pfe finale', '', 'En cours', NULL, 1),
(13, 'ssssss', '', 'En cours', NULL, 1),
(14, 'sarra', 'sarrasarra', 'En cours', NULL, 2),
(15, 'aaaassss', '', 'En cours', NULL, 1),
(16, 'pppp', '', 'En cours', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `soutenance`
--

CREATE TABLE IF NOT EXISTS `soutenance` (
`id_sout` int(11) NOT NULL,
  `date_sout` date NOT NULL,
  `salle` varchar(20) NOT NULL,
  `note` double DEFAULT NULL,
  `id_pfe` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `soutenance`
--

INSERT INTO `soutenance` (`id_sout`, `date_sout`, `salle`, `note`, `id_pfe`) VALUES
(1, '2025-07-15', 'Salle A12', 14.5, 3),
(2, '2025-07-15', 'Salle A12', 14.5, 3),
(3, '2025-12-31', 'A312', 17, 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `encad`
--
ALTER TABLE `encad`
 ADD PRIMARY KEY (`id_encad`);

--
-- Index pour la table `encadrement`
--
ALTER TABLE `encadrement`
 ADD PRIMARY KEY (`id_pfe`,`id_encad`), ADD KEY `id_pfe` (`id_pfe`), ADD KEY `id_pfe_2` (`id_pfe`), ADD KEY `id_encad` (`id_encad`), ADD KEY `id_pfe_3` (`id_pfe`), ADD KEY `id_encad_2` (`id_encad`), ADD KEY `id_encad_3` (`id_encad`), ADD KEY `id_pfe_4` (`id_pfe`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
 ADD PRIMARY KEY (`id_etud`);

--
-- Index pour la table `pfe`
--
ALTER TABLE `pfe`
 ADD PRIMARY KEY (`id_pfe`), ADD KEY `id_etud` (`id_etud`), ADD KEY `id_etud_2` (`id_etud`);

--
-- Index pour la table `soutenance`
--
ALTER TABLE `soutenance`
 ADD PRIMARY KEY (`id_sout`), ADD KEY `id_pfe` (`id_pfe`), ADD KEY `id_pfe_2` (`id_pfe`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `encad`
--
ALTER TABLE `encad`
MODIFY `id_encad` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
MODIFY `id_etud` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `pfe`
--
ALTER TABLE `pfe`
MODIFY `id_pfe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `soutenance`
--
ALTER TABLE `soutenance`
MODIFY `id_sout` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `encadrement`
--
ALTER TABLE `encadrement`
ADD CONSTRAINT `encadrement_ibfk_1` FOREIGN KEY (`id_encad`) REFERENCES `encad` (`id_encad`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_encadrement_pfe` FOREIGN KEY (`id_pfe`) REFERENCES `pfe` (`id_pfe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pfe`
--
ALTER TABLE `pfe`
ADD CONSTRAINT `fk_pfe_etudiant` FOREIGN KEY (`id_etud`) REFERENCES `etudiant` (`id_etud`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `soutenance`
--
ALTER TABLE `soutenance`
ADD CONSTRAINT `soutenance_ibfk_1` FOREIGN KEY (`id_pfe`) REFERENCES `pfe` (`id_pfe`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
