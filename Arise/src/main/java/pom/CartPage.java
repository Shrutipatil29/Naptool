package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    @FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> products;
    @FindBy (xpath = "(//a[@onclick='cart.submitOrder()'])[1]") private WebElement proceedToCheckout;

    @FindBy(xpath = "(//a[@onClick='cart.continueShopping()'])[1]")private WebElement continueShopping;

    @FindBy(xpath = "//a[@onClick='cart.remove(647640328)']")private  WebElement RemoveProduct;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfProdutsPresentInCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
        return products.size();
    }


    public void clickOnContinueShopping(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();

    }

    public void ClickOnRemoveProductFromCart(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(RemoveProduct));
        RemoveProduct.click();


    }



}