package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE_POLICY = "//*[@id=\"u_0_h\"]";
    public static final String XPATH_NEW_ACCOUNT = "//*[@id=\"u_0_2\"]";
    public static final String XPATH_FIRSTNAME = "//*[@name=\"firstname\" or @id=\"u_2_b\"]";
    public static final String XPATH_LASTNAME = "//*[@name=\"lastname\"]";
    public static final String XPATH_PHONE = "//*[@name=\"reg_email__\"]";
    public static final String XPATH_PASSWORD = "//*[@id=\"password_step_input\"]";
    public static final String XPATH_MONTH = "//*[@id=\"month\"]";
    public static final String XPATH_DAY = "//*[@id=\"day\"]";
    public static final String XPATH_YEAR = "//*[@id=\"year\"]";
    public static final String XPATH_MALE_GENDER = "//*[@id=\"u_2_o\"]/span[2]/label";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIE_POLICY)).isDisplayed()) ;
        WebElement cookie = driver.findElement(By.xpath(XPATH_COOKIE_POLICY));
        cookie.click();

        WebElement newAccount = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccount.click();

        Thread.sleep(3000);
        WebElement firstname = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstname.sendKeys("Hubert");

        WebElement lastname = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastname.sendKeys("Burdzy");

        WebElement email = driver.findElement(By.xpath(XPATH_PHONE));
        email.sendKeys("123456789");

        WebElement password = driver.findElement(By.xpath(XPATH_PASSWORD));
        password.sendKeys("Test1234");

        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("9");

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByValue("10");

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1998");

        WebElement gender = driver.findElement(By.xpath(XPATH_MALE_GENDER));
        gender.click();
    }
}
