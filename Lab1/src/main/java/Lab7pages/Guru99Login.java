package Lab7pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login {
    WebDriver driver;

    // Locators
    By username = By.name("uid");
    By password = By.name("password");
    By login = By.name("btnLogin");
    By text = By.className("barone");

    // Constructor
    public Guru99Login(WebDriver driver) {
        this.driver = driver;
        driver.get("https://demo.guru99.com/V4/"); // Set the URL here
    }

    // Actions
    public void setUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public String getHeaderText() {
        return driver.findElement(text).getText();
    }

    public void login(String user, String pass)throws InterruptedException {
        setUsername(user);
        setPassword(pass);
        Thread.sleep(Long.parseLong("3000"));
        clickLogin();
    }
}
