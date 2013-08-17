-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 24. Januar 2011 um 10:58
-- Server Version: 5.1.41
-- PHP-Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `database`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `activeuser`
--

CREATE TABLE IF NOT EXISTS `activeuser` (
  `id` text NOT NULL,
  `username` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `activeuser`
--

INSERT INTO `activeuser` (`id`, `username`) VALUES
('734313dbc78ed065319e6a46635a', 'admin');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `activities`
--

CREATE TABLE IF NOT EXISTS `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `fun-factor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Daten für Tabelle `activities`
--

INSERT INTO `activities` (`id`, `name`, `fun-factor`) VALUES
(1, 'Wellness', 8),
(2, 'Tennis', 7),
(3, 'Skiing', 8),
(4, 'Wandern', 6),
(5, 'Sightseeing', 7),
(6, 'Schnorcheln', 5),
(7, 'Shopping', 5),
(8, 'Children-Club', 6),
(9, 'Aquapark', 9);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bookings`
--

CREATE TABLE IF NOT EXISTS `bookings` (
  `user_id` int(11) unsigned NOT NULL,
  `booking_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hotel` text NOT NULL,
  `persons` int(11) unsigned NOT NULL,
  `nights` int(11) unsigned NOT NULL,
  `roomtype` text NOT NULL,
  PRIMARY KEY (`user_id`,`booking_id`),
  UNIQUE KEY `booking_id` (`booking_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Daten für Tabelle `bookings`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `citys`
--

CREATE TABLE IF NOT EXISTS `citys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL,
  `city` text NOT NULL,
  `destination_id` int(11) NOT NULL,
  `weather` text NOT NULL,
  `popularity` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

--
-- Daten für Tabelle `citys`
--

INSERT INTO `citys` (`id`, `country_id`, `city`, `destination_id`, `weather`, `popularity`) VALUES
(1, 1, 'Wien', 1, 'Sommer-heiß, Winter-kalt', '7'),
(2, 1, 'Graz', 1, 'Sommer-heiß, Winter-kalt', '7'),
(3, 1, 'Salzburg', 1, 'Sommer-heiß, Winter-kalt', '7'),
(4, 2, 'Sharm el Sheikh', 2, 'Immer heiß', '9'),
(5, 2, 'Hurghada', 2, 'Immer heiß', '9'),
(6, 2, 'Kairo', 2, 'Immer heiß', '9'),
(7, 3, 'Vancouver', 3, 'Sommer-mild, Winter-kalt', '4'),
(8, 3, 'Ottawa', 3, 'Sommer-mild, Winter-kalt', '4'),
(9, 4, 'Singapur', 4, 'Sommer-heiß, Winter-kalt', '5'),
(10, 5, 'Teneriffa', 5, 'Sommer-heiß, Winter-warm', '8'),
(11, 5, 'Fuerteventura', 5, 'Sommer-heiß, Winter-warm', '8'),
(12, 5, 'Gran Canaria', 5, 'Sommer-heiß, Winter-warm', '8'),
(13, 6, 'Monaco', 6, 'Sommer-mild, Winter-kalt', '4'),
(14, 7, 'Trondheim', 7, 'Sommer-kalt, Winter-kalt', '3'),
(15, 7, 'Hamar', 7, 'Sommer-kalt, Winter-kalt', '3'),
(16, 8, 'Rumänien', 6, 'Sommer-heiß, Winter-kalt', '5'),
(17, 9, 'Bombay', 10, 'Immer heiß', '4'),
(18, 10, 'Bali', 4, 'Immer heiß', '8'),
(19, 11, 'Gladstone', 8, 'Sommer-heiß, Winter-mild', '3'),
(20, 11, 'Sydney', 8, 'Sommer-heiß, Winter-mild', '3'),
(21, 12, 'Mato Grosso', 9, 'Immer heiß', '6'),
(22, 12, 'Rio de Janeiro', 9, 'Immer heiß', '6'),
(23, 13, 'Hiroshima', 10, 'Sommer-mild, Winter-kalt', '2'),
(24, 14, 'Panama City', 11, 'Immer heiß', '7'),
(25, 14, 'Hawaii', 11, 'Immer heiß', '7'),
(26, 15, 'Carcasonne', 12, 'Sommer-heiß, Winter-kalt', '8'),
(27, 15, 'Toulouse', 12, 'Sommer-heiß, Winter-kalt', '8'),
(28, 16, 'Hereford', 13, 'Sommer-mild, Winter-kalt', '2'),
(29, 16, 'Liverpool', 13, 'Sommer-mild, Winter-kalt', '2'),
(30, 17, 'Kathmandu', 10, 'Sommer-mild, Winter-kalt', '4'),
(31, 18, 'Manila', 10, 'Sommer-heiß, Winter-warm', '7'),
(32, 19, 'Reykjavik', 13, 'Sommer-kalt, Winter-kalt', '3'),
(33, 20, 'Saltillo', 14, 'Immer heiß', '4'),
(34, 20, 'Mexiko-Stadt', 14, 'Immer heiß', '4'),
(35, 21, 'Antalya', 15, 'Immer heiß', '8'),
(36, 21, 'Mersin', 15, 'Immer heiß', '8'),
(37, 21, 'Analya', 15, 'Immer heiß', '8'),
(38, 22, 'Victoria', 16, 'Immer heiß', '8'),
(39, 22, 'Silhoute', 16, 'Immer heiß', '7'),
(40, 23, 'Male', 17, 'Immer heiß', '9'),
(41, 23, 'Villingili', 17, 'Immer heiß', '8'),
(42, 24, 'Riad', 18, 'Immer heiß', '4'),
(43, 24, 'Dubai', 18, 'Immer heiß', '4'),
(44, 25, 'Kreta', 19, 'Immer heiß', '9'),
(45, 25, 'Rhodos', 19, 'Immer heiß', '8'),
(46, 26, 'Santo Domingo', 20, 'Immer heiß', '3'),
(47, 26, 'Barahona', 20, 'Immer heiß', '6');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `capital` text NOT NULL,
  `inhabitants` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Daten für Tabelle `country`
--

INSERT INTO `country` (`id`, `name`, `capital`, `inhabitants`) VALUES
(1, 'Österreich', 'Wien', 8500000),
(2, 'Ägypten', 'Kairo', 83000000),
(3, 'Kanada', 'Toronto', 34000000),
(4, 'Singapur', 'Singapur', 4500000),
(5, 'Spanien', 'Madrid', 47000000),
(6, 'Monaco', 'Monaco', 33000),
(7, 'Norwegen', 'Oslo', 5000000),
(8, 'Rumänien', 'Bukarest', 21500000),
(9, 'Indien', 'Bombay', 1166000000),
(10, 'Indonesien', 'Jakarta', 237000000),
(11, 'Australien', 'Sydney', 22000000),
(12, 'Brasilien', 'Brasilia', 191000000),
(13, 'Japan', 'Tokio', 127000000),
(14, 'Panama', 'Panama-City', 3300000),
(15, 'Frankreich', 'Paris', 65000000),
(16, 'England', 'London', 50500000),
(17, 'Nepal', 'Kathmandu', 29500000),
(18, 'Philippinen', 'Manila', 88500000),
(19, 'Island', 'Reykjavik', 318000),
(20, 'Mexico', 'Mexico-City', 112000000),
(21, 'Türkei', 'Istanbul', 78000000),
(22, 'Sychellen', 'Victoria', 87500),
(23, 'Malediven', 'Male', 400000),
(24, 'Dubai', 'Dubai', 1800000),
(25, 'Griechenland', 'Athen', 11000000),
(26, 'Dom. Republik', 'Santo Domingo', 9500000);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `destination`
--

CREATE TABLE IF NOT EXISTS `destination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL DEFAULT '0',
  `name` text NOT NULL,
  `theme` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Daten für Tabelle `destination`
--

INSERT INTO `destination` (`id`, `country_id`, `name`, `theme`) VALUES
(1, 1, 'Vienna and surrounding area', 2),
(2, 2, 'Rotes Meer', 8),
(3, 3, 'Toronto and and surrounding area', 3),
(4, 4, 'Bomday and and surrounding area', 8),
(5, 5, 'Kanaren', 8),
(6, 6, 'Monaco and surrounding area', 3),
(7, 7, 'Trondheim', 7),
(8, 11, 'Sydney and surrounding area', 6),
(9, 12, 'Rio de Janeiro and surrounding area', 5),
(10, 17, 'Fujijama and surrounding area', 5),
(11, 0, 'Panama and surrounding area', 1),
(12, 15, 'Carcasonne', 4),
(13, 16, 'Gladstone', 5),
(14, 20, 'Mexico City and surrounding area', 8),
(15, 21, 'Turkish riviera', 4),
(16, 22, 'Sychellen', 8),
(17, 23, 'Maledives', 8),
(18, 24, 'Dubai and surrounding area', 5),
(19, 25, 'Greek Islands', 4),
(20, 26, 'Loma de la Viuda and surrounding area', 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `destinationprofiles`
--

CREATE TABLE IF NOT EXISTS `destinationprofiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `destination_id` int(11) NOT NULL,
  `interest1_id` int(11) NOT NULL,
  `interest1_id_rating` int(11) NOT NULL DEFAULT '0',
  `interest2_id` int(11) NOT NULL,
  `interest2_id_rating` int(11) NOT NULL DEFAULT '0',
  `interest3_id` int(11) NOT NULL,
  `interest3_id_rating` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Daten für Tabelle `destinationprofiles`
--

INSERT INTO `destinationprofiles` (`id`, `destination_id`, `interest1_id`, `interest1_id_rating`, `interest2_id`, `interest2_id_rating`, `interest3_id`, `interest3_id_rating`) VALUES
(1, 1, 5, 9, 7, 4, 1, 7),
(2, 2, 8, 8, 3, 7, 2, 3),
(3, 3, 1, 8, 4, 6, 3, 5),
(4, 4, 5, 7, 2, 5, 4, 8),
(5, 5, 8, 7, 4, 3, 3, 8),
(6, 6, 1, 8, 3, 6, 6, 4),
(7, 7, 6, 7, 7, 3, 4, 7),
(8, 8, 8, 8, 3, 9, 5, 3),
(9, 9, 1, 4, 3, 6, 5, 7),
(10, 10, 2, 4, 5, 6, 7, 3),
(11, 11, 8, 7, 2, 7, 6, 4),
(12, 12, 4, 7, 2, 8, 7, 3),
(13, 13, 7, 4, 5, 9, 4, 6),
(14, 14, 2, 5, 4, 7, 1, 5),
(15, 15, 8, 10, 4, 6, 2, 8),
(16, 16, 8, 7, 6, 4, 3, 7),
(17, 17, 8, 9, 3, 6, 2, 6),
(18, 18, 1, 6, 6, 7, 4, 8),
(19, 19, 4, 6, 3, 6, 2, 3),
(20, 20, 5, 3, 6, 3, 1, 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `evaluations`
--

CREATE TABLE IF NOT EXISTS `evaluations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL DEFAULT '0',
  `comment` text NOT NULL,
  `generell` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `service` int(11) NOT NULL,
  `location` int(11) NOT NULL,
  `gastronomy` int(11) NOT NULL,
  `sports` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=75 ;

--
-- Daten für Tabelle `evaluations`
--

INSERT INTO `evaluations` (`id`, `hotel_id`, `comment`, `generell`, `room`, `service`, `location`, `gastronomy`, `sports`, `user_id`) VALUES
(59, 81, 'Scheiss Hotel', 0, 0, 0, 0, 0, 0, 22),
(58, 4, 'Hotel', 0, 1, 3, 1, 2, 4, 20),
(57, 86, 'SChoenes Hotel', 5, 1, 3, 4, 2, 5, 18),
(56, 88, 'Schoenes Hotel', 6, 6, 5, 6, 4, 5, 17),
(55, 3, 'A gmiatliches Hotel', 6, 6, 6, 6, 6, 6, 16),
(54, 1, 'Ein sehr schoenes Hotel', 0, 1, 2, 3, 4, 5, 15),
(60, 5, 'Vui Gailes Hotel', 1, 3, 4, 3, 1, 3, 23),
(61, 29, 'Des hotel war dreckig', 4, 1, 3, 6, 0, 5, 24),
(62, 63, 'Mei war des Hotel klass', 1, 3, 6, 6, 6, 6, 25),
(63, 51, 'In dem Hotel waren Ratten', 0, 0, 0, 0, 0, 0, 26),
(64, 88, 'Man hat keine Gratisgetraenke', 5, 3, 1, 3, 5, 0, 27),
(65, 8, 'Wenig Essen aber tolle lage', 1, 3, 1, 3, 5, 3, 28),
(66, 1, 'Des hotel hat mir gefallen', 5, 3, 3, 5, 1, 3, 29),
(67, 68, 'This was a great hotel ', 5, 3, 3, 5, 0, 3, 30),
(68, 69, 'Geile StaDT ABER SCHEIS HOTEL', 2, 3, 5, 3, 3, 5, 31),
(69, 51, 'Ralph is schirch', 1, 3, 3, 5, 1, 3, 32),
(70, 53, 'That was a cool hotel', 1, 3, 2, 3, 5, 3, 34),
(71, 9, 'nothing', 2, 4, 3, 2, 4, 3, 35),
(72, 10, 'This hotel was nice', 0, 1, 2, 3, 4, 5, 36),
(73, 14, 'The hotel was crap', 1, 2, 3, 2, 1, 2, 37),
(74, 3, 'cool hotel locaton crap', 3, 5, 3, 1, 3, 6, 38);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `stars` int(11) NOT NULL,
  `pension` text NOT NULL,
  `address` text NOT NULL,
  `smoker` text NOT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=89 ;

--
-- Daten für Tabelle `hotel`
--

INSERT INTO `hotel` (`id`, `city_id`, `name`, `stars`, `pension`, `address`, `smoker`, `price`, `rating`) VALUES
(1, 1, 'Vienna Marriott Hotel', 5, 'both', 'Parkring 12a. Vienna, 1010 Österreich', '1', 143, 9),
(2, 1, 'Grand Hotel Wien', 5, 'both', 'Kärntner Ring 9, 1010 Wien', '1', 242, 8),
(3, 2, 'Mercure Graz City', 4, 'half', 'Lendplatz 36-37, 8020 Graz', '1', 59, 7),
(4, 3, 'Hotel Wolf Dietrich', 4, 'none', 'Wolf-Dietrich-Straße 7, Altstadt, 5020 Salzburg', '0', 140, 6),
(5, 4, 'Marriott Resort', 5, 'both', ' El salam Road (Peace Road), Sharm el Sheikh 46619, Ägypten', '0', 180, 8),
(6, 4, 'Hilton Sharks Bay Resort', 4, 'half', ' Sharks Bay, Sharm el Sheikh 203, Ägypten', '1', 140, 8),
(7, 5, 'Iberotel Aquamarine', 5, 'full', 'South Magawish Road, Hurghada', '1', 160, 5),
(8, 6, 'Sheraton Cairo', 5, 'none', 'Galaa Square, Dokki, Kairo', '1', 120, 6),
(9, 7, 'Inn Downtown Vancouver', 3, 'both', '111 Robson St, Vancouver, Britisch-Kolumbien V6B 2A8, Kanada', '0', 90, 4),
(10, 7, 'Best Western Downtown Vancouver', 3, 'both', '718 Drake Street, Vancouver, Britisch-Kolumbien V6Z 2W6, Kanada', '0', 110, 4),
(11, 8, 'Quality Hotel Ottawa', 3, 'half', '290 Rideau Street, Ottawa (Ontario) ', '0', 70, 6),
(12, 9, 'Goodwood Park Hotel', 5, 'both', '22 Scotts Rd, Singapur 228221, Singapur', '1', 180, 8),
(13, 9, 'Swissotel The Stamford', 5, 'full', '2 Stamford Road, Singapur 178882, Singapur', '1', 250, 9),
(14, 9, 'Hotel 81 Osaka', 2, 'none', '1 Eng Hoon Street, Singapur 169753, Singapur', '1', 80, 4),
(15, 9, 'New Changi Hotel', 1, 'none', '80 Changi Road, Singapur 419715, Singapur', '0', 60, 2),
(16, 10, 'Hotel Cleopatra Palace', 4, 'both', 'Playa del Camison, 38660 Playa de las Americas, Teneriffa, Spanien', '0', 90, 8),
(17, 10, 'Oasis Golf Resort', 3, 'full', 'C/ Meandro 3, 38660 Arona, Teneriffa, Spanien', '1', 102, 6),
(18, 11, 'Hotel Elba Sara', 4, 'both', 'Carretera de Jandía, km. 11, Caleta De Fuste', '0', 98, 6),
(19, 12, 'Ria Panzio', 3, 'none', 'Batthyány Lajos utca 13., Gran', '1', 65, 5),
(20, 13, 'Le Méridien Beach Plaza', 4, 'full', '22 Ave Princesse Grace, Monte Carlo 98000, Monaco', '0', 460, 8),
(21, 13, 'Fairmont Monte Carlo', 5, 'both', '12 Avenue des Spelugues, Monte Carlo 98007, Monaco', '1', 600, 7),
(22, 13, 'Port Palace', 4, 'full', '7, avenue JF Kennedy, Monte Carlo 98000, Monaco', '0', 227, 8),
(23, 14, 'Comfort Hotel Trondheim', 4, 'full', 'Krambugata 3, Trondheim 7011, Norwegen', '1', 90, 6),
(24, 14, 'City Living Schøller Hotel', 4, 'both', 'Dronningensgate 26, 7011 Trondheim', '0', 80, 5),
(25, 15, 'First Hotel Victoria', 3, 'none', 'Strandgaten 21, Hamar', '1', 70, 7),
(26, 15, 'Scandic Hamar', 4, 'full', 'Vangsveien 121, Hamar', '1', 110, 8),
(27, 16, 'Hotel Bulevard', 4, 'full', 'Piata Unirii 10, Sibiu 2400, Rumänien', '1', 80, 5),
(28, 16, 'Hotel Palace RRT', 3, 'both', 'Remus Opreanu 5-7, 900734 Constanta', '0', 33, 7),
(29, 16, 'Hotel GMG', 4, 'full', 'Mamaia Boulevard 210, 900565 Constanta ', '0', 58, 9),
(30, 17, 'InterContinental Marine Drive', 5, 'both', '135 Marine Drive, Mumbai (Bombay) 400020, Indien', '0', 210, 10),
(31, 17, 'Ascot Hotel', 3, 'none', '38 Garden Rd | Colaba, Mumbai (Bombay) 400 039, Indien', '1', 110, 8),
(32, 17, 'Chateau Windsor Hotel', 3, 'full', '86 Veer Nariman Road, Mumbai (Bombay) 400020, Indien', '1', 80, 4),
(33, 18, 'La Villais Exclusive Villa & Spa', 5, 'full', 'Jl. Pangkung Sari, Br. Taman, Seminyak, Bali, Indonesien', '0', 180, 7),
(34, 18, 'Ayodya Resort Bali', 5, 'both', 'Jalan Pantai Mengiat, Nusa Dua, Bali 80363, Indonesien', '0', 105, 8),
(35, 18, 'The Radiant Hotel & Spa', 3, 'none', 'Jl. Puri Grenceng 46, Tuban, Bali, Indonesien', '1', 59, 5),
(36, 18, 'De Munut Cottages', 2, 'full', 'Jl. Penestanan, Ubud, Bali 80571, Indonesien', '1', 38, 6),
(37, 19, 'Queens Hotel & Motor Inn', 3, 'half', '	 125 Goondoon St, Gladstone QLD 4680', '1', 160, 4),
(38, 19, 'Quest Gladstone', 4, 'both', '39-43 Bramston Street, Gladstone 4305, Australien', '0', 180, 7),
(39, 20, 'Hyde Park Inn', 4, 'full', '271 Elizabeth St, Central Business District, Sydney', '1', 210, 8),
(40, 20, 'Sydney Harbour Marriott', 5, 'half', '30 Pitt Street, Central Business District, Sydney', '1', 230, 9),
(41, 21, 'Golden Tulip Pantanal', 4, 'both', 'Correa da Costa 93 | Areao, Cuiaba, Bundesstaat Mato Grosso 78010-400, Brasilien', '0', 220, 6),
(42, 21, 'InterCity Premium Cuiabá', 4, 'both', 'Arthur Bernardes, 64 | Bairro Goiabeiras, Cuiaba, Bundesstaat Mato Grosso 78043-365, Brasilien', '1', 130, 8),
(43, 22, 'Golden Tulip Ipanema Plaza', 4, 'full', 'Rua Farme de Amoedo 34, Ipanema, 22420020 Rio de Janeiro ', '0', 180, 8),
(44, 23, 'Hotel Unizo Hiroshima', 4, 'half', '7-25 Kamihacchobori, Naka-ku, Hiroshima, Hiroshima Prefecture 730-0012, Japan', '1', 46, 7),
(45, 23, 'Hotel New Yorishiro', 4, 'both', '16-5 Wakakusacho, Higashi-ku, Hiroshima, Hiroshima Prefecture 732-0053, Japan', '0', 220, 8),
(46, 23, 'Hotel Granvia Hiroshima', 4, 'full', '1-5, Matsubara-cho, Minami-ku, Hiroshima, Hiroshima Prefecture 732-0822, Japan', '0', 197, 8),
(47, 23, 'ANA Crowne Plaza Hiroshim', 4, 'half', '7-20 Naka-machi, Naka-ku, Hiroshima, Hiroshima Prefecture 730-0037, Japan', '1', 210, 9),
(48, 24, 'Legacy By The Sea', 3, 'none', '15325 Front Beach Rd, Panama City Beach, FL 32413', '1', 95, 6),
(49, 24, 'Red Roof Inn Panama City', 3, 'none', '217 North US Highway 231, Panama City, FL 32405', '0', 77, 5),
(50, 25, 'Equus Hotel & Marina Tower', 3, 'half', '1696 Ala Moana Boulevard, Waikiki, Honolulu', '1', 60, 6),
(51, 25, 'Sheraton Princess Kaiulani', 3, 'full', '120 Kaiulani Avenue, Waikiki, Honolulu (Hawaii)', '1', 80, 5),
(52, 26, 'Best Western Le Donjon', 4, 'full', '2 Rue du Comte Roger | Cite Medievale, 11000 Carcassonne, Frankreich', '1', 160, 7),
(53, 26, 'Adonis La Barbacane', 3, 'half', '15 Rue de la Barbacane, 11000 Carcassonne, Frankreich', '1', 85, 5),
(54, 27, 'Best Western Athenee', 3, 'none', '13 Bis Rue Matabiau, Toulouse', '0', 110, 8),
(55, 27, 'At Home Appart Hotel', 3, 'both', '7 Rue Du Pont Montaudran, Toulouse', '1', 99, 6),
(56, 28, 'Brandon Lodge', 4, 'full', 'Ross Road, Grafton HR2 8BL, England', '0', 85, 7),
(57, 28, 'Somerville House', 5, 'both', '12 Bodenham Road, Hereford HR1 2TS , England', '1', 110, 8),
(58, 29, 'Jurys Inn Liverpool', 3, 'none', 'No. 31 Keel Wharf, City Centre, Liverpool ', '1', 80, 5),
(59, 29, 'Radisson BLU Liverpool', 4, 'full', '107 Old Hall Street, City Centre, Liverpool ', '0', 140, 9),
(60, 30, 'Hotel Shanker', 4, 'half', 'Lazimpat, Kathmandu, Nepal', '0', 68, 6),
(61, 30, 'Hotel Vaishali', 3, 'both', 'P.O. Box: 206, Thamel, Kathmandu, Nepal', '1', 65, 7),
(62, 30, 'Gokarna Forest Resort', 5, 'both', 'Rajnikunj Gokarna, Thali, Kathmandu, Nepal', '1', 180, 8),
(63, 30, 'Hotel Thamel', 2, 'none', 'Ward No.29, Block No.16/57, Thamel, Kathmandu, Nepal', '0', 35, 1),
(64, 31, 'Pearl Lane Hotel', 2, 'none', '1700 M Orosa St, cnr Gen Malvar St | Malate, Manila, Luzon, Philippinen', '1', 35, 4),
(65, 31, 'Philippinen Hotel', 5, 'full', 'Embassy Court, Malabanias Road Plaridel 1, Angeles City, Luzon, Philippinen', '1', 120, 8),
(66, 31, 'Pearl Garden Hotel', 3, 'half', '1700 M. Adriatico St. corner General Malvar St. | Malate, Manila, Luzon 1000, Philippinen', '1', 55, 6),
(67, 31, 'Casa Nicarosa Hotel', 3, 'both', '2116 Madre Ignacia St | Malate, Manila, Luzon D1004, Philippinen', '0', 32, 7),
(68, 32, 'CenterHotel Thingholt', 4, 'both', 'Thingholtsstraeti 3, Reykjavik 101, Island', '0', 119, 9),
(69, 32, 'Hotel Reykjavik', 3, 'none', 'Thingholtsstraeti 37, Reykjavik 120, Island', '1', 64, 7),
(70, 32, 'Hotel Odinsve', 3, 'half', 'Odinstorg, Reykjavik 101, Island', '0', 99, 8),
(71, 32, 'CenterHotel Plaza', 3, 'full', 'Adalstraeti 4, Reykjavik 101, Island', '1', 85, 6),
(72, 33, 'American Hotel Eurotel', 3, 'both', 'Carranza 4100 | Col. Virreyes Residencial, Saltillo 25230, Mexiko', '1', 65, 5),
(73, 33, 'Hotel American Suites Resort', 5, 'both', 'Blvd. Venustiano Carranza 8800, Saltillo 25208 , Mexiko', '0', 68, 6),
(74, 34, 'Hotel Nikko Mexico', 5, 'half', 'Campos Eilseos No. 204 Col. Polanco , Mexico-Stad', '1', 130, 7),
(75, 34, 'Ramada Aeropuerto Mexico', 4, 'both', 'Boulevard Puerto Aero 390 Col. Moctezuma 2da Seccion, Mexico-Stadt', '0', 85, 10),
(76, 35, 'Ramada Plaza Antalya', 5, 'full', 'Genclik Mah. Fevzi Cakmak Cad. No:22, Antalya', '0', 240, 9),
(77, 36, 'Kardelen Hotel', 3, 'half', 'Mesudiye Mah Fasih Kayabak Cad No:111, Mersin', '0', 59, 8),
(78, 37, 'Blue Wave Suite Hotel', 3, 'both', 'Fatih Cad No:43 Obagol Mevkii, Alanya', '1', 40, 7),
(79, 38, 'Le Meridien Barbarons', 5, 'both', 'Victoria · P.O. Box 626, Barbarons, Mahé ', '1', 240, 8),
(80, 39, 'Labriz Silhouette', 5, 'none', 'PO Box 69, Mahe, Silhouette Island, Seychellen', '0', 180, 1),
(81, 40, 'Hulhumale Beach Hotel', 3, 'none', 'Dhigga magu, Malé', '1', 79, 4),
(82, 41, 'Robinson Club Maldives', 4, 'full', 'Funamadua, Gaafu Alif Atoll', '1', 320, 10),
(83, 42, 'Executives Hotel', 4, 'half', 'Olaya Main Street, Riyadh', '1', 210, 6),
(84, 43, 'The Palace The Old Town', 3, 'both', 'Downtown Burj Dubai, Sheikh Zayed Road, Downtown Dubai, Dubai', '0', 530, 9),
(85, 44, 'Kastro Hotel', 3, 'both', 'Theotokopoulou 22, 71202 Heraklion', '0', 50, 8),
(86, 45, 'Atlantis City Hotel', 2, 'none', 'Ionos Dragoumi 29, Rhodos', '1', 38, 7),
(87, 46, 'Hotel Occidental El Embajador', 3, 'half', 'Avda. Sarasota, Santo Domingo (Santo Domingo) ', '0', 72, 8),
(88, 47, 'Hotel Gran Bahia Principe El Portillo', 4, 'full', ' Limon Km. 4, Las Terrenas, Dominikanische Republik', '1', 80, 8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hotelprofiles`
--

CREATE TABLE IF NOT EXISTS `hotelprofiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `interest1_id` int(11) NOT NULL,
  `interest2_id` int(11) NOT NULL,
  `interest3_id` int(11) NOT NULL,
  `activity1_id` int(11) NOT NULL,
  `activity1_id_rating` int(11) NOT NULL DEFAULT '0',
  `activity2_id` int(11) NOT NULL,
  `activity2_id_rating` int(11) NOT NULL DEFAULT '0',
  `activity3_id` int(11) NOT NULL,
  `activity3_id_rating` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=89 ;

--
-- Daten für Tabelle `hotelprofiles`
--

INSERT INTO `hotelprofiles` (`id`, `hotel_id`, `interest1_id`, `interest2_id`, `interest3_id`, `activity1_id`, `activity1_id_rating`, `activity2_id`, `activity2_id_rating`, `activity3_id`, `activity3_id_rating`) VALUES
(1, 1, 1, 5, 0, 1, 3, 2, 2, 5, 5),
(2, 2, 1, 5, 0, 1, 6, 2, 3, 5, 2),
(3, 3, 1, 0, 0, 1, 7, 5, 8, 0, 7),
(4, 4, 5, 0, 0, 2, 2, 4, 7, 5, 9),
(5, 5, 3, 4, 8, 1, 2, 8, 5, 9, 4),
(6, 6, 3, 4, 8, 1, 1, 8, 2, 9, 10),
(7, 7, 2, 8, 0, 2, 5, 6, 3, 9, 4),
(8, 8, 2, 3, 0, 2, 7, 6, 5, 8, 6),
(9, 9, 1, 5, 7, 3, 8, 4, 3, 3, 2),
(10, 10, 2, 3, 7, 3, 3, 5, 7, 4, 5),
(11, 11, 2, 3, 7, 3, 4, 4, 6, 0, 4),
(12, 12, 1, 3, 5, 1, 7, 2, 3, 7, 2),
(13, 13, 1, 5, 0, 1, 4, 5, 7, 7, 6),
(14, 14, 1, 5, 0, 2, 7, 5, 6, 7, 6),
(15, 15, 5, 0, 0, 5, 8, 0, 5, 0, 3),
(16, 16, 1, 5, 0, 7, 10, 5, 3, 0, 7),
(17, 17, 1, 8, 3, 2, 4, 8, 4, 9, 3),
(18, 18, 4, 5, 8, 2, 7, 1, 5, 5, 6),
(19, 19, 4, 6, 8, 2, 9, 8, 5, 9, 1),
(20, 20, 1, 5, 0, 1, 10, 2, 4, 5, 4),
(21, 21, 1, 5, 0, 1, 3, 2, 7, 5, 6),
(22, 22, 1, 0, 0, 1, 5, 5, 4, 0, 3),
(23, 23, 1, 2, 3, 3, 7, 4, 9, 7, 8),
(24, 24, 1, 5, 0, 3, 8, 4, 8, 5, 5),
(25, 25, 7, 6, 0, 3, 9, 4, 7, 5, 7),
(26, 26, 6, 7, 0, 3, 3, 0, 4, 0, 9),
(27, 27, 1, 3, 5, 1, 6, 5, 7, 0, 3),
(28, 28, 3, 5, 0, 1, 3, 7, 10, 5, 10),
(29, 29, 5, 0, 0, 1, 7, 7, 6, 0, 4),
(30, 30, 3, 4, 8, 1, 2, 8, 1, 9, 7),
(31, 31, 3, 4, 8, 1, 6, 8, 2, 9, 4),
(32, 32, 2, 8, 0, 2, 7, 6, 7, 9, 6),
(33, 33, 2, 3, 0, 2, 4, 6, 2, 8, 3),
(34, 34, 3, 4, 8, 1, 8, 8, 3, 9, 4),
(35, 35, 3, 4, 8, 1, 4, 8, 7, 9, 4),
(36, 36, 2, 8, 0, 2, 7, 6, 5, 9, 6),
(37, 37, 2, 3, 5, 2, 8, 6, 3, 5, 3),
(38, 38, 3, 4, 8, 1, 4, 8, 7, 9, 4),
(39, 39, 3, 4, 8, 1, 2, 8, 5, 9, 10),
(40, 40, 2, 8, 6, 2, 7, 6, 8, 9, 4),
(41, 41, 2, 3, 5, 2, 8, 6, 4, 5, 6),
(42, 42, 3, 4, 8, 1, 10, 8, 5, 9, 4),
(43, 43, 3, 4, 8, 1, 5, 8, 3, 9, 6),
(44, 44, 1, 5, 0, 1, 4, 2, 5, 5, 3),
(45, 45, 1, 5, 0, 1, 7, 2, 7, 5, 7),
(46, 46, 1, 0, 0, 1, 4, 5, 3, 0, 4),
(47, 47, 5, 0, 0, 2, 6, 4, 5, 5, 2),
(48, 48, 2, 3, 5, 2, 8, 6, 8, 5, 7),
(49, 49, 3, 4, 8, 1, 4, 8, 2, 9, 8),
(50, 50, 3, 4, 8, 1, 5, 8, 3, 9, 4),
(51, 51, 2, 8, 6, 2, 7, 6, 5, 9, 6),
(52, 52, 1, 5, 0, 1, 8, 2, 5, 5, 4),
(53, 53, 1, 5, 0, 1, 5, 2, 10, 5, 5),
(54, 54, 1, 0, 0, 1, 5, 5, 5, 0, 6),
(55, 55, 5, 0, 0, 2, 8, 4, 5, 5, 4),
(56, 56, 1, 5, 0, 1, 2, 2, 2, 5, 4),
(57, 57, 1, 5, 0, 1, 3, 2, 4, 5, 7),
(58, 58, 1, 0, 0, 1, 1, 5, 7, 0, 8),
(59, 59, 5, 0, 0, 2, 6, 4, 8, 5, 5),
(60, 60, 1, 2, 3, 3, 4, 4, 3, 7, 4),
(61, 61, 1, 5, 0, 3, 7, 4, 3, 5, 6),
(62, 62, 7, 6, 0, 3, 6, 4, 4, 5, 7),
(63, 63, 6, 7, 0, 3, 6, 0, 8, 0, 3),
(64, 64, 2, 3, 0, 2, 4, 6, 4, 8, 6),
(65, 65, 3, 4, 8, 1, 8, 8, 2, 9, 7),
(66, 66, 3, 4, 8, 1, 4, 8, 7, 9, 4),
(67, 67, 2, 8, 0, 2, 9, 6, 4, 9, 2),
(68, 68, 1, 2, 3, 3, 7, 4, 6, 7, 6),
(69, 69, 1, 5, 0, 3, 3, 4, 4, 5, 4),
(70, 70, 7, 6, 0, 3, 6, 4, 10, 5, 4),
(71, 71, 6, 7, 0, 3, 7, 0, 2, 0, 5),
(72, 72, 2, 3, 0, 2, 4, 6, 9, 8, 2),
(73, 73, 3, 4, 8, 1, 8, 8, 8, 9, 4),
(74, 74, 3, 4, 8, 1, 3, 8, 5, 9, 2),
(75, 75, 2, 8, 0, 2, 6, 6, 4, 9, 4),
(76, 76, 2, 8, 0, 2, 4, 6, 8, 9, 5),
(77, 77, 1, 2, 3, 3, 8, 4, 6, 7, 6),
(78, 78, 1, 5, 0, 3, 9, 4, 3, 5, 7),
(79, 79, 7, 6, 0, 3, 2, 4, 5, 5, 9),
(80, 80, 6, 7, 0, 3, 10, 0, 2, 0, 10),
(81, 81, 2, 3, 0, 2, 3, 6, 3, 8, 4),
(82, 82, 3, 4, 8, 1, 5, 8, 2, 9, 10),
(83, 83, 3, 4, 8, 1, 7, 8, 3, 9, 3),
(84, 84, 2, 8, 0, 2, 8, 6, 3, 9, 5),
(85, 85, 2, 8, 0, 2, 3, 6, 8, 9, 2),
(86, 86, 1, 2, 3, 3, 2, 4, 6, 7, 6),
(87, 87, 1, 5, 0, 3, 4, 4, 2, 5, 10),
(88, 88, 7, 6, 0, 3, 5, 4, 4, 5, 7);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `interests`
--

CREATE TABLE IF NOT EXISTS `interests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `fun-factor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Daten für Tabelle `interests`
--

INSERT INTO `interests` (`id`, `name`, `fun-factor`) VALUES
(1, 'Buisness', 3),
(2, 'Nature', 7),
(3, 'Sports', 7),
(4, 'Family', 6),
(5, 'Culture', 4),
(6, 'Country-Holiday', 4),
(7, 'North-Holiday', 3),
(8, 'Swim-Holiday', 8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `profiles`
--

CREATE TABLE IF NOT EXISTS `profiles` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserId` int(11) unsigned NOT NULL,
  `Interest1_id` text,
  `Interest1_rating` int(11) unsigned DEFAULT NULL,
  `Interest2_id` text,
  `Interest2_rating` int(11) unsigned DEFAULT NULL,
  `Interest3_id` text,
  `Interest3_rating` int(11) unsigned DEFAULT NULL,
  `Activity1_id` text,
  `Activity1_rating` int(11) unsigned DEFAULT NULL,
  `Activity2_id` text,
  `Activity2_rating` int(11) unsigned DEFAULT NULL,
  `Activity3_id` text,
  `Activity3_rating` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`,`UserId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Daten für Tabelle `profiles`
--

INSERT INTO `profiles` (`Id`, `UserId`, `Interest1_id`, `Interest1_rating`, `Interest2_id`, `Interest2_rating`, `Interest3_id`, `Interest3_rating`, `Activity1_id`, `Activity1_rating`, `Activity2_id`, `Activity2_rating`, `Activity3_id`, `Activity3_rating`) VALUES
(8, 17, '1', 8, '3', 10, '8', 9, '6', 9, '3', 8, '1', 4),
(7, 16, '6', 7, '2', 6, '5', 10, '8', 3, '1', 6, '4', 9),
(1, 1, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0),
(6, 15, '1', 6, '3', 3, '2', 8, '4', 5, '2', 10, '3', 2),
(9, 18, '7', 6, '4', 6, '6', 6, '7', 8, '4', 5, '7', 9),
(10, 19, '', 0, '', 0, '', 0, '', 0, '', 0, '', 0),
(11, 20, '4', 4, '8', 5, '3', 7, '9', 2, '1', 4, '5', 7),
(12, 21, '', 0, '', 0, '', 0, '', 0, '', 0, '', 0),
(13, 22, '3', 10, '8', 7, '7', 5, '9', 6, '3', 7, '6', 8),
(14, 23, '4', 3, '8', 6, '5', 9, '3', 3, '6', 4, '9', 8),
(15, 24, '5', 2, '6', 5, '1', 8, '5', 2, '6', 5, '9', 7),
(16, 25, '2', 4, '5', 5, '4', 3, '1', 2, '5', 5, '8', 3),
(17, 26, '2', 4, '7', 4, '4', 5, '4', 3, '5', 3, '1', 2),
(18, 27, '2', 1, '7', 7, '3', 6, '5', 4, '3', 7, '8', 10),
(19, 28, '3', 2, '5', 8, '7', 7, '1', 2, '2', 7, '4', 10),
(20, 29, '3', 4, '6', 4, '8', 6, '7', 4, '1', 2, '8', 4),
(21, 19, '', 0, '', 0, '', 0, '', 0, '', 0, '', 0),
(22, 31, '4', 2, '1', 6, '8', 6, '5', 4, '9', 3, '7', 5),
(23, 32, '2', 2, '4', 4, '6', 3, '8', 6, '2', 3, '6', 0),
(24, 33, '2', 3, '7', 2, '4', 3, '5', 5, '3', 3, '9', 4),
(25, 34, '4', 6, '3', 4, '6', 8, '2', 3, '5', 6, '8', 9),
(26, 15, '', 0, '', 0, '', 0, '', 0, '', 0, '', 0),
(27, 36, '4', 7, '5', 2, '7', 7, '4', 4, '3', 4, '9', 8),
(28, 37, '3', 1, '6', 3, '1', 8, '1', 3, '6', 3, '7', 9),
(29, 38, '3', 2, '4', 4, '7', 7, '4', 1, '6', 2, '9', 9);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `FirstName` text,
  `LastName` text,
  `Email` text,
  `username` text,
  `password` text,
  `admin` int(1) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`Id`, `FirstName`, `LastName`, `Email`, `username`, `password`, `admin`) VALUES
(17, 'Ralph', 'Ankele', 'ralph.ankele@student.tugraz.at', 'ralph', '123456', 0),
(16, 'Sepp', 'Forcher', 'sepp@hotmail.com', 'sepp', '123456', 0),
(1, 'Administrator', 'Administrator', 'admin@trec.at', 'admin', 'admin', 1),
(15, 'Hans', 'Maier', 'hans@gmail.com', 'hans', '123456', 0),
(18, 'Robin', 'Ankele', 'robin.ankele@student.tugraz.at', 'robin', '123456', 0),
(19, 'test', 'test', 'test', 'test', 'test', 0),
(20, 'Muesluem', 'Atas', 'muesluem.atas@student.tugraz.at', 'muesluem', '123456', 0),
(21, 'Raphael', 'Sommer', 'raphael.sommer@student.tugraz.at', 'raphael', '123456', 0),
(22, 'michi', 'panzerknacker', 'knacker@panzer.at', 'panzer1', '1234', 0),
(23, 'Donald', 'Duck', 'donald@duck.at', 'donald', '12345', 0),
(24, 'Michael ', 'Wendt', 'michael.wendt@hotmail.com', 'michael', '12345', 0),
(25, 'Tullia ', 'Zevi', 'tullia.zevi@gmx.net', 'tullia', '123456', 0),
(26, 'emanuele', 'gerada', 'emanuele@geradea.de', 'emanuele', '1234', 0),
(27, 'Peter ', 'Muller ', 'peter.mueller@student.de', 'peter', 'test', 0),
(28, 'Joachim', 'Schulz', 'schultz@nix.de', 'schulz', '2323', 0),
(29, 'Atas', 'Lang', 'lang.atas@hotmail.com', 'lang', '4545', 0),
(30, 'Fritz', 'Lorenz', 'fritz.lori@gmx.de', 'test1', 'test1', 0),
(31, 'Thomas', 'Sauer', 'tom.sauer@sauer.at', 'tom', 'sauer', 0),
(32, 'Otto', 'Fuchs', 'otto.fuchs@gmx.net', 'otto', 'otto', 0),
(33, 'Weis', 'Jung', 'weis.jung@jung.de', 'weis', 'jung', 0),
(34, ' Java ', 'admin', 'java@netbeans.de', 'java', 'admin', 0),
(35, 'ich', 'hans', 'hans.peter@gg.de', 'hans1', 'peter', 0),
(36, 'Samuel', 'Atas', 'samuel.atas@student.de', 'samuel', 'atas', 0),
(37, 'trec', 'last', 'roland.trec@gmx.de', 'trec', '1234', 0),
(38, 'user', 'name', 'user.name@user.com', 'username', 'password', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
