package StepDefinition;

import com.automationFramework.Pages.EmployeeManagementPage;
import com.automationFramework.utility.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmployeeManagementSteps {
    EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage();

    @And("navigates to the PIM section")
    public void navigatesToTheSection() {
        employeeManagementPage.clickOnPIM();
    }

    @When("the user clicks the Add Employee button")
    public void theUserClicksTheButton() {
        Assert.assertTrue(employeeManagementPage.isAddEmployeeButtonVisible(),
                "Add Employee button not visible");
        employeeManagementPage.clickAddEmployeeButton();
        Assert.assertTrue(employeeManagementPage.isEmployeeFormVisible());
    }


    @Then("user redirected to the employee list page and user name displayed")
    public void userRedirectedToTheEmployeeListPageAndUserNameDisplayed() {
        employeeManagementPage.verifyEmployeeListPageOpen();
    }

    @And("user fills the form using sheet name {string} and row number {int}")
    public void
    userFillsTheFormUsingSheetNameAndRowNumber(String sheetname, int rownumber)
            throws IOException, InvalidFormatException {

        //Reading data from excel
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> employeeDetails = excelReader.getData(
                "src/test/resources/testData/EmployeeDetails.xlsx",
                sheetname);
        Random random = new Random();
        int digit1 = random.nextInt(10); // This generates a number between 0 and 9
        int digit2 = random.nextInt(10); // This does the same for the second digit
        String result = String.format("%d%d", digit1, digit2);

        String firstname = employeeDetails.get(rownumber).get("Firstname");
        String lastName = employeeDetails.get(rownumber).get("Lastname");
        String empID = employeeDetails.get(rownumber).get("EmpID") + result;
        employeeManagementPage.enterEmployeeDetails(firstname, lastName, empID);
    }

    @Given("shadow")
    public void shadow() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();

    }
}
