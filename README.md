**Spring_4 Web MVC Homework**

Required:
1. Extend your service functionality by:
- adding basic validation to DTO classes
- implementing custom common and unified error handling functionality using Spring MVC components.
- adding the Spring Boot Actuator to your project and configuring the ‘/info’ endpoint of it. 
- extending your service RESTful endpoints by adding versioning alongside Swagger2 documentation.

Optional (would be a great plus):
1. Get hands-on experience working with the RestTemplate:
- create a separate service that will make REST calls to your main service endpoints (GET, POST, PUT, PATCH, DELETE) and parse the response.
2. Create custom validation annotations using ConstraintValidatoror. Samples:
- check whether there is a user in the database with such username during registration. If so, throw an error.
- make a class level validation annotation that will check whether 2 passwords (‘password’ and ‘repeatPassword’ fields) are the same during registration. If not, throw an error.
3. Add multilingual support for exception messages configuring the ‘MessageSource’ bean - https://www.baeldung.com/spring-custom-validation-message-source
