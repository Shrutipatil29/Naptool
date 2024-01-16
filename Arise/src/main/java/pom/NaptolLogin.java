package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NaptolLogin {

    @FindBy(xpath = "//a[@id='login-panel-link']")private WebElement LogIn;
    @FindBy(xpath = "//input[@id='registration-basic-panel-mobile']")private WebElement EnterMobileNumber;
    @FindBy(xpath = "//input[@id='registration-basic-panel-submit']") private WebElement Continue;
    @FindBy(xpath = "//input[@id='registration-otp-panel-submit']")private WebElement Submit;

    @FindBy(xpath = "(//div//b)[1]")private WebElement loginUserName;


    public NaptolLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void RegisterLoginInNaptol(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(LogIn));
        LogIn.click();

    }

    public void EnterMobileNumber() throws InterruptedException {
        EnterMobileNumber.sendKeys("9131301718");
        Continue.click();

        Thread.sleep(50000);
        Submit.click();

    }

    public String getUserName(){

         String userName= loginUserName.getText();

         return userName;

    }




}
