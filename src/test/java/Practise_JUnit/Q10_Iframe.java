package Practise_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class Q10_Iframe extends TestBase {
    @Test
    public void Test01() {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
   driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    // web sitesini maximize yapin
    // ikinci emojiye tıklayın
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
    // tüm ikinci emoji öğelerini tıklayın
        WebElement secondEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        List<WebElement> emojiDeger=driver.findElements(By.xpath("//div[@id='nature']"));

        for (WebElement each:emojiDeger) {
           each.click();
        }
        // parent iframe e geri donun
        driver.switchTo().parentFrame();
    // formu doldurun,(Formu istediğiniz metinlerle doldurun)
    //  apply button a basin

    }
}
