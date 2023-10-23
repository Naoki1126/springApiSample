package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	// application.ymlから値を取得
	@Value("${application.messagespring:null}")
	private String message;
	
	// OSの環境変数から値を取得
	// eclipseではなく、コマンドラインからappサーバを起動する必要あり
	// .zshenv等を読み込むわけではない
	@Value("${MESSAGE:null}")
	private String envMessage;
	
	@Value("${savehist:null}")
	private String saveHist;
	
	@Value("${testmessage}")
	private String testMessage;
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
		
		
		System.out.println(message);
		System.out.println(envMessage);
		
		System.out.println(testMessage);
		
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
