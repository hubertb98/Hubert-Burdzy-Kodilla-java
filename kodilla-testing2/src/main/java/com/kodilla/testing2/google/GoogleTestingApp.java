package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q"; // By.name
    public static final String COOKIE_POLICY = "introAgreeButton"; // By.id
    public static final String KODILLA = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3"; // By.xpath

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://google.com/");

        Thread.sleep(4000);

        driver.switchTo().frame(0);
        WebElement cookiePolicy = driver.findElement(By.id(COOKIE_POLICY));
        cookiePolicy.click();

        Thread.sleep(1000);

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();

        Thread.sleep(2000);

        WebElement kodillaSite = driver.findElement(By.xpath(KODILLA));
        kodillaSite.click();
    }
}