package Selenium_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C05_KeyBoardsActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna click yapip sonra harf harf nutella yazisini yazdiralim
        //sonra da enter tusuna basalim
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu)
        .keyDown(Keys.SHIFT)
        .sendKeys("n")
        .keyUp(Keys.SHIFT)
        .sendKeys("u")
        .sendKeys("t")
        .sendKeys("e")
        .sendKeys("l")
        .sendKeys("l")
        .sendKeys("a").sendKeys(Keys.ENTER)
        .perform();



       Thread.sleep(5000);
    }
}
