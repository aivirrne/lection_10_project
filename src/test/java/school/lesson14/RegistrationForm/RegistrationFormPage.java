package school.lesson14.RegistrationForm;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage {
    WebDriver driver;

    @FindBy(name = "name")
    private WebElement FirstnameField;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement LastnameField;
    @FindBy(css = ".fieldset label:nth-child(2) > input")
    private WebElement HobbyCheckbox;
    @FindBy(css = ".time_feild:nth-child(2) > select")
    private WebElement MonthDropdown;
    @FindBy(css = ".time_feild:nth-child(3) > select")
    private WebElement DayDropdown;
    @FindBy(css = ".time_feild:nth-child(4) > select")
    private WebElement YearDropdown;
    @FindBy(name = "phone")
    private WebElement PhoneField;
    @FindBy(name = "username")
    private WebElement UsernameField;
    @FindBy(name = "email")
    private WebElement EmailField;
    @FindBy(name = "password")
    private WebElement PasswordField;
    @FindBy(name = "c_password")
    private WebElement ConfirmPasswordField;
    @FindBy(css = "fieldset:nth-child(13) > input")
    private WebElement SubmitButton;
    @FindBy(xpath = "//label/label")
    private WebElement ErrorMessage;



    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Enter the firstname")
    public RegistrationFormPage enterFirstname(String firstname) {
        FirstnameField.sendKeys(firstname);
        return this;
    }

    @Step("Enter the lastname")
    public RegistrationFormPage enterLastname(String lastname) {
        LastnameField.sendKeys(lastname);
        return this;
    }

    @Step("Select a hobby")
    public RegistrationFormPage selectHobby() {
        HobbyCheckbox.click();
        return this;
    }

    @Step("Select a month")
    public RegistrationFormPage selectMonth() {
        MonthDropdown.click();
        MonthDropdown.findElement(By.xpath("//option[. = '1']")).click();
        return this;
    }

    @Step("Select a day")
    public RegistrationFormPage selectDay() {
        DayDropdown.click();
        DayDropdown.findElement(By.xpath("//option[. = '1']")).click();
        return this;
    }

    @Step("Select a year")
    public RegistrationFormPage selectYear() {
        YearDropdown.click();
        YearDropdown.findElement(By.xpath("//option[. = '2014']")).click();
        return this;
    }

    @Step("Enter a phone")
    public RegistrationFormPage enterPhone(String phone) {
        PhoneField.sendKeys(phone);
        return this;
    }

    @Step("Enter a username")
    public RegistrationFormPage enterUsername(String username) {
        UsernameField.sendKeys(username);
        return this;
    }

    @Step("Enter an email")
    public RegistrationFormPage enterEmail(String email) {
        EmailField.sendKeys(email);
        return this;
    }

    @Step("Enter a password")
    public RegistrationFormPage enterPassword(String password) {
        PasswordField.sendKeys(password);
        return this;
    }

    @Step("Enter a password confirmation")
    public RegistrationFormPage enterConfirmPassword(String confirmation) {
        ConfirmPasswordField.sendKeys(confirmation);
        return this;
    }

    @Step("Click the Submit button")
    public RegistrationFormPage clickSubmit() {
        SubmitButton.click();
        return this;
    }

    @Step("Assert that registration is successful")
    public RegistrationFormPage assertRegistrationSuccess() {
        Assert.assertEquals("", FirstnameField.getText());
        return this;
    }

    @Step("Assert that registration failed")
    public RegistrationFormPage assertRegistrationFail() {
        String ExpectedText = "This field is required.";
        Assert.assertEquals(ExpectedText, ErrorMessage.getText());
        return this;
    }

}
