package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.*;


import org.testng.annotations.Listeners;
import pojo.browser;
import pom.NaptoolHomePage;
import utility.Reports;

@Listeners (test.Listeners.class)

public class VerifyShoppingCategoriesTest extends BaseTest {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public  void CreateReports()
    {
        extentReports= Reports.generateTestReports();
    }

    @BeforeMethod
    public void openApplication() {
       driver= browser.chrome();
    }

    @Test
    public void verifyIfUserIsAbleToAccessShoppingCategories() {
        extentTest=extentReports.createTest("verifyIfUserIsAbleToAccessShoppingCategories");
        NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.clickOnShoppingCategories();
        naptoolHomePage.selectShoppingCategories(driver, 3);
        String currentTitle =driver.getTitle();
        Assert.assertTrue(currentTitle.contains("Mobile Handsets"));
        Assert.assertEquals(naptoolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");
    }



    @AfterMethod
    public void postTest() {
        driver.close();
    }
    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }

}