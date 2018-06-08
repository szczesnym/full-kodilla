package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    Employee johnSmith, stephanieClarckson, lindaKovalsky;
    Company softwareMachine, dataMaesters, greyMatter;

    @Before
    public void init() {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

    }

    @After
    public void cleanUp() throws Exception {
        //Clean UP
        companyDao.delete(softwareMachine);
        companyDao.delete(dataMaesters);
        companyDao.delete(greyMatter);
    }

    @Test
    public void testSaveManyToMany() {
        //Given
        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        int softwareMachineId = softwareMachine.getId();
        int dataMaestersId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();
        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        //Clean up
        companyDao.delete(softwareMachine);
        companyDao.delete(dataMaesters);
        companyDao.delete(greyMatter);
    }

    @Test
    public void testSearchCompanies() {
        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        List<Company> sutSoftwareCompanies = companyDao.firstThreeCharactersAreEqualParam("Sof");
        List<Company> sutDataCompanies = companyDao.firstThreeCharactersAreEqualParam("Dat");
        List<Company> sutGreyCompanies = companyDao.firstThreeCharactersAreEqualParam("Gre");
        //Then
        Assert.assertNotEquals(0, sutSoftwareCompanies.stream().count());
        sutSoftwareCompanies.stream().forEach(company -> Assert.assertTrue(company.getName().contains("Sof")));
        Assert.assertNotEquals(0, sutDataCompanies.stream().count());
        sutDataCompanies.stream().forEach(company -> Assert.assertTrue(company.getName().contains("Dat")));
        Assert.assertNotEquals(0, sutGreyCompanies.stream().count());
        sutGreyCompanies.stream().forEach(company -> Assert.assertFalse(company.getName().contains("Sof")));
        sutGreyCompanies.stream().forEach(company -> Assert.assertFalse(company.getName().contains("Dat")));
        sutGreyCompanies.stream().forEach(company -> Assert.assertTrue(company.getName().contains("Gre")));
    }

    @Test
    public void findEmployeesOfLastname() throws Exception {
        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        List<Employee> sutEmplyees1 = employeeDao.withLastnameOf("Smith");
        List<Employee> sutEmplyees2 = employeeDao.withLastnameOf("Clarckson");
        List<Employee> sutEmplyees3 = employeeDao.withLastnameOf("Kovalsky");
        //Then
        sutEmplyees1.stream().forEach(employee -> Assert.assertEquals("Smith", employee.getLastname()));
        sutEmplyees2.stream().forEach(employee -> Assert.assertEquals("Clarckson", employee.getLastname()));

        sutEmplyees3.stream().forEach(employee -> Assert.assertNotEquals("Smith", employee.getLastname()));
        sutEmplyees3.stream().forEach(employee -> Assert.assertNotEquals("Clarckson", employee.getLastname()));
        sutEmplyees3.stream().forEach(employee -> Assert.assertEquals("Kovalsky", employee.getLastname()));
        //Clean up
        employeeDao.delete(johnSmith);
        employeeDao.delete(stephanieClarckson);
        employeeDao.delete(lindaKovalsky);
    }
}
