package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class RetrunTypesController {
	@GetMapping("/viewname")
	public String viewname() {
		return "hello";
	}
	@GetMapping(value="respbody", produces="text/plain; charset=utf-8")
	public @ResponseBody String body() {
		return "body내용";
	}
	// 모델과 뷰를 같이 반환하는 객체
	@GetMapping("/mv")
	public ModelAndView mv() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result","모델앤 뷰 객체로 설정");
		mv.setViewName("plusresult");
		
		return mv;
	}
	//<바디의 타입>이 들어간다.
	// 
	@GetMapping("/respentity")
	public ResponseEntity<String> entity() {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8").body("바디 내용");
		// 또는

//		String body = "바디 내용입니다.";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/plain; charset=utf-8");
//		ResponseEntity<String> en = new ResponseEntity<>(body,headers,HttpStatus.OK);

//		return en;
	}
	@GetMapping("/red")
	public String redirect() {
		return "redirect:/";
	}
}
