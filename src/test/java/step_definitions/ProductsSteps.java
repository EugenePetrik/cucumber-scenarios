package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProductsSteps {

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

    @Given("^user navigates to \"([^\"]*)\" website$")
    public void userNavigatesToWebsite(String url) {
        driver.get(url);
    }

    @When("user clicks on {string}")
    public void userClicksOn(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    @Then("user should be presented with a promo alert")
    public void userShouldBePresentedWithAPromoAlert() {
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}
