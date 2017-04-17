-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2017 at 08:54 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `longswordusermanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(50) NOT NULL,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `firstname` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `lastname` varchar(250) DEFAULT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `activatedKey` varchar(250) DEFAULT NULL,
  `resetKey` varchar(250) DEFAULT NULL,
  `resetDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `username`, `password`, `isAdmin`, `firstname`, `email`, `lastname`, `activated`, `activatedKey`, `resetKey`, `resetDate`) VALUES
(1, 'Tk', '12345', 1, 'Takalani', 'dsad@g.com', 'Black', 1, NULL, NULL, NULL),
(3, 'John', '30', 1, 'Joey', 'something@gmail.com', 'Doe', 1, NULL, NULL, NULL),
(8, 'Pete', 'LFby/ODNbcfTQ9ZXHVTByt5XoF2HWRvoyqmXH8lEvjY=$VUP6ytNjvLGymNLcZzsp64rQLroSGf46+wKy/BOYXF0=', 1, 'Joey', 'something@gmail.com', 'Doe', 1, 'key1', 'key2', '2017-09-17 20:02:28'),
(10, 'Pete2', 'FnyejGvWPkYPYYBI6prF6mPf8TyNxYu69igtJD3QkVQ=$O7X6qwSkmJ+BW7Ph9ueZ0ZAJwW1LkxmUrXDZ6oh1Wm4=', 1, 'Joey', 'something2@gmail.com', 'Doe', 1, 'key1', 'key2', '2017-09-17 20:49:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
