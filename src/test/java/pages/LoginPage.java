package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class LoginPage {
    WebDriver driver = Driver.getDriver();

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButtonOption;

    @FindBy(id = "email_input_text")
    public WebElement emailInput;

    @FindBy(id = "password_input_text")
    public WebElement passwordInput;

    @FindBy(xpath = "//h3[text()='Sign in']/following::button[@type='submit']")
    public WebElement signInButton;




    public void login(String email, String password) {
        String loginPageUrl = "https://cashwise.us/main?showLogin=false";
        driver.get(loginPageUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(signInButtonOption));
        signInButtonOption.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}