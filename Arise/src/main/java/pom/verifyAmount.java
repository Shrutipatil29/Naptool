package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyAmount {

    @FindBy(xpath = "//a[@href=\"/smart-watches/bluetooth-calling-smart-watch-with-neckband-and-mobile-stand-sc6/p/12612081.html\"]")private WebElement mobileName;
    @FindBy(xpath = "(//li[@class='head_ship'])[2]")private WebElement ShipPrice;
    @FindBy(xpath = "(//li[@class='head_UPrice'])[2]")private WebElement UnitPrice;
    @FindBy(xpath = "(//li[@class='head_Amount'])[2]")private WebElement OrderAmount;

    public verifyAmount(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProdName(){

        return mobileName.getText();
    }

    public double getUnitPrice() {

        return Double.parseDouble(UnitPrice.getText().substring(3));
    }

    public double getShippingPrice() {
        return Double.parseDouble(ShipPrice.getText().substring(3));
    }

    public double getOrderAmount() {
        return Double.parseDouble(OrderAmount.getText().substring(3));
    }








}
