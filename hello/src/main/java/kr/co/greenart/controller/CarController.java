package kr.co.greenart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@Controller
@RequestMapping("/car")
@ResponseBody
public class CarController {	
	@Autowired
	private CarService service;

	// 뷰가 아닌 원하는 텍스트를 바로 보내는 방식 
	@GetMapping
	public List<Car> view() {
		
		return service.list();
	}
	// 또는 이런 방식
//	@GetMapping
//	public ResponseEntity<String> view() {
//		return "view name";
//	}
	// {PathVariable} : 경로를 변수처럼 사용할 수 있음
	@GetMapping("/{id}")
	public Car carById(@PathVariable int id) {
		return service.getById(id);
	}
	
	// json으로 형식을 받아서 db에 넣어보자
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		service.add(car);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
	
	// 수정은 보통 post나 put방식으로 한다.
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
}
