package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps {

    private final LoginPage LOGIN_PAGE = new LoginPage();

    @Step("Verify that the login logo is displayed")
    public boolean verifyLogoDisplaying(){
        return LOGIN_PAGE.isLogoDisplayed();
    }

    @Step("Verify that the login form is displayed")
    public boolean verifyLoginFormDisplaying(){
        return LOGIN_PAGE.isLoginFormDisplayed();
    }

    @Step("Verify that the login form elements are displayed")
    public boolean verifyLoginFormElementsDisplaying(){
        return LOGIN_PAGE.isLoginFormElementsDisplayed();
    }

    @Step("Click the login button")
    public void clickTheLoginButton(){
        LOGIN_PAGE.clickLoginButton();
    }

    @Step("Verify if error message is displayed")
    public boolean verifyErrorMessageDisplaying(){
        return LOGIN_PAGE.isErrorMessageVisible();
    }

    @Step("Retrieve the error message text for verification")
    public String retrieveErrorMessageText(){
        return LOGIN_PAGE.getErrorMessageText();
    }

    @Step("Enter the user name into the username input field")
    public void enterUsername(String username){
        LOGIN_PAGE.populateUsername(username);
    }

    @Step("Enter the password into the password input field")
    public void enterPassword(String password){
        LOGIN_PAGE.populatePassword(password);
    }

    @Step("Clear the user name input field")
    public void clearUsernameInput(){
        LOGIN_PAGE.clearUsernameInputField();
    }

    @Step("Clear the password input field")
    public void clearPasswordInput(){
        LOGIN_PAGE.clearPasswordInputField();
    }

}
