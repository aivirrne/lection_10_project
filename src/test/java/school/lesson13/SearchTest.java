package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchTest {

    private static void searchTest(WebDriver driver) {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("t-shirt");
        driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".ajax_block_product"));
            assert(elements.size() > 0);
        }
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        searchTest(driver);
        driver.quit();
    }
}
