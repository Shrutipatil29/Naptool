package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import pojo.browser;
import pom.BuyProductFromDescriptionPage;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class RemoveProductFromCartTest extends BaseTest {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public  void CreateReports()
    {
        extentReports= Reports.generateTestReports();
    }

    @BeforeMethod
    public void openChrome() {
        driver = browser.chrome();
    }

    @Test
    public void verifyIfUserIsAbleToRemoveProductFromCart() throws InterruptedException {

        extentTest=extentReports.createTest("verifyIfUserIsAbleToRemoveProductFromCart");

        NaptoolHomePage naptolHomePage = new NaptoolHomePage(driver);
        naptolHomePage.enterInSearchTab("Mobile");
        naptolHomePage.clickOnSearch();

        ProductResultPage productResultPage = new ProductResultPage(driver);
        productResultPage.clickOnProductDescription(1);

        BuyProductFromDescriptionPage buyProductFromDescriptionPage = new BuyProductFromDescriptionPage(driver);

        buyProductFromDescriptionPage.switchToPage(driver, "https://www.naaptol.com/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html");
        buyProductFromDescriptionPage.clickOnClickHereToBuy();

        CartPage cartPage= new CartPage(driver);

        Thread.sleep(5000);

        cartPage.ClickOnRemoveProductFromCart(driver);

        int value=cartPage.getNumberOfProdutsPresentInCart(driver)-1;
        Assert.assertEquals(value, 0);




    }
    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }


}
