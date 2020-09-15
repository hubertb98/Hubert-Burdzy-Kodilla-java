package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);

    public List<Company> processCompanySearch(CompanyDao companyDao, String firstThreeLetters)
            throws SearchingException {
        boolean wasError = false;
        if (firstThreeLetters.length() != 3) {
            LOGGER.error(SearchingException.ERR_NOT_THREE_LETTERS);
            throw new SearchingException(SearchingException.ERR_NOT_THREE_LETTERS);
        }

        List<Company> companies =
                companyDao.retrieveCompanyNameBeginningWith(firstThreeLetters);
        try {
            LOGGER.info("Beginning a search with phrase: " + firstThreeLetters);
            if (companies.size() < 0) {
                LOGGER.error("There are no companies that match the search phrase: " + firstThreeLetters,
                        SearchingException.ERR_COMPANY_NOT_FOUND);
                wasError = true;
                throw new SearchingException(SearchingException.ERR_COMPANY_NOT_FOUND);
            }
            for (Company company : companies) {
                LOGGER.info("Company that matches the search phrase: " + company.getName());
            }
        } finally {
            if (wasError) {
                LOGGER.info("Company is not found");
            }
        }
        return companies;
    }

    public List<Employee> processEmployeeSearch(EmployeeDao employeeDao, String employeeLastName)
            throws SearchingException {
        boolean wasError = false;
        if (employeeLastName.length() < 3) {
            LOGGER.error(SearchingException.ERR_NOT_ENOUGH_LETTERS);
            throw new SearchingException(SearchingException.ERR_NOT_ENOUGH_LETTERS);
        }

        List<Employee> employeeWithGivenLastName =
                employeeDao.retrieveEmployeeWithGivenLastname(employeeLastName);
        try {
            LOGGER.info("Beginning a search with phrase: " + employeeLastName);
            if (employeeWithGivenLastName.size() < 0) {
                LOGGER.error("There are no companies that match the search phrase: " + employeeLastName,
                        SearchingException.ERR_EMPLOYEE_NOT_FOUND);
                wasError = true;
                throw new SearchingException(SearchingException.ERR_EMPLOYEE_NOT_FOUND);
            }
            for (Employee employee : employeeWithGivenLastName) {
                LOGGER.info("Company that matches the search phrase: " + employee.getFirstName() + " " +
                        employee.getListName());
            }
        } finally {
            if (wasError) {
                LOGGER.info("Employee is not found");
            }
        }
        return employeeWithGivenLastName;

    }


}
