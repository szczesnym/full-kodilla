package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.fac(..))" + "&& args(theNumber) && target(object)")
    public void logEvent(double theNumber, Object object) {
        LOGGER.info("Logging the event");
        LOGGER.info("Object" + object.getClass().getName() + ", Args: " + theNumber);
    }
}
