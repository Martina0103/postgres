# @h4h/medical-portal-backend

## Prerequisites
* jdk 13
* docker (v17 or later)
* docker-compose (v1.21 or later)
* maven (3.3.1 or later)

## How to start

Step #1: Initial maven build 
> mvn clean install -DskipTests

Step #2: Start up services (POSTGRES)
> docker-compose up -d 

Step #3: Verify that services are up & running
> docker-compose ps

Step #4: Run/Debug `PostgresExampleApplication.java`


##Logging
* To enable logging database.url in application.properties should be set to
>spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb?loggerLevel=DEBUG&loggerFile=postgresql_logs.log

* loggerLevel: Logger level of the driver. Allowed values: OFF, DEBUG or TRACE.
* Changes on log lever will be visible after restarting the application. On root level(same level as README.md file) you should see the log file

##IMPORTANT:
* Stopping containers
> docker-compose down
* Stopping containers and discarding the persisted data
> docker-compose down -v


##hikari cp properties
https://github.com/brettwooldridge/HikariCP

## Exercise
* TIM 1: Simulate usage of connectionTimeout and readonly
* TIM 2: Simulate usage of idleTimeout, minimumIdle, maximumPoolSize