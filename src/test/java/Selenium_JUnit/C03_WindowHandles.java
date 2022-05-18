package Selenium_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi=driver.findElement(By.xpath("//h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> WindowHandleSeti=driver.getWindowHandles();
        System.out.println(WindowHandleSeti);
        String ikinciSayfaWindowHandleDegeri="";

        for (String each:WindowHandleSeti
             ) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=each;
            }
        }
         driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedikinciTitle="New Window";
        String actualikinciTitle=driver.getTitle();
        Assert.assertEquals(expectedikinciTitle, actualikinciTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.xpath("//h3"));
        String expectedikinciYazi="New Window";
        String actualikinciYazi=ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedikinciYazi, actualikinciYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayı
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
         expectedTitle ="The Internet";
         actualTitle =driver.getTitle();

         Assert.assertEquals(expectedTitle,actualTitle);


    }

}
