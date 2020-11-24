package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class CrudAppTests {
    private static final String BASE_URL = "https://hubertb98.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input[1]";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        sleep(2000);

        return taskName;
    }

    private boolean deleteCrudAppTestTask(String taskName) throws InterruptedException {
        final String XPATH_TASK_NAME = ".//p[@class=\"datatable__field-value\"]";
        final String XPATH_TASK_ROW = "//form[@class=\"datatable__row\"]";
        final String XPATH_DELETE_BUTTON = ".//button[contains(text(),\"Delete\")]";
        boolean result = false;

        driver.switchTo().alert().accept();

        while (!driver.findElement(By.xpath(XPATH_DELETE_BUTTON)).isDisplayed()) ;

        driver.findElements(By.xpath(XPATH_TASK_ROW)).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(XPATH_TASK_NAME))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton =
                            theForm.findElement(By.xpath(XPATH_DELETE_BUTTON));
                    deleteButton.click();
                });

        sleep(2000);

        result = driver.findElements(By.xpath(XPATH_TASK_ROW)).stream()
                .noneMatch(anyForm -> anyForm.findElement(By.xpath(XPATH_TASK_NAME))
                        .getText().equals(taskName));
        return result;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        sleep(1000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("hubertb.98.hb@gmail.com");

        sleep(2000);

        driverTrello.findElement(By.id("login")).submit();

        sleep(2000);

        driverTrello.findElement(By.id("password")).sendKeys("trelloHaslo");
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();

        sleep(5000);

        driverTrello.findElement(By.xpath("//*[@id=\"content\"]//a/div")).click();

        sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        assertTrue(deleteCrudAppTestTask(taskName));
    }
}