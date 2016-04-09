# Rapid prototyping with Spring Boot and AngularJS
This example demonstrates how **Spring Boot**, **Spring Data JPA** and in the front-end **AngularJS** can be used together to write micro services based web applications easily.
In this code example I'm demonstrating this by creating a full fledged Financial Markets analysis dashboard for Africa's top 3 markets.

## Frameworks

### Front-end

#### Twitter Bootstrap
For rapidly creating prototypes of a web application, a UI toolkit or library will become really handy. There are many choices available, and for this example I chose Twitter Bootstrap.

#### AngularJS
AngularJS is a MVC based framework for web applications, written in JavaScript. It makes it possible to use the Model-View-Controller pattern on the front-end. It also comes with several additional modules. In this example I'm also using **angular-resource**, which is a simple factory-pattern based module for creating REST clients.

### Back-end

#### Spring Boot
One of the hassles while creating web applications using the Spring Framework is that it involves a lot of configuration. Spring Boot makes it possible to write configuration-less web application because it does a lot for you out of the box.
For example, if you add H2 as a dependency to your application, it will automatically provide a datasource to it.
If you add the spring-boot-starter-web dependency, then you can start writing controllers for creating a web application.

One of the brightest spots of a Spring Boot application is the Actuator, which adds several helpful management endpoints for application mnitoring. We are going to use actuators in this demo to access endpoints like GET /health — which displays the current application health, and GET /metrics — which lists metrics concerning the application, including running
counts of requests against certain endpoints. 

#### Spring Data JPA
Spring Data JPA allows you to create repositories for your data without even having to write a lot of code. The only code you need is a simple interface that extends from another interface and then you're done.
With Spring Boot you can even leave the configuration behind for configuring Spring Data JPA, so now it's even easier.

## Installation
Installation is quite easy, first you will have to install some front-end dependencies using Bower:
```
bower install
```

Then you can run Maven to package the application:
```
mvn clean package
```

Now you can run the Java application quite easily:
```
java -jar target\ng-springboot-markets-dashboard-1.0.0.jar
```