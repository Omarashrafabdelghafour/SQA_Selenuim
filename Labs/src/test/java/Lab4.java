import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Lab4 {
    public static void main(String[] args) {
        WebDriver edge= new EdgeDriver();
        edge.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement mylist=edge.findElement(By.xpath("//select[@name='country']"));
        Select my_item =new Select(mylist);
        my_item.selectByValue("ANGOLA");
        List<WebElement> elements=my_item.getOptions();
        for(int i=0;i<elements.size();i++) {

            System.out.println(elements.get(i).getText());
        }
    }
}
