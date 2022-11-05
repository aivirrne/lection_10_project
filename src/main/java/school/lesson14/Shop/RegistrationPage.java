package school.lesson14.Shop;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(id = "id_gender2")
    private WebElement GenderCheckbox;
    @FindBy(id = "customer_firstname")
    private WebElement FirstnameField;
    @FindBy(id = "customer_lastname")
    private WebElement LastnameField;
    @FindBy(id = "passwd")
    private WebElement PasswordField;
    @FindBy(id = "address1")
    private WebElement AddressField;
    @FindBy(id = "city")
    private WebElement CityField;
    @FindBy(id = "id_state")
    private WebElement StateDropdown;
    @FindBy(id = "postcode")
    private WebElement PostalCodeField;
    @FindBy(id = "phone_mobile")
    private WebElement PhoneField;
    @FindBy(css = "#submitAccount > span")
    private WebElement RegisterButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Wait for registration form to load")
    public RegistrationPage waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(RegisterButton));
        return this;
    }

    @Step("Select the gender")
    public RegistrationPage selectGender() {
        GenderCheckbox.click();
        return this;
    }

    @Step("Enter the firstname")
    public RegistrationPage enterFirstname(String firstname) {
        FirstnameField.sendKeys(firstname);
        return this;
    }

    @Step("Enter the lastname")
    public RegistrationPage enterLastname(String lastname) {
        LastnameField.sendKeys(lastname);
        return this;
    }

    @Step("Enter a password")
    public RegistrationPage enterPassword(String password) {
        PasswordField.sendKeys(password);
        return this;
    }

    @Step("Enter the address")
    public RegistrationPage enterAddress(String address) {
        AddressField.sendKeys(address);
        return this;
    }

    @Step("Enter the city")
    public RegistrationPage enterCity(String city) {
        CityField.sendKeys(city);
        return this;
    }

    @Step("Select the state")
    public RegistrationPage selectState() {
        StateDropdown.click();
        StateDropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        return this;
    }

    @Step("Enter the postal code")
    public RegistrationPage enterPostcode(String postcode) {
        PostalCodeField.sendKeys(postcode);
        return this;
    }

    @Step("Enter the phone number")
    public RegistrationPage enterPhone(String phone) {
        PhoneField.sendKeys(phone);
        return this;
    }


    @Step("Click the Register button")
    public MyAccountPage clickRegister() {
        RegisterButton.click();
        return new MyAccountPage(driver);
    }



}
