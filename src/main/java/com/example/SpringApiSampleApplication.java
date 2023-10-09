package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DiSample;

@SpringBootApplication
public class SpringApiSampleApplication {
	
	private final String NAME = "TestDiSampleName";
	private final int AGE = 21;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiSampleApplication.class, args);
	}

    @Bean
    // Configration　クラスにてBeanに追加
    DiSample createDiSample() {
		return new DiSample(NAME, AGE);
	}
}

