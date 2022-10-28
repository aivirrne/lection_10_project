package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegistrationFailTest {

    private static void registrationFail(WebDriver driver) {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Name");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Lastname");
        driver.findElement(By.cssSelector("fieldset:nth-child(2) label:nth-child(2) > input")).click();
        driver.findElement(By.cssSelector(".time_feild:nth-child(2) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(2) > select"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(4) > select")).click();

        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(4) > select"));
            dropdown.findElement(By.xpath("//option[. = '2014']")).click();
        }
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys("345678d");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("lllllogin");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("dvcghsbcjnksmc");
        {
            WebElement element = driver.findElement(By.name("password"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".fieldset:nth-child(11)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".fieldset:nth-child(11)")).click();
        driver.findElement(By.name("password")).sendKeys("55555r");
        driver.findElement(By.name("c_password")).click();
        driver.findElement(By.name("c_password")).sendKeys("55555r");
        driver.findElement(By.cssSelector("fieldset:nth-child(13) > input")).click();

        WebElement ErrorMessage = driver.findElement(By.xpath("//label/label"));
        String ExpectedText = "This field is required.";
        Assert.assertEquals(ExpectedText, ErrorMessage.getText());
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        registrationFail(driver);
        //driver.quit();
    }

}
