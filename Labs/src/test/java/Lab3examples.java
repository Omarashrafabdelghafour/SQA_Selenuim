import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Lab3examples {

    private WebDriver driver; // Fixed typo

    public void load() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
    }

    public void maximize() { // Renamed to maximize
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(800,600));

        } else {
            System.out.println("WebDriver is not initialized. Call load() first.");
        }
    }
  public void navigate(){

        driver.get("http://www.google.com");

  }
    public static void main(String[] args) {
        Lab3examples example1 = new Lab3examples();
        example1.load();   // Initialize the WebDriver
//        example.maximize()//;  // Maximize after loading
        example1.navigate();
    }
}
