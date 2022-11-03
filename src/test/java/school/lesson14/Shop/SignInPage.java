package school.lesson14.Shop;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement EmailCreateField;

    @FindBy(css = "#SubmitCreate > span")
    private WebElement CreateAccountButton;

    public SignInPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Enter the email")
    public SignInPage enterEmail(String email) {
        EmailCreateField.sendKeys(email);
        return this;
    }

    @Step("Click the Create Account button")
    public RegistrationPage clickCreateAccount() {
        CreateAccountButton.click();
        return new RegistrationPage(driver);
    }

}
