package tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.SellersPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class SellersTests extends BaseUI {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    SellersPage sellersPage = new SellersPage();
    CommonPage commonPage = new CommonPage();

    @Test
    public void sellersPageTest() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        commonPage.expenses.click();

        sellersPage.addSeller();

        waitForUrlContains("sellers");
        Assertions.assertTrue(driver.getCurrentUrl().contains("sellers"));
    }

    @Test
    public void editSellerInfoTest() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        commonPage.expenses.click();

        sellersPage.editSellerInfo();

        waitUntilVisible(10, sellersPage.successfullyEditedMessage);
        Assertions.assertTrue(sellersPage.successfullyEditedMessage.isDisplayed());
    }
}