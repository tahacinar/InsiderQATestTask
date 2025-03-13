package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    // WebDriver nesnesi için özellik
    private static WebDriver driver;
    public Driver() {
    }

    // WebDriver nesnesi döndüren statik metot
    public static WebDriver get() {

        // WebDriver henüz oluşturulmadıysa
        if (driver == null) {

            // Kullanılacak tarayıcıyı yapılandır
            String browser = ConfigurationReader.get("browser");
            switch (browser) {

                // Eğer tarayıcı Chrome ise
                case "chrome":

                    // WebDriverManager kullanarak ChromeDriver'ı kur ve yapılandır
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications"); // Bildirimleri devre dışı bırak
                    options.addArguments("--disable-extensions"); // Uzantıları devre dışı bırak
                    options.addArguments("--disable-cookies"); // Çerezleri devre dışı bırak

                    // Kurulan ve yapılandırılan ChromeDriver'ı oluştur
                    driver = new ChromeDriver(options);
                    break;
            }
        }

        // WebDriver nesnesini döndür
        return driver;
    }

    // WebDriver nesnesini kapatmak için statik metot
    public static void closeDriver() {
        // WebDriver nesnesi null değilse
        if (driver != null) {
            // WebDriver'ı kapat
            driver.quit();
            // WebDriver nesnesini null yap
            driver = null;
        }
    }
}
