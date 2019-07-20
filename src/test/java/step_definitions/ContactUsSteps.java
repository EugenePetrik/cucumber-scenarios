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

import java.util.List;

public class ContactUsSteps extends DriverFactory {

    @Given("I access webdriveruniversity contact us form")
    public void iAccessWebdriveruniversityContactUsForm() {
        getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a valid first name")
    public void iEnterAValidFirstName() {
        getDriver().findElement(By.cssSelector("input[name='first_name']")).sendKeys("tom");
    }

    @When("I enter a valid last name")
    public void iEnterAValidLastName(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        getDriver().findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        getDriver().findElement(By.cssSelector("input[name='email']")).sendKeys("webdriveruniversity@outlook.com");
    }

    @And("I enter comments")
    public void iEnterComments(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        getDriver().findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(0));
        getDriver().findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(1));
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        getDriver().findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("the information should successfully be submitted via the contact us form")
    public void theInformationShouldSuccessfullyBeSubmittedViaTheContactUsForm() {
        WebElement thanksContactUsPage = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));

        String actualMessage = "thankyouforyourmessage!";
        String expectedMessage = thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", "");

        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
