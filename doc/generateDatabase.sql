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
-- Table `FinancialApp`.`Accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`Accounts` (
  `idAccount` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `iconLetters` VARCHAR(45) NOT NULL,
  `note` TINYTEXT NOT NULL,
  `value` FLOAT NOT NULL,
  `situation` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idAccount`),
  UNIQUE INDEX `idaccount_UNIQUE` (`idAccount` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FinancialApp`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`Categories` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `categoryColor` VARCHAR(45) NOT NULL,
  `note` TINYTEXT NOT NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE INDEX `idcategory_UNIQUE` (`idCategory` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FinancialApp`.`Transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FinancialApp`.`Transactions` (
  `idTransation` INT NOT NULL AUTO_INCREMENT,
  `value` FLOAT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `note` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `remider` VARCHAR(45) NOT NULL,
  `consolidate` TINYINT(1) NOT NULL,
  `categories_idCategory` INT NOT NULL,
  `accounts_idAccount` INT NOT NULL,
  PRIMARY KEY (`idTransation`),
  UNIQUE INDEX `idtransation_UNIQUE` (`idTransation` ASC),
  INDEX `fk_Transactions_Categories1_idx` (`categories_idCategory` ASC),
  INDEX `fk_Transactions_Accounts1_idx` (`accounts_idAccount` ASC),
  CONSTRAINT `fk_Transactions_Categories1`
    FOREIGN KEY (`categories_idCategory`)
    REFERENCES `FinancialApp`.`Categories` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transactions_Accounts1`
    FOREIGN KEY (`accounts_idAccount`)
    REFERENCES `FinancialApp`.`Accounts` (`idAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
