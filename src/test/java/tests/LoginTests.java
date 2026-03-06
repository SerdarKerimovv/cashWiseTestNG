package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTests extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Test (priority = 1, groups = {"smoke","regression"})
    public void loginTest() {

        loginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

        waitForUrlContains("dashboard");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("dashboard"),
                "Login failed: Dashboard URL not loaded"
        );
    }
}