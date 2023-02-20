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


create table vuelo_seq
(
    next_val bigint null
);

CREATE TABLE vuelo (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `codigo` varchar(255) NOT NULL,
    `compañia` varchar(255) NOT NULL,
    `avion_id` bigint NOT NULL,
    `origen_id` bigint NOT NULL,
    `destino_id` bigint NOT NULL,
    `fecha_salida` date NOT NULL,
    `duracion` int(255) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`origen_id`) REFERENCES `aeropuerto`(`id`),
    FOREIGN KEY (`destino_id`) REFERENCES `aeropuerto`(`id`),
    FOREIGN KEY (`avion_id`) REFERENCES `avion`(`id`)
) ENGINE=InnoDB;

INSERT INTO vuelo (codigo, compañia, avion_id, origen_id, destino_id, fecha_salida, duracion) VALUES ("IB111", "Iberia", 1, 1, 2,  "20101210", 0.5);
INSERT INTO vuelo (codigo, compañia, avion_id, origen_id, destino_id, fecha_salida, duracion) VALUES ("IB222", "Iberia", 2, 3, 4, "20101210", 2.5);
INSERT INTO vuelo (codigo, compañia, avion_id, origen_id, destino_id, fecha_salida, duracion) VALUES ("VU111", "Vueling", 5, 4, 5, "20101210", 1.5);

create table mecanico_seq
(
    next_val bigint null
);

CREATE TABLE mecanico (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `codigo` varchar(255) NOT NULL,
    `nombre` varchar(255) NOT NULL,
    `apellidos` varchar(255) NOT NULL,
    `empresa` varchar(255) NOT NULL,
    `año_incorporacion` int(255) NOT NULL,
    `formacion` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO mecanico (codigo, nombre, apellidos, empresa, año_incorporacion, formacion) VALUES ("1000", "Alexis", "Ramos", "Empresa 1", 2005, "FP");
INSERT INTO mecanico (codigo, nombre, apellidos, empresa, año_incorporacion, formacion) VALUES ("2000", "Rafa", "Marquez", "Empresa 2", 2015, "Ninguna");
INSERT INTO mecanico (codigo, nombre, apellidos, empresa, año_incorporacion, formacion) VALUES ("3000", "María", "Pérez", "Empresa 3", 2010, "Ingeniería");
INSERT INTO mecanico (codigo, nombre, apellidos, empresa, año_incorporacion, formacion) VALUES ("4000", "Adela", "López", "Empresa 1", 2019, "FP");
INSERT INTO mecanico (codigo, nombre, apellidos, empresa, año_incorporacion, formacion) VALUES ("5000", "Ramón", "Ronda", "Empresa 2", 2005, "FP");

create table revision_seq
(
    next_val bigint null
);

CREATE TABLE revision (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `avion_id` bigint NOT NULL,
    `fecha_inicio_revision` date NOT NULL,
    `fecha_fin_revision` date NOT NULL,
    `horas_revision` int(255) NOT NULL,
    `mecanico_id` bigint NOT NULL,
    `tipo_revision` varchar(255) NOT NULL,
    `descripcion` varchar(255) NOT NULL,
    `aeropuerto_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`avion_id`) REFERENCES avion(`id`),
    FOREIGN KEY (`mecanico_id`) REFERENCES mecanico(`id`),
    FOREIGN KEY (`aeropuerto_id`) REFERENCES aeropuerto(`id`)
) ENGINE=InnoDB;

INSERT INTO revision (avion_id, fecha_inicio_revision, fecha_fin_revision, horas_revision, mecanico_id, tipo_revision, descripcion, aeropuerto_id) VALUES (1, "20101210", "20101210", 150, 1, "Revision", "Descripcion 1", 1);
INSERT INTO revision (avion_id, fecha_inicio_revision, fecha_fin_revision, horas_revision, mecanico_id, tipo_revision, descripcion, aeropuerto_id) VALUES (2, "20101210", "20101210", 500, 1, "Avería", "Descripcion 2", 1);
INSERT INTO revision (avion_id, fecha_inicio_revision, fecha_fin_revision, horas_revision, mecanico_id, tipo_revision, descripcion, aeropuerto_id) VALUES (5, "20101210", "20101210", 200, 2, "Revisión", "Descripcion 3", 2);
INSERT INTO revision (avion_id, fecha_inicio_revision, fecha_fin_revision, horas_revision, mecanico_id, tipo_revision, descripcion, aeropuerto_id) VALUES (5, "20101210", "20101210", 600, 3, "Revision", "Descripcion 4", 2);
