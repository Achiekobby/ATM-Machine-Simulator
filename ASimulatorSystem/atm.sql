-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2021 at 06:10 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `pin` varchar(15) NOT NULL,
  `date` varchar(50) NOT NULL,
  `mode` varchar(50) NOT NULL,
  `amount` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`pin`, `date`, `mode`, `amount`) VALUES
('3020', 'Thu Apr 15 13:22:56 GMT 2021', 'Deposit', '1000'),
('3020', 'Mon Apr 19 08:22:39 GMT 2021', 'Withdrawal', '500'),
('3020', 'Mon Apr 19 10:48:17 GMT 2021', 'Withdrawal', '500'),
('3020', 'Mon Apr 19 10:52:29 GMT 2021', 'Withdrawal', '0'),
('3020', 'Mon Apr 19 11:42:46 GMT 2021', 'Deposit', '10000'),
('3020', 'Mon Apr 19 11:43:00 GMT 2021', 'Withdrawal', '2000');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `form_no` varchar(50) NOT NULL,
  `cardno` varchar(255) NOT NULL,
  `pin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`form_no`, `cardno`, `pin`) VALUES
(' 2303', '5040936021549473', '3020');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `form_no` varchar(50) NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `birthDay` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `maritalStatus` varchar(50) NOT NULL,
  `homeAddress` varchar(50) NOT NULL,
  `homeCity` varchar(50) NOT NULL,
  `pinCode` varchar(50) NOT NULL,
  `homeRegion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`form_no`, `fatherName`, `fullName`, `birthDay`, `gender`, `email`, `maritalStatus`, `homeAddress`, `homeCity`, `pinCode`, `homeRegion`) VALUES
(' 2303', 'Richard Webb', 'David Webb', 'Aug 9, 1997', 'Male', 'david@gmail.com', 'Unmarried', 'Santasi Station', 'Kumasi', '10000', 'Ashanti Region');

-- --------------------------------------------------------

--
-- Table structure for table `signup2`
--

CREATE TABLE `signup2` (
  `form_no` varchar(50) NOT NULL,
  `religion` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `income` varchar(50) NOT NULL,
  `educational` varchar(50) NOT NULL,
  `occupation` varchar(50) NOT NULL,
  `pan` varchar(50) NOT NULL,
  `aadhar` varchar(50) NOT NULL,
  `senior` varchar(50) NOT NULL,
  `existing` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup2`
--

INSERT INTO `signup2` (`form_no`, `religion`, `category`, `income`, `educational`, `occupation`, `pan`, `aadhar`, `senior`, `existing`) VALUES
(' 2303', 'Christian', 'General', '> $1000', 'Graduate', 'Salaried', 'AQRS20000', '300000', 'No', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `signup3`
--

CREATE TABLE `signup3` (
  `form_no` varchar(50) NOT NULL,
  `accountType` varchar(50) NOT NULL,
  `cardNumber` varchar(50) NOT NULL,
  `cardPass` varchar(50) NOT NULL,
  `serviceRequired` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup3`
--

INSERT INTO `signup3` (`form_no`, `accountType`, `cardNumber`, `cardPass`, `serviceRequired`) VALUES
(' 2303', 'Saving Account', '5040936021549473', '3020', ' -ATM Card  -Internet Banking ');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
