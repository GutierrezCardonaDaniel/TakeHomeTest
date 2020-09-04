package TakeHomeTest;

import static org.junit.Assert.assertTrue;


import TakeHomeTest.PapaJohnsWebApp.Helpers.Navigator;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.HorizontalMenu;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ProductAdditions;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ProductMainFields;
import TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest
{
    private static WebDriver driver;

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
       String[] ingredients = {"Maíz ", "Aceitunas negras ", "Champiñones ", "Dos quesos ","Cebolla ","Carne ","Tocineta "};
       productAdditions.chooseIngredients(ingredients);
       ShoppingCart shoppingCart = productMainFields.goToShoppingCart();
       shoppingCart.sendMaximumQuantity();
    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


}
