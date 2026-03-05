package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SellersPage;
import utils.BaseUI;
import pages.CommonPage;
import utils.ConfigurationReader;
import utils.Driver;

public class CommonPagesTests extends BaseUI {
    CommonPage commonPage = new CommonPage();
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @BeforeClass
    public void loginFirst(){
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @Test
    public void clickInfographics() {
        commonPage.clickSidebarOption(commonPage.infographics);
    }

    @Test
    public void clickSales() {
        commonPage.clickSidebarOption(commonPage.sales);
    }

    @Test
    public void clickExpenses() {
        commonPage.clickSidebarOption(commonPage.expenses);
    }

    @Test
    public void clickReports() {
        commonPage.clickSidebarOption(commonPage.reports);
    }

    @AfterClass
    public void closeWindow(){
        driver.close();
    }


}
