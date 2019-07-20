package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;

    public WebDriver getDriver() {
        try {
            // Read Config
            ReadConfigFile file = new ReadConfigFile();
            String browserName = file.getBrowser();

            switch (browserName) {
                case "chrome":
                    if (null == driver) {
                        ChromeOptions options = new ChromeOptions();
                        driver = new ChromeDriver(options);
                    }
                    break;

                case "firefox":
                    if (null == driver) {
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        capabilities.setCapability("marionette", true);
                        driver = new FirefoxDriver();
                    }
                    break;

                case "chromeheadless":
                    if (null == driver) {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        driver = new ChromeDriver(chromeOptions);
                    }
                    break;

                case "firefoxheadless":
                    if (null == driver) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setBinary(firefoxBinary);
                        driver = new FirefoxDriver(firefoxOptions);
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unable to load browser " + e.getMessage());
        } finally {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        return driver;
    }

}
