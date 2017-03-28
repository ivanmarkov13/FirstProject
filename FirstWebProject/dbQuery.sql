-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema firstprojectdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema firstprojectdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `firstprojectdb` DEFAULT CHARACTER SET utf8 ;
USE `firstprojectdb` ;

-- -----------------------------------------------------
-- Table `firstprojectdb`.`carts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`carts` (
  `cart_id` INT(11) NOT NULL AUTO_INCREMENT,
  `price` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE INDEX `cart_id_UNIQUE` (`cart_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`users` (
  `user_id` INT(11) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phonenumber` VARCHAR(10) NULL DEFAULT NULL,
  `money` DOUBLE NULL DEFAULT NULL,
  `rating` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `phonenumber_UNIQUE` (`phonenumber` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`services` (
  `service_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE INDEX `service_id_UNIQUE` (`service_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`products` (
  `product_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `quantity` INT(11) NOT NULL,
  `owner_id` INT(11) NULL DEFAULT NULL,
  `soldpieces` INT(11) NULL DEFAULT NULL,
  `category` ENUM('BEAUTY', 'SPA', 'RELAX', 'FOOD', 'ADVENTURE', 'SECOND_HAND', 'BRAND_NEW') NOT NULL,
  `service_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `owner_id_idx` (`owner_id` ASC),
  INDEX `service_id_idx` (`service_id` ASC),
  CONSTRAINT `owner_id`
    FOREIGN KEY (`owner_id`)
    REFERENCES `firstprojectdb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `service_id`
    FOREIGN KEY (`service_id`)
    REFERENCES `firstprojectdb`.`services` (`service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`cartsproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`cartsproducts` (
  `cart_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`cart_id`, `product_id`),
  INDEX `product_id_idx` (`product_id` ASC),
  CONSTRAINT `cart_id`
    FOREIGN KEY (`cart_id`)
    REFERENCES `firstprojectdb`.`carts` (`cart_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `firstprojectdb`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`orders` (
  `order_id` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `user_order_id` INT(11) NOT NULL,
  `price` DECIMAL(10,0) NOT NULL,
  `isfinished` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC),
  INDEX `user_id_idx` (`user_order_id` ASC),
  CONSTRAINT `user_order_id`
    FOREIGN KEY (`user_order_id`)
    REFERENCES `firstprojectdb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`ordersproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`ordersproducts` (
  `order_id` INT(11) NOT NULL,
  `ordered_product_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`order_id`, `ordered_product_id`),
  INDEX `product_id_idx` (`ordered_product_id` ASC),
  CONSTRAINT `order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `firstprojectdb`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ordered_product_id`
    FOREIGN KEY (`ordered_product_id`)
    REFERENCES `firstprojectdb`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `firstprojectdb`.`usersproductsfavourites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `firstprojectdb`.`usersproductsfavourites` (
  `user_id` INT(11) NOT NULL,
  `fav_product_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `fav_product_id`),
  INDEX `product_id_idx` (`fav_product_id` ASC),
  CONSTRAINT `fav_product_id`
    FOREIGN KEY (`fav_product_id`)
    REFERENCES `firstprojectdb`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `firstprojectdb`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
