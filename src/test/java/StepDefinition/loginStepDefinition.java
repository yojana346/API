package StepDefinition;

import com.automationFramework.Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;
import java.util.Map;


public class loginStepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the OrangeHRM login page")
    public void user_is_on_the_orange_hrm_login_page() {
        Assert.assertTrue(loginPage.isLabelVisible());
    }

    @When("^the user enters (.*) and (.*)$")
    public void theUserEntersUserNameAndPassword(String userName, String password) {
        loginPage.enterCredentials(userName, password);
        loginPage.clickOnLoginButton();
    }

    @Then("^the user should see the dashboard$")
    public void the_user_should_see_the_dashboard() {
            Assert.assertTrue(loginPage.isDashboardVisible(),"Dashboard should be visible for admin");
    }

    @Then("the user should see invalid user message")
    public void theUserShouldSeeInvalidUserMessage(DataTable dataTable) {
        List<Map<String ,String>> map = dataTable.asMaps();
        map.get(0).get("city");
        Assert.assertTrue(loginPage.isInvalidMessageDisplayed());
    }

    @When("User enter credential")
    public void userEnterCredential(DataTable table) {
        List<List<String>> credTable = table.asLists(String.class);
        loginPage.enterCredentials(credTable.get(0).get(0), credTable.get(0).get(1));
        loginPage.clickOnLoginButton();
    }
}
