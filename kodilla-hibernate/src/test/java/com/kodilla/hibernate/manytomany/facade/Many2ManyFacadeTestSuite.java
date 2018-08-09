package com.kodilla.hibernate.manytomany.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class Many2ManyFacadeTestSuite {
    @Autowired
    Many2ManyFacade many2ManyFacade;

    @Test
    public void findCompanyWithName() {
        //When
        List<CompanyDto> listOfComapniesDto = many2ManyFacade.companiesWithNamesContainingParam("Sof");

        //Then
        Assert.assertEquals(1, listOfComapniesDto.size());
        Assert.assertEquals("Software Machine",listOfComapniesDto.get(0).getName());
    }

    @Test
    public void findEmployeeWithName() {
        //When
        List<EmployeeDto> listOfEmployeesDto = many2ManyFacade.employeesWithaNamesContaining("Ste");

        //Then
        Assert.assertEquals(1, listOfEmployeesDto.size());
        Assert.assertEquals("Stephanie",listOfEmployeesDto.get(0).getFirstname());
    }
}
