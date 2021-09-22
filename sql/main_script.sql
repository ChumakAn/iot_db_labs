-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema chumak_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `chumak_db` ;

-- -----------------------------------------------------
-- Schema chumak_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chumak_db` DEFAULT CHARACTER SET utf8 ;
USE `chumak_db` ;

-- -----------------------------------------------------
-- Table `chumak_db`.`transport_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`transport_type` (
  `transport_type_id` INT NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`transport_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`guide`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`guide` (
  `guide_id` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `telephone_number` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`guide_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`route` (
  `route_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `guide_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`route_id`),
  INDEX `fk_route_guide1_idx` (`guide_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_guide1`
    FOREIGN KEY (`guide_id`)
    REFERENCES `chumak_db`.`guide` (`guide_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`tour` (
  `tour_id` INT NOT NULL AUTO_INCREMENT,
  `transport_type_id` INT NOT NULL,
  `description` VARCHAR(80) NOT NULL,
  `duration` VARCHAR(45) NOT NULL,
  `price_per_person` DECIMAL(10,2) NOT NULL,
  `date_of_departure` DATE NOT NULL,
  `next_departure_date` DATE NULL,
  `route_id` INT NOT NULL,
  PRIMARY KEY (`tour_id`),
  INDEX `fk_tour_transport_type_idx` (`transport_type_id` ASC) INVISIBLE,
  INDEX `fk_tour_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_tour_transport_type`
    FOREIGN KEY (`transport_type_id`)
    REFERENCES `chumak_db`.`transport_type` (`transport_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tour_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `chumak_db`.`route` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`hotel` (
  `hotel_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `rate` INT NULL,
  PRIMARY KEY (`hotel_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`tour_has_hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`tour_has_hotel` (
  `tour_id` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  PRIMARY KEY (`tour_id`, `hotel_id`),
  INDEX `fk_tour_has_hotel_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  INDEX `fk_tour_has_hotel_tour1_idx` (`tour_id` ASC) VISIBLE,
  CONSTRAINT `fk_tour_has_hotel_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `chumak_db`.`tour` (`tour_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tour_has_hotel_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `chumak_db`.`hotel` (`hotel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`country` (
  `country_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`city` (
  `city_id` INT NOT NULL,
  `hotel_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `fk_city_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  INDEX `fk_city_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `chumak_db`.`hotel` (`hotel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `chumak_db`.`country` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`place` (
  `place_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`place_id`),
  INDEX `fk_place_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_place_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `chumak_db`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chumak_db`.`route_has_place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chumak_db`.`route_has_place` (
  `route_id` INT NOT NULL,
  `place_id` INT NOT NULL,
  PRIMARY KEY (`route_id`, `place_id`),
  INDEX `fk_route_has_place_place1_idx` (`place_id` ASC) VISIBLE,
  INDEX `fk_route_has_place_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_has_place_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `chumak_db`.`route` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_has_place_place1`
    FOREIGN KEY (`place_id`)
    REFERENCES `chumak_db`.`place` (`place_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
