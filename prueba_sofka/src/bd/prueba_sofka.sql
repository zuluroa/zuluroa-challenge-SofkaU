-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-09-2021 a las 18:58:24
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba_sofka`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `Id` int(1) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `Ronda` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`Id`, `Nombre`, `Ronda`) VALUES
(1, 'PROGRAMACIÓN', 1),
(2, 'GEOGRAFÍA', 2),
(4, 'HISTORIA', 3),
(6, 'CIENCIAS EXACTAS', 5),
(7, 'CIENCIAS NATURALES', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `Id` int(1) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Premio` int(1) NOT NULL,
  `Ronda` int(1) NOT NULL,
  `Acomulado` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

CREATE TABLE `opcion` (
  `Id` int(3) NOT NULL,
  `Respuesta` text NOT NULL,
  `Estado` int(1) NOT NULL,
  `Pregunta` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opcion`
--

INSERT INTO `opcion` (`Id`, `Respuesta`, `Estado`, `Pregunta`) VALUES
(1, 'Es el seguimiento del DFD para la solucion a un problema.', 1, 1),
(2, 'Es una serie de pasos para dar solución a un problema.', 0, 1),
(3, 'Es el orden de los pasos para un sistema de informacion.', 1, 1),
(4, 'Es el estudio de las ordenes creadas por un programador.', 1, 1),
(5, 'php', 1, 2),
(6, 'java', 1, 2),
(7, 'mysql', 0, 2),
(8, 'c++', 1, 2),
(9, 'postgres', 1, 3),
(10, 'sqljava', 0, 3),
(11, 'mysql', 1, 3),
(12, 'oracle', 1, 3),
(13, 'if', 1, 4),
(14, 'for', 1, 4),
(15, 'witch', 0, 4),
(16, 'else', 1, 4),
(17, 'if', 1, 5),
(18, 'witch', 1, 5),
(19, 'while', 0, 5),
(20, 'fore', 1, 5),
(21, 'Río Nilo', 1, 6),
(22, 'Río Amazonas', 0, 6),
(23, 'Río Danubio', 1, 6),
(24, 'Rio Zulia', 1, 6),
(25, 'Océano Pacífico', 0, 7),
(26, 'Océano Índico', 1, 7),
(27, 'Océano Atlántico', 1, 7),
(28, 'Océano Rojo', 1, 7),
(33, 'China', 1, 8),
(34, 'Rusia', 0, 8),
(35, 'India', 1, 8),
(36, 'Estados Unidos', 1, 8),
(37, 'España', 1, 9),
(38, 'Honduras', 1, 9),
(39, 'Mexico', 1, 9),
(40, 'Italia', 0, 9),
(41, 'Estados Unidos', 1, 10),
(42, 'Canada', 1, 10),
(43, 'China', 1, 10),
(44, 'Rusia', 0, 10),
(45, '1945', 0, 17),
(46, '1947', 1, 17),
(47, '1943', 1, 17),
(48, '1941', 1, 17),
(49, '1429', 1, 18),
(50, '1592', 1, 18),
(51, '1492', 0, 18),
(52, '1591', 1, 18),
(53, 'Sigmund Freud', 0, 19),
(54, 'Carl Gustav Jung', 1, 19),
(55, 'Skinner', 1, 19),
(56, 'Sigmund Fenax', 1, 19),
(57, 'Benito Mussolini', 1, 20),
(58, 'Adolf Hitler', 0, 20),
(59, 'Heinrich Himmler', 1, 20),
(60, 'Sigmund Fenax', 1, 20),
(61, 'La Biblia', 1, 21),
(62, 'El Talmud', 1, 21),
(63, 'Talmud', 1, 21),
(64, 'El Corán', 0, 21),
(65, 'Hígado', 1, 22),
(66, 'Pulmones', 1, 22),
(67, 'Páncreas', 0, 22),
(68, 'Celebro', 1, 22),
(69, 'Zoología', 0, 23),
(70, 'Fauna', 1, 23),
(71, 'Medicina', 1, 23),
(72, 'Bioentorno', 1, 23),
(73, '6', 1, 24),
(74, '10', 1, 24),
(75, '8', 0, 24),
(76, '4', 1, 24),
(77, 'Leopardo', 1, 25),
(78, 'Guepardo', 0, 25),
(79, 'Cóndor', 1, 25),
(80, 'Tiburón', 1, 25),
(81, 'Murciélago', 0, 26),
(82, 'Avestruz', 1, 26),
(83, 'Águila', 1, 26),
(84, 'Pinguino', 1, 26),
(85, 'Oxígeno', 0, 27),
(86, 'Nitrógeno', 1, 27),
(87, 'Carbono', 1, 27),
(88, 'Agua', 1, 27),
(89, 'Múltiplo', 1, 28),
(90, 'Restante', 1, 28),
(91, 'Resultado', 1, 28),
(92, 'Producto', 0, 28),
(93, '3.1614', 1, 29),
(94, '3.1416', 0, 29),
(95, '3.416', 1, 29),
(96, '3.166', 1, 29),
(97, 'Bronce', 1, 30),
(98, 'Cobre', 0, 30),
(99, 'Acero', 1, 30),
(100, 'Diamante', 1, 30),
(101, '0', 1, 31),
(102, '1', 1, 31),
(103, '2', 0, 31),
(104, '3', 1, 31);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `Id` int(2) NOT NULL,
  `Pregunta` text NOT NULL,
  `Categoria` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`Id`, `Pregunta`, `Categoria`) VALUES
(1, '¿Que es un algoritmo?', 1),
(2, 'No es un lenguaje de programacion', 1),
(3, 'No es un gestor de base de datos', 1),
(4, '¿Cual no es una sentencia condicional?', 1),
(5, 'Seleccione la sentencia de ciclo', 1),
(6, '¿Cuál es el nombre del río más largo del mundo?', 2),
(7, '¿Cuál es el océano más grande del mundo?', 2),
(8, '¿Cuál es el país más grande del mundo?', 2),
(9, '¿Cuál es el país que tiene forma de bota?', 2),
(10, '¿Cuál es el país más poblado de la tierra?', 2),
(17, '¿Cuándo terminó la II Guerra Mundial?', 4),
(18, '¿En qué año llegó Cristobal Colón a América?', 4),
(19, ' ¿Quién es el padre del psicoanálisis?', 4),
(20, '¿Quién era el general de los Nazis en la Segunda Guerra Mundial?', 4),
(21, '¿Cuál es el libro sagrado de los musulmanes?', 4),
(22, '¿En qué parte del cuerpo se produce la insulina?', 7),
(23, '¿Qué rama de la biología estudia a los animales?', 7),
(24, '¿Cuántas patas tiene una araña?', 7),
(25, '¿Cuál es el animal más rápido del mundo?', 7),
(26, '¿Cuál es el único mamífero que puede volar?', 7),
(27, '¿Cuál es el elemento químico más abundante en la corteza terrestre?', 6),
(28, '¿Cómo se denomina al resultado de una multiplicación?', 6),
(29, '¿A cuánto equivale el numero Pi?', 6),
(30, '¿Cuál fue el primer metal que emplearon los seres humanos?', 6),
(31, '¿Cuál es el primero de los números primos?', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `Id` int(1) NOT NULL,
  `TipoPremio` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `premio`
--

INSERT INTO `premio` (`Id`, `TipoPremio`) VALUES
(1, 'PUNTOS'),
(2, 'DINERO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `Id` int(1) NOT NULL,
  `Nivel` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`Id`, `Nivel`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Pregunta` (`Ronda`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Premio` (`Premio`),
  ADD KEY `Ronda` (`Ronda`);

--
-- Indices de la tabla `opcion`
--
ALTER TABLE `opcion`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Pregunta` (`Pregunta`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Categoria` (`Categoria`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `Id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `Id` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `opcion`
--
ALTER TABLE `opcion`
  MODIFY `Id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `Id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `Id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ronda`
--
ALTER TABLE `ronda`
  MODIFY `Id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`Ronda`) REFERENCES `ronda` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_3` FOREIGN KEY (`Ronda`) REFERENCES `ronda` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jugador_ibfk_4` FOREIGN KEY (`Premio`) REFERENCES `premio` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `opcion`
--
ALTER TABLE `opcion`
  ADD CONSTRAINT `opcion_ibfk_1` FOREIGN KEY (`Pregunta`) REFERENCES `pregunta` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
