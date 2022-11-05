package school.lesson14.RegistrationForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormTest {
    static WebDriver driver;
    static RegistrationFormPage registrationFormPage;

    @BeforeAll
    @Description("Set Up")
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @BeforeEach
    @Description("Set Up Each")
    public void setUp() {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
    }

    @AfterAll
    public static void TearDown() {
        driver.quit();
    }

    @Test
    @Description("Valid Registration Test")
    public void testRegistrationSuccess() {
        RegistrationFormPage page = registrationFormPage.enterFirstname("Name")
                .enterLastname("Last-name")
                .selectHobby()
                .selectMonth()
                .selectDay()
                .selectYear()
                .enterPhone("2357446780")
                .enterUsername("User123")
                .enterEmail("email@mail.cc")
                .enterPassword("password1")
                .enterConfirmPassword("password1")
                .clickSubmit();
        Assert.assertTrue(page.getFirstnameValue());
    }


    @Test
    @Description("Invalid Registration Test with Unselected Hobby")
    public void testRegistrationFail() {
        RegistrationFormPage page = registrationFormPage.enterFirstname("Name")
                .enterLastname("Last-name")
                .selectMonth()
                .selectDay()
                .selectYear()
                .enterPhone("2357446780")
                .enterUsername("User123")
                .enterEmail("email@mail.cc")
                .enterPassword("password1")
                .enterConfirmPassword("password1")
                .clickSubmit();
        Assert.assertTrue(page.getErrorMessageText());
    }
}
