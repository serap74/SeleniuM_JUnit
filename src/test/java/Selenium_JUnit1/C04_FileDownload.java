package Selenium_JUnit1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void Test01() throws InterruptedException {

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement dummy=driver.findElement(By.xpath("//*[text()='dummy.txt']"));
        dummy.click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));




    }
}
