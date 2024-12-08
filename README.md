# Country Info Service
Country Info Service is a Spring Boot application that allows you to fetch country information from public API [REST Countries](https://restcountries.com) API and store it in a local database.
### Main features of the project include:
* Fetching country data based on the Alpha-3 code (e.g., POL for Poland).
* Automatically saving the fetched data to the database.

## Technologies used in the project
* Programming language: Java
* Framework: Spring Boot
* Database: H2
* API communication: RestTemplate
* Build tools: Maven

## Installation and running
Build the project:
```
mvn clean install
```
Run the application:
```
mvn spring-boot:run
```
Test the application: The application runs by default at http://localhost:8080.

## Usage
### Fetching country data
Application endpoint (example for the Alpha-3 code POL):
```
GET http://localhost:8080/countries/POL
```
JSON response::
```
{
  "alpha3Code": "POL",
  "nameCommon": "Poland",
  "nameOfficial": "Republic of Poland",
  "capital": [
    "Warsaw"
  ],
  "region": "Europe",
  "subregion": "Central Europe",
  "currencies": {
    "PLN": {
      "name": "Polish złoty",
      "symbol": "zł"
    }
  },
  "languages": {
    "pol": "Polish"
  },
  "population": 37950802,
  "borders": [
    "BLR",
    "CZE",
    "DEU",
    "LTU",
    "RUS",
    "SVK",
    "UKR"
  ],
  "timezones": [
    "UTC+01:00"
  ]
}
```
## Configuration
### `application.properties` file
The application uses the default H2 configuration. You can change the database configuration in the `application.properties`file \
Example:
```
spring.datasource.url=jdbc:h2:mem:db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## Tests
You can run the tests with the following command:
```
mvn test
```
