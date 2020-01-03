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