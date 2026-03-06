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
    public void loginFirst() {
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

    @Test
    public void chooseEnglish() {
        commonPage.languageChange(commonPage.englishLanguage);
        commonPage.clickSidebarOption(commonPage.infographics);

        Assert.assertTrue(commonPage.cashFlowText.getText().equals("Cash flows"));
    }

    @Test
    public void chooseRussian() {
        commonPage.languageChange(commonPage.russianLanguage);
        commonPage.clickSidebarOption(commonPage.russianInfographics);

        Assert.assertTrue(commonPage.russianCashFlowText.getText().equals("'Денежные потоки"));
    }

    @AfterClass
    public void closeWindow(){
        driver.close();
    }


}
