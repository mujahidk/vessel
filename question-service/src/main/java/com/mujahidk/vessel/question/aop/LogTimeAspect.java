package com.mujahidk.vessel.question.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTimeAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogTimeAspect.class);

	@Around("@annotation(com.mujahidk.vessel.question.aop.LogTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		final long startTime = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		final long endTime = System.currentTimeMillis() - startTime;

		logger.info("Method {} took [time: {}ms]", joinPoint.toShortString(), endTime);
		return result;
	}

}
