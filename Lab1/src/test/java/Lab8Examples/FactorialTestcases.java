package Lab8Examples;

import Lab7pages.Guru99Login;
import Lab7pages.Guru99LoginpageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class FactorialTestcases {

    WebDriver driver;



    @Parameters({"browser"})

    @BeforeTest()
    public void prepare(  @Optional("edge") String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();

        }


    }
@DataProvider(name = "Logindata")

public  Object[][]  Logindata(){

        return new  Object[][]{
                {"test@mail.com","123","Invalid email or password.","Invalid"},

    {"test@mail.com","152","https://demo.guru99.com/test/success.html","Valid"}
    };

}


@Test(dataProvider = "Logindata")
public  void testlogin(String un,String pass,String expected, String CaseType) throws InterruptedException {

Guru99Login login = new Guru99Login(driver);
login.login(un,pass);
if(CaseType.equalsIgnoreCase("valid")){

    String actualurl =driver.getCurrentUrl();
    assertEquals(actualurl,expected,"valid url navigation");

}

}

@AfterTest()
    public  void finish(){

        driver.quit();

}

}
