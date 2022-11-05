package school.lesson14.Shop;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(css = ".center_column > .info-account")
    private WebElement WelcomeToAccountText;

    public MyAccountPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Assert that registration is successful")
    public boolean isWelcomeToAccountPage() {
        String ExpectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        return ExpectedText.equals(WelcomeToAccountText.getText());
    }

}
