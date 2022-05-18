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

public class C02_BestBayAssertions {
    // 2) https://www.bestbuy.com/ Adresine gidin
    //    farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://www.bestbuy.com/");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test2(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void tess3(){
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void test4(){
        WebElement FrancaisLinkTest=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(FrancaisLinkTest.isDisplayed());
    }

}
