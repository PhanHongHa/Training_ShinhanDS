# Practice Week 9-3 (JWT)
* Dependency
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity5</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
```

### Run application

![1](https://user-images.githubusercontent.com/72399528/221613041-4cb86d76-d19d-4830-8cc7-f82884d08342.png)

* Khi server on, chúng ta thử request vào http://localhost:8080/api/random , sẽ bị error 403

![403](https://user-images.githubusercontent.com/72399528/221614241-0a904e77-5aac-4310-b8e9-0512b7892d70.png)

* Để có thể request được, chúng ta đăng nhập vào hệ thống bằng api/login, login bằng user/password có sẳn ở db

![login](https://user-images.githubusercontent.com/72399528/221614938-3196274c-e74b-4d56-901e-299f2d5d4d9a.png)

* Sau đó sử dụng thông tin jwt server trả về để thực hiện các request khác

![Result](https://user-images.githubusercontent.com/72399528/221615098-a7976461-3076-4517-aa12-58e6903439d9.jpg)


