package com.automationFramework.Pages;

import com.automationFramework.driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class  BasePage {
    protected WebDriver driver;

    public BasePage(){
        System.out.println("Base page");
        driver = DriverFactory.getDriver();
    }

}
