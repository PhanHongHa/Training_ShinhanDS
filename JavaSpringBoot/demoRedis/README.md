# Practice Week 10-1 (Redis)

* Dependency 
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>	
</dependency>

<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
```

* application.properties
```properties
redis.host = localhost
redis.port= 6379
```

* Run Redis Server. cmd Run "redis-server"

 ![1](https://user-images.githubusercontent.com/72399528/222202970-44252c28-a4f4-4842-88e4-6663b048132c.png)
 
 
* Set Key/Value 

![2](https://user-images.githubusercontent.com/72399528/222203868-b83c5cac-c6a3-4d8a-bc02-c5dc89809bdd.png)

* Thêm 3 Value nào list 

![3](https://user-images.githubusercontent.com/72399528/222204641-604bbeb8-2da3-4a38-a7bc-4c9a8e1c1075.png)

* Thêm 4 Value nữa vào list thì list value sẽ là 7

![4](https://user-images.githubusercontent.com/72399528/222205244-405a4d22-1f1c-45b2-818a-b6b7f0adbe04.png)


