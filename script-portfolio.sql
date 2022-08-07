-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio-database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio-database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio-database` DEFAULT CHARACTER SET utf8 ;
USE `portfolio-database` ;

-- -----------------------------------------------------
-- Table `portfolio-database`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`user` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `birthday` VARCHAR(45) NULL,
  `nationality` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `about` VARCHAR(1000) NULL,
  `title` VARCHAR(45) NULL,
  `avatar` VARCHAR(45) NULL,
  `banner` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

INSERT INTO `portfolio-database`.`user` (`id`, `firstname`, `lastname`, `birthday`, `nationality`, `email`, `password`, `about`, `title`, `avatar`, `banner`, `location`)VALUES ('1', 'Andrea', 'Maccan', '1985-07-28', 'Argentina', 'acmaccan@gmail.com', 'pass123!', 'Comencé a desarrollar en 2008 por curiosidad con HTML, CSS y JS. Hoy trabajo en EdTech, para Vi-Da Tec como Fullstack Developer, desarrollando el producto Ticmas. Me apasiona aprender, conocer cómo funcionan las nuevas tecnologías y el trabajo en equipo.', 'Desarrolladora FullStack Jr.', '../assets/images/avatar.jpg', '../assets/images/banner.jpg', 'Villa Adelina, Buenos Aires');

-- -----------------------------------------------------
-- Table `portfolio-database`.`type_experience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`type_experience` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

INSERT INTO `portfolio-database`.`type_experience` (`id`, `name`) VALUES ('1', 'Full-Time');
INSERT INTO `portfolio-database`.`type_experience` (`id`, `name`) VALUES ('2', 'Part-Time');
INSERT INTO `portfolio-database`.`type_experience` (`id`, `name`) VALUES ('3', 'Freelance');

-- -----------------------------------------------------
-- Table `portfolio-database`.`experience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`experience` (
  `id` INT NOT NULL,
  `thumb` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `details` VARCHAR(1000) NULL,
  `from_date` VARCHAR(45) NULL,
  `to_date` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `type_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_experience_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_experience_type_experience1_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `fk_experience_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `portfolio-database`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_experience_type_experience1`
    FOREIGN KEY (`type_id`)
    REFERENCES `portfolio-database`.`type_experience` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `portfolio-database`.`experience` (`id`, `thumb`, `company`, `title`, `details`, `from_date`, `to_date`, `user_id`, `type_id`) VALUES ('1', '../assets/images/experience/ticmas.png', 'Ticmas', 'Fullstack Developer', 'Plataforma educativa bajo metodología SCRUM, GitFlow y CI/CD. Arquitectura de Microservicios. Tecnologías: Angular, NgRx, RxJs, NestJS,GraphQL, MongoDB, PostgreSQL, Algolia Search, React, Next, Material UI, Chakra.', '2022', 'Actualidad', '1', '1');
INSERT INTO `portfolio-database`.`experience` (`id`, `thumb`, `company`, `title`, `details`, `from_date`, `to_date`, `user_id`, `type_id`) VALUES ('2', '../assets/images/experience/pv.png', 'Puntovero.co', 'Ecommerce Manager', 'Venta de arte online. Migración de plataforma a Opencart 3, gestión y soporte. Curaduría de contenidos web y social. Tareas administrativas, ventas y gestión de artistas.', '2016', '2021', '1', '2');
INSERT INTO `portfolio-database`.`experience` (`id`, `thumb`, `company`, `title`, `details`, `from_date`, `to_date`, `user_id`, `type_id`) VALUES ('3', '../assets/images/experience/am.png', 'Freelance', 'Freelance', 'Desarrollo Frontend & Hosting. Diseño y desarrollo web. Librerías. Crossbrowser y optimización. PHP + MySQL basics. Setup y gestión de hosting compartidos y dedicados sobre servidor Apache. CPanel y WHM. DNS. Dominios.', '2010', '2015', '1', '3');

-- -----------------------------------------------------
-- Table `portfolio-database`.`education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`education` (
  `id` INT NOT NULL,
  `thumb` VARCHAR(45) NULL,
  `institution` VARCHAR(45) NULL,
  `title` VARCHAR(250) NULL,
  `details` VARCHAR(1000) NULL,
  `from_date` VARCHAR(45) NULL,
  `to_date` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_education_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_education_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `portfolio-database`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('1', '../assets/images/education/arg.png', 'Argentina Programa', 'Etapa 1 #SeProgramar / Etapa 2 #YoProgramo.', 'Fundamentos, programación imperativa y orientada a objetos. Arquitectura web, gestión de tiempo, SCRUM, GitFlow, HTML, CSS, JS, Bootstrap, TypeScript, SPA, MVC, Angular, Bases de Datos Relacionales, UML, POO, patrones de diseño, Java, Spring Boot, Dev Ops, comunicación efectiva.', '2021.10', '2022.08', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('2', '../assets/images/education/uda.png', 'Udacity', 'Object Oriented JavaScript.', 'Objetos en profundidad, funciones en tiempo de ejecución, clases y objetos, patrones de diseño orientado a objetos.', '2021.12', '2022.01', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('3', '../assets/images/education/alk.png', 'Alkemy', 'Aceleración en NodeJS.', 'Certificación job ready. Desarrollo en equipo de API para ONG en Node, Express, MySQL, Sequelize, JWT, Sendgrid, S3, Swagger, Mocha & Chai. Metodologías ágiles, Git, buenas prácticas.', '2021.10', '2022.02', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('4', '../assets/images/education/mdu.png', 'MongoDB University', 'M001 MongoDB Basics / M103 Basic Cluster Administration / M220JS MongoDB for JS Developers.', 'Client configuration, basic reads. Basic aggregation, updates, deletes and joins. Read concerns and bulks. Resiliency. Environment setup. Mongod. Replication. Sharding. Atlas, Compass & Shell. BSON, JSON, importing and exporting data, and basic document queries. Insert, update, and delete operations. Query operators. Aggregation, indexes, data modeling.', '2021.08', '2021.09', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('5', '../assets/images/education/acc.png', 'Accenture', 'Habilidades blandas.', 'Taller orientado a mejorar la autoconfianza, flexibilidad, trabajo en equipo y comunicación.', '2021.06', '2021.06', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `from_date`, `to_date`, `user_id`) VALUES ('6', '../assets/images/education/ctc.png', 'Cluster Tecnológico de Catamarca', 'Bootcamp NodeJS.', '2021.05', '2021.07', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('7', '../assets/images/education/cac.png', 'Codo a Codo 4.0', 'Web Fullstack JS + NodeJS.', 'HTML, CSS, Bootstrap, JS, GIT, Scrum, Arquitectura, Bases de Datos, Node, NPM, Express.', '2021.04', '2021.08', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('8', '../assets/images/education/ibm.png', 'IBM', 'Enterprise Design Thinking Practitioner.', 'Bases del Design Thinking: colaboración, síntesis, design research, prototipado y storytelling.', '2021.03', '2021.03', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('9', '../assets/images/education/fal.png', 'Fundación Argentina de Logoterapia', 'Orientadora en Desarrollo Humano.', 'Estrategias y recursos para el desarrollo humano, orientado a valores y propósito, en el ámbito educativo y organizacional, fundados en la Antropología Existencial Frankleana.', '2020.08', '2020.12', '1');
INSERT INTO `portfolio-database`.`education` (`id`, `thumb`, `institution`, `title`, `details`, `from_date`, `to_date`, `user_id`) VALUES ('10', '../assets/images/education/utn.png', 'UTN Extensión Universitaria', 'Professional Webmaster / Desarrollo web con JavaScript / Desarrollo Avanzado con JS, JQuery y JSON / Fundamentos de la Programación.', 'Protocolos, browsers, DNS, dominios, ISPs, hosting. Illustrator y Photoshop. HTML / CSS. SEO. Programación, tipos, algoritmos, metodología, lenguajes, servidores y plataformas. DB relacionales. Modelos de datos. Servidores locales. PHP. MySQL. JavaScript. Librerías. Funciones. Eventos. Estructuras de control de flujo, funciones y propiedades. Principios POO. Prototipos, funciones, eventos. DOM, BOM. Librerías y frameworks. Manipulación del DOM y nodos. Elementos, atributos, estilos. Jerarquías, selectores, atributos, funciones, métodos, eventos, objetos. JSON. AJAX. Lenguajes y paradigmas. Algoritmos, lógica, seudocódigo y diagramas. Variables y tipos. Estructura de datos. POO.', '2010', '2014', '1');


-- -----------------------------------------------------
-- Table `portfolio-database`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`skill` (
  `id` INT NOT NULL,
  `skill` VARCHAR(45) NULL,
  `percentage` INT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_skill_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_skill_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `portfolio-database`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('1', 'Organización', '95', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('2', 'Perseverancia', '85', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('3', 'Motivación', '80', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('4', 'SCRUM', '70', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('5', 'Angular', '75', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('6', 'React', '85', '1');
INSERT INTO `portfolio-database`.`skill` (`id`, `skill`, `percentage`, `user_id`) VALUES ('7', 'NodeJS', '90', '1');


-- -----------------------------------------------------
-- Table `portfolio-database`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio-database`.`project` (
  `id` INT NOT NULL,
  `image` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `details` VARCHAR(1000) NULL,
  `link` VARCHAR(100) NULL,
  `project_year` INT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_project_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_project_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `portfolio-database`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `portfolio-database`.`project` (`id`, `image`, `title`, `details`, `link`, `project_year`, `user_id`) VALUES ('1', '../assets/images/project/buscateungif.jpg', 'Buscate un gif', 'App en React + Giphy API integration + hooks + custom hooks + unit testing with Jest, Enzyme and React Hooks Testing Library.', 'https://acmaccan.github.io/buscateungif/', '2022', '1');
INSERT INTO `portfolio-database`.`project` (`id`, `image`, `title`, `details`, `link`, `project_year`, `user_id`) VALUES ('2', '../assets/images/project/calculator.jpg', 'Calculadora', 'Playing with vanilla JS + DOM.', 'https://acmaccan.github.io/my-calculator/', '2022', '1');
INSERT INTO `portfolio-database`.`project` (`id`, `image`, `title`, `details`, `link`, `project_year`, `user_id`) VALUES ('3', '../assets/images/project/exchange.jpg', 'Exchange', 'Playing with vanillaJS + DOM + axios + CORS + third party APIs.', 'https://acmaccan.github.io/exchange-dolar-pesoarg/', '2022', '1');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
