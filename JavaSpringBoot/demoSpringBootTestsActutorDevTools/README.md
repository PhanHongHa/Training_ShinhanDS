# Practice Week 8-3

## I. Spring boot Tests

### Using JUnit 5

* Dependency

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
<!--Exclude JUnit4-->  
	<exclusions>
		<exclusion>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
		</exclusion>
	</exclusions>
</dependency>

<!--Add JUnit5--> 
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-api</artifactId>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-engine</artifactId>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.assertj</groupId>
	<artifactId>assertj-core</artifactId>
	<version>3.24.2</version>
	<scope>test</scope>
</dependency>
```

#### Project Spring Boot JPA:
![Screenshot 2023-02-22 231456](https://user-images.githubusercontent.com/72399528/220687453-f9a2c823-9d8c-4adf-98a6-6ccc69557262.png)

#### Spring Boot Test:
![Screenshot 2023-02-22 231843](https://user-images.githubusercontent.com/72399528/220688689-acaed901-91d7-49b3-9c5e-f7a5d9d05294.png)

* Test Repository:
![TestRepository](https://user-images.githubusercontent.com/72399528/220689759-c874e3d9-98fa-4d53-a71e-424c42845025.png)

* Test Service:
![TestService](https://user-images.githubusercontent.com/72399528/220690019-8f21e37f-0d4a-49e1-b5f2-15286f8b44af.png)

* Test Controller:
![TestController](https://user-images.githubusercontent.com/72399528/220690070-fd2f98c0-b92d-4aa0-a823-589f91afd8b9.png)

## II. Actuator 

* Dependency

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

* Config Actuator:
```properties
#Spring Boot Actuator settings
management.server.port=8090
management.endpoints.web.exposure.include=*
management.endpoint.shutdown.enabled=true
```

* Actuator Endpoints:
![ActuatorEndpoints](https://user-images.githubusercontent.com/72399528/220692824-81b3207d-f917-4450-90e0-d068c5f782d5.png)

* Actuator Health:
![ActuatorHealth](https://user-images.githubusercontent.com/72399528/220692975-b0bff193-dd39-49b1-ac7a-c4dc6e6316d1.png)

* Actuator ShutDown:
![ActuatorShutdown](https://user-images.githubusercontent.com/72399528/220693286-cebaf88f-988a-4db6-9433-0e0862bcbcda.png)

## III. DevTools

* Dependency:
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
```

* Before:
![DevTools (before)](https://user-images.githubusercontent.com/72399528/220694366-70efb2fe-fa03-4541-acdb-cf5d99615df7.png)

* Error:
![Devtools (error)](https://user-images.githubusercontent.com/72399528/220694593-603008a7-0d54-421d-b722-a0dc9e2f8ce4.png)

* After:
![DevTool (after)](https://user-images.githubusercontent.com/72399528/220694732-b2509dc2-11f2-4559-9b88-d348bd1aad40.png)


