package helpers;

import com.codeborne.selenide.Condition;
import lombok.Getter;
import pages.LoginPage;

import java.util.ArrayList;

@Getter
public class LoginHelper {

    private final LoginPage LOGIN_PAGE = new LoginPage();
    private ArrayList<String> namesList;
    private ArrayList<String> passwordsList;

    public LoginHelper(){
        String userNames = LOGIN_PAGE.getTextFromUsernameList();
        namesList = ExtractCredentials.extract(userNames);

        String passwords = LOGIN_PAGE.getTextFromPasswordList();
        passwordsList = ExtractCredentials.extract(passwords);
    }

    public void loginAsStandardUser(){
        LOGIN_PAGE.getLoginForm().shouldBe(Condition.visible);
        LOGIN_PAGE.populateUsername(namesList.get(0));
        LOGIN_PAGE.populatePassword(passwordsList.get(0));
        LOGIN_PAGE.clickLoginButton();
    }
}
