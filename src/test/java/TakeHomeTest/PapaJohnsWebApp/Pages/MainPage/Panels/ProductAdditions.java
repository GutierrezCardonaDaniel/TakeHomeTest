package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import TakeHomeTest.PapaJohnsWebApp.Helpers.Navigator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductAdditions {
    WebDriver driver;

    @FindBy(css = "div[class='pizza_size selector '] a")
    private List<WebElement> pizzaSizeButtons;

    @FindBy(css = "a[title='Modificar ingredientes']")
    private WebElement btn_modifyIngredients;

    @FindBy(css = "#adiciones input")
    private List<WebElement> chk_ingredients;

    @FindBy(css = "#adiciones input+label")
    private List<WebElement> lbl_ingredientsLabels;

    @FindBy(css = "a[class='btn redbtn add_addittion']")
    private WebElement addIngredientsBtn;

    public ProductAdditions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseIngredients(List<String> ingredientsArray){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(chk_ingredients));
        for (int index=0;index<chk_ingredients.size();index++) {
            if (ingredientsArray.contains(lbl_ingredientsLabels.get(index).getText())){
                wait.until(ExpectedConditions.visibilityOf(chk_ingredients.get(index)));
                chk_ingredients.get(index).click();
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(addIngredientsBtn));
        addIngredientsBtn.click();
    }
}
