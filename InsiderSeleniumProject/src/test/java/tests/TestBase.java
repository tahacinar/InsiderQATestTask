package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.Driver;
import java.time.Duration;

public class TestBase {
    // WebDriver nesnesi tanımlanır
    public WebDriver driver;

    // Her test metodu çalışmadan önce çalışacak olan setUp() metodu
    @BeforeMethod
    public void setUp() {
        // WebDriver nesnesi oluşturulur ve yapılandırılır
        driver = Driver.get(); // WebDriver'ı alır
        driver.manage().window().maximize(); // Pencereyi maksimize eder
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Bekleme zamanı ayarlanır
        String url = ConfigurationReader.get("base_url"); // Base URL alınır
        driver.get(url); // URL'ye gidilir
        driver.manage().deleteAllCookies(); // Tüm çerezler silinir
    }
}
