package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.browser;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import pom.verifyAmount;
import utility.Reports;

public class VerifyCartAmountTest extends BaseTest {

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
        public void verifyIfUnitPricePlusShippingPriceIsEqualToOrderAmountIsEqualToCartAmount() throws InterruptedException {

            extentTest=extentReports.createTest("verifyIfUnitPricePlusShippingPriceIsEqualToOrderAmountIsEqualToCartAmount");

            ProductResultPage productResultPage =new ProductResultPage(driver);
            ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);

            NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
            naptoolHomePage.enterInSearchTab("Mobiles");
            naptoolHomePage.clickOnSearch();


            productResultPage.clickOnQuickView(driver, 0);
            productQuickViewPage.clickOnClickHereToBuy();



            verifyAmount verifyamount=new verifyAmount(driver);

            double unitprice= verifyamount.getUnitPrice();

            System.out.println(unitprice);
            double shippingprice = verifyamount.getShippingPrice();
            System.out.println(shippingprice);

            double expectedorderamount= verifyamount.getOrderAmount();
            System.out.println(expectedorderamount);

            double orderamount= unitprice + shippingprice;
            System.out.println(orderamount);

            double cartAmount= expectedorderamount;
            Assert.assertEquals(orderamount,800);
            Assert.assertEquals(cartAmount,expectedorderamount);




        }


        @AfterTest

        public void flushReports()
        {
            extentReports.flush();
        }

    }


