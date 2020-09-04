package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import org.openqa.selenium.By;
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

    @FindBy(css = ".carrito_table span")
    private WebElement span_totalPrice;

    @FindBy(css = ".actualizar_cart_btn")
    private WebElement anch_updatePrice;

    @FindBy(xpath = "//div[@class='notification-content']/p[contains(text(),'Cantidad actualizada exitosamente')]")
    private WebElement notification;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendMaximumQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(input_productQuantity));
        if (input_productQuantity.size()!=0) {
            for (WebElement input : input_productQuantity) {
                wait.until(ExpectedConditions.visibilityOf(input));
                input.clear();
                input.sendKeys("10");
//                input.sendKeys(Keys.CONTROL + "a");
//                input.sendKeys(Keys.DELETE);
            }
        }
        anch_updatePrice.click();
    }
    public String getTotalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(notification));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loader-container")));
        wait.until(ExpectedConditions.visibilityOfAllElements(input_productQuantity));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Hacer pedido']")));

       return span_totalPrice.getText();
    }


}
