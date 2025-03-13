package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class HomePage extends BasePage {

    // "Company" butonunu tanımlıyoruz
    @FindBy(xpath = "//a[contains(text(), 'Company')]")
    public WebElement companyButton;

    // "Careers" butonunu tanımlıyoruz
    @FindBy(xpath = "//*[text()='Careers']")
    public WebElement careersButton;

    // Çerezleri kabul etme butonunu tanımlıyoruz
    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement acceptCookieButton;

    // Kariyerler sayfasına gitmek için bir metod oluşturuyoruz
    public void clickToCareerButton() {
        // Çerezleri kabul etme butonunun tıklanabilir olmasını bekleyin ve tıklayın
        BrowserUtils.waitForClickability(acceptCookieButton);
        acceptCookieButton.click();

        // "Company" butonuna tıklayın
        companyButton.click();

        // "Careers" butonuna tıklayın
        careersButton.click();
    }
}
