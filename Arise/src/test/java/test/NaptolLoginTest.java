package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.browser;
import pom.NaptolLogin;

import static test.BaseTest.driver;

public class NaptolLoginTest {

    @BeforeMethod
    public void openApplication() {

        driver= browser.chrome();
    }


    @Test
    public void NaptolLoginTest() throws InterruptedException {

        NaptolLogin naptollogin= new NaptolLogin(driver);
        naptollogin.RegisterLoginInNaptol(driver);
        naptollogin.EnterMobileNumber();
       String name=naptollogin.getUserName();
        System.out.println(name);

        Assert.assertEquals(name,naptollogin.getUserName());


    }


}
