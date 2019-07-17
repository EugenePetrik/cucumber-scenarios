package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        // Features files location
        features = "src/test/java/features/",
        // Steps files location
        glue = "step_definitions",
        monochrome = true,
        // Run scenarios with specific tags
        tags= {},
        dryRun = true,
        // Generate reports
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"
        }

)

public class MainRunner extends AbstractTestNGCucumberTests {
}
