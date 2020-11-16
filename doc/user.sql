/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.22 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` bigint (20),
	`name` varchar (90),
	`age` int (11),
	`email` varchar (150),
	`manager_id` bigint (20),
	`budui` JSON ,
	`create_time` datetime 
); 
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('1','临江仙','35','hzqiuxm@163.com',NULL,'{\"type\": \"步兵\", \"count\": 30, \"level\": \"高阶\"}','2020-03-25 15:41:34');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('2','鹊桥仙','30','qqx@163.com',NULL,'{\"type\": \"骑兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-25 15:46:48');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('3','花荣','38','huarong@baomidou.com','1','{\"type\": \"弓兵\", \"count\": 20, \"level\": \"高阶\"}','2019-01-11 14:20:20');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('4','张横','25','wtf@baomidou.com','1','{\"type\": \"水兵\", \"count\": 20, \"level\": \"中阶\"}','2019-02-05 11:12:22');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('5','张顺','28','lyw@baomidou.com','1','{\"type\": \"水兵\", \"count\": 20, \"level\": \"高阶\"}','2019-02-14 08:31:16');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('6','李逵','31','zjq@baomidou.com','1','{\"type\": \"步兵\", \"count\": 20, \"level\": \"高阶\"}','2019-01-14 09:15:15');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('7','蔡进','32','lhm@baomidou.com','1','{\"type\": \"步兵\", \"count\": 20, \"level\": \"初阶\"}','2019-01-14 09:48:16');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('8','水龙吟','39','slq@163.com','1','{\"type\": \"水兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-25 15:55:09');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('9','王二麻子','20','wangxiaoer@163.com','2','{\"type\": \"弓兵\", \"count\": 20, \"level\": \"初阶\"}','2019-02-14 08:31:16');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('10','王云','20','wangyun@163.com','2','{\"type\": \"枪兵\", \"count\": 20, \"level\": \"高阶\"}','2019-01-11 14:20:20');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('11','王阳明','55','wangym@163.com','2','{\"type\": \"枪兵\", \"count\": 20, \"level\": \"高阶\"}','2019-02-14 09:48:16');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('12','阮小二','32','ruanxiaoer@163.com','2','{\"type\": \"水兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-27 14:46:51');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('13','阮小七','29','xiaoqi@163.com','2','{\"type\": \"水兵\", \"count\": 20, \"level\": \"中阶\"}','2020-03-27 14:58:07');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('14','扈三娘','26','husanniang@163.com','2','{\"type\": \"骑兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-27 14:58:32');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('15','孙二娘','32','sunerniang@163.com','2','{\"type\": \"步兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-27 14:58:51');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('16','蔡琴','18','caiqing@163.com','1','{\"type\": \"骑兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-29 22:13:21');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('17','宋江','16','songjiang@163.com','1','{\"type\": \"步兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-29 22:38:50');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('18','卢俊义','47','lujunyi@163.com','1','{\"type\": \"骑兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-29 22:59:58');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('19','鲁智深','36','luzihshen@163.com','1','{\"type\": \"步兵\", \"count\": 20, \"level\": \"高阶\"}','2020-03-30 11:13:53');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('20','临江仙','23','linjiangxian@163.com','2','{\"type\": \"骑兵\", \"count\": 20, \"level\": \"高阶\"}','2020-11-16 14:43:18');
insert into `user` (`id`, `name`, `age`, `email`, `manager_id`, `budui`, `create_time`) values('21','阮小五','30','ruanxiaowu@163.com','2',NULL,'2020-11-16 14:43:24');
