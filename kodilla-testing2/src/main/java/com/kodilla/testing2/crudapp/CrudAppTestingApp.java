package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrudAppTestingApp {
    private static final String SEARCH_XPATH ="//input";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://szczesnym.github.io/HtmlFrontEnd/index-heroku.html");

        WebElement searchFiled = driver.findElement(By.xpath(SEARCH_XPATH));
        searchFiled.sendKeys("first");
        searchFiled.submit();
    }

}
