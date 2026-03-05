package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DeleteProfilePage {
    WebDriver driver = Driver.getDriver();

    public DeleteProfilePage() {
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

    @FindBy(xpath = "//button[text()='Delete account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement confirmDeleteButton;

    /*
    This method will delete profile
     */
    public void deleteProfile() {
        expandProfileMenu.click();
        profileLink.click();
        deleteAccountButton.click();
        confirmDeleteButton.click();
    }
}
