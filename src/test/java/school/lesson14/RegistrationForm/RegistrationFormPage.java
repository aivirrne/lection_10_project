package school.lesson14.RegistrationForm;

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

    public RegistrationFormPage enterFirstname(String firstname) {
        FirstnameField.sendKeys(firstname);
        return this;
    }
    public RegistrationFormPage enterLastname(String lastname) {
        LastnameField.sendKeys(lastname);
        return this;
    }
    public RegistrationFormPage selectHobby() {
        HobbyCheckbox.click();
        return this;
    }
    public RegistrationFormPage selectMonth() {
        MonthDropdown.click();
        MonthDropdown.findElement(By.xpath("//option[. = '1']")).click();
        return this;
    }
    public RegistrationFormPage selectDay() {
        DayDropdown.click();
        DayDropdown.findElement(By.xpath("//option[. = '1']")).click();
        return this;
    }
    public RegistrationFormPage selectYear() {
        YearDropdown.click();
        YearDropdown.findElement(By.xpath("//option[. = '2014']")).click();
        return this;
    }
    public RegistrationFormPage enterPhone(String phone) {
        PhoneField.sendKeys(phone);
        return this;
    }
    public RegistrationFormPage enterUsername(String username) {
        UsernameField.sendKeys(username);
        return this;
    }
    public RegistrationFormPage enterEmail(String email) {
        EmailField.sendKeys(email);
        return this;
    }
    public RegistrationFormPage enterPassword(String password) {
        PasswordField.sendKeys(password);
        return this;
    }
    public RegistrationFormPage enterConfirmPassword(String confirmation) {
        ConfirmPasswordField.sendKeys(confirmation);
        return this;
    }
    public RegistrationFormPage clickSubmit() {
        SubmitButton.click();
        return this;
    }
    public RegistrationFormPage assertRegistrationSuccess() {
        Assert.assertEquals("", FirstnameField.getText());
        return this;
    }

    public RegistrationFormPage assertRegistrationFail() {
        String ExpectedText = "This field is required.";
        Assert.assertEquals(ExpectedText, ErrorMessage.getText());
        return this;
    }

}
