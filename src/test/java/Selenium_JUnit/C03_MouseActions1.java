package Selenium_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.

        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        String ilkSayfaHandleDeeheri=driver.getWindowHandle();
        System.out.println(ilkSayfaHandleDeeheri);

        //5- Tamam diyerek alert’i kapatalim
       driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri=driver.getWindowHandle();
        System.out.println(ikinciSayfaHandleDegeri);
        for (String each:handleSeti
             ) {
            if(!each.equals(ikinciSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedikinciYazi="Elemental Selenium";
        String actualİkinciYazi=yaziElementi.getText();
        Assert.assertEquals(expectedikinciYazi,actualİkinciYazi);



    }

}
