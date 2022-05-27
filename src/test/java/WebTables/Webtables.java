package WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class Webtables extends TestBase {
    @Test
    public void Test01() {
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!

        //● table( ) metodu oluşturun
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
    }
    public void girisYap(){
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
