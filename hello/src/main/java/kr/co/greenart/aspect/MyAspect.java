package kr.co.greenart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	// 포인트 컷 작성 문법 : 접근제한자 리턴타입 패키지.클래스.메소드(파라미터)
	// * : 모든 접근 제한자, 모든 리턴타입
	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {}
	
	//이 어노테이션이 붙어있는 모든 클래스의 모든 메소드
	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repository() {}
	
	// 특정 메소드가 실행되기 전과 후로
	@Around("repository()")
	// joinpoint
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable{
		//실행 전
		long start = System.nanoTime();
		logger.info("시작시간" + start);
		//실제 실행 (앞과 뒤에 적어준대로 실행된다)
		Object proceed = jp.proceed();
		//실행 후
		long end = System.nanoTime();
		logger.info("종료시간" + end);
		
		logger.info(jp.getSignature().getName() + " 메소드의 실행시간 : " + (end - start));
		return proceed;
	}
	
	@Before("print()")
	public void printBefore() {

	}

	@After("print()")
	public void printAfter() {

	}

	
//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printBefore() {
//		logger.info("--- 파일 목록을 불러오기 전에 실행됩니다. ---");
//	}
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printAfter() {
//		logger.info("--- 파일 목록을 불러온 후에 실행됩니다. ---");
//	}
}
