# Practice Week 10-3: Practice Websocket, Redis, Kafka, Docker.

### docker-compose.yml file:
``` yml
version: "3"
services:
  zookeeper:
    image: 'bitnami/zookeeper:latest'
    ports:
      - '2181:2181'
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
  kafka:
    image: 'bitnami/kafka:latest'
    ports:
      - '9092:9092'
    environment:
      - KAFKA_BROKER_ID=1
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092
      - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
    depends_on:
      - zookeeper
```
### Run terminal:
``` cmd
docker-compose up -d
```

### Check Docker Desktop:
![3](https://user-images.githubusercontent.com/72399528/224065682-49897a51-a9c5-4420-ac01-b0878d403db5.png)

### Run terminal:
``` cmd
redis-server
```

![0](https://user-images.githubusercontent.com/72399528/224066028-0e9c79ba-67e5-430b-9d39-834bfc418acd.png)


## Bài 1:
![Screenshot 2023-03-09 213507](https://user-images.githubusercontent.com/72399528/224066527-25006813-9301-4bec-a476-5d8df240029e.png)

![1](https://user-images.githubusercontent.com/72399528/224066206-4e88ec46-2075-44c8-be39-21dda372f522.png)

![2](https://user-images.githubusercontent.com/72399528/224066292-c715c757-4d17-475b-88b1-327994d92aaa.png)

## Bài 2:

### Run terminal:
``` cmd
kafka-topics.sh --list --bootstrap-server localhost:9092
```
![6](https://user-images.githubusercontent.com/72399528/224067037-848bf3ff-be85-4039-9215-ae7c64bab243.png)

### Using method POST. Add new topic.

![5](https://user-images.githubusercontent.com/72399528/224067008-f19cc26a-5bc4-4704-81fa-ad81e6e96e2c.png)

### Check docker desktop:

![4](https://user-images.githubusercontent.com/72399528/224066966-ba20669e-99f7-46df-9b59-1bad7f065ba5.png)

### Using method DELETE. delete topic.

![7](https://user-images.githubusercontent.com/72399528/224067082-b8505d71-01e8-413f-8f80-0b7874b89bac.png)


### Check docker desktop:

![8](https://user-images.githubusercontent.com/72399528/224067115-278d56cb-5b8d-4e5c-ae82-62bb674b2cc5.png)


