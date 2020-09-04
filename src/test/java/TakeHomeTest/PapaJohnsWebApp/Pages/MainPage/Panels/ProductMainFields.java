package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import TakeHomeTest.PapaJohnsWebApp.Helpers.Navigator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductMainFields {

    WebDriver driver;

    @FindBy(css = "div[class='pizza_size selector '] a")
    private List<WebElement> pizzaSizeButtons;

    @FindBy(css = "a[title='Modificar ingredientes']")
    private WebElement btn_modifyIngredients;

    @FindBy(css = "input[class='btn redbtn add-to-cart']")
    private WebElement btn_addShoppingCart;

    @FindBy(css = "div[class='masa_familiar row'] input")
    private List<WebElement> radiobutton_crust;

    WebElement btn_PersonalSize;
    WebElement btn_MedianaSize;
    WebElement btn_FamiliarSize;
    WebElement btn_MegaFamiliarSize;

    public ProductMainFields(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        btn_PersonalSize = pizzaSizeButtons.get(0);
        btn_MedianaSize = pizzaSizeButtons.get(1);
        btn_FamiliarSize = pizzaSizeButtons.get(2);
        btn_MegaFamiliarSize = pizzaSizeButtons.get(3);
    }

    public enum PizzaSize{Personal,Mediana,Familiar,MegaFamiliar}
    public void selectPizzaSize(PizzaSize pizzaSize){
        WebDriverWait wait = new WebDriverWait(driver,5);
        switch (pizzaSize){
            case Personal:
                wait.until(ExpectedConditions.elementToBeClickable(btn_PersonalSize));
                Navigator.ForceClick(btn_FamiliarSize);
                break;
            case Mediana:
                wait.until(ExpectedConditions.elementToBeClickable(btn_MedianaSize));
                Navigator.ForceClick(btn_FamiliarSize);
                break;
            case Familiar:
                wait.until(ExpectedConditions.elementToBeClickable(btn_FamiliarSize));
                Navigator.ForceClick(btn_FamiliarSize);
                break;
            case MegaFamiliar:
                wait.until(ExpectedConditions.elementToBeClickable(btn_MegaFamiliarSize));
                Navigator.ForceClick(btn_FamiliarSize);
                break;

        }
    }
    public void selectCrust(int value){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(radiobutton_crust.get(value)));
        radiobutton_crust.get(value).click();
    }

    public ProductAdditions goToModifyIngredients(){
        btn_modifyIngredients.click();
        return new ProductAdditions(driver);
    }

    public ShoppingCart goToShoppingCart(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(btn_addShoppingCart));
        wait.until(ExpectedConditions.visibilityOf(btn_addShoppingCart));

        btn_addShoppingCart.click();
        return new ShoppingCart(driver);
    }
}
