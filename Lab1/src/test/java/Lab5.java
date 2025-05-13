import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class Lab5 {
    public static void alert() throws  InterruptedException {

        WebDriver edge = new EdgeDriver();
       edge.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement content =edge.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        content.sendKeys("12223");
        WebElement btn_submit=edge.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        btn_submit.click();
        Thread.sleep(3000);


        String alercontent = edge.switchTo().alert().getText();
        System.out.println(alercontent);
        edge.switchTo().alert().accept();
        Thread.sleep(2000);
        edge.quit();




    }
    public static void  iframe()  throws InterruptedException {

        WebDriver edge =new EdgeDriver();
       edge.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
       edge.switchTo().frame("iframeResult");

       Thread.sleep(Long.parseLong("3000"));
       WebElement content = edge.findElement(By.xpath("/html/body/p"));
    System.out.println("content iframe"+content.getText());
       edge.quit();
}
    public static void popup() throws  InterruptedException{

        WebDriver edge= new EdgeDriver();
        edge.get("https://demo.guru99.com/popup.php");
        String mainwindow= edge.getWindowHandle();
        System.out.println("  "+mainwindow);
        System.out.println(edge.getTitle());
        WebElement btn =edge.findElement(By.xpath("/html/body/p[1]/a"));
        btn.click();

        Set<String>  myoption = edge.getWindowHandles();
        for(String handels:myoption){
            if(!handels.equals(mainwindow)){
          edge.switchTo().window(handels);
          edge.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
          WebElement loginbtn= edge.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
          loginbtn.sendKeys("frgergb");
          loginbtn.click();

            }

        }

    }
    public static void main(String[] args) throws InterruptedException {
        //Lab5.alert();
       // Lab5.iframe();
        Lab5.popup();
    }




}
