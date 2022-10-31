package school.lesson14.Shop;

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

    public RegistrationPage waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(RegisterButton));
        return this;
    }

    public RegistrationPage selectGender() {
        GenderCheckbox.click();
        return this;
    }

    public RegistrationPage enterFirstname(String firstname) {
        FirstnameField.sendKeys(firstname);
        return this;
    }

    public RegistrationPage enterLastname(String lastname) {
        LastnameField.sendKeys(lastname);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        PasswordField.sendKeys(password);
        return this;
    }

    public RegistrationPage enterAddress(String address) {
        AddressField.sendKeys(address);
        return this;
    }

    public RegistrationPage enterCity(String city) {
        CityField.sendKeys(city);
        return this;
    }

    public RegistrationPage selectState() {
        StateDropdown.click();
        StateDropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        return this;
    }

    public RegistrationPage enterPostcode(String postcode) {
        PostalCodeField.sendKeys(postcode);
        return this;
    }

    public RegistrationPage enterPhone(String phone) {
        PhoneField.sendKeys(phone);
        return this;
    }

    public MyAccountPage clickRegister() {
        RegisterButton.click();
        return new MyAccountPage(driver);
    }



}
