package com.SwapIT.SwapIt_BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.SwapIT.SwapIt_BackEnd")
public class SwapItBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapItBackEndApplication.class, args);
	}

}
