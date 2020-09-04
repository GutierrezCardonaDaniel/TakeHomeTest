package TakeHomeTest.PapaJohnsWebApp.Pages.MainPage.Panels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HorizontalSubMenu {

    private WebDriver driver;

    @FindBy(css = "#main-menu>.row>li>div li>a")
    private List<WebElement> subMenuButtons;

    public HorizontalSubMenu(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductMainFields selectFromSubMenu (String Option) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (WebElement element: subMenuButtons) {
            if (element.getAttribute("title").equals(Option)){
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
        }
        return new ProductMainFields(driver);
    }
}
