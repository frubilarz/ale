USE `buticpatydb` ;


-- -----------------------------------------------------
-- Table `buticpatydb`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticpatydb`.`clientes` ;

CREATE TABLE IF NOT EXISTS `buticpatydb`.`clientes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `rut` INT(11) NOT NULL,
  `telefono` INT(11) NULL DEFAULT NULL,
  `correo` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `direccion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rut_UNIQUE` (`rut` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;



-- -----------------------------------------------------
-- Table `buticpatydb`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticpatydb`.`productos` ;

CREATE TABLE IF NOT EXISTS `buticpatydb`.`productos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `codigo` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,    
  `descripcion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `stock` INT(11) NOT NULL DEFAULT '0',
  `valor` FLOAT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX  `codigo_UNIQUE` (`codigo` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;




-- -----------------------------------------------------
-- Table `buticpatydb`.`usuarioa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticpatydb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `buticpatydb`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `clave` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,    
  `rol` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `rut` INT(11) NOT NULL ,

  PRIMARY KEY (`id`),
  UNIQUE INDEX  `rut_UNIQUE` (`rut` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;