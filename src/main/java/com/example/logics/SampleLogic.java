package com.example.logics;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.DiSample;

@Service
public class SampleLogic {
	
	private final String NAME = "SampleLogicです";
	
	private final int AGE = 22; 
	
	public int calcAdd(int num, int num2) {
		return num + num2;
	}
	
	public int calcMinus(int num, int num2) {
		return num - num2;
	}
	
	public String showMessage(int num) {
		if ( num > 10) {
			return "数字は10より大きいです";
		}
		return "数字は10未満です";
	}
	
	public String getDiSampleInfomation() {
		DiSample ds = createDiSample();
		return ds.getProfile();
	}
	
	@Bean("Junit-test")
	public DiSample createDiSample() {
		return new DiSample(NAME, AGE);
	}
	
}
