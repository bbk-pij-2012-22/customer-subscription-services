# Customer Subscription Service

This is a spring boot application that provides a solution to the coding test posed at https://hackmd.io/LAt6HwlQTH-RLJS4478Gqg?view.

As requested, the application provides an endpoint for returning matches that a customer has purchased a license to view with an optional summary parameter. It does not provide endpoints and services that would naturally coexist, e.g. customer creation, match creation, logic behind purchasing a tournament etc. simply because it's not a requirement of the spec. However, some relations that are hinted at in the spec are in place in a very basic format, e.g. tournament or customer_tournament_licence that are not actually used.

## Getting Started

You can run/test this project in several ways:

**Docker Compose (recommended)**: download the root level docker-compose.yaml file, cd to the parent directory and simply run
`docker compose up`

This will download the bespoke images for the application and DB. It will then launch a containerised mysql 8 instance and wait for it to be responsive to connections, at which point it will run the spring boot application in a docker container and map its internal tomcat server to port 8080 on localhost. The two services will be running on the same network and they will be able to communicate with one another. As it is pre-populated, there's no need to create the schema or insert any data to be able to begin returning results from the api. As soon as the command has has completed successfully, you'll be able to hit the match licence endpoint either in your browser or using a tool like postman (https://www.postman.com/). Example url:

localhost:8080/api/user/licence/{userId}/matches?summaryType={summaryType}

where userId is an existing user in the DB and summaryType can be either 'AvB' or 'AvBTime'


**Git clone**: If you wish to clone the repository and run the application manually, you will need to provision a mysql database for it. The simplest way to provide one is to use the following Docker run commands. These database containers run on non-standard mysql ports so as to avoid any clash with existing mysql instances:

Application DB:
`sudo docker container run --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_db -d mysql:8`

Test DB:
`sudo docker container run --name mysqldbtest -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_test_db -d mysql:8`

When launching the live application, it will auto-create the tables and insert some example data for you to query.

To be able to run the tests, you will need to access the DB container's bash, log into mysql, and paste the DB schema sql script, located here: https://gitlab.com/marshall_gj/customer-subscription-service/-/blob/master/src/main/resources/schema.sql

Another way to provide a mysql DB is to have a locally installed mysql server running. You will need to change the mysql host port in the application.properties file of the spring boot application (or test resource counterpart) to match the port that your mysql server is running on (defaults to 3306). You'll need to then create the db 'customer_subscription_db' (for application) or 'customer_subscription_test_db' (for test suite).

However you have provisioned the mysql DB, you can then run the project by using the command `mvn spring-boot:run` from the project's root directory. This will launch spring boot and run its embedded tomcat server on port 8080 on localhost. You'll be able to hit the match licence endpoint either in your browser or using a tool like postman (https://www.postman.com/).


### Prerequisites

**Docker Compose (recommended)** To run the application via docker compose, you will need the latest version of Docker desktopinstalled and running. Follow instructions here: https://www.docker.com/get-started. This is all you need and is why it is the recommended approach.

**Git clone** To fire up the dockerised mysql instances, you will need Docker installed and running. Follow instructions here: https://www.docker.com/get-started. To successfully run the command `mvn spring-boot:run`, you will need maven installed (http://maven.apache.org/install.html). 

## Running the tests

1. Clone the project
2. Provide a blank mysql DB (see above)
3. Run command `mvn clean install` from the project root directory (test data will be inserted by DBUnit)


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com/) - Database
* [Docker](https://www.docker.com/) - Virtualisation 

## API contract


**Get Match Licences**

Rest method: GET
uri: /api/user/licence/{customerId}/matches?summaryType={summaryType}
parameters:
  **customerId** (path parameter): the unique id of the customer whose results we are seeking
  **summaryType** (query parameter): optional. Accepted values: 'AvB' will return player A vs player B. 'AvBTime will return player A vs player B with the minute from or until the start of the match in question.

Example request:

{baseUrl}:8080/api/user/licence/{userId}/matches?summaryType={summaryType}


Example response:

[
   {
      "matchId":1,
      "startDate":"2021-02-08T14:00:00.000+00:00",
      "playerA":"K.Anderson",
      "playerB":"M.Berrettini",
      "summary":"K.Anderson vs M.Berrettini, starts in 1104 minutes"
   },
   {
      "matchId":2,
      "startDate":"2021-02-09T16:30:00.000+00:00",
      "playerA":"S.Querrey",
      "playerB":"L.Sonego",
      "summary":"S.Querrey vs L.Sonego, starts in 2694 minutes"
   }
]


## Example Data

Example data includes customers with ids 1 + 2. Any other customer IDs will return an error message that the user ID does not exist as they are not in the example data.
