package com.kodlla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private final static String DAY_XPATH = "//select[1]";
    private final static String MONTH_XPATH = "//select[2]";
    private final static String YEAR_XPATH = "//select[3]";

    public static void main(String[] args) {
        //To select my birth date 03-06-1974

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        WebElement selectDayCombo = driver.findElement(By.xpath(DAY_XPATH));
        Select selectDay = new Select(selectDayCombo);
        selectDay.selectByValue("18");

        WebElement selectMonthCombo = driver.findElement(By.xpath(MONTH_XPATH));
        Select selectMonth = new Select(selectMonthCombo);
        selectMonth.selectByValue("12");

        WebElement selectYearCombo = driver.findElement(By.xpath(YEAR_XPATH));
        Select selectYear = new Select(selectYearCombo);
        selectYear.selectByValue("2007");
    }
}
