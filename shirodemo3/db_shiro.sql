/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.18 : Database - db_shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_shiro`;

/*Table structure for table `member_roles` */

DROP TABLE IF EXISTS `member_roles`;

CREATE TABLE `member_roles` (
  `membername` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_roles` */

insert  into `member_roles`(`membername`,`role_name`,`role_desc`) values ('fuwh','admin','管理员'),('zhangsan','buzhang','部长'),('lisi','yuangong','员工'),('zhangsan','yuangong','员工');

/*Table structure for table `members` */

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `members` */

insert  into `members`(`id`,`userName`,`pass`) values (1,'fuwh','123456'),(2,'zhangsan','123'),(3,'lisi','12');

/*Table structure for table `members2` */

DROP TABLE IF EXISTS `members2`;

CREATE TABLE `members2` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `members2` */

insert  into `members2`(`id`,`username`,`password`,`name`) values (1,'fuwh','123','老傅');

/*Table structure for table `roles_permissions` */

DROP TABLE IF EXISTS `roles_permissions`;

CREATE TABLE `roles_permissions` (
  `role_name` varchar(20) NOT NULL,
  `permission` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles_permissions` */

insert  into `roles_permissions`(`role_name`,`permission`) values ('admin','*'),('buzhang','bumen:*'),('yuangong','bumen:diwubu:query');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `username` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

insert  into `user_roles`(`username`,`role_name`,`role_desc`) values ('fuwh','admin','管理员'),('zhangsan','buzhang','部长'),('lisi','yuangong','员工'),('zhangsan','yuangong','员工');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`) values (1,'fuwh','123456'),(2,'zhangsan','123'),(3,'lisi','12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
