# Country Info Service
Country Info Service to aplikacja Spring Boot, która pozwala na pobieranie informacji o krajach z publicznego API [REST Countries](https://restcountries.com) i przechowywanie ich w lokalnej bazie danych. 
### Główne funkcjonalności projektu obejmują:
* Pobieranie danych o kraju na podstawie kodu Alpha-3 (np. POL dla Polski).
* Automatyczne zapisanie pobranych danych do bazy danych.
* Obsługa brakujących informacji i zapewnienie domyślnych wartości w przypadku niepełnych danych.

## Technologie użyte w projekcie
* Język programowania: Java
* Framework: Spring Boot
* Baza danych: H2
* Komunikacja z API: RestTemplate
* Narzędzia budowy projektu: Maven

## Wymagania
* Java 17 lub nowsza
* Maven 3.8 lub nowszy

## Instalacja i uruchamianie
Zbuduj projekt:
```
mvn clean install
```
Uruchom aplikację:
```
mvn spring-boot:run

```
Testuj aplikację: Aplikacja domyślnie działa pod adresem http://localhost:8080

## Użycie
### Pobranie danych o kraju
Endpoint aplikacji (przykład dla kodu Alpha-3 POL):
```
GET http://localhost:8080/countries/POL
```
Odpowiedź JSON:
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
## Konfiguracja
### Plik `application.properties`
Aplikacja korzysta z domyślnej konfiguracji H2. Możesz zmienić konfigurację bazy danych w pliku `application.properties`
Przykład:
```
spring.datasource.url=jdbc:h2:mem:db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## Testy
testy można uruchomić poleceniem:
```
mvn test
```
