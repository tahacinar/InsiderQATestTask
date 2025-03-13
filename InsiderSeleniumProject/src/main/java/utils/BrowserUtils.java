package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {

    // WebDriver nesnesi üzerinde işlemler gerçekleştirmek için Actions nesnesi oluşturulur
    static Actions action = new Actions(Driver.get());

    // Bir WebElement'in tıklanabilir olmasını bekleyen metod
    public static void waitForClickability(WebElement element) {

        // Belirli bir süre boyunca (15 saniye) belirtilen WebElement'in görünür olmasını bekler
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Bir WebElement'e kadar sayfayı scroll eden metod
    public static void scrollToElement(WebElement element) {

        // Belirtilen WebElement'e kadar sayfayı scroll eder
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView({ block: 'center' });", element);
    }

    // Bir WebElement'e JavaScript ile tıklama yapmayı sağlayan metod
    public static void clickWithJS(WebElement element) {

        // İlgili WebElement sayfada görünene kadar scroll eder
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);

        // İlgili WebElement üzerine JavaScript ile tıklama yapar
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
}
