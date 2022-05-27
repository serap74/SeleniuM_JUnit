package Practise_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utulities.TestBase;

import java.time.Duration;

public class Q8_Expilicitly_Wait extends TestBase {
    @Test
    public void Test01() {

    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
    //maximize the window
    //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();
    //if need use explicitly wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-body']"))));
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog-mycodemyway-action"))).click();
    //click on the ok button
    //accept the alert message
        WebElement textMesaj=driver.findElement(By.xpath("//div[@class='modal-body']"));
        Assert.assertTrue(textMesaj.isDisplayed());

        driver.findElement(By.xpath("//button[@id=\"dialog-mycodemyway-action\"]")).click();
        driver.switchTo().alert().accept();
    }
}
