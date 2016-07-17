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
DROP TABLE IF EXISTS `buticpatydb`.`productos` CASCADE;

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
DROP TABLE IF EXISTS `buticpatydb`.`usuarios` CASCADE;

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


DROP TABLE IF EXISTS locales CASCADE;

create TABLE if not exists locales(
    id int(11) not null auto_increment,
    nombre varchar(255) not null,
    telefono int,
    direccion varchar(255),
    numero_local int default 0,
    primary key(id)
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;



-- tabla boleta

DROP TABLE IF EXISTS boletas cascade;
create TABLE boletas(
    id int not null auto_increment,
    fecha datetime not null default now(),
    monto double default 0 not null,
    local_id int,
    usuario_id int,
    FOREIGN KEY (local_id) 
        REFERENCES locales(id)
        ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) 
        REFERENCES usuarios(id)
        ON DELETE CASCADE,
    primary key(id)
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

-- create table carros_ventas

drop table if exists carros_ventas CASCADE;
CREATE TABLE IF NOT EXISTS `buticpatydb`.`carros_ventas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `producto_id` INT(11) NOT NULL ,
   `boleta_id` INT(11) NOT NULL , 
    FOREIGN KEY (producto_id) 
        REFERENCES productos(id)
        ON DELETE CASCADE,
        FOREIGN KEY (boleta_id) 
        REFERENCES boletas(id)
        ON DELETE CASCADE,
    cantidad int default 0 not null,
    valor int default 0 not null,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

drop table if exists pagos;
create table pagos(
    id int(11) not null auto_increment,
    fecha datetime default now() not null,
    cliente_id int,
    monto int default 0 not null,
    FOREIGN KEY (cliente_id) 
        REFERENCES clientes(id)
        ON DELETE CASCADE,
        primary key(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


drop table if exists carros_fiados;
create table carros_fiados(
    id int(11) not null auto_increment,
    boleta_id int ,
    cliente_id int,
    monto int default 0,
    FOREIGN KEY (boleta_id) 
        REFERENCES boletas(id)
        ON DELETE CASCADE,
    FOREIGN KEY (cliente_id) 
        REFERENCES clientes(id)
        ON DELETE CASCADE,
        primary key(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


drop table if exists deudas;
create table deudas(
    id int(11) not null auto_increment,
    monto int default 0 not null,
    pago_id int,
    carro_fiado_id int,
    FOREIGN KEY (pago_id) 
        REFERENCES pagos(id)
        ON DELETE CASCADE,
    FOREIGN KEY (carro_fiado_id) 
        REFERENCES carros_fiados(id)
        ON DELETE CASCADE,
        primary key(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;