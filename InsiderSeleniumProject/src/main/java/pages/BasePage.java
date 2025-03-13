package pages;

// Gerekli Selenium PageFactory sınıfı ve Driver sınıfını import ediyoruz.
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasePage {

    // BasePage sınıfı constructor metodu
    public BasePage() {
        // PageFactory'yi kullanarak sınıfın içindeki Web elementlerini initialize ediyoruz.
        // Bu, sayfalarımızdaki (page objects) Web elementlerinin, Driver üzerinden ulaşılabilir
        // olmasını sağlıyor. Yani, bu kod her sayfa nesnesi oluşturulduğunda otomatik olarak
        // o sayfadaki Web elementleri tanımlanır.
        PageFactory.initElements(Driver.get(), this);
    }

}
