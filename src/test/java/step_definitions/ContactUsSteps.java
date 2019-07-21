package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {

    @Given("I access webdriveruniversity contact us form")
    public void iAccessWebdriveruniversityContactUsForm() {
        contactUsPage.getContactUsPage();
    }

    @When("I enter a valid first name")
    public void iEnterAValidFirstName() {
        contactUsPage.enterFirstName("Tom");
    }

    @When("I enter a valid last name")
    public void iEnterAValidLastName(DataTable dataTable) {
        contactUsPage.enterLastName(dataTable, 0, 1);
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        contactUsPage.enterEmailAddress("webdriveruniversity@outlook.com");
    }

    @And("I enter comments")
    public void iEnterComments(DataTable dataTable) {
        contactUsPage.enterComments(dataTable, 0, 1);
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        contactUsPage.clickOnSubmiButton();
    }

    @Then("the information should successfully be submitted via the contact us form")
    public void theInformationShouldSuccessfullyBeSubmittedViaTheContactUsForm() {
        contactFormThankYouPage.confirmContactUsFormSubmissionWasSuccessful();
    }

}
