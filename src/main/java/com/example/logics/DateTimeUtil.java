package com.example.logics;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {
	public static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}
}
