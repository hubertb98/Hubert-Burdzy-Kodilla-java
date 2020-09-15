package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("SoftwareMachine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(dataMaesters);
        stephanieClarckson.getCompanies().add(dataMaesters);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteAll();
            employeeDao.deleteAll();
        } catch (Exception e) {

        }
    }

    @Test
    public void testFindEmployeesByLastname() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee thomasHardy = new Employee("Thomas", "Hardy");
        Employee hannaSmith = new Employee("Hanna", "Smith");
        Employee diegoRoel = new Employee("Diego", "Roel");
        Employee helenBennett = new Employee("Helen", "Bennett");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(thomasHardy);
        employeeDao.save(hannaSmith);
        employeeDao.save(diegoRoel);
        employeeDao.save(helenBennett);

        List<Employee> employeesByLastname = employeeDao.retrieveEmployeeWithGivenLastname("Smith");

        try {
            Assert.assertEquals(2, employeesByLastname.size());
        } finally {
            employeeDao.deleteAll();
        }
    }

    @Test
    public void testFindCompaniesByFirstThreeLetter() {
        Company softwareMachine = new Company("SoftwareMachine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company apple = new Company("Apple");
        Company google = new Company("Google");
        Company softwareHouses = new Company("SoftwareHouse");
        Company pcProject = new Company("PC Project");
        Company helion = new Company("Helion");
        Company facebook = new Company("Facebook");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        companyDao.save(apple);
        companyDao.save(google);
        companyDao.save(softwareHouses);
        companyDao.save(pcProject);
        companyDao.save(helion);
        companyDao.save(facebook);

        List<Company> companiesBeginningWith = companyDao.retrieveCompanyNameBeginningWith("sof");

        try {
            Assert.assertEquals(2, companiesBeginningWith.size());
        } finally {
            companyDao.deleteAll();
        }
    }
}
