-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 25 avr. 2022 à 21:42
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

DROP TABLE IF EXISTS `doctrine_migration_versions`;
CREATE TABLE IF NOT EXISTS `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20220216211153', '2022-02-16 21:12:12', 168),
('DoctrineMigrations\\Version20220217221951', '2022-02-17 22:23:34', 447),
('DoctrineMigrations\\Version20220223215039', '2022-02-23 21:55:31', 67),
('DoctrineMigrations\\Version20220223223458', '2022-02-23 22:35:14', 165),
('DoctrineMigrations\\Version20220303223303', '2022-03-03 22:33:39', 1961),
('DoctrineMigrations\\Version20220307230028', '2022-03-07 23:00:40', 213),
('DoctrineMigrations\\Version20220309233610', '2022-03-09 23:40:29', 205),
('DoctrineMigrations\\Version20220310195615', '2022-03-10 19:56:34', 164),
('DoctrineMigrations\\Version20220310195947', '2022-03-10 19:59:54', 34);

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `publication_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5A8A6C8D38B217A7` (`publication_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id`, `description`, `created_at`, `publication_id`) VALUES
(67, 'hgvhv', '2022-03-31 13:53:57', 127),
(68, 'hghghgh', '2022-03-31 16:21:23', 129),
(69, 'gjgkjhkjh', '2022-03-31 21:05:09', 127),
(70, 'bhjb', '2022-03-31 21:05:16', 127);

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime DEFAULT NULL COMMENT '(DC2Type:datetime_immutable)',
  `views` int(11) DEFAULT NULL,
  `titre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `likes` int(11) DEFAULT NULL,
  `status_like` tinyint(1) DEFAULT NULL,
  `requser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `description`, `created_at`, `views`, `titre`, `likes`, `status_like`, `requser`) VALUES
(127, 'omar', '2022-03-31 13:53:49', 0, 'omar', 0, 1, NULL),
(129, 'aziz', '2022-03-31 16:21:05', 0, 'aaaaa', 0, 1, NULL),
(134, 'zefef', NULL, NULL, 'azef', NULL, NULL, NULL),
(135, 'zzzzzezezezed', NULL, NULL, 'defzef', NULL, NULL, NULL),
(136, 'dsdsd', NULL, NULL, 'dzed', NULL, NULL, NULL),
(138, 'sss', NULL, NULL, 'aas', NULL, NULL, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_5A8A6C8D38B217A7` FOREIGN KEY (`publication_id`) REFERENCES `publication` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
