# WORK FLOW OF SPRING DATA JPA
![Work Flow of Spring Data JPA](https://user-images.githubusercontent.com/72399528/212788736-14b29706-f469-4e29-a03a-170e981cd9df.png)

# Cách Spring Data JPA hoạt động:

## Application Modules
Đầu tiên, Repository sẽ cung cấp các method cho tầng Service. Trong các method đó có chứa các thông tin của Entity và các tham số. Repository là một interface kế thừa một trong những Repository Interfaces (CrudRepository, JpaRepository, ...) mà Spring Data JPA cung cấp sẵn.

## O/R Mapper
Tiếp theo, Repository sẽ kế thừa lại method mà Spring Data JPA cung cấp theo định nghĩa mapping của JPA và việc thực mapping của Hibernate. 

## JDBC interfaces
Kế đó, JPA và Hibernate sẽ định nghĩa các config thông qua JDBC Basic APIs và DataSource để kết nối với Database.

## JDBC implementations
Tiếp theo, Những định nghĩa đó sẽ được gửi cho JDBC Driver xử lý. Những thứ JDBC Driver xủ lý là những câu lệnh thuần để kết nối với Data base.

## Persistence layer
Cuối cùng, Database như Oracle, DB2, PostgreSQL,... sẽ nhận dữ liệu từ JDBC Driver đã xử lý trước đó.
