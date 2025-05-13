package Lab7pages;

import Lab7pages.Guru99Login;
import Lab7pages.Guru99HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Guru99Test {
    public static void main(String[] args)throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        // Login Page Actions
        Guru99Login loginPage = new Guru99Login(driver);
        loginPage.login("mngr123456", "password123"); // Use valid test credentials

        // Home Page Actions
        Guru99HomePage homePage = new Guru99HomePage(driver);
        String userText = homePage.getHomePageDashboardUserName();
        System.out.println("Dashboard Text: " + userText);

        driver.quit();
    }
}
