package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage{

    // Tüm QA işlerini görmek için buton
    @FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllJobsButton;

    // "See all QA jobs" butonuna tıklamak için metod
    public void clickSeeAllQaJobsButton(){
        seeAllJobsButton.click();
    }
}
