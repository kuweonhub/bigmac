# bigmac

Spring Boot, Angular v6 & Bootstrap 4 Demo

## Features
It's a
* Rest
* Client Server
* Open Data
* Single Page
* Responsive
* Javascript
* Groovy

App

## Getting Started
To see how the application looks like take a look at the [Screenshot](https://github.com/kuweonhub/bigmac/blob/master/Screenshot.png).

### Prerequisites

Please install
* [npm](https://www.npmjs.com/get-npm)
* [Angular CLI](https://github.com/angular/angular-cli/wiki)
* [Groovy](http://groovy-lang.org/install.html)

To run the app locally you have to register (free) with [QUANDL](https://www.quandl.com/sign-up-modal?defaultModal=showSignUp).
If you have your quandle api key set is a system property or a JVM property (see [AbstractTimeSeriesDao](https://github.com/kuweonhub/bigmac/blob/master/lib/src/main/groovy/org/unkongress/bigmac/dao/AbstractTimeSeriesDao.groovy)).

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* Gradle (gradle clean build)

## Start locally

### Webclient
./bigmac/webapp/ng serve --port 4200

### Application
Start the application with your IDE or if you have built an jar:
java -Dserver.port=8080 -Dquandl_api_key=xxx -jar bigmac-1.0.0.jar

## Component diagrams
![High Level Component Diagram](https://github.com/kuweonhub/bigmac/blob/master/comp_high_level.png "High Level Component Diagram")
![Webclient Component Diagram](https://github.com/kuweonhub/bigmac/blob/master/comp_webapp.png "Webclient Component Diagram")
![Application Component Diagram](https://github.com/kuweonhub/bigmac/blob/master/comp_bigMacApp.png "Application Component Diagram")

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
