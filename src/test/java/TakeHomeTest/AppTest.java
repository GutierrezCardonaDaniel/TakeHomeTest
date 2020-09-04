package TakeHomeTest;

import static org.junit.Assert.assertTrue;


import TakeHomeTest.PapaJohnsWebApp.Helpers.Navigator;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.HorizontalMenu;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ProductAdditions;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ProductMainFields;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ShoppingCart;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest
{
    private static WebDriver driver;
    private SoftAssertions softly = new SoftAssertions();

    @BeforeClass
    public static void setupClass() {
        driver = Navigator.Navigation("https://www.papajohns.com.co/", Navigator.WebBrowser.CHROME);
        driver.manage().window().maximize();
    }
    @Test
    public void HappyPath() throws InterruptedException {
       ProductMainFields productMainFields = new HorizontalMenu(driver).goToSubMenu("Favoritas")
                .selectFromSubMenu("CARNES");
       productMainFields.selectPizzaSize(ProductMainFields.PizzaSize.Familiar);
       productMainFields.selectCrust(0);
       ProductAdditions productAdditions = productMainFields.goToModifyIngredients();
       List<String> ingredients = new ArrayList<>();
       ingredients.add("Maíz");
       ingredients.add("Aceitunas negras");
       ingredients.add("Champiñones");
       ingredients.add("Dos quesos");
       ingredients.add("Cebolla");
       ingredients.add("Carne");
       ingredients.add("Tocineta");

       productAdditions.chooseIngredients(ingredients);
       ShoppingCart shoppingCart = productMainFields.goToShoppingCart();
       shoppingCart.sendMaximumQuantity();
        softly.assertThat(shoppingCart.getTotalPrice())
                .as("Validating Total Cost" )
                .isEqualTo("918,000");
        softly.assertAll();
    }

    @Test
    public void AddingIllogicalQuantityOfProducts() throws InterruptedException {
        ProductMainFields productMainFields = new HorizontalMenu(driver).goToSubMenu("Favoritas")
                .selectFromSubMenu("CARNES");
        productMainFields.selectPizzaSize(ProductMainFields.PizzaSize.Familiar);
        productMainFields.selectCrust(0);
        ProductAdditions productAdditions = productMainFields.goToModifyIngredients();
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Maíz");
        ingredients.add("Aceitunas negras");
        ingredients.add("Champiñones");
        ingredients.add("Dos quesos");
        ingredients.add("Cebolla");
        ingredients.add("Carne");
        ingredients.add("Tocineta");

        productAdditions.chooseIngredients(ingredients);
        ShoppingCart shoppingCart = productMainFields.goToShoppingCart();
        productMainFields.goToShoppingCart();
        productMainFields.goToShoppingCart();
        productMainFields.goToShoppingCart();
        shoppingCart.sendMaximumQuantity();
        softly.assertThat(shoppingCart.getTotalPrice())
                .as("Validating Total Cost" )
                .isEqualTo("918,000");
        softly.assertAll();
    }

       @AfterClass
        public void teardown() {
           if (driver != null) {
                driver.quit();
            }
       }


}
