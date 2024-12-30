package epam.bdd_StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.epam.Account;
import org.epam.CashMachine;
import org.testng.Assert;

public class WithdrawCashStepDefinition {

    private Account account;
    private CashMachine cashMachine;

    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_$_in_my_account(int initialBalance) {
      account = new Account(initialBalance);//setting initial amount
      cashMachine = new CashMachine(account);//pass the account to cashmachine
    }

    @When("^I request \\$(.*)$")
    public void i_request(Integer amountToWithdraw) {
        cashMachine.withDraw(amountToWithdraw);
    }

    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(int amountDispensed) {
        Assert.assertEquals(cashMachine.getCashDispensed(),amountDispensed);
    }
}
