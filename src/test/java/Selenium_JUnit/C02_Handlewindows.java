package Selenium_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Handlewindows {
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
        driver.quit();
    }
    @Test
    public void test01(){

        //1-amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        //2-URL nin amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        //3-yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayaHandlerDegeri=driver.getWindowHandle();

        String actual_title=driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actual_title.contains(arananKelime));

        //5-ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        driver.findElement(By.xpath("twotabsearchtextbox"));

        //6- Arama sonuclarinin java icerdigini test edelim
        WebElement sonucyazisi=driver.findElement(By.xpath("\"//span[@class=\\\"a-color-state a-text-bold\\\"]\""));
        String sonucyazisistr=sonucyazisi.getText();
        String ArananKelime="Java";
        Assert.assertTrue(sonucyazisistr.contains(ArananKelime));

        //7-Yeniden BestBuy in acik oldugu sayfaya gidelim
        driver.switchTo().window(ilkSayfaHandleDegeri);

        //-Logonun gorundugunu test edelim
        WebElement logoelementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoelementi.isDisplayed());

    }

}
