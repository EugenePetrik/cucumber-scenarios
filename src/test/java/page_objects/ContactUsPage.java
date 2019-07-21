package page_objects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactUsPage extends BasePage {

    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement textFieldFirstName;
    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement textFieldLastName;
    private @FindBy(xpath = "//input[@name='email']")
    WebElement textFieldEmailAddress;
    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement textFieldMessage;
    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement buttonSubmit;

    public ContactUsPage() {
        super();
    }

    public ContactUsPage getContactUsPage() {
        getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        return new ContactUsPage();
    }

    public ContactUsPage enterFirstName(String firstName) {
        sendKeysToWebElement(textFieldFirstName, firstName);
        return new ContactUsPage();
    }

    public ContactUsPage enterLastName(DataTable dataTable, int row, int column) {
        List<List<String>> data = dataTable.asLists();
        sendKeysToWebElement(textFieldLastName, data.get(row).get(column));
        return new ContactUsPage();
    }

    public ContactUsPage enterEmailAddress(String emailAddress) {
        sendKeysToWebElement(textFieldEmailAddress, emailAddress);
        return new ContactUsPage();
    }

    public ContactUsPage enterComments(DataTable dataTable, int row, int column) {
        List<List<String>> data = dataTable.asLists();
        sendKeysToWebElement(textFieldMessage, data.get(row).get(column));
        return new ContactUsPage();
    }

    public ContactUsPage clickOnSubmiButton() {
        waitAndClickElement(buttonSubmit);
        return new ContactUsPage();
    }

}
