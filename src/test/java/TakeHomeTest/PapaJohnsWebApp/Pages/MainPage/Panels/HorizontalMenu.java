package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HorizontalMenu {

    WebDriver driver;
    @FindBy(css = "#main-menu>.row>li>a")
    private List<WebElement> menuButtons;
    @FindBy(css = "#cart_head_container .carrito_info_head")
    private WebElement btn_shoppingCart;


    public HorizontalMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  String[] menuOptions= new String[]{"Tradicionales","Favoritas","Insignia","arma tu pizza","Acompañamientos","Postres & Bebidas","ver más"};
    public HorizontalSubMenu goToSubMenu(String Option) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (WebElement element: menuButtons) {
            if (element.getAttribute("title").equals(Option)){
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                //wait.until(ExpectedConditions.attributeToBe(element,"style","display: block;"));
            }
        }
        return new HorizontalSubMenu(driver);
    }

}
