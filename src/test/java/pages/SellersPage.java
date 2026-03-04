package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SellersPage {
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    public SellersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add seller']")
    public WebElement addSellerButton;

    @FindBy(id = "company_name_input_text")
    public WebElement titleInput;

    @FindBy(id = "seller_name_input_text")
    public WebElement sellerFullNameInput;

    @FindBy(id = "email_input_text")
    public WebElement sellerEmailInput;

    @FindBy(id = "phone_number_input_text")
    public WebElement sellerPhoneInput;

    @FindBy(id = "address_input_text")
    public WebElement sellerAddressInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement sellerSaveButton;

    @FindBy(xpath = "//td[last()]//button[1]")
    public WebElement firstEditSellerButton;

    @FindBy(xpath = "//h3[text()='Edit']/following::input[@id='company_name_input_text'][1]")
    public WebElement titleInputEdit;

    @FindBy(xpath = "//div[text()='Seller successfully edited']")
    public WebElement successfullyEditedMessage;

    public void addSeller() {
        addSellerButton.click();

        titleInput.sendKeys(faker.name().title());
        sellerFullNameInput.sendKeys(faker.name().fullName());
        sellerEmailInput.sendKeys(faker.internet().emailAddress());
        sellerPhoneInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerAddressInput.sendKeys(faker.address().streetAddress());

        sellerSaveButton.click();

    }

    public void clearAndType(WebElement element, String text) {
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public void editSellerInfo() {
        firstEditSellerButton.click();

        clearAndType(titleInput, faker.name().title());
        clearAndType(sellerFullNameInput, faker.name().fullName());
        clearAndType(sellerEmailInput, faker.internet().emailAddress());
        clearAndType(sellerPhoneInput, faker.phoneNumber().phoneNumber());
        clearAndType(sellerAddressInput, faker.address().streetAddress());

        sellerSaveButton.click();
    }
}