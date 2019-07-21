package runners;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import page_objects.BasePage;

import java.io.File;
import java.io.IOException;

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
        @AfterClass
        public static void writeExtentReport() throws IOException {
                Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + File.separator +
                        "src" + File.separator +
                        "main" + File.separator +
                        "java" + File.separator +
                        "utils" + File.separator +
                        "ReportsConfig.xml"));
                BasePage.copyLatestExtentReport();
        }
}
