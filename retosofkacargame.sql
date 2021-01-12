-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-01-2021 a las 03:58:03
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `retosofkacargame`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `Id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `puntos` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`Id`, `nombre`, `puntos`) VALUES
(1, 'prueba', 0),
(11, 'Sebastian', 1),
(12, 'Davila', 2),
(13, 'Garcia', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `podio`
--

CREATE TABLE `podio` (
  `IdentificadorCarrera` varchar(50) NOT NULL,
  `PrimerLugar` varchar(50) NOT NULL,
  `SegundoLugar` varchar(50) NOT NULL,
  `TercerLugar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `podio`
--

INSERT INTO `podio` (`IdentificadorCarrera`, `PrimerLugar`, `SegundoLugar`, `TercerLugar`) VALUES
('Australia', 'Garcia', 'Sebastian', 'Davila'),
('Brasil', 'Sebastian', 'Davila', 'Garcia'),
('EEUU', 'Garcia', 'Sebastian', 'Davila'),
('Gran premio Australia', 'Davila', 'Sebastian', 'Garcia'),
('Gran premio Mexico', 'Garcia', 'Sebastian', 'Davila'),
('Monaco', 'Davila', 'Garcia', 'Sebastian');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `podio`
--
ALTER TABLE `podio`
  ADD PRIMARY KEY (`IdentificadorCarrera`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
