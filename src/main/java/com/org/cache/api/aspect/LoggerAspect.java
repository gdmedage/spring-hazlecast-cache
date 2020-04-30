package com.org.cache.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logger Aspect. It will log all method execution of any class that is annotated with @Loggable.
 * 
 */
@Aspect
@Component
public class LoggerAspect {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(LoggerAspect.class);

  /**
   * Point cut for before method execution of method having @Loggable annotation. Just logs starting
   * of method execution.
   *
   * @param joinPoint the join point
   */
  @Before("@annotation(Loggable)")
  public void beforeStartMethod(JoinPoint joinPoint) {
    LOG.debug("Starting method : {}", joinPoint);
  }

  /**
   * Point cut for after method execution of @Loggable annotation. Just logs completed of method
   * execution.
   *
   * @param joinPoint the join point
   */
  @After("@annotation(Loggable)")
  public void afterStartMethod(JoinPoint joinPoint) {
    LOG.debug("Completed method : {}", joinPoint);
  }
}
