package com.example.logics;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import com.example.demo.DiSample;

@SpringBootTest
public class SampleLogicTest {

	// Mockにする
	// MockBeanにしないと別のオブジェクトとなる
	@MockBean
	private DiSample diSample;
	
	@Autowired
	ApplicationContext applicationContext;
	 
	@Autowired
	
	// テスト対象クラスの関数を一部モック化
	@InjectMocks
	@Spy
	private SampleLogic sampleLogic;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		// インスタンスをBeanに設定
		doReturn((DiSample)applicationContext.getBean("Junit-test")).when(sampleLogic).createDiSample();
	}
	
	@Test
	public void case001() {
		int result =  sampleLogic.calcAdd(1, 2);
		String info = sampleLogic.getDiSampleInfomation();
		System.out.println(info);
		
		doReturn("Mockで取得した結果です。").when(diSample).getProfile();
		
		String mockInfo = sampleLogic.getDiSampleInfomation();
		System.out.println(mockInfo);
		
		assertEquals(3,result);
	}
	

}
