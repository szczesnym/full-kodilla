package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableAspectJAutoProxy
public class Many2ManyFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<CompanyDto> companiesWithNamesContainingParam(String companyNameParam) //throws CompanyException, EmployeeException
    {
        List<CompanyDto> listOfCompanies = new ArrayList<>();
        List<Company> companies = companyDao.findByNameContaining(companyNameParam);
        //withNamesContainsParam - do dyskusji na telco
        if (companies.isEmpty()) {
            //throw new CompanyException(CompanyException.WRN_NOT_FOUND); - do dyskusji na telco

        } else {
            companies.stream()
                    .forEach(company -> listOfCompanies.add(new CompanyDto(company.getId(), company.getName())));
        }
        return listOfCompanies;
    }

    public List<EmployeeDto> employeesWithaNamesContaining(String nameParam) {
        List<EmployeeDto> listOfEmployees = new ArrayList<>();
        List<Employee> employees = employeeDao.findByFirstnameContaining(nameParam);
        if (employees.isEmpty()) {

        } else {
            employees.stream()
                    .forEach(emp -> listOfEmployees.add(new EmployeeDto(emp.getId(), emp.getFirstname(), emp.getLastname())));
        }
        return listOfEmployees;
    }
}
