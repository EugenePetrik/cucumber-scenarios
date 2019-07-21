package step_definitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import page_objects.BasePage;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {

    @Before
    public void setUp() {
        driver = new DriverFactory().getDriver();
    }

    @After
    public void tearDownAndScreenshotOnFailure(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                BasePage.captureScreenshot();
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Method has failed: tearDownAndScreenshotOnFailure, Exception " + e.getMessage());
        }

    }

}
