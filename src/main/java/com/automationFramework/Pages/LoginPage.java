package com.automationFramework.Pages;

import com.automationFramework.utility.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//h5[text()='Login']")
    private WebElement loginLbl;

    @FindBy (name = "username")
    private WebElement usernameIpt;

    @FindBy (name = "password")
    private WebElement passwordIpt;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    private WebElement submitBtn;

    @FindBy (xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardLbl;

    @FindBy (xpath = "//p[text()='Invalid credentials']")
    private WebElement invalidCredentialsMessage;

    public LoginPage(){
        System.out.println("Login const");
        PageFactory.initElements(driver,this);
    }

    public boolean isLabelVisible(){
        return loginLbl.isDisplayed();
    }

    public void enterCredentials(String userName, String password){
        BaseUtils.waitForElementToLoad(driver,usernameIpt);
        usernameIpt.sendKeys(userName);
        passwordIpt.sendKeys(password);
    }

    public void clickOnLoginButton(){
        submitBtn.click();
    }

    public boolean isDashboardVisible(){
        return dashboardLbl.isDisplayed();
    }

    public boolean isInvalidMessageDisplayed(){
        return invalidCredentialsMessage.isDisplayed();
    }

 public  void shadow(){
        driver.get("http://watir.com/examples/shadow_dom.html");
        
 }



 public void test(){
        driver.navigate().to("https://practice.expandtesting.com/tables");
      WebElement table =   driver.findElement(By.id("table1"));
     List<WebElement> headear = driver.findElements(By.id("header"));
     int i = -1;
     int indexOfLastName = -1;
     for(WebElement e: headear){
         if(e.getText().equals("Last Name")){
indexOfLastName = i+1;
         }
         i++;
     }
     System.out.println();
 }
}
