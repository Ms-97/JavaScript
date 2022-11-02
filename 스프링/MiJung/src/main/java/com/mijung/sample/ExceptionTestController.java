package com.mijung.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mijung.sample.exception.SmokingException;

@Controller
@RequestMapping("/exception")
public class ExceptionTestController {

	@GetMapping("/test")
	public String testExp() {
		throw new SmokingException("담배피면 당근 안데영"); // 일부러 그냥 예외 던지깅
	}
	
	@GetMapping("/test2")
	public String test2Exp() {
		throw new NullPointerException("개발자는 NULL 너무 안 따랑해용");
	}

	@GetMapping("/test3")
	public String test3Exp() {
		throw new IllegalArgumentException("매개변수를 또옥바롱 너으삼");
	}

	
}
