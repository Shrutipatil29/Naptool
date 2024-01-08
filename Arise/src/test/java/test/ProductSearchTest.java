package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.*;


import org.testng.annotations.Listeners;
import pojo.browser;
import pom.NaptoolHomePage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class ProductSearchTest extends BaseTest{

        ExtentReports extentReports;
        ExtentTest extentTest;

        @BeforeTest
        public  void CreateReports()
        {
            extentReports= Reports.generateTestReports();
        }

    @BeforeMethod
    public void openApplication() {
        driver=browser.chrome();
    }

    @Test
    public void verifyIfProdutsAreDisplayedOnValidSearch() {

            extentTest=extentReports.createTest("verifyIfProdutsAreDisplayedOnValidSearch");
        NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.enterInSearchTab("Mobiles");
        naptoolHomePage.clickOnSearch();

        ProductResultPage productResultPage =new ProductResultPage(driver);
        Assert.assertTrue(productResultPage.getNumberOfProducts()>0);

    }

    @Test
    public void verifyIfProdutsAreNotDisplayedOnInvalidSearch() {
        extentTest=extentReports.createTest("verifyIfProdutsAreNotDisplayedOnInvalidSearch");
        NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.enterInSearchTab("iphone");
        naptoolHomePage.clickOnSearch();

        ProductResultPage productResultPage =new ProductResultPage(driver);
        Assert.assertTrue(productResultPage.getNumberOfProducts()==0);

    }


    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }

}