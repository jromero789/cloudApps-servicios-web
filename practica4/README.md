# EoloPlanner
- Master: CloudApps URJC
- Módulo II. Servicios Web
- 2.1 - Tecnologías de Servicios Web
- Práctica 4 – Paso de mensajes y WebSockets

- Alumnos: Eduardo Larraz, Juan Romero González
- Email: e.larraz.2022@alumnos.urjc.es, j.romero1.2016@alumnos.urjc.es
- Fecha: 12/12/2022

## Github práctica:
- https://github.com/jromero789/cloudApps-servicios-web

## Iniciar servicios auxiliares: MySQL, RabbitMQ

Los servicios auxiliares se ejecutan con la tecnología de contenedores Docker usando el siguiente comando:

```
$ docker run --rm -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=eoloplantsDB -p 3306:3306 --name mysql mysql:8.0.22
```
RabbitMQ


## Ejecutar servicios

Servicios:
- Server (http://localhost:8080/)
- Planner
- WeatherService
- TopoService