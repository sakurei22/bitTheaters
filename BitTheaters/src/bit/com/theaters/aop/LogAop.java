package bit.com.theaters.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAop {
	
	@Around("withinbit.com.theaters.controller.*) or within(bit.com.theaters.dao.impl.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		try {
			System.out.println("loggerAOP : " + signatureStr + " 메소드가 실행되었습니다.");
			Object obj = joinpoint.proceed(); // 기능 실행
			return obj;
		} finally {
		}
	}
}
