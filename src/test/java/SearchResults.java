import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    private WebDriver driver;
    private By destinationInput = By.id("destination");
    private By dateInput = By.id("date");
    private By adultCountInput = By.id("adultCount");
    private By searchButton = By.id("searchButton");

    public SearchResults(WebDriver driver) {
        this.driver = driver;
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
