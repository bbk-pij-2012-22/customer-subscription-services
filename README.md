# Project Title

This is a simple spring boot application that provides a solution to the coding test posed at https://hackmd.io/LAt6HwlQTH-RLJS4478Gqg?view.

As requested, the application provides an endpoint for returning matches that a customer has purchased a license to be able to access with an optional summary parameter. It does not provide endpoints and services that would naturally coexist, e.g. customer creation, match creation, logic behind purchasing a tournament etc. simply because it's not a requirement of the spec. However, some relations mentioned in the spec are suggested, e.g. tournament or customer_tournament_licence that are not actually used.

## Getting Started

You can run/test this project in several ways:

**Docker Compose (recommended)**: download the root level docker compose yaml file, cd to the parent directory and simply run
`docker compose up`

This will run the spring boot application in a container and a compatible, pre-populated mysql container that will both run on the same network and communicate with one another. You'll be able to hit the match licence endpoint either in your browser or using a tool like postman.

localhost:8080/api/user/licence/{userId}/matches?summaryType={summaryType}

where summaryType can be either 'AvB' or 'AvBTime'


**Git clone**: If you wish to clone the repository and run it locally, you will need to provide the application with a mysql db. The simplest way to provide one is to use the following Docker run commands. These database containers run on non-standard mysql ports so as to avoid any clash with existing instances:

Application DB:
`sudo docker container run --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_db -d mysql:8`

Test DB:
`sudo docker container run --name mysqldbtest -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customer_subscription_test_db -d mysql:8`


**AWS**:



### Prerequisites

To run the application locally either via docker compose or by providing dockerised mysql instances, you will need Docker installed and running. Follow instructions here: https://www.docker.com/get-started


## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

