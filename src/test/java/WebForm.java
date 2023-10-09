import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebForm {
    private WebDriver driver;
    private By searchInput = By.id("searchInput");
    private By searchButton = By.id("searchButton");

    public WebForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDestination(String destination) {
        driver.findElement(searchInput).sendKeys(destination);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
