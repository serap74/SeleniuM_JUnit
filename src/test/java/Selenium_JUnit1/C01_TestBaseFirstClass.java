package Selenium_JUnit1;

import org.junit.Test;
import utulities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
