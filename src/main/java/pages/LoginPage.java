package pages;

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

}
