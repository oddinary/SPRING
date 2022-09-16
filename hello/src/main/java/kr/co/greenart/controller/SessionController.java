package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value="/session", produces = "text/plain; charset=utf-8")
// 리퀘스트와 세션의 중간 정도의 스코프를 가지고 있다.
// 모델 객체를 세션처럼 사용할 때 사용하는 어노테이션
@SessionAttributes("modelname")
@ResponseBody
public class SessionController {
	@GetMapping("/add")
	// 세션을 달라고 하면 줌
	public String addSessionValue(HttpSession session) {
		session.setAttribute("myname", "myvalue");
		return "세션에 값 설정";
	}
	
	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {
		return (String) session.getAttribute("myname");
	}
	
	@GetMapping("/model")
	public String addModelValue(Model model) {
		model.addAttribute("modelname","modelvalue");
		return "모델에 값 설정";
	}
	@GetMapping("/modelcheck")
	public String getModleValue(Model model) {
		return (String) model.getAttribute("modelname");
	}
	
	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete();
		return "세션 어트리뷰트 삭제 되었음";
	}
	
}
