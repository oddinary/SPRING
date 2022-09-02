package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("setRepo")
//@Primary 우선적으로 적용하게 설정해주기
public class MySetRepository implements MyDataRepository{
	@Autowired
	private Set<Integer> set;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		
		return set;
	}
	
}
