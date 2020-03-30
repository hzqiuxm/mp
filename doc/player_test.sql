/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.22 : Database - mp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mp`;

/*Table structure for table `player` */

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `name` varchar(30) DEFAULT NULL COMMENT '名字',
  `age` int(8) DEFAULT NULL COMMENT '年龄',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `manager_id` int(8) DEFAULT NULL COMMENT '上级领导编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(8) DEFAULT '1' COMMENT '版本号',
  `deleted` int(1) DEFAULT '0' COMMENT '0:未删除，1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `player` */

insert  into `player`(`id`,`name`,`age`,`email`,`manager_id`,`create_time`,`update_time`,`version`,`deleted`) values 
(1,'临江仙',35,'linjiangxian@163.com',0,'2020-03-30 13:44:01','2020-03-30 13:44:01',1,0),
(2,'鹊桥仙',30,'queqiaoxian@163.com',0,'2020-03-30 13:46:00','2020-03-30 13:46:00',1,0),
(3,'李逵',40,'likui@163.com',1,'2020-03-30 13:46:47','2020-03-30 13:46:47',1,1),
(4,'宋江',60,'songjiamng@163.com',1,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(5,'卢俊义',50,'lujingyi@163.com',1,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(6,'花荣',42,'huaorng@163.com',1,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(7,'燕青',30,'yanqing@163.com',1,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(8,'扈三娘',30,'hushanniang@163.com',2,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(9,'孙二娘',40,'sunerniang@163.com',2,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(10,'杜十娘',35,'dushiniang@163.com',2,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(11,'孙尚香',20,'sunshangxiang@163.com',2,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0),
(12,'马云禄',24,'mayunlu@163.com',2,'2020-03-30 13:56:46','2020-03-30 13:56:46',1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
