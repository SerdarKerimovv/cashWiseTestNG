package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

public class UpdateProfilePage extends BaseUI {

    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    public UpdateProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='css-omke5m']//p")
    public WebElement expandProfileMenu;

    @FindBy(xpath = "//li[text()='Profile']")
    public WebElement profileLink;

    @FindBy(id = "first_name_input_text")
    public WebElement firstNameInput;

    @FindBy(id = "last_name_input_text")
    public WebElement lastNameInput;

    @FindBy(id = "address_input_text")
    public WebElement addressInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    /*
    This method will update profile which is following info
        - userName
        - lastName
        - address
     */
    public void updateProfile() {
        expandProfileMenu.click();
        profileLink.click();

        clearAndSendKeys(firstNameInput, faker.name().firstName());
        clearAndSendKeys(lastNameInput, faker.name().lastName());
        clearAndSendKeys(addressInput, faker.address().streetAddress());

        saveButton.click();
    }
}
