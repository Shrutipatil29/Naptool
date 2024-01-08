package test;

import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.*;


import org.testng.annotations.Listeners;
import pojo.browser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class AddToCartTest extends BaseTest {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public  void CreateReports()
    {
        extentReports= Reports.generateReports();
    }

    private NaptoolHomePage naptoolHomePage;
    private ProductResultPage productResultPage;
    private ProductQuickViewPage productQuickViewPage;
    private CartPage cartPage;


    @BeforeMethod
    public void openApplication() {
        driver=browser.chrome();
    }

    @Test
    public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() {

        extentTest= extentReports.createTest("verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption");
        NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.enterInSearchTab("Mobiles");
        naptoolHomePage.clickOnSearch();

        ProductResultPage productResultPage =new ProductResultPage(driver);
        productResultPage.clickOnQuickView(driver, 0);

        ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
        productQuickViewPage.clickOnClickHereToBuy();

        CartPage cartPage =new CartPage(driver);
        Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver), 1);

    }

    @Test
    public void verifyIfUserIsAbleToAddMultipleProductsInCart(){

        extentTest= extentReports.createTest("verifyIfUserIsAbleToAddMultipleProductsInCart");

        naptoolHomePage = new NaptoolHomePage(driver);
        naptoolHomePage.enterInSearchTab("Mobiles");
        naptoolHomePage.clickOnSearch();

         productResultPage =new ProductResultPage(driver);
        productResultPage.clickOnQuickView(driver, 0);

       productQuickViewPage =new ProductQuickViewPage(driver);
        productQuickViewPage.clickOnClickHereToBuy();

         cartPage =new CartPage(driver);
        cartPage.clickOnContinueShopping(driver);

        productResultPage.clickOnQuickView(driver,1);

        productQuickViewPage.clickOnClickHereToBuy();
        Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver),2);

    }
    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }

}