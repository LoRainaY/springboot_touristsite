REATE TABLE `persistent_logins`(
   `username` varchar(64) not null, 
   `series` varchar(64) not null, 
   `token` varchar(64) not null, 
   `last_used` timestamp default CURRENT_TIMESTAMP not null on 
update CURRENT_TIMESTAMP, 
   primary key (`series`) 
); 
 
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT, 
  `firstname` varchar(255) NOT NULL, 
  `lastname` varchar(255) NOT NULL, 
  `patronymic` varchar(255) NOT NULL, 
  `email` varchar(255) NOT NULL, 
  `phone` varchar(255) NOT NULL, 
  `password` varchar(255)NOT NULL, 
  `active` int DEFAULT NULL, 
  `get_bonus` bit(1) NOT NULL, 
  PRIMARY KEY (`id`) 
); 
 
CREATE TABLE `role` ( 
  `role_id` int NOT NULL AUTO_INCREMENT, 
  `role` varchar(255) DEFAULT NULL, 
  PRIMARY KEY (`role_id`) 
); 
 
CREATE TABLE `user_role` ( 
  `user_id` int NOT NULL, 
  `role_id` int NOT NULL, 
  PRIMARY KEY (`user_id`,`role_id`), 
  KEY `user_role_key` (`role_id`), 
  CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) 
REFERENCES `role` (`role_id`), 
  CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) 
REFERENCES `user` (`id`) 
); 
 
CREATE TABLE `tour` ( 
  `code` int NOT NULL AUTO_INCREMENT, 
  `image` varchar(45) DEFAULT NULL, 
  `title` varchar(100) NOT NULL, 
  `description` varchar(16000)DEFAULT NULL, 
  `start_time` varchar(20) NOT NULL, 
  `end_time` varchar(20) NOT NULL, 
  `price` double NOT NULL, 
  `first_day` mediumtext, 
  `second_day` mediumtext,
   `third_day` mediumtext, 
  `fourth_day` mediumtext, 
  `fifth_day` mediumtext, 
  `included_in_price` mediumtext, 
  `additionally` mediumtext, 
  PRIMARY KEY (`code`) 
); 
 
CREATE TABLE `cart_items` ( 
  `id` int NOT NULL AUTO_INCREMENT, 
  `tour_id` int DEFAULT NULL, 
  `user_id` int DEFAULT NULL, 
  `order_date` datetime DEFAULT NULL, 
  `quantity` int DEFAULT NULL, 
  PRIMARY KEY (`id`), 
  KEY `fk_cart_tour_idx` (`tour_id`), 
  KEY `fk_cart_user_idx` (`user_id`), 
  CONSTRAINT `fk_cart_tour` FOREIGN KEY (`tour_id`) 
REFERENCES `tour` (`code`), 
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`user_id`) 
REFERENCES `user` (`id`) 
); 
  
CREATE TABLE `order` ( 
  `id` bigint NOT NULL AUTO_INCREMENT, 
  `count` int DEFAULT NULL, 
  `date` datetime(6) DEFAULT NULL, 
  `discount_price` int DEFAULT NULL, 
  `status` int DEFAULT '0', 
  `tour_code` int NOT NULL, 
  `user_id` int NOT NULL, 
  PRIMARY KEY (`id`), 
  KEY `FK7c5c34qiflibr53ocpi8w0il4` (`tour_code`), 
  KEY `FK2mtx522xemlxd0ij9gj4rbfud` (`user_id`), 
  CONSTRAINT `FK2mtx522xemlxd0ij9gj4rbfud` FOREIGN KEY 
(`user_id`) REFERENCES `user` (`id`), 
  CONSTRAINT `FK7c5c34qiflibr53ocpi8w0il4` FOREIGN KEY 
(`tour_code`) REFERENCES `tour` (`code`) 
);