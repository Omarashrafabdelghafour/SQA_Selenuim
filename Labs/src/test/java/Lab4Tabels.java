import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab4Tabels {


    public static void main(String[] args) {
        WebDriver edge= new EdgeDriver();


        edge.get("https://demo.guru99.com/test/write-xpath-table.html");
         WebElement table =edge.findElement(By.xpath("//table/tbody/tr[2]/td[1]"));
        System.out.println(table);
    }


}
