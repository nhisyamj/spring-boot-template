[![Build Status](https://travis-ci.org/nhisyamj/spring-boot-template.svg?branch=master)](https://travis-ci.org/nhisyamj/spring-boot-template)
[![codecov](https://codecov.io/gh/nhisyamj/spring-boot-template/branch/master/graph/badge.svg)](https://codecov.io/gh/nhisyamj/spring-boot-template)

# spring-boot-template
This project act as initial template for spring boot app.

## Pre-requisites

- Java 1.8.x
- Maven
- Docker
- Docker Compose

### Usage

Start required services
```
$ docker-compose -f infra/sb-template/docker-compose.yml up -d
```

Run the application

```
$ mvn spring-boot:run
```

Scanning the code quality using SonarQube

```
$ mvn clean verify sonar:sonar /
  -Dsonar.host.url=http://sonarserver:9000 # <optional> default http://localhost:9000
```
