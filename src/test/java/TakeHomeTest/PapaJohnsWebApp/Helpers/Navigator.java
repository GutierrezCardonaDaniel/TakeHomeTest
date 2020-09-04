package TakeHomeTest.PapaJohnsWebApp.Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Navigator {

    private static WebDriver driver;
    public enum WebBrowser{CHROME,EDGE,FIREFOX,OPERA}

    public static WebDriver Navigation(String url,WebBrowser browser)
    {
        switch (browser){
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.get(url);
        return driver;
    }
    public static void ForceClick(WebElement webElement) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        actions.moveToElement(webElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        actions.moveToElement(webElement).click(webElement).perform();
    }
    public static void HoverElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }
}
