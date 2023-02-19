create table aeropuerto_seq
(
    next_val bigint null
);

CREATE TABLE aeropuerto (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `codigo` varchar(255) NOT NULL,
    `nombre` varchar(255) NOT NULL,
    `ciudad` varchar(255) NOT NULL,
    `pais` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO aeropuerto (codigo, nombre, ciudad, pais) VALUES ("MAD", "Adolfo Suárez Madrid Barajas", "España", "Madrid");
INSERT INTO aeropuerto (codigo, nombre, ciudad, pais) VALUES ("BCN", "El Plat", "España", "Barcelona");
INSERT INTO aeropuerto (codigo, nombre, ciudad, pais) VALUES ("DUB", "Aeropuerto Dublin", "Irlanda", "Dublin");
INSERT INTO aeropuerto (codigo, nombre, ciudad, pais) VALUES ("SVQ", "Aeropuerto Sevilla", "España", "Sevilla");
INSERT INTO aeropuerto (codigo, nombre, ciudad, pais) VALUES ("SCQ", "Aeropuerto Santiago", "España", "Lavacolla");

create table avion_seq
(
    next_val bigint null
);

CREATE TABLE avion (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `matricula` varchar(255) NOT NULL,
    `fabricante` varchar(255) NOT NULL,
    `modelo` varchar(255) NOT NULL,
    `horasVuelo` int(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO avion (matricula, fabricante, modelo, horasVuelo) VALUES ("1111", "Airbus", "A320", 5000);
INSERT INTO avion (matricula, fabricante, modelo, horasVuelo) VALUES ("2222", "Airbus", "A330", 10000);
INSERT INTO avion (matricula, fabricante, modelo, horasVuelo) VALUES ("3333", "Airbus", "A380", 15000);
INSERT INTO avion (matricula, fabricante, modelo, horasVuelo) VALUES ("4444", "Boeing", "737", 20000);
INSERT INTO avion (matricula, fabricante, modelo, horasVuelo) VALUES ("5555", "Boeing", "747", 50000);

create table tripulante_seq
(
    next_val bigint null
);

CREATE TABLE tripulante (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `codigo` varchar(255) NOT NULL,
    `nombre` varchar(255) NOT NULL,
    `apellidos` varchar(255) NOT NULL,
    `compañia` varchar(255) NOT NULL,
    `puesto` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO tripulante (codigo, nombre, apellidos, puesto, compañia) VALUES ("00001", "Pedro", "García", "Auxiliar", "Iberia");
INSERT INTO tripulante (codigo, nombre, apellidos, puesto, compañia) VALUES ("00002", "María", "Pérez", "Piloto", "Iberia");
INSERT INTO tripulante (codigo, nombre, apellidos, puesto, compañia) VALUES ("00003", "Ana", "López", "Comandante", "Iberia");
INSERT INTO tripulante (codigo, nombre, apellidos, puesto, compañia) VALUES ("00004", "Juan", "Blas", "Piloto", "Vueling");
INSERT INTO tripulante (codigo, nombre, apellidos, puesto, compañia) VALUES ("00005", "Andrés", "Martínez", "Auxiliar", "Vueling");
