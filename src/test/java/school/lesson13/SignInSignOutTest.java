package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInSignOutTest {
    private static void signOutTest(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("email+8564@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("00367458");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.linkText("Sign out")).click();
        Assert.assertEquals("Sign in", driver.findElement(By.cssSelector(".login")).getText());
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        signOutTest(driver);
        driver.quit();
    }
}
