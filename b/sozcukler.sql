-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 14 Nis 2016, 01:35:05
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `sozcukler`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `govdeler`
--

CREATE TABLE IF NOT EXISTS `govdeler` (
  `govdeno` int(11) NOT NULL AUTO_INCREMENT,
  `govdeisim` text COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`govdeno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=25 ;

--
-- Tablo döküm verisi `govdeler`
--

INSERT INTO `govdeler` (`govdeno`, `govdeisim`) VALUES
(1, 'Annesiyle'),
(2, 'yoksa'),
(3, 'dünyada'),
(4, 'ölümlü'),
(5, 'yaşındaki'),
(6, 'isminde'),
(7, 'adam.'),
(8, 'ayağı'),
(9, 'çukurda'),
(10, 'çocukken'),
(11, 'peronda'),
(12, 'Tren'),
(13, 'Annesiyle'),
(14, 'yoksa'),
(15, 'babasıyla'),
(16, 'sayıda'),
(17, 'olasılığı'),
(18, 'gezegen,'),
(19, 'ölüm'),
(20, 'düşük'),
(21, 'kalorili'),
(22, 'mısırınızın'),
(23, 'tadını'),
(24, 'seyirler');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kokler`
--

CREATE TABLE IF NOT EXISTS `kokler` (
  `kokno` int(11) NOT NULL AUTO_INCREMENT,
  `kokisim` text COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`kokno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=30 ;

--
-- Tablo döküm verisi `kokler`
--

INSERT INTO `kokler` (`kokno`, `kokisim`) VALUES
(1, 'anne'),
(2, 'yok'),
(3, 'baba'),
(4, 'dünya'),
(5, 'öl'),
(6, 'yaş'),
(7, 'isim'),
(8, 'adam'),
(9, 'ayak'),
(10, 'çukur'),
(11, 'genç'),
(12, 'çocuk'),
(13, 'peron'),
(14, 'tren'),
(15, 'anne'),
(16, 'yok'),
(17, 'baba'),
(18, 'sayı'),
(19, 'ol'),
(20, 'gezegen'),
(21, 'öl'),
(22, 'düş'),
(23, 'kalori'),
(24, 'mısır'),
(25, 'tat'),
(26, 'devam'),
(27, 'seyir'),
(28, 'baba'),
(29, 'baba');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
