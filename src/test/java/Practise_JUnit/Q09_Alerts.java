package Practise_JUnit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class Q09_Alerts extends TestBase {
    @Test
    public void Test01() throws InterruptedException {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        driver.switchTo().alert().accept();
        //    accept Alert(I am an alert box!) and print alert on console

        //System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();


        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(By.xpath(\"//*[text()='Alert with OK & Cancel ']\")).click();"));
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        Thread.sleep(2000);
        //    finally print on console this message "Hello TechproEducation How are you today"
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        String expectedMsj = "Hello TechproEducation How are you today";
        String actualMsj = driver.findElement(By.xpath("//p[@id='demo']")).getText();

        Assert.assertEquals(expectedMsj, actualMsj);

    }
}