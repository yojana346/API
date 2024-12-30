package com.automationFramework.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver(String browser) {
         browser = System.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println(browser + " is not a valid browser!! Pass correct browser.");
                break;
        }
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .pollingEvery(Duration.ofMillis(200))
//                .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("test"))));
//driver.findElement(RelativeLocator.with(By.id("id")).above(driver.findElement(By.id("sd"))));
        File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destination = new File("full_page_screenshot.png");
        try {
            FileUtils.copyFile(pic,destination);
        } catch (IOException e) {

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }


    public static  WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
