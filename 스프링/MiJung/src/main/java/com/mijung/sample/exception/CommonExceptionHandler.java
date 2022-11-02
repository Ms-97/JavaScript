package com.mijung.sample.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

	// Controller마다 Exception처리가 들어 있는겡 괘니 누네 마니 거슬림
	@ExceptionHandler(SmokingException.class)
	public String smokeHandler(SmokingException se, Model model) {
		model.addAttribute("exception", se);
		return "exp";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullHandler(NullPointerException ne, Model model) {
		model.addAttribute("exception", ne);
		return "exp";
	}
	
	// 핵심 예외 아닌 거 퉁 치깅
	@ExceptionHandler(Exception.class)
	public String finalHandler(Exception ec, Model model) {
		log.debug("딘짜 요기로 와용");
		model.addAttribute("exception", ec);
		return "exp";
	}
		
}
