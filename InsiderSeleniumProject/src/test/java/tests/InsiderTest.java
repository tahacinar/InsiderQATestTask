
package tests;

import org.testng.annotations.Test;
import pages.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class InsiderTest extends TestBase {

    // Sayfa objeleri oluşturulur
    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    OpenPositionsPage openPositionsPage = new OpenPositionsPage();

    // Beklenen sayfa başlığı, URL'ler ve diğer bilgiler tanımlanır
    String expectedHomePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    String expectedQaPageUrl = "https://useinsider.com/careers/quality-assurance/";
    String expectedLocationName = "Istanbul, Turkey";
    String expectedDepartmentName = "Quality Assurance";
    String expectedLeverUrl = "https://jobs.lever.co/useinsider";

    // InsiderTest test case'i
    @Test
    public void insiderTestCase() {
        // Anasayfanın başlığının beklenen başlıkla eşleşip eşleşmediğini kontrol et
        assertEquals(driver.getTitle(), expectedHomePageTitle);

        // Kariyerler sayfasına gitmek için anasayfadaki butona tıkla
        homePage.clickToCareerButton();

        // Kariyerler sayfasının yüklenip yüklenmediğini ve önemli öğelerin görüntülendiğini doğrula
        assertTrue(careersPage.careersPageHead.isDisplayed());
        assertTrue(careersPage.ourLocation.isDisplayed());
        assertTrue(careersPage.allTeamsBlocks.isDisplayed());
        assertTrue(careersPage.lifeAtInsider.isDisplayed());

        // Kariyerler sayfasından QA sayfasına git
        careersPage.clickQAButton();

        // QA sayfasının URL'sinin beklenen URL ile eşleşip eşleşmediğini kontrol et
        assertEquals(expectedQaPageUrl, driver.getCurrentUrl());

        // QA sayfasında "See all QA jobs" butonuna tıkla
        qualityAssurancePage.clickSeeAllQaJobsButton();

        // Açık pozisyonlar sayfasında lokasyon seç, lokasyon adını ve departman adını kontrol et
        openPositionsPage.selectLocations(expectedLocationName);
        assertEquals(expectedLocationName, openPositionsPage.getLocationName());
        assertEquals(expectedDepartmentName, openPositionsPage.getDepartmentName());

        // Rastgele bir role tıkla
        openPositionsPage.selectRole();

        // Yeni açılan sekme üzerindeki URL'yi kontrol et
        openPositionsPage.switchToNewTab();
        assertTrue(driver.getCurrentUrl().contains(expectedLeverUrl));
    }
}
