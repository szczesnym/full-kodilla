package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



import java.util.stream.Collectors;

public class CrudAppTestingApp {

    private static final String PAGES_LINK = "https://szczesnym.github.io/CrudFrontEnd/";
    private WebDriver driver;

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
        final String XPAHT_ADD_BUTTON = "/html/body/main/section[1]/form/fieldset[3]/button";

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        String taskName = "CrudAppTesting - name ->" + dateFormat.format(cal.getTime());
        String taskContent = "CrudAppTesting - content ->" + dateFormat.format(cal.getTime());

        WebElement addTaskNameFiled = driver.findElement(By.xpath(XPATH_TASK_NAME));
        addTaskNameFiled.sendKeys(taskName);

        WebElement addTaskContentFiled = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        addTaskContentFiled.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPAHT_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);
        return taskName;
    }

    private void removeTaskByName(String taskName) throws InterruptedException{
        driver.navigate().refresh();
        while ((!driver.findElement(By.xpath("//select[1]")).isDisplayed())) ;
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(formElement ->{
                    WebElement deleteButton = formElement.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                    });
    }


    private void sendTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        while ((!driver.findElement(By.xpath("//select[1]")).isDisplayed())) ;
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();

                });
        Thread.sleep(5000);
    }

    @Before
    public void init() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(PAGES_LINK);
    }

    @After
    public void close() {
        //driver.close();
    }


    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {

        String taskName = createCrudAppTestTask();
        System.out.println("Task name:" +taskName);
        //sendTaskToTrello(taskName);
        removeTaskByName(taskName);
    }

}
