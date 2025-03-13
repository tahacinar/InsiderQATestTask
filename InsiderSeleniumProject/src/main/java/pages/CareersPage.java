package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

// CareersPage, BasePage sınıfından türetilmiştir. Bu, BasePage'de tanımlanan ortak işlevselliği miras alır.
public class CareersPage extends BasePage {

    // Sayfa başlığı elementini bulmak için @FindBy kullanıyoruz
    @FindBy(id = "page-head")
    public WebElement careersPageHead;

    // "See all teams" düğmesini bulmak için @FindBy kullanıyoruz
    @FindBy(xpath = "//*[text()='See all teams']")
    public WebElement seeAllTeamsButton;

    // Tüm takımların bloklarını bulmak için @FindBy kullanıyoruz
    @FindBy(id = "career-find-our-calling")
    public WebElement allTeamsBlocks;

    // Konumumuzu bulmak için @FindBy kullanıyoruz
    @FindBy(id = "career-our-location")
    public WebElement ourLocation;

    // "Life at Insider" öğesini bulmak için @FindBy kullanıyoruz
    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement lifeAtInsider;

    // "Quality Assurance" düğmesini bulmak için @FindBy kullanıyoruz
    @FindBy(xpath = "//*[text()='Quality Assurance']")
    public WebElement qualityAssuranceButton;

    // Bu metod, önce "See all teams" düğmesine, ardından "Quality Assurance" düğmesine tıklar
    public void clickQAButton() {
        // "See all teams" düğmesine JavaScript kullanarak tıklıyoruz
        BrowserUtils.clickWithJS(seeAllTeamsButton);

        // "Quality Assurance" düğmesine JavaScript kullanarak tıklıyoruz
        BrowserUtils.clickWithJS(qualityAssuranceButton);
    }
}
