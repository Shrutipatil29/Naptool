package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.browser;
import pom.NaptolCheckout;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;

import static test.BaseTest.driver;

public class NaptolCheckoutTest {

    private String name;
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
    public void NaptolLoginTest() throws InterruptedException {

        extentTest=extentReports.createTest("NaptolLoginTest");

        NaptolCheckout naptollogin= new NaptolCheckout(driver);
        naptollogin.RegisterLoginInNaptol(driver);
        naptollogin.EnterMobileNumber();
        name=naptollogin.getUserName();
        System.out.println(name);

        Thread.sleep(5000);

        ProductResultPage productResultPage =new ProductResultPage(driver);
        ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);

        NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.enterInSearchTab("Mobiles");
        naptoolHomePage.clickOnSearch();


        productResultPage.clickOnQuickView(driver, 0);
        productQuickViewPage.clickOnClickHereToBuy();

        naptollogin.clickOnCheckout();
        naptollogin.selectShippingAddress();

        naptollogin.placeOrderNow(driver);

        System.out.println(naptollogin.getOrderAmount());


        Assert.assertEquals(naptollogin.getOrderAmount(),800);





    }
    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }


}
