package com.automationFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementPage extends BasePage{

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimBtn;

    @FindBy(xpath =  "//a[text()= 'Add Employee']")
    private WebElement addEmployeeTab;

    @FindBy(xpath =  "//a[text()= 'Employee List']/..")
    private WebElement employeeListTab;

    @FindBy(className = "orangehrm-card-container")
    private WebElement employeeFormDiv;

    @FindBy(xpath = "//div[normalize-space()='Employee Id']//input")
    private WebElement employeeIdIpt;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameIpt;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameIpt;

    @FindBy(xpath =  "//button[normalize-space() = 'Save']")
    private WebElement saveButton;

    @FindBy(css = ".orangehrm-edit-employee-name>h6")
    private WebElement employeeListFormLbl;

    public EmployeeManagementPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickOnPIM(){
        pimBtn.click();
    }

    public boolean isAddEmployeeButtonVisible(){
        return addEmployeeTab.isDisplayed();
    }

    public void clickAddEmployeeButton(){
            addEmployeeTab.click();
    }

    public boolean isEmployeeFormVisible(){
        return  employeeFormDiv.isDisplayed();
    }

    public void enterEmployeeDetails(String firstName,String lastName,String empid){
        firstNameIpt.sendKeys(firstName);
        lastNameIpt.sendKeys(lastName);
        employeeIdIpt.sendKeys(empid);

        clickOnSaveBtn();
    }

    public void clickOnSaveBtn(){
        saveButton.click();
    }

    public boolean verifyEmployeeListPageOpen(){
        return  employeeListTab.getAttribute("class").contains("visited");
    }

    public String  getCreatedUser(){
        driver.navigate().to("");

        Select dropdown = new Select(driver.findElement(By.id("dropdownId")));
        List<WebElement> options = dropdown.getOptions();
        List<String> optionTexts = new ArrayList<>();
        options.forEach(option->optionTexts.add(option.getText()));

        for (WebElement option : options) {
            optionTexts.add(option.getText()); // Store option text in a List
        }
        System.out.println(optionTexts);
        return employeeListFormLbl.getText();
    }

}
