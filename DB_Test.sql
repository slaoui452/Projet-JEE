-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 mai 2021 à 18:23
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Base de données : `matable1`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `code_etudiant` varchar(255) DEFAULT NULL,
  `groupe` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `code_etudiant`, `groupe`, `nom`, `prenom`) VALUES
(2, 'RI180085', 1, 'BILAL', 'ACHAHBAR'),
(1, 'RI180084', 1, 'HAMZA', 'AAKLA'),
(3, 'RI180086', 1, 'KAMAL', 'ADDI'),
(4, 'RI180087', 1, 'SAYFEDDINE', 'ADDOU'),
(5, 'RI180088', 1, 'ABDELLAH', 'AGHLALOU'),
(6, 'RI180089', 1, 'ABDERRAHIM', 'ALAKOUCHE'),
(7, 'RI180090', 1, 'AYOUB', 'ALALOU'),
(8, 'RI180091', 1, 'ABDELLAH', 'ASBIK'),
(9, 'RI180092', 1, 'TAHA', 'AZZIM'),
(10, 'RI180093', 1, 'MOHAMED', 'BENCHIKH'),
(11, 'RI190084', 2, 'AYA', 'BENTALEB'),
(12, 'RI190085', 2, 'MAYSSAE', 'CHIMI'),
(13, 'RI190086', 2, 'MERYAM', 'DRIOUICH'),
(14, 'RI190087', 2, 'CHIHAB-EDDINE', 'EL-KILANI'),
(15, 'RI190088', 2, 'HIND', 'EL ALAMI'),
(16, 'RI190089', 2, 'HAJAR', 'EL FAHFOUHI'),
(17, 'RI190090', 2, 'KAOUTAR', 'EL KEDDADI'),
(18, 'RI190091', 2, 'HASNAE', 'EL OUAKILI'),
(19, 'RI190092', 2, 'LAHSEN', 'EL OUARRATI'),
(20, 'RI190093', 2, 'ABDERRAHIM', 'EL OUTMADI'),
(21, 'RI200084', 3, 'MAROUA', 'EL-ARNI'),
(22, 'RI200085', 3, 'MOHAMMED', 'ER-RAKHO'),
(23, 'RI200086', 3, 'FATIMA', 'ES-SAGUER'),
(24, 'RI200087', 3, 'KHALIL', 'HADJI'),
(25, 'RI200088', 3, 'AYMANE', 'HMIDICH'),
(26, 'RI200089', 3, 'HIBA', 'HOSSAM'),
(27, 'RI200090', 3, 'Yassine', 'JABORI'),
(28, 'RI200091', 3, 'AHMED', 'KADAOUI'),
(29, 'RI200092', 3, 'MOHAMED', 'KOUHOU'),
(30, 'RI210084', 4, 'OUSSAMA', 'LAY'),
(31, 'RI210085', 4, 'ADIL', 'OUSSIDI'),
(32, 'RI210086', 4, 'MOUAD', 'RIALI'),
(33, 'RI210087', 4, 'Hassan', 'SAAID'),
(34, 'RI210088', 4, 'AYOUB', 'SADKI'),
(35, 'RI210089', 4, 'HAROUNE', 'SAMOUCHE '),
(36, 'RI210090', 4, 'MEHDI', 'SLAOUI'),
(37, 'RI210091', 4, 'MOUAD', 'SLIMANE'),
(38, 'RI210092', 4, 'TAHA', 'TAMIR'),
(39, 'RI210093', 4, 'NOUR-EDDINE', 'ZANDAG'),
(40, 'RI210094', 4, 'MOHAMMED', 'SKALLI');

-- --------------------------------------------------------

--
-- Structure de la table `presencetable`
--

CREATE TABLE `presencetable` (
  `id` bigint(20) NOT NULL,
  `code_etudiant` varchar(255) DEFAULT NULL,
  `groupe` int(11) NOT NULL,
  `presence` bit(1) NOT NULL,
  `code_prof` varchar(255) DEFAULT NULL,
  `code_seance` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `profs`
--

CREATE TABLE `profs` (
  `id` bigint(20) NOT NULL,
  `code_prof` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `matiere` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `profs`
--

INSERT INTO `profs` (`id`, `code_prof`, `nom`, `matiere`, `prenom`) VALUES
(1, 'MS1', 'M.', 'Statistique appliquee ', 'FEKRI'),
(2, 'MS2', 'M.', 'Modelisation stochastique', 'CHEFCHAOUNI'),
(3, 'IF1', 'M.', 'Conception et analyse des algorithmes', 'BENSALAH'),
(4, 'IF2', 'Y.', 'Theorie des langages et compilation', 'TABII'),
(5, 'IF3', 'M.', 'Informatique theorique', 'BAINA'),
(6, 'AS1', 'Mme.', 'Ingenierie des systemes d\'exploitation', 'AOUAD'),
(7, 'AS2', 'A.', 'Administration systeme (Unix et Windows)', 'MAIZATE'),
(8, 'RT1', 'Mme.', 'Introduction aux reseaux telecoms', 'OUADDAH'),
(9, 'BD2', 'M.', 'Base de donnees structurees', 'BELLAFKIH'),
(10, 'BD1', 'M.', 'Bases de donnees semi structurees', 'DAHCHOUR'),
(11, 'FE2', 'M.', 'Diagnostic financier de l\'entreprise', 'LAARABI'),
(12, 'LCO1', 'M.', 'Anglais DATA', 'NAJI'),
(13, 'LCO2', 'Mme.', 'Techniques d\'expression et de communication DATA', 'TOUNSI');

-- --------------------------------------------------------

--
-- Structure de la table `seances`
--

CREATE TABLE `seances` (
  `id` bigint(20) NOT NULL,
  `code_prof` varchar(255) DEFAULT NULL,
  `groupe` int(11) NOT NULL,
  `seance0` varchar(255) DEFAULT NULL,
  `seance1` varchar(255) DEFAULT NULL,
  `seance2` varchar(255) DEFAULT NULL,
  `seance3` varchar(255) DEFAULT NULL,
  `seance4` varchar(255) DEFAULT NULL,
  `seance5` varchar(255) DEFAULT NULL,
  `seance6` varchar(255) DEFAULT NULL,
  `seance7` varchar(255) DEFAULT NULL,
  `seance8` varchar(255) DEFAULT NULL,
  `seance9` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `seance_actv`
--

CREATE TABLE `seance_actv` (
  `id` int(11) NOT NULL,
  `code_prof` varchar(255) DEFAULT NULL,
  `groupe` int(11) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `presencetable`
--
ALTER TABLE `presencetable`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profs`
--
ALTER TABLE `profs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `seances`
--
ALTER TABLE `seances`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `seance_actv`
--
ALTER TABLE `seance_actv`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `etudiant`
--

ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `presencetable`
--

ALTER TABLE `presencetable`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `profs`
--
ALTER TABLE `profs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `seances`
--

ALTER TABLE `seances`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `seance_actv`
--

ALTER TABLE `seance_actv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;