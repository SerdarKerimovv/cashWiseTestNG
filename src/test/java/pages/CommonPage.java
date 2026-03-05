package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseUI;
import utils.Driver;

public class CommonPage extends BaseUI {
    WebDriver driver = Driver.getDriver();

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[text()='Expenses']")
    public WebElement expenses;

    @FindBy(xpath = "//li[text()='Sales']")
    public WebElement sales;

    @FindBy(xpath = "//li[text()='Reports']")
    public WebElement reports;

    @FindBy(xpath = "//a[text()='Infographics']")
    public WebElement infographics;

//    @FindBy(className = "css-3rupl2")
//    public WebElement languageSelector;

    public void clickSidebarOption(WebElement element) {
        waitAndClick(element);

        if (element.equals(expenses)) {
            Assert.assertTrue(driver.getCurrentUrl().contains("costs"));
        } else if (element.equals(sales)) {
            Assert.assertTrue(driver.getCurrentUrl().contains("sales"));
        } else if (element.equals(reports)) {
            Assert.assertTrue(driver.getCurrentUrl().contains("reports"));
        } else if (element.equals(infographics)) {
            Assert.assertTrue(driver.getCurrentUrl().contains("infographics"));
        } else {
            System.out.println("There is no such option on the common navigation bar.");
        }
    }




}