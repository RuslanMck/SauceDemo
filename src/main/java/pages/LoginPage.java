package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class LoginPage {

    private final String BASE_URL = "https://www.saucedemo.com/";
    private SelenideElement loginLogo = Selenide.$(".login_logo");
    private SelenideElement loginForm = Selenide.$(".form_column");
    private SelenideElement loginUsernamesList = Selenide.$(".login_credentials");
    private SelenideElement loginPasswordsList = Selenide.$(".login_password");
    private SelenideElement usernameInputField = Selenide.$("#user-name");
    private SelenideElement passwordInputField = Selenide.$("#password");
    private SelenideElement loginButton = Selenide.$("#login-button");
    private SelenideElement inputFieldErrorIcon = Selenide.$(".input_error");
    private SelenideElement errorMessageContainer = Selenide.$(".error-message-container");
    private SelenideElement closeErrorMessageButton = Selenide.$(".error-button");

    public String getTextFromUsernameList(){
        loginUsernamesList.shouldBe(Condition.visible);
        return loginUsernamesList.getText();
    }

    public String getTextFromPasswordList(){
        loginPasswordsList.shouldBe(Condition.visible);
        return loginPasswordsList.getText();
    }

    public boolean isLogoDisplayed(){
        loginLogo.shouldBe(Condition.visible);
        return loginLogo.isDisplayed();
    }

    public boolean isLoginFormDisplayed(){
        loginForm.shouldBe(Condition.visible);
        return loginForm.isDisplayed();
    }

    public boolean isLoginFormElementsDisplayed(){
        usernameInputField.shouldBe(Condition.visible);
        passwordInputField.shouldBe(Condition.visible);
        loginButton.shouldBe(Condition.visible);
        return usernameInputField.isDisplayed() && passwordInputField.isDisplayed() && loginButton.isDisplayed();
    }

    public void clickLoginButton(){
        loginButton.shouldBe(Condition.visible);
        loginButton.click();
    }

    public boolean isErrorMessageVisible(){
        errorMessageContainer.shouldBe(Condition.visible);
        return errorMessageContainer.isDisplayed();
    }

    public String getErrorMessageText(){
        errorMessageContainer.shouldBe(Condition.visible);
        return errorMessageContainer.text();
    }

    public void populateUsername(String username){
        usernameInputField.shouldBe(Condition.visible);
        usernameInputField.sendKeys(username);
    }

    public void populatePassword(String password){
        passwordInputField.shouldBe(Condition.visible);
        passwordInputField.sendKeys(password);
    }

    public void clearUsernameInputField(){
        usernameInputField.clear();
    }

    public void clearPasswordInputField(){
        passwordInputField.clear();
    }


}
