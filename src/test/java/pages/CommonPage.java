package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CommonPage {
    WebDriver driver = Driver.getDriver();

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[text()='Expenses']")
    public WebElement expenses;

    @FindBy(xpath = "//li[text()='Sales']")
    public WebElement sales;
}