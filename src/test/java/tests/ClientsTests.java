package tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ClientsPage;
import pages.CommonPage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class ClientsTests extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();
    ClientsPage clientsPage = new ClientsPage();

    @Test
    public void sellersPageTest() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        commonPage.sales.click();

        clientsPage.addClient();

        waitForUrlContains("sales");
        Assertions.assertTrue(driver.getCurrentUrl().contains("sales"));
    }
}