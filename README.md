# REST API for an Online Cab Booking Application

* I have developed this REST API for an Online Cab Booking application. This API performs all the fundamental CRUD operations of any Online Cab Booking platform with user validation at every step.

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Login, Logout Module
* Driver Module
* Customer Module
* Admin Module
* TripBooking Module

## Features

* Customer, Driver and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different customers, drivers and trip bookings
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available cabs and booking a trip
    * Only logged in user can access his trip history, profile updation and other features.


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](Online_Cab_Booking_System/src/main/resources/application.properties) file.

* Update the port number, username and password as per your local database config.

```
 server.port=8888

spring.datasource.url=jdbc:mysql://localhost:3306/cabbookingdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui.html`


## API Module Endpoints

### Customer Module


* `POST /customer/login` : Logging in customer with valid mobile number & password
* `GET /customer/availablecabs` : Getting the list of all the available cabs
* `GET /customers/cabs` : Getting All the cabs
* `GET /customers/checkhistory` : Getting the history of completed tr
* `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
* `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
* `POST /customer/booktrip` : Customer can book a cab
* `POST /customer/updatetrip` : Customer can modify or update the trip
* `POST /customer/logout` : Logging out customer based on session token
* `DELETE /customer/delete` : Deletes logged in user 
* `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid 
* `DELETE /customer/canceltrip` : Cancel the trip with the given tripid 


### Admin Module

* `POST /admin/register` : Register a new admin with proper data validation and admin session
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on session token
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id


### Driver Module

* `POST /driver/register` : Register a new driver with proper data validation and admin session
* `POST /driver/login` : Driver can login with mobile number and password provided at the time of registation
* `POST /driver/status/{?}` : Changes the status of the driver either Online or Offline
* `GET /driver/logout` : Logging out driver based on session token
* `GET /driver/driverlist` : Gets list of all the drivers
* `GET /driver/bestdriver` : Gets the best driver whose rating is over 4.5
* `PUT /driver/update` : Updates the driver details

