package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SignupPage {

    WebDriver driver = Driver.getDriver();

    public SignupPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement signUpButtonOption;

    @FindBy(id = "email_input_text")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='password_input_text' and @name='password']")
    public WebElement passwordInput;

    @FindBy(id = "repeat_password_input_text")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement continueButton;

    @FindBy(id = "first_name_input_text")
    public WebElement firstNameInput;

    @FindBy(id = "last_name_input_text")
    public WebElement lastNameInput;

    @FindBy(id = "company_name_input_text")
    public WebElement companyNameInput;

    @FindBy(xpath = "(//div[@class='MuiFormControl-root css-eh6m7v']//div//div[@role='button'])[1]")
    public WebElement areaOfBusiness;

    @FindBy(xpath = "//li[text()='Manufacturing & Production']")
    public WebElement manufacturingProductOption;

    @FindBy(id = "address_input_text")
    public WebElement addressInput;

    @FindBy(xpath = "(//div[@class='MuiFormControl-root css-eh6m7v']//div//div[@role='button'])[2]")
    public WebElement selectCurrencyOptions;

    @FindBy(xpath = "//div[text()='USD ($)']")
    public WebElement selectCurrencyUSD;

    @FindBy(xpath = "//h3[text()='Sign up']/following::button[@type='submit']")
    public WebElement signUpButton;


    public void signup(String email, String password, String firstName, String lastName, String companyName, String address) {
        String loginPageUrl = "https://cashwise.us/main?showLogin=false";
        driver.get(loginPageUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(signUpButtonOption));
        signUpButtonOption.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPassword.sendKeys(password);
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyNameInput.sendKeys(companyName);
        areaOfBusiness.click();
        manufacturingProductOption.click();
        addressInput.sendKeys(address);
        selectCurrencyOptions.click();
        selectCurrencyUSD.click();
        signUpButton.click();


    }

}