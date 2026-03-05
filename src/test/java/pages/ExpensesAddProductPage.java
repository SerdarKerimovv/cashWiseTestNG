package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUI;
import utils.Driver;

import java.time.Duration;

public class ExpensesAddProductPage extends BaseUI {
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();

    public ExpensesAddProductPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[text()='Product and services (Expenses)']")
    public WebElement productsAndServicesHeader;

    @FindBy (xpath = "//button[contains(.,'Add product and services')]")
    public WebElement addProductAndServicesButton;

    @FindBy (id = "product_title_input_text")
    public WebElement nameInput;

    @FindBy (id = "product_price_input_text")
    public WebElement priceInput;

    @FindBy (id = "mui-component-select-service_type_id")
    public WebElement selectServiceType;

    @FindBy (id = "mui-component-select-category_id")
    public WebElement selectCategoryInput;

    @FindBy (id = "product_description_input_text")
    public WebElement descriptionInput;

    @FindBy (id = "undefined_input_text")
    public WebElement dateOfPayInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;


    public void addProductsAndServices(){
        waitUntilClickable(20,addProductAndServicesButton);
        addProductAndServicesButton.click();

        nameInput.sendKeys(faker.commerce().productName());

        priceInput.sendKeys(String.valueOf(faker.number().numberBetween(10,500)));

        waitUntilClickable(20,selectServiceType);
        selectServiceType.click();
        driver.findElement(By.xpath("//li[contains(text(),'Service')]")).click();

        waitUntilClickable(10,selectCategoryInput);
        selectCategoryInput.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option' and normalize-space()='Marketing']"))).click();

        descriptionInput.sendKeys(faker.lorem().sentence());

        dateOfPayInput.sendKeys("02/26/2026");

        saveButton.click();


    }


}
