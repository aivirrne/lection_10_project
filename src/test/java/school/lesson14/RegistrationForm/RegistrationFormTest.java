package school.lesson14.RegistrationForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormTest {
    WebDriver driver;
    RegistrationFormPage registrationFormPage;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Test
    public void testRegistrationSuccess() {
        registrationFormPage.enterFirstname("Name")
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
                .clickSubmit()
                .assertRegistrationSuccess();
    }

    @Test
    public void testRegistrationFail() {
        registrationFormPage.enterFirstname("Name")
                .enterLastname("Last-name")
                .selectMonth()
                .selectDay()
                .selectYear()
                .enterPhone("2357446780")
                .enterUsername("User123")
                .enterEmail("email@mail.cc")
                .enterPassword("password1")
                .enterConfirmPassword("password1")
                .clickSubmit()
                .assertRegistrationFail();

    }
}
