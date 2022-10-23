package school.lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopOrder {

    private static void shopOrderTest(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?id_category=5&controller=category'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")).click();
        driver.findElement(By.id("quantity_wanted")).click();
        driver.findElement(By.id("quantity_wanted")).sendKeys("2");
        driver.findElement(By.id("group_1")).click();
        {
            WebElement dropdown = driver.findElement(By.id("group_1"));
            dropdown.findElement(By.xpath("//option[. = 'M']")).click();
        }
        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.cssSelector(".exclusive > span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Proceed to checkout')]")));
        driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("email+8564@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("00367458");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        shopOrderTest(driver);
        driver.quit();
    }

}
