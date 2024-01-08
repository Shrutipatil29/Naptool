package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProductFromDescriptionPage extends BasePage {

    @FindBy (xpath="//span[text()='Click here to Buy']") private WebElement clickHereToBuy;

    public BuyProductFromDescriptionPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickHereToBuy()
    {
        clickHereToBuy.click();
    }
}