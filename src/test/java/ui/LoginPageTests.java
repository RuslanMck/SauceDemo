package ui;

import com.codeborne.selenide.WebDriverRunner;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.InventoryPageSteps;
import steps.LoginPageSteps;


public class LoginPageTests extends BasicTest {

    private final LoginPage LOGIN_PAGE = new LoginPage();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private LoginHelper loginHelper;
    private final InventoryPageSteps INVENTORY_PAGE_STEPS = new InventoryPageSteps();

    @BeforeClass
    public void setUp() {
        super.baseSetUp(LOGIN_PAGE.getBASE_URL());
        loginHelper = new LoginHelper();
    }

    @Test(description = "Verify if required UI elements are presented on the page")
    public void verifyUiElementsDisplaying() {

        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyLogoDisplaying());
        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyLoginFormDisplaying());
        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyLoginFormElementsDisplaying());

    }

    @Test(description = "Verify the validation of the login input fields",
            dependsOnMethods = {"verifyUiElementsDisplaying"})
    @Parameters({"validUsername", "validPassword", "invalidUsername", "invalidPassword"})
    public void verifyInputFieldsValidation() {

        String validUsername = loginHelper.getNamesList().get(0);
        String validPassword = loginHelper.getPasswordsList().get(0);
        String invalidUsername = "qwe";
        String invalidPassword = "asd1!";

        LOGIN_PAGE_STEPS.clickTheLoginButton();
        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyErrorMessageDisplaying());
        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(), "Epic sadface: Username is required",
                "Actual error message does not match the expected text");

        LOGIN_PAGE_STEPS.enterUsername(invalidUsername);
        LOGIN_PAGE_STEPS.enterPassword(invalidPassword);
        LOGIN_PAGE_STEPS.clickTheLoginButton();
        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Actual error message does not match the expected text");
        LOGIN_PAGE_STEPS.clearUsernameInput();
        LOGIN_PAGE_STEPS.clearPasswordInput();

        LOGIN_PAGE_STEPS.enterUsername(invalidUsername);
        LOGIN_PAGE_STEPS.enterPassword(validPassword);
        LOGIN_PAGE_STEPS.clickTheLoginButton();
        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Actual error message does not match the expected text");
        LOGIN_PAGE_STEPS.clearUsernameInput();
        LOGIN_PAGE_STEPS.clearPasswordInput();

        LOGIN_PAGE_STEPS.enterUsername(validUsername);
        LOGIN_PAGE_STEPS.enterPassword(invalidPassword);
        LOGIN_PAGE_STEPS.clickTheLoginButton();
        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Actual error message does not match the expected text");
        LOGIN_PAGE_STEPS.clearUsernameInput();
        LOGIN_PAGE_STEPS.clearPasswordInput();
    }


    @Test(description = "Verify that login process using provided credentials",
            dependsOnMethods = {"verifyInputFieldsValidation"})
    public void verifyLoginProcess() {

        for (String password : loginHelper.getPasswordsList()) {

            for (String username : loginHelper.getNamesList()) {

                LOGIN_PAGE_STEPS.clearUsernameInput();
                LOGIN_PAGE_STEPS.enterUsername(username);

                LOGIN_PAGE_STEPS.clearPasswordInput();
                LOGIN_PAGE_STEPS.enterPassword(password);

                LOGIN_PAGE_STEPS.clickTheLoginButton();

                switch (username) {
                    case "standard_user":
                    case "problem_user":
                    case "performance_glitch_user":
                    case "error_user":
                    case "visual_user":
                        Assert.assertEquals(WebDriverRunner.driver().url(), "https://www.saucedemo.com/inventory.html");
                        INVENTORY_PAGE_STEPS.logoutFromUserAccount();
                        break;
                    case "locked_out_user":
                        Assert.assertTrue(LOGIN_PAGE_STEPS.verifyErrorMessageDisplaying());
                        Assert.assertEquals(LOGIN_PAGE_STEPS.retrieveErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.",
                                "Actual error message does not match the expected text");
                        break;
                }
            }
        }
    }

}
