import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SeturHomePage {
    private WebDriver driver;
    private By hotelTab = By.linkText("Otel");
    private By destinationInput = By.id("searchInput");
    private By dateInput = By.id("date");
    private By adultCountInput = By.id("adultCount");
    private By searchButton = By.id("searchButton");
    private By otherRegionsLink = By.xpath("//div[@class='other-regions']/a");

    public SeturHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public boolean isHotelTabSelected() {
        return driver.findElement(hotelTab).isSelected();
    }

    public int clickRandomRegionInOtherRegions() {
        List<WebElement> elements = driver.findElements(otherRegionsLink);
        if (elements.size() > 0) {
            int randomIndex = new Random().nextInt(elements.size());
            elements.get(randomIndex).click();
            return randomIndex + 1;
        } else {
            return 0;
        }
    }

    public void enterDestination(String destination) {
        driver.findElement(destinationInput).sendKeys(destination);
    }

    public void selectDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public void incrementAdultCount() {
        driver.findElement(adultCountInput).click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
