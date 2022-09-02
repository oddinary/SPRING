package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	@Qualifier("setRepo") // 해당 구현체를 알아서 찾아줄 수 있도록 고유한 아이디 값을 적어주기
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService(){
		return repo.getMyNumbers();
	}
}
