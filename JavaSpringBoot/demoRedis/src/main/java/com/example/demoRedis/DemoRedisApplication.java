package com.example.demoRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoRedisApplication {

	@Autowired
	private RedisTemplate template;
	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args ->{
			listExample();
		};
	}

	public void listExample(){
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("redis");
		list.add("Hà nè");
		list.add("Spring boot");
		template.opsForList().rightPushAll("likelion_list", list);
		System.out.println("Size of key likelion:"+template.opsForList().size("likelion_list"));
	}

//	@Bean
//	CommandLineRunner commandLineRunner(RedisTemplate<Object, Object> redisTemplate){
//		return args ->{
//			redisTemplate.opsForValue().set("likelion","hello redis");
//			System.out.println("Value of key likelion: "+ redisTemplate.opsForValue().get("likelion"));
//		};
//	}


}
