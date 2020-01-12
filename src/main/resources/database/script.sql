CREATE DATABASE the_dragon;

DROP TABLE IF EXISTS `the_dragon`.`home`;
CREATE TABLE `the_dragon`.`home` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `number_of_rooms` int(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` int(10) NOT NULL,
  `images` varchar(1000) NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`home` (name, number_of_rooms, address, city, images, status)
VALUES ('Vung Tau City', 5, 'Vung Tau City', 5, '/static/img/home/1/home1.jpg', 'active');
INSERT INTO `the_dragon`.`home` (name, number_of_rooms, address, city, images, status)
VALUES ('Vinhomes Central Park - Ho Chi Minh City', 17, 'Binh Thanh district', 1, '/static/img/home/2/home2.jpg', 'active');
INSERT INTO `the_dragon`.`home` (name, number_of_rooms, address, city, images, status)
VALUES ('Ho Chi Minh City Center', 28, 'Ho Chi Minh City', 1, '/static/img/home/3/home3.jpg', 'active');
INSERT INTO `the_dragon`.`home` (name, number_of_rooms, address, city, images, status)
VALUES ('TDH Tre Tresor', 3, 'Ho Chi Minh City', 1, '/static/img/home/4/home4.jpg', 'active');
INSERT INTO `the_dragon`.`home` (name, number_of_rooms, address, city, images, status)
VALUES ('Vinhomes Golden River - Ho Chi Minh City', 2, 'District 1, Ho Chi Minh City', 1, '/static/img/home/5/home5.jpg', 'active');



DROP TABLE IF EXISTS `the_dragon`.`room`;
CREATE TABLE `the_dragon`.`room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `home_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `number_of_guest` int(10) NOT NULL,
  `room_type` varchar(50) NOT NULL,
  `rental_type` varchar(50) NOT NULL,
  `bedroom` int(10) NOT NULL,
  `bed` int(10) NOT NULL,
  `bath` int(10) NOT NULL,
  `address` text,
  `status` varchar(50),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `the_dragon`.`user`;
CREATE TABLE `the_dragon`.`user` (
  `id`          int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` 	varchar(100) NOT NULL,
  `password`   	text NOT NULL,
  `first_name` 	varchar(50) NULL,
  `last_name`  	varchar(50) NULL,
  `address` 	text NULL,
  `email` 		varchar(100) NOT NULL,
  `role_id`     int(10),
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;