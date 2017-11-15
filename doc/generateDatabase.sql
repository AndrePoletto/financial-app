-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema FinancialApp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FinancialApp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FinancialApp` DEFAULT CHARACTER SET utf8 ;
USE `FinancialApp` ;

-- -----------------------------------------------------
-- Table `FinancialApp`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`account` (
  `idaccount` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `iconLetters` VARCHAR(45) NOT NULL,
  `note` TINYTEXT NOT NULL,
  `value` FLOAT NOT NULL,
  `situation` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idaccount`),
  UNIQUE INDEX `idaccount_UNIQUE` (`idaccount` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FinancialApp`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `categoryColor` VARCHAR(45) NOT NULL,
  `note` TINYTEXT NOT NULL,
  PRIMARY KEY (`idcategory`),
  UNIQUE INDEX `idcategory_UNIQUE` (`idcategory` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FinancialApp`.`transation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`transation` (
  `idtransation` INT NOT NULL AUTO_INCREMENT,
  `value` FLOAT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `note` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `remider` VARCHAR(45) NOT NULL,
  `consolidade` VARCHAR(45) NOT NULL,
  `account_idaccount` INT NOT NULL,
  `category_idcategory` INT NOT NULL,
  PRIMARY KEY (`idtransation`),
  UNIQUE INDEX `idtransation_UNIQUE` (`idtransation` ASC),
  INDEX `fk_transation_account_idx` (`account_idaccount` ASC),
  INDEX `fk_transation_category1_idx` (`category_idcategory` ASC),
  CONSTRAINT `fk_transation_account`
    FOREIGN KEY (`account_idaccount`)
    REFERENCES `FinancialApp`.`account` (`idaccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transation_category1`
    FOREIGN KEY (`category_idcategory`)
    REFERENCES `FinancialApp`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
