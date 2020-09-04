package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCart {

    private WebDriver driver;

    @FindBy(css = ".itemsMiniCart>td[class='cart_cant_cell']>input")
    private List<WebElement> input_productQuantity;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendMaximumQuantity(){
        if (input_productQuantity.size()!=0) {
            for (WebElement input : input_productQuantity) {
                input.sendKeys("10");
            }
        }
    }


}
