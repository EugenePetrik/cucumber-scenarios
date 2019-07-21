package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    private @FindBy(css = "#container-special-offers")
    WebElement buttonSpecialOffers;
    private @FindBy(id = "container-product2")
    WebElement buttonLaptops;
    private @FindBy(xpath = ".//*[@id='myModal']//b[contains(text(),'NEWCUSTOMER')]")
    WebElement voucherNumber;
    private @FindBy(xpath = "//button[text()='Proceed']")
    WebElement buttonProceedPopup;

    public ProductsPage() {
        super();
    }

    public ProductsPage clickOnProceedButtonPopup() {
        waitAndClickElement(buttonProceedPopup);
        return new ProductsPage();
    }

    public String printSpecialOffersVoucherCode() {
        waitUntilWebElementIsVisible(voucherNumber);
        String voucherNumberValue = voucherNumber.getText();
        System.out.println("Voucher Number: " + voucherNumberValue);
        return voucherNumberValue;
    }

}
