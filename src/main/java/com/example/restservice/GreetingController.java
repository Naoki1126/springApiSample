package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DiSample;
import com.example.logics.DateTimeUtil;

@RestController
public class GreetingController extends BaseController {
	
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	// Constructor Injection or Setter Injection
	private DiSample diSample;
	
	@Autowired
	private DateTimeUtil DateTimeUtil; 
	
//	// Fieild Injection Sample
	// Configrationで定義しているBeanがInjectionされる
//	@Autowired
//	DiSample diSample;
	
	// Constractor Injection
	// コンストラクタが一つの場合は「@Autowiredは不要」
	// Configurationで定義しているBeanがInjectionされる
//	public GreetingController(DiSample diSample) {
//		this.diSample = diSample;
//	}
	
//	@Autowired
	// Configrationで定義しているBeanがInjectionされる
//	public void setGreetingContoroller(DiSample diSample) {
//		this.diSample = diSample;
//	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		DiSample  diSample = newDiSample("aaaaa", 22222);
		
		System.out.println("Bean定義場所:" + diSample.getName());
		System.out.println("Bean 年齢" + diSample.getAge());
		
		DiSample notBeanDiSample = newDiSample("Greeting Contoroller", 111);
		System.out.println("newしたDiSample: " + notBeanDiSample.getName());
		System.out.println("newしたDiSample: "+ notBeanDiSample.getAge());
		return new Greeting(counter.incrementAndGet(), String.format(template, name), DateTimeUtil.getCurrentDateTime());
	}
	
	private DiSample newDiSample(String name, int age) {
		return new  DiSample(name, age);
	}
}
