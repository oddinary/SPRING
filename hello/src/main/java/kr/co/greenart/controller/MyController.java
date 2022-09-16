package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	// 아래와 같이 매번 같은 작업을 반복할때 필터를 활용하면 좋은데 필터는 요청 주소로 작동한다.
	// 하지만 스프링에서는 서블릿이 하나뿐이라 구현이 어려울 수 있음.
	// 그래서 주소를 컨트롤 하는 컨트롤러 전후에 끼어들어서 작업을 만들어 줄 수 있음.(인터셉터) 
	@GetMapping
	public String myView() {
		logger.info("사용자의 요청을 로깅합니다");
		return "myview";
	}
	@GetMapping("/{var}")
	public String myPathVar(@PathVariable String var) {
		logger.info("사용자의 요청을 로깅합니다");
		return "myview";
	}
	@GetMapping("/burn")
	public String burnAttr(HttpSession session) {
		logger.info("사용자의 요청을 로깅합니다");
		session.setAttribute("burn", "읽고 삭제하시오");
		return "myview";
	}
	
	@GetMapping("/null")
	public String nullExcep() {
		throw new NullPointerException("내가 발생시킨 널 포인터 익셉션");
	}
}
