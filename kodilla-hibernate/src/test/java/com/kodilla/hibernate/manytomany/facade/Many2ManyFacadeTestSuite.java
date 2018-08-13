package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    private Employee johnSmith, stephanieClarckson, lindaKovalsky;
    private Company softwareMachine, dataMaesters, greyMatter;
    private int initNumberOfCompanies, initNumberOfEmployees;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Before
    public void init() {
        initNumberOfEmployees = many2ManyFacade.employeesWithaNamesContaining("Ste").size();
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        initNumberOfCompanies = many2ManyFacade.companiesWithNamesContainingParam("Sof").size();
        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }


    @Test
    public void findCompanyWithName() {


        //When
        List<CompanyDto> listOfComapniesDto = many2ManyFacade.companiesWithNamesContainingParam("Sof");

        //Then
        Assert.assertEquals(initNumberOfCompanies + 1, listOfComapniesDto.size());
        Assert.assertEquals("Software Machine", listOfComapniesDto.get(0).getName());
    }

    @Test
    public void findEmployeeWithName() {
        //When
        List<EmployeeDto> listOfEmployeesDto = many2ManyFacade.employeesWithaNamesContaining("Ste");

        //Then
        Assert.assertEquals(initNumberOfEmployees + 1, listOfEmployeesDto.size());
        Assert.assertEquals("Stephanie", listOfEmployeesDto.get(0).getFirstname());
    }

    @After
    public void cleanUp() {
        companyDao.delete(softwareMachine);
        companyDao.delete(dataMaesters);
        companyDao.delete(greyMatter);

        employeeDao.delete(johnSmith);
        employeeDao.delete(stephanieClarckson);
        employeeDao.delete(lindaKovalsky);
    }
}
