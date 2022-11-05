package school.lesson14.Shop;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopTest {
    static WebDriver driver;
    static HomePage home;

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    @BeforeAll
    @Description("Set Up")
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new HomePage(driver);
    }

    @BeforeEach
    @Description("Set Up Each")
    public void setUp() {
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterAll
    public static void TearDown() {
        driver.quit();
    }

    @Test
    @Description("Valid Registration Test")
    public void testRegistration() {
        MyAccountPage page = home.clickSignIn()
                .enterEmail(randomEmail())
                .clickCreateAccount()
                .waitForLoad()
                .selectGender()
                .enterFirstname("Firstname")
                .enterLastname("Lastname")
                .enterPassword("password1")
                .enterAddress("Street, 20, 30087")
                .enterCity("New York")
                .selectState()
                .enterPostcode("30087")
                .enterPhone("345678903567")
                .clickRegister();
        Assert.assertTrue(page.isWelcomeToAccountPage());
    }


}
