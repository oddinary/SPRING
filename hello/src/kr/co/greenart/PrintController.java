package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// /print 주소 요청해서 text 입력가능 form으로 forward 시키기
// form.jsp submit 하면  "/print"를 POST로 요청 -> 입력한 text를 그대로 볼 수 있는 (view)print.jsp로 forward하기
@Controller
@RequestMapping(value="/print")
public class PrintController {
	@GetMapping
	public String form(){
		return "form";
	}
	@PostMapping
	public String print(@RequestParam(value="input") String param, Model model) {
	
		model.addAttribute("result", param);
		
		return "print";
	}
	
	@GetMapping("/sub")
	public @ResponseBody String sub() {
		return "/print/sub";
	}
}
