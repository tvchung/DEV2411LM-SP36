package com.devmaster.lesson01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Devmaster Hello World");
		MyBean obj = new MyBean();
		System.out.println(obj.sayHello());
	}

}
class MyBean{
	@Bean
	public MyBean myBean(){
		return new MyBean();
	}
	@Bean
	public String sayHello(){
		return "Hello World";
	}
}