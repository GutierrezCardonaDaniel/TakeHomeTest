package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductAdditions {
    WebDriver driver;

    @FindBy(css = "div[class='pizza_size selector '] a")
    private List<WebElement> pizzaSizeButtons;

    @FindBy(css = "a[title='Modificar ingredientes']")
    private WebElement btn_modifyIngredients;

    @FindBy(css = "#adiciones input")
    private List<WebElement> chk_ingredients;

    @FindBy(css = "a[class='btn redbtn add_addittion']")
    private WebElement addIngredientsBtn;

    public ProductAdditions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void chooseIngredients(String[] ingredientsArray){
        for (int index=0;index<chk_ingredients.size();index++) {
            if (chk_ingredients.get(index).equals(ingredientsArray[index])){
                chk_ingredients.get(index).click();
            }
        }
        addIngredientsBtn.click();
    }
}
