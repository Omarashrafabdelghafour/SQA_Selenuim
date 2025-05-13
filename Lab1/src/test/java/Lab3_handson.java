import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab3_handson {
    public static void main(String[] args) throws InterruptedException {
        WebDriver edge=new EdgeDriver() ;
        edge.get("https://demo.guru99.com/test/login.html");

WebElement email = edge.findElement(By.id("email"));
        WebElement password = edge.findElement(By.id("passwd"));

        WebElement btn_sub = edge.findElement(By.id("SubmitLogin"));

email.sendKeys("Omar@gmail.com");
password.sendKeys("Omar123");
Thread.sleep(3000);
btn_sub.click();
        System.out.println("finish");

    }
}
