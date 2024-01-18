package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NaptolCheckout {

    @FindBy(xpath = "//a[@id='login-panel-link']")private WebElement LogIn;
    @FindBy(xpath = "//input[@id='registration-basic-panel-mobile']")private WebElement EnterMobileNumber;
    @FindBy(xpath = "//input[@id='registration-basic-panel-submit']") private WebElement Continue;
    @FindBy(xpath = "//input[@id='registration-otp-panel-submit']")private WebElement Submit;

    @FindBy(xpath = "(//div//b)[1]")private WebElement loginUserName;

    @FindBy(xpath = "//a[@class='red_button2']")private WebElement Checkout;

    @FindBy(xpath = "//select[@class='input_Special']")private WebElement title;
    @FindBy(xpath = "//input[@name='firstName']")private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")private WebElement LastName;
    @FindBy(xpath = "//textarea[@name='address']")private WebElement Address;
    @FindBy(xpath = "//input[@name='pincode']")private WebElement pincode;
    @FindBy(xpath = "//input[@name='mobile']")private WebElement mobileNumber;
    @FindBy(xpath = "//a[@id='addEditButton']")private WebElement saveAndProceed;
     @FindBy(xpath = "//a[@class='red_button_normal']")private WebElement placeOrder;


    @FindBy(xpath = "//a[@class='button_2']")private WebElement shipToThisAddress;



    public NaptolCheckout(WebDriver driver) {
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

    public void clickOnCheckout(){

        Checkout.click();
    }

    public void selectShippingAddress(){

        Select titleSelect = new Select(title);

        // Select the desired title by visible text
        titleSelect.selectByVisibleText("Miss.");
        firstName.sendKeys("shruti");
        LastName.sendKeys("patil");
        Address.sendKeys("LALUK");
        pincode.sendKeys("784160");


        mobileNumber.sendKeys("9131301718");
        saveAndProceed.click();
        shipToThisAddress.click();
         placeOrder.click();





    }




}
