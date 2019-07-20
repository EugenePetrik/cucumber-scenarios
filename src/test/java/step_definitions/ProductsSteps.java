package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import utils.DriverFactory;

public class ProductsSteps extends DriverFactory {

    @Given("^user navigates to \"([^\"]*)\" website$")
    public void userNavigatesToWebsite(String url) {
        getDriver().get(url);
    }

    @When("user clicks on {string}")
    public void userClicksOn(String locator) {
        getDriver().findElement(By.cssSelector(locator)).click();
    }

    @Then("user should be presented with a promo alert")
    public void userShouldBePresentedWithAPromoAlert() {
        getDriver().findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}
