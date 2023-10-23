package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiSampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringApiSampleApplication.class, args);
	}
    

	// SampleLogicにてBean定義するためコメントアウト
//    @Bean
    // Configration　クラスにてBeanに追加
//    DiSample createDiSample() {
//		return new DiSample(NAME, AGE);
//	}
}

