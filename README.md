# Smart Lighter

Purpose of this project is to create a back-end server that send instructions to different Wi-Fi smart switch relays. A generic system that enables the client to communicate to all kind of Wi-Fi relays, no matter which manufacture or model.


## Description

Spring-boot application with a 3-tier architecture. User can create lights and assign them with the relays ip. User can create collections of presets and execute the instructions that these presets hold. A command pattern is implemented to take care of this. For the moment only on/off commands are implemented and are mocking a request to the Wi-Fi relay. Further on commands will send instructions to relays flashed with Tasmota.


## Getting Started

### Dependencies

* Mysql
* Maven
* Java 8


### Installing

* Clone/download repository
* Set your Mysql username and password in the application.properties file under smart-lighter/src/main/resources/



### Executing program


* $ mvn spring-boot:run
* After create user and login, add Authorization header with a valid JWT on all requests.
* See all endpoints http://localhost:8080/swagger-ui/
