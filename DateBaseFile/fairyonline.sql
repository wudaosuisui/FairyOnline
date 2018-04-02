-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-04-02 13:20:41
-- 服务器版本： 5.7.18
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fairyonline`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `UserName` varchar(1) DEFAULT NULL,
  `PassWord` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `admins`
--

CREATE TABLE `admins` (
  `ID` int(11) DEFAULT NULL,
  `UserName` varchar(1) DEFAULT NULL,
  `PassWord` varchar(1) DEFAULT NULL,
  `Power` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `balog`
--

CREATE TABLE `balog` (
  `who` int(11) DEFAULT NULL,
  `when` time DEFAULT NULL,
  `thing` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `books`
--

CREATE TABLE `books` (
  `ID` int(11) DEFAULT NULL,
  `BookName` varchar(1) DEFAULT NULL,
  `BuyUrl` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `car`
--

CREATE TABLE `car` (
  `UID` int(11) DEFAULT NULL,
  `CID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE `category` (
  `ID` int(11) DEFAULT NULL,
  `CategoryName` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `ID` int(11) DEFAULT NULL,
  `CName` varchar(1) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  `UPTime` time DEFAULT NULL,
  `TID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `example`
--

CREATE TABLE `example` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `example`
--

INSERT INTO `example` (`id`, `name`) VALUES
(1, 'exampleName'),
(2, 'exampleName'),
(3, 'exampleName');

-- --------------------------------------------------------

--
-- 表的结构 `file`
--

CREATE TABLE `file` (
  `ID` int(11) DEFAULT NULL,
  `name` varchar(1) DEFAULT NULL,
  `TiD` int(11) DEFAULT NULL,
  `URL` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `followcourse`
--

CREATE TABLE `followcourse` (
  `ID` int(11) DEFAULT NULL,
  `FCID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `followuser`
--

CREATE TABLE `followuser` (
  `ID` int(11) DEFAULT NULL,
  `FID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `gag`
--

CREATE TABLE `gag` (
  `UID` int(11) DEFAULT NULL,
  `AID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `STime` time DEFAULT NULL,
  `ETime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `orderlist`
--

CREATE TABLE `orderlist` (
  `OID` int(11) DEFAULT NULL,
  `CID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE `orders` (
  `ID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `PTime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `rbook`
--

CREATE TABLE `rbook` (
  `CID` int(11) DEFAULT NULL,
  `BID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `rcourse`
--

CREATE TABLE `rcourse` (
  `RID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `Reason` varchar(1) DEFAULT NULL,
  `TOF` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `relog`
--

CREATE TABLE `relog` (
  `who` int(11) DEFAULT NULL,
  `when` time DEFAULT NULL,
  `thing` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `rteacher`
--

CREATE TABLE `rteacher` (
  `RID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `Reason` varchar(1) DEFAULT NULL,
  `TOF` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `ruser`
--

CREATE TABLE `ruser` (
  `RID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `Reason` varchar(1) DEFAULT NULL,
  `TOF` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `studying`
--

CREATE TABLE `studying` (
  `ID` int(11) DEFAULT NULL,
  `SID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `ID` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `IDName` varchar(1) DEFAULT NULL,
  `Name` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `title`
--

CREATE TABLE `title` (
  `UID` int(11) DEFAULT NULL,
  `AID` int(11) DEFAULT NULL,
  `Time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `ID` int(11) DEFAULT NULL,
  `UserName` varchar(1) DEFAULT NULL,
  `PassWord` varchar(1) DEFAULT NULL,
  `PetName` varchar(1) DEFAULT NULL,
  `Img` varchar(1) DEFAULT NULL,
  `TName` varchar(1) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `userlogin`
--

CREATE TABLE `userlogin` (
  `UserName` char(10) DEFAULT NULL,
  `PassWord` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `vertex`
--

CREATE TABLE `vertex` (
  `id` int(11) NOT NULL,
  `sign` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `vertex`
--

INSERT INTO `vertex` (`id`, `sign`, `name`) VALUES
(1, 0, 'test1'),
(2, 3, 'test'),
(3, 3, 'test'),
(4, 3, 'test'),
(5, 3, 'test'),
(6, 3, 'name'),
(7, 3, 'name'),
(8, 3, 'name1'),
(9, 3, 'name1'),
(10, 3, 'name1'),
(11, 3, 'name1'),
(12, 3, 'name1'),
(13, 3, 'name1'),
(14, 3, 'name1'),
(15, 3, 'name1'),
(16, 3, 'name1'),
(17, 3, 'name1');

-- --------------------------------------------------------

--
-- 表的结构 `video`
--

CREATE TABLE `video` (
  `ID` int(11) DEFAULT NULL,
  `Name` varchar(1) DEFAULT NULL,
  `CID` int(11) DEFAULT NULL,
  `TID` int(11) DEFAULT NULL,
  `URL` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `example`
--
ALTER TABLE `example`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vertex`
--
ALTER TABLE `vertex`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
