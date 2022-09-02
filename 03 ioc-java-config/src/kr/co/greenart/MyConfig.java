package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.co.greenart")
public class MyConfig {
	@Bean
	// 리턴타입에 등록하고자 하는 정보를 입력해주고 bean의 이름은 메소드 이름으로 하면 된다.
	public List<Integer> myList() {
		return new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}
	
	@Bean
	public Set<Integer> mySet() {
		return new HashSet<>(Arrays.asList(1,2,3,4,5));
	}
}
