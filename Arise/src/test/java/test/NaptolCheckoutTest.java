package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.browser;
import pom.NaptolCheckout;
import pom.NaptoolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

import static test.BaseTest.driver;

public class NaptolCheckoutTest {

    private String name;

    @BeforeMethod
    public void openApplication() {

        driver= browser.chrome();
    }


    @Test
    public void NaptolLoginTest() throws InterruptedException {

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




    }


}
