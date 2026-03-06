package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.LoginPage;
import pages.Reports_TransactionsPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class Reports_TransactionsTests extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    Reports_TransactionsPage reportsTransactionsPage = new Reports_TransactionsPage();
    CommonPage commonPage = new CommonPage();

    @Test
    public void transactionsPageTest() {

        loginPage.login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));

        commonPage.reports.click();
        reportsTransactionsPage.clickAddIncome();

        waitForUrlContains("dashboard");

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
