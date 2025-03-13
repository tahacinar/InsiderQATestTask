package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.Driver;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class OpenPositionsPage extends BasePage {

    // Lokasyon dropdown elementi
    @FindBy(id = "filter-by-location")
    public WebElement locationDropdown;

    // Departman dropdown elementi
    @FindBy(id = "filter-by-department")
    public WebElement departmentDropdown;

    // Role görüntüleme butonları listesi
    @FindBy(xpath = "//*[text()='View Role']")
    public List<WebElement> viewRoleButtons;


    // QA rollerinin bulunduğu liste
    @FindBy(xpath = "//*[@data-team='qualityassurance']")
    public List<WebElement> qualityAssuranceRole;


    // Lokasyon seçmek için metod
    public void selectLocations(String location) {
        Select select = new Select(locationDropdown);
        select.selectByVisibleText(location);
    }


    // Seçili lokasyonun adını almak için metod
    public String getLocationName() {
        Select select = new Select(locationDropdown);
        return select.getFirstSelectedOption().getText();
    }


    // Seçili departmanın adını almak için metod
    public String getDepartmentName() {
        Select select = new Select(departmentDropdown);
        return select.getFirstSelectedOption().getText();
    }


    // Rastgele bir role tıklamak için metod
    public void selectRole() {

        // Rastgele bir role tıklamak için Random nesnesi oluşturulur
        Random random = new Random();

        // 0'dan 3'e kadar rastgele bir sayı üretilir
        int randomNumber = random.nextInt(3);

        // QA rollerinin bulunduğu liste içinden rastgele bir rol seçilir ve tarayıcı scroll edilerek görünür hale getirilir
        BrowserUtils.scrollToElement(qualityAssuranceRole.get(randomNumber));

        // Seçilen role tıklanır
        BrowserUtils.clickWithJS(viewRoleButtons.get(randomNumber));
    }

    // Yeni bir sekme açmak için metod
    public void switchToNewTab() {
        Set<String> windowHandles = Driver.get().getWindowHandles();
        Driver.get().switchTo().window(windowHandles.toArray()[1].toString());
    }


}
