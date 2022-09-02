package kr.co.greenart;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
	@GetMapping(value="/??.two", produces="text/plain; charset=utf-8")
	public @ResponseBody String two() {
		return "두글자 매핑";
	}
	@GetMapping(value="/*.do", produces="text/plain; charset=utf-8")
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}
//	@GetMapping(value="/*.do", produces="application/json; charset=utf-8")
//	public @ResponseBody String doURI() {
//		return "do로 끝나는 매핑";
//	}
	// com이라는 파라미터가 필수로 val이라는 값을 가지게 만들수 있다.(정규식으로 값을 정해줄수 있다.)
	@GetMapping(value="/ppp", params="com=val", produces="text/plain; charset=utf-8")
	public @ResponseBody String ppp() {
		return "ppp";
	}
	// 값이 없을 경우 "default"를 넣어주게 한다.
	@GetMapping(value="/qqq", params="com", produces="text/plain; charset=utf-8")
	public @ResponseBody String qqq(@RequestParam(defaultValue = "default") String com) {
		return com;
	}
	// header는 이름,값이 쌍으로 있어야 한다. 
	@GetMapping(value="/ggg", params="com", produces="text/plain; charset=utf-8")
	public @ResponseBody String ggg(@RequestParam(defaultValue = "default") String com) {
		return com;
	}
	//!com : com이라는 파라미터가 없어야 한다.
	@GetMapping(value="/ggg", params="!com", produces="text/plain; charset=utf-8")
	public @ResponseBody String notggg(@RequestParam(defaultValue = "default") String com) {
		return com;
	}
}
