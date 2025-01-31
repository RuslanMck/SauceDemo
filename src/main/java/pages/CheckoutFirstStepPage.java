package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CheckoutFirstStepPage extends BasicPageElements{

    private final String BASE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    private SelenideElement firstNameInputField = Selenide.$("#first-name");
    private SelenideElement lastNameInputField = Selenide.$("#last-name");
    private SelenideElement postalCodeInputField = Selenide.$("#postal-code");
    private SelenideElement continueCheckoutButton = Selenide.$("#continue");

    public void inputFirstName(String firstName){
        firstNameInputField.shouldBe(Condition.visible);
        firstNameInputField.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        lastNameInputField.shouldBe(Condition.visible);
        lastNameInputField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeInputField.shouldBe(Condition.visible);
        postalCodeInputField.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueCheckoutButton.shouldBe(Condition.visible);
        continueCheckoutButton.click();
    }

}
