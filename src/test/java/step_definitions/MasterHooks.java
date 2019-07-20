package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {

    @Before
    public void setUp() {
        driver = new DriverFactory().getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}
