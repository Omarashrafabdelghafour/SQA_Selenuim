package Lab7pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99HomePage {
    WebDriver driver;

    // Locator for welcome message
    By homepageUser = By.xpath("//td[contains(text(),'Manger Id')]");

    public Guru99HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageDashboardUserName() {
        return driver.findElement(homepageUser).getText();
    }
}
