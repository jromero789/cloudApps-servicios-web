create table aeropuerto_seq
(
    next_val bigint null
);

CREATE TABLE `aeropuerto` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `codigo` string NOT NULL,
    `nombre` string NOT NULL,
    `ciudad` string NOT NULL,
    `pais` string NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `aeropuerto`("codigo", "nombre", "ciudad", "pais") VALUES ("MADIDDD", "Adolfo Suárez Madrid Barajas", "España", "Madrid");
INSERT INTO `aeropuerto`("codigo", "nombre", "ciudad", "pais") VALUES ('"BCN", "El Plat", "España", "Barcelona"');
INSERT INTO `aeropuerto`("codigo", "nombre", "ciudad", "pais") VALUES ("DUB", "Aeropuerto Dublin", "Irlanda", "Dublin");
INSERT INTO `aeropuerto`("codigo", "nombre", "ciudad", "pais") VALUES ("SVQ", "Aeropuerto Sevilla", "España", "Sevilla");
INSERT INTO `aeropuerto`("codigo", "nombre", "ciudad", "pais") VALUES ("SCQ", "Aeropuerto Santiago", "España", "Lavacolla");