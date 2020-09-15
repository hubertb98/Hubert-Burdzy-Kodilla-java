package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchingFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SearchingFacade searchingFacade;

    @Test
    public void testSearchingFacadeCompanyName() throws SearchingException {
        Employee johnSmith = new Employee("John", "Smith");
        Company softwareMachine = new Company("SoftwareMachine");
        softwareMachine.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        List<Company> companies = searchingFacade.processCompanySearch(companyDao, "sof");

        try {
            Assert.assertEquals(1, companies.size());
        } finally {
            companyDao.deleteAll();
        }
    }

    @Test
    public void testSearchingFacadeEmployeeName() throws SearchingException {
        Employee johnSmith = new Employee("John", "Smith");
        Company softwareMachine = new Company("SoftwareMachine");
        softwareMachine.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(softwareMachine);

        employeeDao.save(johnSmith);
        List<Employee> employees = searchingFacade.processEmployeeSearch(employeeDao, "Smith");

        try {
            Assert.assertEquals(1, employees.size());
        } finally {
            employeeDao.deleteAll();
        }
    }
}