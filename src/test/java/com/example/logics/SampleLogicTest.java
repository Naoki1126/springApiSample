package com.example.logics;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
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

	// テスト対象クラスの関数を一部モック化
	@Autowired
	@InjectMocks
	@Spy
	private SampleLogic sampleLogic;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		// インスタンスをBeanに設定
		doReturn((DiSample) applicationContext.getBean("Junit-test")).when(sampleLogic).createDiSample();
	}

	// Beanの確認目的
	@Test
	public void case001() {
		
		String info = sampleLogic.getDiSampleInfomation();
		System.out.println(info);
		doReturn("Mockで取得した結果です。").when(diSample).getProfile();

		String mockInfo = sampleLogic.getDiSampleInfomation();
		System.out.println(mockInfo);

		assertEquals("Mockで取得した結果です。", mockInfo);
	}

	// StaticメソッドのMock化を行う
	@Test
	public void case002() {

		// StaticメソッドのMock化
		try (MockedStatic<SampleLogic> mock = Mockito.mockStatic(SampleLogic.class)) {
			// YamadaメソッドをTanakaに書き換える   
			mock.when(() -> sampleLogic.getYamadaName()).thenReturn("Tanaka Takashi");
			//　対象メソッド
			System.out.println(sampleLogic.getYamadaName());
			// 対象外メソッド
			// 対象外メソッドの書き換えはされない
			System.out.println(sampleLogic.getYamadaAge());
		}
		// ブロック外は適用されない
		System.out.println(SampleLogic.getYamadaProfile());
		assertEquals("Yamada Taro", sampleLogic.getYamadaName());

	}

}
