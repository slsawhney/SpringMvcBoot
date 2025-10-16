package com.foodelthy.springmvcboot.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect
{
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before( "execution(* com.foodelthy.springmvcboot.api.student.StudentRestController.*(..))") // All methods
    //@Before( "execution(public * com.foodelthy.springmvcboot.api.student.StudentRestController.getStudents())") // Specific method
    public void logBefore()
    {
        LOGGER.info("LoggingAspect: Logging a method call");
    }

    @AfterReturning( "execution(* com.foodelthy.springmvcboot.api.student.StudentRestController.*(..))")
    public void logAfter()
    {
        LOGGER.info("LoggingAspect: Method call completed");
    }
}
