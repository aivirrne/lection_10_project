package school.lesson13;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShopRegistrationTest {
    private static void shopRegistrationTest(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).sendKeys(randomEmail());
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submitAccount > span")));
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Nhfdhfr");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys("Ncvvhyrjk");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("00367458");
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).sendKeys("Hjrkrcm, 45, 33846");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("id_state")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_state"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys("74765");
        driver.findElement(By.id("id_country")).click();
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).sendKeys("789397566");
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).sendKeys("djfnrjrr");
        driver.findElement(By.cssSelector("#submitAccount > span")).click();

        WebElement RegisteredAccount = driver.findElement(By.cssSelector(".center_column > .info-account"));
        String ExpectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assert.assertEquals(ExpectedText, RegisteredAccount.getText());
    }

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        shopRegistrationTest(driver);
        //driver.quit();
    }
}
