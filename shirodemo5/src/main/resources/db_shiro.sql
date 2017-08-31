
CREATE DATABASE `db_shiro` ;

USE `db_shiro`;

DROP TABLE IF EXISTS `member_roles`;

CREATE TABLE `member_roles` (
  `membername` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `member_roles`(`membername`,`role_name`,`role_desc`) values ('fuwh','admin','管理员'),('zhangsan','buzhang','部长'),('lisi','yuangong','员工'),('zhangsan','yuangong','员工');

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert  into `members`(`id`,`userName`,`pass`) values (1,'fuwh','123456'),(2,'zhangsan','123'),(3,'lisi','12');

DROP TABLE IF EXISTS `roles_permissions`;

CREATE TABLE `roles_permissions` (
  `role_name` varchar(20) NOT NULL,
  `permission` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `roles_permissions`(`role_name`,`permission`) values ('admin','*'),('buzhang','bumen:*'),('yuangong','bumen:diwubu:query');

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `username` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `user_roles`(`username`,`role_name`,`role_desc`) values ('fuwh','admin','管理员'),('zhangsan','buzhang','部长'),('lisi','yuangong','员工'),('zhangsan','yuangong','员工');


DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



insert  into `users`(`id`,`username`,`password`) values (1,'fuwh','123456'),(2,'zhangsan','123'),(3,'lisi','12');

