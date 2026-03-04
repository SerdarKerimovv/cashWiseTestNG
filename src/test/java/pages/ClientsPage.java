package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

import java.util.List;
import java.util.Random;

public class ClientsPage extends BaseUI {
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    public ClientsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add client']")
    public WebElement addClientButton;

    @FindBy(xpath = "//h3[text()='Add client']/following-sibling::div//div//div//div[@class=' css-tlfecz-indicatorContainer']")
    public WebElement selectTag;

    @FindBy(xpath = "//div[@id='react-select-3-option-0']")
    public WebElement selectOneTagOption;

    @FindBy(xpath = "//button[text()='Create new tag']")
    public WebElement createNewTagLink;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    public WebElement saveNewTagButton;

    @FindBy(id = "name_tag_input_text")
    public WebElement newTagNameInput;

    @FindBy(id = "company_name_input_text")
    public WebElement companyNameInput;


    @FindBy(id = "client_name_input_text")
    public WebElement clientFullNameInput;

    @FindBy(id = "email_input_text")
    public WebElement clientEmailInput;

    @FindBy(id = "phone_number_input_text")
    public WebElement clientPhoneInput;

    @FindBy(id = "address_input_text")
    public WebElement clientAddressInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement clientSaveButton;


    public void addClient() {
        addClientButton.click();
        waitUntilClickable(10, selectTag);
        selectTag.click();

        List<WebElement> listOfClientTags = driver.findElements(By.xpath("//div[contains(@class,'-option')]"));
        int sizeOfClientTags = listOfClientTags.size();

        if (sizeOfClientTags >= 5  ) {
            int randomNumber = new Random().nextInt(sizeOfClientTags);          // create random number between 0 - size of list
            listOfClientTags.get(randomNumber).click();
        } else {
            createNewTagName();
            selectTag.click();
            selectOneTagOption.click();
        }

        companyNameInput.sendKeys(faker.company().bs());
        clientFullNameInput.sendKeys(faker.name().firstName() + " " + faker.name().lastName());
        clientEmailInput.sendKeys(faker.internet().emailAddress());
        clientPhoneInput.sendKeys(faker.phoneNumber().phoneNumber());
        clientAddressInput.sendKeys(faker.address().streetAddress());
        clientSaveButton.click();
    }

    /**
     * This method will create new tag name
     * if we have less than 20 tag names
     * we create new tag name by calling this method
     */
    public void createNewTagName() {
        createNewTagLink.click();
        newTagNameInput.sendKeys(faker.name().title());
        saveNewTagButton.click();
    }
}