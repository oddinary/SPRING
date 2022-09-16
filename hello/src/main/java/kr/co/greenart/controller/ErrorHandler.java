package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러 전역에 대해 반복적으로 일어나는 일을 정의하는 컴포넌트
// 모든 컨트롤러에서 발생하는 에러를 처리하지만 특정 컨트롤러에서 발생하는 에러를 처리하는 경우
// annotations : 해당 어노테이션이 붙어있는 컨트롤러
// basePackages : 적혀있는 패키지 내부에만 적용되는 
@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다. ㅎㅎ ㅈㅅ" + ex.getMessage());
		return "errorpage";
	}
}
