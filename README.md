# Customer Subscription Service

This is a simple spring boot application that provides a solution to the coding test posed at https://hackmd.io/LAt6HwlQTH-RLJS4478Gqg?view.

As requested, the application provides an endpoint for returning matches that a customer has purchased a license to be able to access with an optional summary parameter. It does not provide endpoints and services that would naturally coexist, e.g. customer creation, match creation, logic behind purchasing a tournament etc. simply because it's not a requirement of the spec. However, some relations mentioned in the spec are in place in a very basic format, e.g. tournament or customer_tournament_licence that are not actually used.

## Getting Started

You can run/test this project in several ways:

**Docker Compose (recommended)**: download the root level docker-compose.yaml file, cd to the parent directory and simply run
`docker compose up`

This will run the spring boot application in a docker container and map its internal tomcat server to port 8080 on localhost. It will also launch a compatible, pre-populated mysql container that will run on the same network as the spring boot service and they will be able to communicate with one another. You'll be able to hit the match licence endpoint either in your browser or using a tool like postman (https://www.postman.com/). Example url:

localhost:8080/api/user/licence/{userId}/matches?summaryType={summaryType}

where summaryType can be either 'AvB' or 'AvBTime'


**Git clone**: If you wish to clone the repository and run it locally, you will need to provide the application with a mysql db. The simplest way to provide one is to use the following Docker run commands. These database containers run on non-standard mysql ports so as to avoid any clash with existing instances:

Application DB:
`sudo docker container run --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_db -d mysql:8`

Test DB:
`sudo docker container run --name mysqldbtest -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_test_db -d mysql:8`

Another way to provide a mysql DB is to have a locally installed mysql server running. You will need to change the mysql host port in the application.properties file of the spring boot application (or test resource counterpart) to match the port that your mysql server is running on (defaults to 3306). You'll need to then create the db 'customer_subscription_db' (for application) or 'customer_subscription_test_db' (for test suite).

However you have provisioned the mysql DB, you can then run the project by using the command `mvn spring-boot:run` from the project's root directory. This will launch spring boot and run its embedded tomcat server on port 8080. You'll be able to hit the match licence endpoint either in your browser or using a tool like postman (https://www.postman.com/).

**AWS**:



### Prerequisites

**Docker Compose (recommended)** To run the application via docker compose, you will need the latest version of Docker installed and running. Follow instructions here: https://www.docker.com/get-started. This is all you need and is why it is the recommended approach.

**Git clone** To fire up the dockerised mysql instances, you will need Docker installed and running. Follow instructions here: https://www.docker.com/get-started. To successfully run the command `mvn spring-boot:run`, you will need maven installed (http://maven.apache.org/install.html). 

## Running the tests

1. Clone the project
2. Provide a mysql DB 


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com/) - Database
* [Docker](https://www.docker.com/) - Virtualisation 

## API contract
