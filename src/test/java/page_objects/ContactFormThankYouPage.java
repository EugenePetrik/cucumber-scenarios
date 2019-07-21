package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactFormThankYouPage extends BasePage {

    private @FindBy(xpath = ".//*[@id='contact_reply']/h1")
    WebElement thankYouMessage;

    public ContactFormThankYouPage() {
        super();
    }

    public ContactFormThankYouPage confirmContactUsFormSubmissionWasSuccessful() {
        waitUntilWebElementIsVisible(thankYouMessage);

        String actualText = "thankyouforyourmessage!";
        String expectedText = thankYouMessage.getText().toLowerCase().replaceAll("[ ()0-9]", "");
        Assert.assertEquals(actualText, expectedText);
        return new ContactFormThankYouPage();
    }

}
