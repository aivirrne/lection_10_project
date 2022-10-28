package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSuccessTest {
    private static void registrationSuccess(WebDriver driver) {

        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Name");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.cssSelector("p:nth-child(2) > input")).sendKeys("Lastname");
        driver.findElement(By.name("m_status")).click();
        driver.findElement(By.cssSelector(".fieldset label:nth-child(2) > input")).click();
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
        driver.findElement(By.name("phone")).sendKeys("5673947765");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("logiiin");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("mail@mail.dd");
        driver.findElement(By.cssSelector("textarea")).click();
        driver.findElement(By.cssSelector("textarea")).sendKeys("hfhfhf");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123456y");
        driver.findElement(By.name("c_password")).click();
        driver.findElement(By.name("c_password")).sendKeys("123456y");
        driver.findElement(By.cssSelector("fieldset:nth-child(13) > input")).click();

        String EmptyName = driver.findElement(By.name("name")).getText();
        Assert.assertEquals("", EmptyName);
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        registrationSuccess(driver);
        //driver.quit();
    }
}
