package Selenium_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        Actions actions= new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Serap")
                .sendKeys(Keys.TAB)
                .sendKeys("Diraz")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Şub")
                .sendKeys(Keys.TAB)
                .sendKeys("1989")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).tick()
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);

    }
}
