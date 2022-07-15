DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(255) ,
	`colour` VARCHAR(255),
	`body_covering` VARCHAR(255),
	PRIMARY KEY(`id`)
);