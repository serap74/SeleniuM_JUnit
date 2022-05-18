package Selenium_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Aseertions {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        //url nin https://www.facebook.com a esit olup olmadigini test edin

/*
        if(driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi paste");
        }else {
            System.out.println("Url testi paste");
    }
*/
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farkli",expectedUrl, actualUrl);
    }
}
