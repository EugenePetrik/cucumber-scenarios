package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUsSteps {

    WebDriver driver;

    @Before()
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Given("I access webdriveruniversity contact us form")
    public void iAccessWebdriveruniversityContactUsForm() {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a valid first name")
    public void iEnterAValidFirstName() {
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("tom");
    }

    @When("I enter a valid last name")
    public void iEnterAValidLastName(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("webdriveruniversity@outlook.com");
    }

    @And("I enter comments")
    public void iEnterComments(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(1));
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("the information should successfully be submitted via the contact us form")
    public void theInformationShouldSuccessfullyBeSubmittedViaTheContactUsForm() {
        WebElement thanksContactUsPage = driver.findElement(By.xpath(".//*[@id='contact_reply']/h1"));

        String actualMessage = "thankyouforyourmessage!";
        String expectedMessage = thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", "");

        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
