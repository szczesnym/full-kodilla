package com.kodilla.hibernate.manytomany.facade;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Many2ManyWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Many2ManyWatcher.class);

    @Before("execution(* com.kodilla.hibernate.manytomany.facade.Many2ManyFacade.companiesWithNamesContainingParam(..))" + "&& args(companyName) && target(object)")
    public void logEventCompany(String companyName, Object object) {
        LOGGER.info("Logging the event for companiesWithNamesContainingParam");
        LOGGER.info("!!!!!!!!!!!Object" + object.getClass().getName() + ", Args: " + companyName);
    }

    @Before("execution(* com.kodilla.hibernate.manytomany.facade.Many2ManyFacade.employeesWithaNamesContaining(..))" + "&& args(employeeName) && target(object)")
    public void logEventEmployee(String employeeName, Object object) {
        LOGGER.info("Logging the event for employeesWithaNamesContaining");
        LOGGER.info("!!!!!!!!!!Object" + object.getClass().getName() + ", Args: " + employeeName);
    }

}


