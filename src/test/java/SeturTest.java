import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class SeturTest {
    private WebDriver driver;
    private SeturHomePage homePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new SeturHomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSeturScenario() {
        String url = "https://www.setur.com.tr/";
        homePage.navigateToHomePage(url);
        assertTrue(homePage.isHotelTabSelected());

        String destination = "Antalya";
        homePage.enterDestination(destination);
        driver.findElement(By.xpath("//li[contains(text(),'Antalya')][1]")).click();

        String date = "Nisan 1, 2023"; // Tarih formatına uygun bir değer girin
        homePage.selectDate(date);

        homePage.incrementAdultCount();
        int adultCount = Integer.parseInt(driver.findElement(By.id("adultCount")).getAttribute("value"));
        assertEquals(2, adultCount); // Yetişkin sayısı arttırıldığında 2 olmalıdır.

        assertTrue(driver.findElement(By.id("searchButton")).isDisplayed());
        homePage.clickSearchButton();

        assertTrue(driver.getCurrentUrl().contains("antalya"));

        // 9. Adım: "Diğer Bölgeleri Göster" alanında rastgele bir seçim yapılır
        int randomRegionIndex = homePage.clickRandomRegionInOtherRegions();
        assertTrue(randomRegionIndex > 0); // Rastgele bir bölge seçildiyse doğrulama yap

        // 10. Adım: Sayfanın altına kaydırma yapılır ve değer kontrol edilir
        WebElement antalyaHotelsSection = driver.findElement(By.xpath("//h2[contains(text(), 'Antalya Otelleri')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", antalyaHotelsSection);

        // 9. adımda kaydedilen değer ile karşılaştırma yapılır
        int scrollToRegionIndex = randomRegionIndex + 1; // 1 ekleyerek indeksi 1 tabanlı yapın
        assertEquals(scrollToRegionIndex, 8);
    }
}

