# airline-sales
In this study we will dive into aviation sector.
## Airline
### Add New Airline (endpoint (POST): /airline/save)

```
{
    "name": "airline1"
}
```
### Get Airline (endpoint (GET): airline/get/INDEX)
Replace INDEX tag with a number.
### Search Airline (endpoint (GET): airline/getContains/KEYWORD)
Replace KEYWORD tag with anything you want.
## Airport
### Add New Airport (endpoint (POST): /airport/save)

```
{
    "name": "airport1"
}
```
### Get Airport (endpoint (GET): airport/get/INDEX)
Replace INDEX tag with a number.
### Search Airport (endpoint (GET): airport/getContains/KEYWORD)
Replace KEYWORD tag with anything you want.
## Route
### Add New Route (endpoint (POST): /route/save)

```
{
    "name": "route1",
    "fromAirportId": 1,
    "toAirportId": 1
}
```
### Get Route (endpoint (GET): route/get/INDEX)
Replace INDEX tag with a number.
### Search Route (endpoint (GET): route/getContains/KEYWORD)
Replace KEYWORD tag with anything you want.
## Flight
### Add New Flight (endpoint (POST): /flight/save)

```
{
    "name": "flight1",
    "capacity": 10,
    "departure": "22-11-2021 23:12",
    "basePrice": 100.0,
    "routeId": 1,
    "airlineId": 1
}
```
### Get Flight (endpoint (GET): flight/get/INDEX)
Replace INDEX tag with a number.
### Search Route (endpoint (GET): flight/getContains/KEYWORD)
Replace KEYWORD tag with anything you want.
## Ticket
### Add New Ticket (endpoint (POST): /ticket/sell)
Web service will return ticket id and another informations.

```
{
    "creditCard": "“4221,/*-+!'^+&/&()=?_ -*}][{½$#£>1611,2233,0005",
    "flightId": 1
}
```
### Get Ticket (endpoint (GET): ticket/get/INDEX)
Replace INDEX tag with a number.
### Delete Ticket (endpoint (DELETE): ticket/delete/INDEX)
Replace INDEX tag with a ticket number.
# DEMO
If you'd like to see some demo data. Call following endpoints as ordered. You can call multiple times the latest one.

Order | Endpoints
------------ | -------------
1 | localhost:8080/fill/withData
2 | localhost:8080/fill/withRoute
3 | localhost:8080/fill/withFlights
4 | localhost:8080/fill/withTickets
