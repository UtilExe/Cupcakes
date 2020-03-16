CREATE SCHEMA `cupcake`;
USE `cupcake`;

CREATE TABLE `cupcake`.`users` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `mobil_nr` INT(8) NULL,
  `saldo` INT NOT NULL DEFAULT 500,
  PRIMARY KEY (`email`));

CREATE TABLE `cupcake`.`orders` (
  `orderID` INT NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `fk_email_orders_idx` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_email_orders`
    FOREIGN KEY (`email`)
    REFERENCES `cupcake`.`users` (`email`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT);

CREATE TABLE `cupcake`.`topping` (
  `idTopping` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`idTopping`));

CREATE TABLE `cupcake`.`bottom` (
  `idBottom` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`idbottom`));
  
CREATE TABLE `cupcake`.`orderlines` (
  `detailsID` INT NOT NULL,
  `orderID` INT NOT NULL,
  `quantity` INT NULL,
  `sum` INT NULL,
  `toppingID` INT NOT NULL,
  `bottomID` INT NOT NULL,
  PRIMARY KEY (`detailsID`),
  INDEX `fk_orderlines_orderID_idx` (`orderID` ASC) VISIBLE,
  INDEX `fk_orderlines_toppingID_idx` (`toppingID` ASC) VISIBLE,
  INDEX `fk_orderlines_bottomID_idx` (`bottomID` ASC) VISIBLE,
  CONSTRAINT `fk_orderlines_orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `cupcake`.`orders` (`orderID`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_orderlines_toppingID`
    FOREIGN KEY (`toppingID`)
    REFERENCES `cupcake`.`topping` (`idTopping`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderlines_bottomID`
    FOREIGN KEY (`bottomID`)
    REFERENCES `cupcake`.`bottom` (`idbottom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `cupcake`.`support` (
  `idsupport` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsupport`));
  
  -- DATA INSERTION
-- Bottoms
INSERT INTO bottom VALUES (0, "Chocolate", 5);
INSERT INTO bottom VALUES (0, "Vanilla", 5);
INSERT INTO bottom VALUES (0, "Nutmeg", 5);
INSERT INTO bottom VALUES (0, "Pistacio", 6);
INSERT INTO bottom VALUES (0, "Almond", 7);

-- Toppings
INSERT INTO topping VALUES(0, "Chocolate", 5);
INSERT INTO topping VALUES(0, "Blueberry", 5);
INSERT INTO topping VALUES(0, "Raspberry", 5);
INSERT INTO topping VALUES(0, "Crispy", 6);
INSERT INTO topping VALUES(0, "Strawberry", 6);
INSERT INTO topping VALUES(0, "Rum/Raisin", 7);
INSERT INTO topping VALUES(0, "Orange", 8);
INSERT INTO topping VALUES(0, "Lemon", 8);
INSERT INTO topping VALUES(0, "Blue cheese", 9);
