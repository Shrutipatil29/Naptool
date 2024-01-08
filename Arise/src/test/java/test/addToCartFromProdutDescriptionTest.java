package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pojo.browser;
import pom.*;
import utility.Reports;

import static test.BaseTest.driver;

@Listeners(test.Listeners.class)


public class addToCartFromProdutDescriptionTest extends BasePage {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
            public  void CreateReports()
    {
      extentReports= Reports.generateReports();
    }

    @BeforeMethod
    public void openChrome()
    {
        driver= browser.chrome();
    }

    @Test

    public void  verifyIfUserIsAbleToAddProductToCartUsingDescription()  {

        extentTest= extentReports.createTest("verifyIfUserIsAbleToAddProductToCartUsingDescription");
        NaptoolHomePage naptolHomePage=new NaptoolHomePage(driver);
        naptolHomePage.enterInSearchTab("Mobile");
        naptolHomePage.clickOnSearch();

        ProductResultPage productResultPage=new ProductResultPage(driver);
        productResultPage.clickOnProductDescription(1);

        BuyProductFromDescriptionPage buyProductFromDescriptionPage= new BuyProductFromDescriptionPage(driver);

        buyProductFromDescriptionPage.switchToPage(driver, "https://www.naaptol.com/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html");
        buyProductFromDescriptionPage.clickOnClickHereToBuy();

    }

    @AfterTest

    public void flushReports()
    {
        extentReports.flush();
    }



}